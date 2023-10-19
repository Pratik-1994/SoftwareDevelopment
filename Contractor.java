package com.kronos.wfc.cms.business;

import java.util.Date;
import java.util.List;

import com.kronos.wfc.commonapp.people.business.person.Person;
import com.kronos.wfc.platform.businessobject.framework.KBusinessObject;
import com.kronos.wfc.platform.persistence.framework.ObjectIdLong;
import com.kronos.wfc.platform.utility.framework.datetime.KDate;

public class Contractor implements KBusinessObject {

	private ObjectIdLong contractorid;
	private String contractorname;
	private String caddress;
	private String caddress1;
	private String caddress2;
	private String caddress3;
	private String ccode;
	private String email;
	private String mobilenumber;
	private String managername;
	private String esiwc;
	private KDate esistdt;
	private KDate esieddt;
	private String wcnumber;
	private String licensenumber;
	private KDate licensevalidity1;
	private KDate licensevalidity2;
	private String coverage;
	private String totalstrength;
	private String maxnoofemployees;
	private String natureofwork;
	private String locationofcontractwork;
	private KDate periodofcontract1;
	private KDate periodofcontract2;
	private String vendorCode;
	private String pfcode;
	private String pfnumber;
	private KDate pfcodeapplicationdate;
	private ObjectIdLong unitId;

	public Contractor() {}
	public Contractor(ObjectIdLong contractorid,ObjectIdLong unitId, String contractorname, String caddress, String caddress1,
			String caddress2, String caddress3, String ccode, String email, String mobilenumber, String managername,
			String esiwc, KDate esistdt, KDate esieddt, String wcnumber, String licensenumber, KDate licensevalidity1,
			KDate licensevalidity2, String coverage, String totalstrength, String maxnoofemployees, String natureofwork,
			String locationofcontractwork, KDate periodofcontract1, KDate periodofcontract2, String vendorCode,
			String pfcode, String pfnumber, KDate pfcodeapplicationdate) {
		super();
		
		setContractorid(contractorid);
		setUnitId(unitId);
		setContractorname(contractorname);
		setCaddress(caddress);
		setCaddress1(caddress1);
		setCaddress2(caddress2);
		setCaddress3(caddress3);
		setCcode(ccode);
		setEmail(email);
		setMobilenumber(mobilenumber);
		setManagername(managername);
		setEsiwc(esiwc);
		setEsistdt(esistdt);
		setEsieddt(esieddt);
		setWcnumber(wcnumber);
		setLicensenumber(licensenumber);
		setLicensevalidity1(licensevalidity1);
		setLicensevalidity2(licensevalidity2);
		setCoverage(coverage);
		setTotalstrength(totalstrength);
		setMaxnoofemployees(maxnoofemployees);
		setNatureofwork(natureofwork);
		setLocationofcontractwork(locationofcontractwork);
		setPeriodofcontract1(periodofcontract1);
		setPeriodofcontract2(periodofcontract2);
		setVendorCode(vendorCode);
		setPfcode(pfcode);
		setPfnumber(pfnumber);
		setPfcodeapplicationdate(pfcodeapplicationdate);
	}






	public ObjectIdLong getContractorid() {
		return contractorid;
	}

	public void setContractorid(ObjectIdLong contractorid) {
		this.contractorid = contractorid;
	}


	public String getContractorname() {
		return contractorname;
	}

	public void setContractorname(String contractorname) {
		this.contractorname = contractorname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCaddress1() {
		return caddress1;
	}


	public void setCaddress1(String caddress1) {
		this.caddress1 = caddress1;
	}


	public String getCaddress2() {
		return caddress2;
	}

	public void setCaddress2(String caddress2) {
		this.caddress2 = caddress2;
	}

	public String getCaddress3() {
		return caddress3;
	}


	public void setCaddress3(String caddress3) {
		this.caddress3 = caddress3;
	}


	public String getCcode() {
		return ccode;
	}


	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getEsiwc() {
		return esiwc;
	}


	public void setEsiwc(String esiwc) {
		this.esiwc = esiwc;
	}

	public KDate getEsistdt() {
		return esistdt;
	}

	public void setEsistdt(KDate esistdt) {
		this.esistdt = esistdt;
	}

	public KDate getEsieddt() {
		return esieddt;
	}

	public void setEsieddt(KDate esieddt) {
		this.esieddt = esieddt;
	}


	public String getWcnumber() {
		return wcnumber;
	}

	public void setWcnumber(String wcnumber) {
		this.wcnumber = wcnumber;
	}
	public String getLicensenumber() {
		return licensenumber;
	}

	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}

	public KDate getLicensevalidity1() {
		return licensevalidity1;
	}


	public void setLicensevalidity1(KDate licensevalidity1) {
		this.licensevalidity1 = licensevalidity1;
	}

	public KDate getLicensevalidity2() {
		return licensevalidity2;
	}

	public void setLicensevalidity2(KDate licensevalidity2) {
		this.licensevalidity2 = licensevalidity2;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getTotalstrength() {
		return totalstrength;
	}


	public void setTotalstrength(String totalstrength) {
		this.totalstrength = totalstrength;
	}

	public String getMaxnoofemployees() {
		return maxnoofemployees;
	}


	public void setMaxnoofemployees(String maxnoofemployees) {
		this.maxnoofemployees = maxnoofemployees;
	}

	public String getNatureofwork() {
		return natureofwork;
	}


	public void setNatureofwork(String natureofwork) {
		this.natureofwork = natureofwork;
	}

	public String getLocationofcontractwork() {
		return locationofcontractwork;
	}

	public void setLocationofcontractwork(String locationofcontractwork) {
		this.locationofcontractwork = locationofcontractwork;
	}

	public KDate getPeriodofcontract1() {
		return periodofcontract1;
	}

	public void setPeriodofcontract1(KDate periodofcontract1) {
		this.periodofcontract1 = periodofcontract1;
	}

	public KDate getPeriodofcontract2() {
		return periodofcontract2;
	}

	public void setPeriodofcontract2(KDate periodofcontract2) {
		this.periodofcontract2 = periodofcontract2;
	}


	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getPfcode() {
		return pfcode;
	}


	public void setPfcode(String pfcode) {
		this.pfcode = pfcode;
	}

	public String getPfnumber() {
		return pfnumber;
	}


	public void setPfnumber(String pfnumber) {
		this.pfnumber = pfnumber;
	}


	public KDate getPfcodeapplicationdate() {
		return pfcodeapplicationdate;
	}


	public void setPfcodeapplicationdate(KDate pfcodeapplicationdate) {
		this.pfcodeapplicationdate = pfcodeapplicationdate;
	}


	public ObjectIdLong getUnitId() {
		return unitId;
	}






	public void setUnitId(ObjectIdLong unitId) {
		this.unitId = unitId;
	}






	public static Contractor doRetrieveById(ObjectIdLong oid, ObjectIdLong unitId2) {
		if (oid != null) {
			ContractorService service = new ContractorService();
			Contractor employee = service.retrieveById(oid, unitId2);
			return employee;
		}
		return null;
	}

	public static Contractor doRetrieveByName(String name) {
		if (name != null) {
			ContractorService service = new ContractorService();
			Contractor employee = service.retrieveByName(name);
			return employee;
		}
		return null;
	}


	public static List<Contractor> doRetrieveAll() {

		return (new ContractorService()).retrieveAll();
	}

	public static List<Contractor>  doRetrieveByCode(String code) {
		
		return (new ContractorService()).retrieveByCode(code);
	}
public static List<Contractor>  doRetrieveByCodenUnit(String code,ObjectIdLong unitid) {
		
		return (new ContractorService()).retrieveByCodenUnit(code,unitid);
	}
	
	public static List<Contractor>  doRetrieveByUCode(String code) {
		
		return (new ContractorService()).retrieveByUCode(code);
	}
	
	public void doUpdate() {
		(new ContractorService()).updateContractor(this);
	}

	public static List<Contractor> doRetrieveByUnitId(ObjectIdLong unitId) {

		return (new ContractorService()).retrieveByUnitId(unitId);
	}

	
	public static Contractor doRetrieveByName(String name, String unitId2) {
		
		return (new ContractorService()).retrieveByName(name, unitId2);
	}

	public static Contractor doRetrieveByCode(String code, String unitId2) {
		
		return (new ContractorService()).retrieveByCode(code, unitId2);
	}


	  
	  private Boolean selected = Boolean.valueOf(false);
	  public Boolean getSelected() {
	    return selected;
	  }
	  
	  public void setSelected(Boolean selected) {
	    this.selected = selected;
	  }

	public static Contractor doRetrieveById(ObjectIdLong objectIdLong, Integer int1, Person byPersonId, Object object,
			String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<Contractor> doRetrieveByPid(ObjectIdLong PId) {

		return (new ContractorService()).retrieveByPid(PId);
	}
	public static List<Contractor> doRetrieveByPIdRoleAndPrdln(ObjectIdLong pId, String gatePassRole, String prodLine) {
		return (new ContractorService()).retrieveByPIdRoleAndPrdln(pId,gatePassRole,prodLine);
	}



}
