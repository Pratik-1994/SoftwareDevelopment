package com.kronos.wfc.cms.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ibm.icu.util.StringTokenizer;
import com.kronos.wfc.platform.persistence.framework.ObjectId;
import com.kronos.wfc.platform.persistence.framework.ObjectIdLong;
import com.kronos.wfc.platform.persistence.framework.SQLStatement;
import com.kronos.wfc.platform.persistence.framework.statement.DataStoreIfc;
import com.kronos.wfc.platform.utility.framework.collator.CollatorManager;

public class PrincipalEmployeeService {

	public PrincipalEmployee retrieveByCode(String unitCode) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(unitCode);
		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_BY_CODE", params);
		if(ds.nextRow()){
			return createPEObject(ds);
		}
		return null;
	}

	public PrincipalEmployee retrieveData() {

		ArrayList<String> params = new ArrayList<String>();
		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_PE_DATA", params);
		if(ds.nextRow()){
			return createPEObject(ds);
		}
		return null;
	}

	public List<PrincipalEmployee> retrieveByUnitCode(String unitCode) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(unitCode);
		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_BY_CODE", params);
		return createPEObjects(ds);
	}

	public List<PrincipalEmployee> retrieveAll() {

		ArrayList<String> params = new ArrayList<String>();
		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_ALL", params);
		return createPEObjects(ds);
	}


	private PrincipalEmployee createPEObject(DataStoreIfc ds) {

		ObjectIdLong unitid = ds.getObjectIdLong(1);
		String unitname  = ds.getString(2);
		String unitcode = ds.getString(3);
		String name = ds.getString(4);
		String type = ds.getString(5);
		String peaddress =ds.getString(6);
		String hrmcode= ds.getString(7);
		String hrmname = ds.getString(8);
		String fmcode = ds.getString(9);
		String fmname = ds.getString(10);
		String organization  = ds.getString(11);
		String clralicnum = ds.getString(12) ;
		String totalstrngth = ds.getString(13);
		String noContr = ds.getString(14);
		String location=ds.getString(15);
		String tohec=ds.getString(16);
		String ton=ds.getString(17);
		String esic=ds.getString(18);
		String pfCode=ds.getString(19);
		String pt=ds.getString(20);
		String lwf=ds.getString(21);
		String gst=ds.getString(22);
		String rc=ds.getString(23);
		String rcfd=ds.getString(24);
		String rced=ds.getString(25);
		String fl=ds.getString(26);
		String flfd=ds.getString(27);
		String fled=ds.getString(28);
		String sne=ds.getString(29);
		String snefd=ds.getString(30);
		String sneed=ds.getString(31);
		String wcin=ds.getString(32);
		String wcinfd=ds.getString(33);
		String wcined=ds.getString(34);
		String Hin=ds.getString(35);
		String Hinfd=ds.getString(36);
		String Hined=ds.getString(37);
		String tli=ds.getString(38);
		String tlifd=ds.getString(39);
		String tlied=ds.getString(40);
		String ismw=ds.getString(41);
		String ismwfd=ds.getString(42);
		String ismwed=ds.getString(43);
		PrincipalEmployee emp = new PrincipalEmployee();
		emp.setUnitiD(unitid.longValue());
		emp.setUnitname(unitname);
		emp.setUnitcode(unitcode);
		emp.setName(name);
		emp.setType(type);
		emp.setPeaddress(peaddress);
		emp.setHrmcode(hrmcode);
		emp.setHrmname(hrmname);
		emp.setFmcode(fmcode);
		emp.setFmname(fmname);
		emp.setOrganization(organization);
		emp.setClralicnum(clralicnum);
		emp.setTotalstrngth(totalstrngth);
		emp.setNoContr(noContr);
		emp.setLocation(location);
		emp.setTohec(tohec);
		emp.setTon(ton);
		emp.setEsic(esic);
		emp.setPt(pt);
		emp.setPfCode(pfCode);
		emp.setGst(gst);
		emp.setLwf(lwf);
		emp.setRc(rc);
		emp.setRcfd(rcfd);
		emp.setRced(rced);
		emp.setFl(fled);
		emp.setFlfd(flfd);
		emp.setFled(fled);
		emp.setSne(sne);
		emp.setSnefd(snefd);
		emp.setSneed(sneed);
		emp.setWcin(wcin);
		emp.setWcinfd(wcinfd);
		emp.setWcined(wcined);
		emp.setHin(Hin);
		emp.setHinfd(Hinfd);
		emp.setHined(Hined);
		emp.setTli(tli);
		emp.setTlifd(tlifd);
		emp.setTlied(tlied);
		emp.setIsmw(ismwed);
		emp.setIsmwfd(ismwfd);
		emp.setIsmwed(ismwed);
		ArrayList params = new ArrayList();

		params.add(unitid); 
		ds = getDataStoreFromSQLStatement("business.cms.SELECT_PE_PROPS_BY_UNITID",params); 
		ArrayList<CustomProperties> propertyList = new ArrayList();
		emp.setProperties(propertyList); CustomProperties property;
		for(;ds.nextRow(); propertyList.add(property)) { 
			ObjectIdLong custId = ds.getObjectIdLong(1); 
			String fieldName = ds.getString(2); 
			String fieldValue = ds.getString(3); 
			property = new CustomProperties(custId, fieldName,fieldValue, unitid); 
		} 
		if(!propertyList.isEmpty())
			Collections.sort(propertyList, new CustomPropertiesComparator(CollatorManager.getCollator()));
		
		return emp;

	}

	private List<PrincipalEmployee> createPEObjects(DataStoreIfc ds) {
		ArrayList<PrincipalEmployee> list = new ArrayList<PrincipalEmployee>();

		while (ds.nextRow())
		{
			PrincipalEmployee employee = createPEObject(ds);
			list.add(employee);
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

	private static DataStoreIfc getDataStoreFromSQLStatement(String sqlStatement,
			ArrayList<String> params) {
		SQLStatement select = new SQLStatement(SQLStatement.PREPARE_SELECT, sqlStatement);
		select.execute(params);
		DataStoreIfc ds = select.getDataStore();
		return ds;

	}

	public PrincipalEmployee retrieveById(ObjectId unitId) {
		ArrayList<String> params = new ArrayList<String>();
		params.add(((ObjectIdLong)unitId).toSQLString());
		DataStoreIfc ds = getDataStoreFromSQLStatement("business.cms.SELECT_BY_ID", params);
		return createPEObject(ds);
	}


	public void updatePrincipalEmployee(List employees) {
		if(employees!=null && !employees.isEmpty()){
			for (java.util.Iterator<PrincipalEmployee> iterator = employees.iterator(); iterator
					.hasNext();) {
				PrincipalEmployee employee = (PrincipalEmployee) iterator.next();
				updateEmployee(employee);

			}
		}

	}



	private void updateEmployee(PrincipalEmployee employee) {
		PrincipalEmployeeTransaction trans = new PrincipalEmployeeTransaction(employee);
		trans.run();
	}

	public void updateContractor(PrincipalEmployee pe) {
		PrincipalEmployeeTransaction trans = new PrincipalEmployeeTransaction(pe);
		trans.run();
	}
}
