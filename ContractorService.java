package com.kronos.wfc.cms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.util.StringTokenizer;
import com.kronos.wfc.commonapp.people.business.person.Person;
import com.kronos.wfc.commonapp.people.business.personality.Personality;
import com.kronos.wfc.datacollection.empphoto.api.APIEmpPhotoBean;
import com.kronos.wfc.datacollection.empphoto.business.EmpPhotoBusinessValidationException;
import com.kronos.wfc.platform.persistence.framework.ObjectIdLong;
import com.kronos.wfc.platform.persistence.framework.SQLStatement;
import com.kronos.wfc.platform.persistence.framework.statement.DataStoreIfc;
import com.kronos.wfc.platform.utility.framework.datetime.KDate;
import com.kronos.wfc.platform.xml.api.bean.APIBeanList;
import com.kronos.wfc.platform.xml.api.bean.APIPersonIdentityBean;
import com.kronos.wfc.platform.xml.api.bean.ParameterMap;

public class ContractorService {

	public Contractor retrieveById(ObjectIdLong contractorid, ObjectIdLong unitId) {

		ArrayList<String> params = new ArrayList<String>();

		params.add(((ObjectIdLong)contractorid).toSQLString());
		params.add(((ObjectIdLong)unitId).toSQLString());

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_CONTRACTOR_BY_ID", params);

		return createContObject(ds);	
	}

	public List<Contractor> retrieveAll() {

		ArrayList<String> params = new ArrayList<String>();

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_ALL_CONTRACTORS", params);

		return createContObjects(ds);
	}


	private List<Contractor> createContObjects(DataStoreIfc ds) {

		ArrayList<Contractor> list = new ArrayList<Contractor>();

		while (ds.nextRow())
		{
			Contractor contr = createContObject(ds);

			list.add(contr);
		} 
		return list;
	}

	private String getAddress(String address, int i) {

		if(address != null){

			StringTokenizer st2 = new StringTokenizer(address, "|");

			int j=0;

			String result ="";

			while (st2.hasMoreElements()) {

				result = (String)st2.nextElement();

				if(i==j)

					return result;

				j++;
			}
		}
		return null;
	}



	private Contractor createContObject(DataStoreIfc ds) {

		ObjectIdLong id = ds.getObjectIdLong(1);
		ObjectIdLong  unitId = ds.getObjectIdLong(2);
		String contractorname = ds.getString(3);
		String caddress = getAddress(ds.getString(4), 0);
		String caddress1 = getAddress(ds.getString(4), 1);
		String caddress2 = getAddress(ds.getString(4), 2);
		String caddress3 = getAddress(ds.getString(4), 3);
		String ccode = ds.getString(5);
		String email = ds.getString(6);
		String mobilenumber = ds.getString(7);
		String managername = ds.getString(8);
		String esiwc = ds.getString(9);
		KDate esistdt = ds.getKDate(10);
		KDate esieddt = ds.getKDate(11);
		String wcnumber = ds.getString(12);
		String licensenumber = ds.getString(13);
		KDate licensevalidity1 = ds.getKDate(14);
		KDate licensevalidity2 = ds.getKDate(15);
		String coverage = ds.getString(16);
		String totalstrength = ds.getString(17);
		String maxnoofemployees = ds.getString(18);
		String natureofwork = ds.getString(19);
		String locationofcontractwork  = ds.getString(20);
		KDate periodofcontract1 = ds.getKDate(21);
		KDate periodofcontract2 = ds.getKDate(22);
		String vendorCode =ds.getString(23);
		String pfcode = ds.getString(24);
		String pfnumber = ds.getString(25);
		KDate pfcodeapplicationdate =  ds.getKDate(26);


		Contractor contr = new Contractor(id,unitId, contractorname, caddress,
				caddress1, caddress2, caddress3, ccode, email, mobilenumber, managername,
				esiwc, esistdt, esieddt, wcnumber, licensenumber, licensevalidity1,
				licensevalidity2, coverage, totalstrength, maxnoofemployees, natureofwork,
				locationofcontractwork, periodofcontract1, periodofcontract2, vendorCode,
				pfcode, pfnumber, pfcodeapplicationdate);


		return contr;

	}

	public Contractor retrieveByName(String contractorName) {

		ArrayList<String> params = new ArrayList<String>();

		params.add(contractorName);

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_CONTRACTOR_BY_NAME", params);

		if(ds.nextRow()){
			return createContObject(ds);
		}
		return null;
	}

	private static DataStoreIfc getDataStoreFromSQLStatement(String sqlStatement,
			ArrayList<String> params) {

		SQLStatement select = new SQLStatement(3, sqlStatement);

		select.execute(params);

		DataStoreIfc ds = select.getDataStore();

		return ds;

	}


	public void updateContractors(List employees) {

		if(employees!=null && !employees.isEmpty()){
			for (java.util.Iterator<Contractor> iterator = employees.iterator(); iterator
					.hasNext();) {
				Contractor employee = (Contractor)iterator.next();

				updateContractor(employee);

			}
		}
	}


	/*
	 * 
	 */
	public void updateContractor(Contractor contr) {
		ContractorTransaction trans = new ContractorTransaction(contr);
		trans.run();
	}



	protected List retrieveByUnitId(ObjectIdLong unitId) {
		ArrayList<String> params = new ArrayList<String>();

		params.add(unitId.toSQLString());

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_CONTRACTOR_BY_UNITID", params);

		return createContObjects(ds);
	}



	public Contractor retrieveByName(String name, String unitId2) {

		ArrayList<String> params = new ArrayList<String>();

		params.add("%"+name+"%");
		params.add(unitId2);

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_CONTRACTOR_BY_NAME_UNITID", params);

		if(ds.nextRow()){
			return createContObject(ds);
		}
		return null;
	}



	public Contractor retrieveByCode(String code, String unitId2) {

		ArrayList<String> params = new ArrayList<String>();

		params.add(code);
		params.add(unitId2);

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_CONTRACTOR_BY_CODE_UNITID", params);

		if(ds.nextRow()){
			return createContObject(ds);
		}
		return null;
	}
	public List<Contractor> retrieveByUCode(String code) {

		ArrayList<String> params = new ArrayList<String>();

		params.add(code.toString());

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_CONTRACTOR_BY_CODE_Gate", params);

		return createContObjects(ds);
	}

	//newco  
	public List<Contractor> retrieveByCode(String code) {

		ArrayList<String> params = new ArrayList<String>();

		params.add(code.toString());

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_CONTRACTOR_BY_CODE_Y", params);

		return createContObjects(ds);

	}

	public List<Contractor> retrieveByCodenUnit(String code, ObjectIdLong unitid) {

		ArrayList<String> params = new ArrayList<String>();

		params.add(code.toString());
		params.add(unitid.toSQLString());
		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_CONTRACTOR_BY_CODE_N_UNIT", params);

		return createContObjects(ds);

	}


	/**
	 * Returns the image content for the given person
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
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageContent;
	}

	public List<Contractor> retrieveByPid(ObjectIdLong pId) {

		ArrayList<String> params = new ArrayList<String>();

		params.add(pId.toSQLString());

		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.GET_CONTRACTOR_BY_PID", params);
		ArrayList<Contractor> list = new ArrayList();

		while (ds.nextRow()) {
			Contractor stdm = new Contractor();
			stdm.setCcode(ds.getString(1));
			stdm.setContractorname(ds.getString(2));

			list.add(stdm);
		}
		return list;

	}

	public List<Contractor> retrieveByPIdRoleAndPrdln(ObjectIdLong pId, String gatePassRole, String prodLine) {
		ArrayList<String> params = new ArrayList();
		//params.add(pId.toSQLString());
		//params.add(gatePassRole);
		//params.add(prodLine);
		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.GET_CONTRACTOR_BY_PID_ROLE_PRDLN", params);
		ArrayList<Contractor> list = new ArrayList();

		while (ds.nextRow()) {
			Contractor stdm = new Contractor();
			stdm.setCcode(ds.getString(1));
			stdm.setContractorname(ds.getString(2));

			list.add(stdm);
		}
		return list;
	}


}
