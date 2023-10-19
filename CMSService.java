package com.kronos.wfc.cms.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.kronos.wfc.cms.facade.PrincipalEmployeeFacade;
import com.kronos.wfc.cms.facade.PrincipalEmployeeFacadeImpl;
import com.kronos.wfc.cms.facade.WorkmenDetailAction;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import com.kronos.wfc.commonapp.laborlevel.business.set.LaborAccountSetEntry;
import com.kronos.wfc.commonapp.people.business.person.Person;
import com.kronos.wfc.commonapp.people.business.person.PersonStatus;
import com.kronos.wfc.commonapp.people.business.personality.Personality;
import com.kronos.wfc.commonapp.people.business.personality.PersonalityException;
import com.kronos.wfc.commonapp.people.business.user.CurrentUserAccountManager;
import com.kronos.wfc.commonapp.types.business.DeviceGroup;
import com.kronos.wfc.commonapp.types.business.EmploymentStatusType;
import com.kronos.wfc.datacollection.empphoto.api.APIEmpPhotoBean;
import com.kronos.wfc.datacollection.empphoto.business.EmpPhotoBusinessValidationException;
import com.kronos.wfc.platform.datetime.framework.KServer;
import com.kronos.wfc.platform.persistence.framework.ObjectId;
import com.kronos.wfc.platform.persistence.framework.ObjectIdLong;
import com.kronos.wfc.platform.persistence.framework.SQLStatement;
import com.kronos.wfc.platform.persistence.framework.business.SQLStatementWithInClause;
import com.kronos.wfc.platform.persistence.framework.internal.ObjectIdManager;
import com.kronos.wfc.platform.persistence.framework.statement.DataStoreIfc;
import com.kronos.wfc.platform.persistence.framework.statement.SqlDataSetter;
import com.kronos.wfc.platform.persistence.framework.statement.SqlKDate;
import com.kronos.wfc.platform.persistence.framework.statement.SqlString;
import com.kronos.wfc.platform.properties.framework.KronosProperties;
import com.kronos.wfc.platform.utility.framework.datetime.KCalendar;
import com.kronos.wfc.platform.utility.framework.datetime.KDate;
import com.kronos.wfc.platform.utility.framework.datetime.KDateTime;
import com.kronos.wfc.platform.utility.framework.datetime.KTime;
import com.kronos.wfc.platform.utility.framework.datetime.KTimeStamp;
import com.kronos.wfc.platform.xml.api.bean.APIBeanList;
import com.kronos.wfc.platform.xml.api.bean.APIPersonIdentityBean;
import com.kronos.wfc.platform.xml.api.bean.ParameterMap;
import com.kronos.wfc.wfp.logging.Log;

public class CMSService {



	private static DataStoreIfc getDataStoreFromSQLStatement(String sqlStatement, ArrayList<String> params) {
		SQLStatement select = new SQLStatement(SQLStatement.PREPARE_SELECT, sqlStatement);
		select.execute(params);
		DataStoreIfc ds = select.getDataStore();
		return ds;

	}

	private void logError(Exception e) {
		Log.log(Log.ERROR, e, "Error in CMS Service");
	}

	public void addManager(Manager manager) {
		ManagerInsertTransaction trans = new ManagerInsertTransaction(manager);
		trans.run();
	}


	protected void addAddress(Address address) {
		//ObjectIdLong id = ObjectIdLong.createObjectIdLong("CMSADDRESS");
		ObjectIdLong id = new CMSService().getNewAddrId();
		ArrayList<Object> params = new ArrayList();
		params.add(id.toSQLString());
		params.add("not registered");
		params.add(address.getDistrict());
		params.add(address.getTaluka());
		params.add(address.getVillage());
		params.add(address.getStateId());
		address.setId(id);
		SQLStatement insert = new SQLStatement(SQLStatement.PREPARE_INSERT, "business.cms.INSERT_CMSADDRESS");
		insert.execute(params);

	}

	private ObjectIdLong getNewAddrId() {
		ArrayList<String> params = new ArrayList();

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.GET.NEW.getNewAddrId", params);
		ObjectIdLong result = new ObjectIdLong();
		if (ds.nextRow()) {
			result = ds.getObjectIdLong(1);

			return result;
		}
		return result;
	}

	public List<CMSState> getStates() {

		ArrayList<String> params = new ArrayList<String>();
		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_STATES", params);

		List<CMSState> states = new ArrayList<CMSState>();
		while (ds.nextRow()) {
			CMSState state = new CMSState(ds.getObjectIdLong(1), ds.getString(2));
			if (!CMSState.DEFAULT_STATE_ID.equals(state.getStateId())) {
				states.add(state);
			}
		}

		return states;

	}

	public void updateAddress(Address address) {

		ArrayList<Object> params = new ArrayList();
		params.add("future use");
		params.add(address.getDistrict());
		params.add(address.getTaluka());
		params.add(address.getVillage());
		params.add(address.getStateId());
		params.add(address.getId().toSQLString());
		SQLStatement insert = new SQLStatement(SQLStatement.PREPARE_UPDATE, "business.cms.UPDATE_CMSADDRESS");
		insert.execute(params);

	}

	public Address getAddressById(ObjectIdLong id) {
		ArrayList<String> params = new ArrayList();
		params.add(id.toSQLString());

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_ADDRESS_BY_ID", params);

		Address result = null;
		while (ds.nextRow()) {
			Address address = new Address(ds.getObjectIdLong(1), ds.getString(2), ds.getString(3), ds.getString(4),
					ds.getString(5), ds.getObjectIdLong(6));
			result = address;
		}

		return result;
	}

	/*
	 * public void deleteWorkmen(Workmen workmen) {
	 * 
	 * CMSPersonDeleteTransaction trns = new CMSPersonDeleteTransaction(workmen);
	 * trns.run(); }
	 */

	public void deleteAddress(Address address) {
		ArrayList<Object> params = new ArrayList();

		params.add(address.getId().toSQLString());

		SQLStatement update = new SQLStatement(SQLStatement.PREPARE_DELETE, "business.cms.DELETE_ADDRESS");
		update.execute(params);
	}




	/**
	 * Returns the photo image content for the given person
	 * 
	 * @param personNumber
	 * @return
	 */
	private String getImageContent(String personNumber) {
		APIPersonIdentityBean bean = new APIPersonIdentityBean();
		bean.setPersonNumber(personNumber);
		String imageContent = null;
		APIEmpPhotoBean photoBean = new APIEmpPhotoBean();
		photoBean.setEmployee(bean);

		ParameterMap map = new ParameterMap();
		try {
			APIBeanList empPhotoList = (APIBeanList) photoBean.doAction("Load", map);
			APIEmpPhotoBean pbean = (APIEmpPhotoBean) empPhotoList.get(0);
			if (pbean != null && !pbean.getDeleteFlag().booleanValue())
				imageContent = pbean.getImageContent();
		} catch (EmpPhotoBusinessValidationException ex) {
			imageContent = null;
		} catch (Exception e1) {
			imageContent = null;
		}
		return imageContent;
	}

	/**
	 * Returns true if the provided employee code is already used
	 * 
	 * @param employeeCode
	 * @return
	 */
	public boolean doesEmployeeCodeExist(String employeeCode) {
		ArrayList<String> params = new ArrayList();
		params.add(employeeCode);

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.CHECK_WORKMEN_EMPCODE", params);
		while (ds.nextRow()) {
			String result = ds.getString(1);
			return new Boolean(result);
		}
		return true;
	}

	/**
	 * Returns the list of principal employers based on user's employee group
	 * setting Note: Returns an empty string if the user is not a manager Note:
	 * Returns an empty string if employee group is not configured
	 * 
	 * @param personality
	 * @return
	 */
	public List<PrincipalEmployee> getPrincipalEmployerList() {
		Personality personality = CurrentUserAccountManager.getPersonality();
		PrincipalEmployeeFacade peFacade = new PrincipalEmployeeFacadeImpl();
		List<PrincipalEmployee> pes = peFacade.getPrincipalEmployees();
		List<PrincipalEmployee> filteredList = new ArrayList<PrincipalEmployee>();
		try {
			if (personality.getPersonId().longValue() > 0) {
				List<LaborAccountSetEntry> employeeGroup = personality.getAccessAssignment().getManagerAccessSet()
						.getLaborLevelEntries().collection();
				for (Iterator<PrincipalEmployee> iterator = pes.iterator(); iterator.hasNext();) {
					PrincipalEmployee pe = (PrincipalEmployee) iterator.next();
					for (int i = 0; i < employeeGroup.size(); i++) {
						String llEntryName = ((LaborAccountSetEntry) employeeGroup.get(i)).getLaborLevelEntryName();
						if (llEntryName.equalsIgnoreCase(pe.getUnitcode())) {
							filteredList.add(pe);
						}
					}
				}
				return filteredList;
			} else {
				return pes;
			}
		} catch (Exception e) {
			Log.log(e.getLocalizedMessage());
			return filteredList;
		}
	}
}
