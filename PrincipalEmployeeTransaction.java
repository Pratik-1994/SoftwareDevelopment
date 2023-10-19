package com.kronos.wfc.cms.business;

import com.kronos.wfc.platform.persistence.framework.ObjectIdLong;
import com.kronos.wfc.platform.persistence.framework.SQLStatement;
import com.kronos.wfc.platform.persistence.framework.Transaction;
import java.sql.SQLException;
import java.util.ArrayList;



public class PrincipalEmployeeTransaction
extends Transaction
{
	private PrincipalEmployee employee = null;

	public PrincipalEmployeeTransaction(PrincipalEmployee emp) {
		employee = emp;
	}

	protected void transaction() throws SQLException
	{
		updateEmployee();
		//updateCustomProperties();
	}


	private void updateCustomProperties()
	{
		CMSConfigPropertyTransaction configPropertyTransaction = new CMSConfigPropertyTransaction(employee);
		configPropertyTransaction.run();
	}

	private void updateEmployee() {
		ArrayList params = new ArrayList<String>();

		params.add(employee.getUnitname());
		params.add(employee.getUnitcode());
		params.add(employee.getType());
		params.add(employee.getPeaddress());
		params.add(employee.getHrmcode());
		params.add(employee.getHrmname());
		params.add(employee.getFmcode());
		params.add(employee.getFmname());	
		params.add(employee.getOrganization());
		params.add(employee.getClralicnum());
		params.add(employee.getTotalstrngth());	
		params.add(employee.getNoContr());
		params.add(employee.getLocation());
		params.add(employee.getTohec());
		params.add(employee.getTon());
		params.add(employee.getEsic());
		params.add(employee.getPfCode());
		params.add(employee.getPt());
		params.add(employee.getLwf());
		params.add(employee.getGst());
		params.add(employee.getRc());
		params.add(employee.getRcfd());
		params.add(employee.getRced());
		params.add(employee.getFl());
		params.add(employee.getFlfd());
		params.add(employee.getFled());
		params.add(employee.getSne());
		params.add(employee.getSnefd());
		params.add(employee.getSneed());
		params.add(employee.getWcin());
		params.add(employee.getWcinfd());
		params.add(employee.getWcined());
		params.add(employee.getHin());
		params.add(employee.getHinfd());
		params.add(employee.getHined());
		params.add(employee.getTli());
		params.add(employee.getTlifd());
		params.add(employee.getTlied());
		params.add(employee.getIsmw());
		params.add(employee.getIsmwfd());
		params.add(employee.getIsmwed());
		params.add(((ObjectIdLong)employee.getUnitid()).toSQLString());

		SQLStatement update = new SQLStatement(SQLStatement.PREPARE_UPDATE, "cms.business.Update");
		update.execute(params);
	}

}
