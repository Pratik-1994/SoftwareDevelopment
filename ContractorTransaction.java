package com.kronos.wfc.cms.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kronos.wfc.platform.datetime.framework.KServer;
import com.kronos.wfc.platform.persistence.framework.ObjectIdLong;
import com.kronos.wfc.platform.persistence.framework.SQLStatement;
import com.kronos.wfc.platform.persistence.framework.Transaction;

public class ContractorTransaction extends Transaction {
	
	

	public static final String RETRIEVEBYNAME = "RetrieveByName";
	private Contractor contr= null;	

	public ContractorTransaction(Contractor contr) {
		this.contr = contr;
	}

	@Override
	protected void transaction() throws SQLException {
		
		ArrayList<String> parm = new ArrayList<String>();
		parm.add(getConcactAddress(contr.getCaddress(), contr.getCaddress1(),contr.getCaddress2(), contr.getCaddress3()));
		parm.add(contr.getCcode());
		parm.add(((ObjectIdLong)contr.getContractorid()).toSQLString());
		SQLStatement update = new SQLStatement(SQLStatement.PREPARE_UPDATE, "cms.business.UPDATECONTRACTOR");
        update.execute(parm);
        
		ArrayList params = new ArrayList<String>();
		params.add(contr.getManagername());
		params.add(contr.getLicensenumber());
		params.add(contr.getLicensevalidity1());
		params.add(contr.getLicensevalidity2());
		params.add(contr.getCoverage());
		params.add(contr.getTotalstrength());
		params.add(contr.getMaxnoofemployees());
		params.add(contr.getNatureofwork());
		params.add(contr.getLocationofcontractwork());
		params.add(contr.getPeriodofcontract1());
		params.add(contr.getPeriodofcontract2());
		params.add(contr.getPfcode());
		params.add(contr.getEsiwc());
		params.add(contr.getEsistdt());
		params.add(contr.getEsieddt());
		params.add(contr.getPfnumber());
		params.add(contr.getPfcodeapplicationdate());
		params.add(contr.getEmail());
		params.add(contr.getMobilenumber());
		params.add(contr.getWcnumber());
		params.add(((ObjectIdLong)contr.getContractorid()).toSQLString());
		params.add(((ObjectIdLong)contr.getUnitId()).toSQLString());
		SQLStatement update1 = new SQLStatement(SQLStatement.PREPARE_UPDATE, "cms.business.UPDATECONTRACTOR1M");
        update1.execute(params);
        
	}
	private String getConcactAddress(String caddress,String caddress1,
			String caddress2,String caddress3){
			
			StringBuffer buffer=new StringBuffer();
		
		if(caddress!=null){
			
			buffer.append(caddress);
		}
			buffer.append("|");
		
		if(caddress1 !=null){
			
			buffer.append(caddress1);
			
		}
		buffer.append("|");
		
		if(caddress2 != null){
			
			buffer.append(caddress2);
		}
		buffer.append("|");
		
		if(caddress3 != null){
			
			buffer.append(caddress3);
		}
	  return buffer.toString();
		
		
		
	}

}
