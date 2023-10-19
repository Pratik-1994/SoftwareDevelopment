package com.kronos.wfc.cms.business;

import java.util.ArrayList;
import java.util.List;

import com.kronos.wfc.platform.businessobject.framework.KBusinessObject;
import com.kronos.wfc.platform.persistence.framework.ObjectId;
import com.kronos.wfc.platform.persistence.framework.ObjectIdLong;

public class PrincipalEmployee implements KBusinessObject {

	private ObjectIdLong unitid;
	private String unitname;
	private String unitcode;
	private String name;
	private String type;
	private String peaddress;
	private String hrmcode;
	private String hrmname;
	private String fmcode;
	private String fmname;
	private String organization;
	private String clralicnum;
	private String totalstrngth;
	private String noContr;
	private String location;
	private String tohec;
	private String ton;
	private String esic;
	private String pt;
	private String gst;
	private String lwf;
	private String rc;
	private String rcfd;
	private String rced;
	private String fl;
	private String flfd;
	private String fled;
	private String sne;
	private String snefd;
	private String sneed;
	private String wcin;
	private String wcinfd;
	private String wcined;
	private String Hin;
	private String Hinfd;
	private String Hined;
	private String tli;
	private String tlifd;
	private String tlied;
	private String ismw;
	private String ismwfd;
	private String ismwed;
	private String pfCode;

	private List<CustomProperties> properties;

	public PrincipalEmployee(ObjectIdLong unitid, String unitname, String unitcode, String name, String type, String peaddress,
			String hrmcode, String hrmname, String fmcode, String fmname, String organization
			,String clralicnum,String totalstrngth,String noContr,List<CustomProperties>props,String location, String tohec, String ton, String esic
			, String pt , String gst , String lwf , String rc , String rcfd , String rced , String fl , String flfd , String fled , String sne
			, String snefd , String sneed , String wcin , String wcinfd , String wcined , String Hin , String Hinfd , String Hined , String tli
			, String tlifd , String tlied , String ismw , String ismwfd , String ismwed , String pfCode ) {
		super();
		setUnitiD(unitid.longValue());
		this.unitname = unitname;
		this.unitcode = unitcode;
		this.name = name;
		this.type = type;
		this.peaddress = peaddress;
		this.hrmcode = hrmcode;
		this.hrmname = hrmname;
		this.fmcode = fmcode;
		this.fmname = fmname;
		this.organization = organization;
		this.setProperties(props);
		this.clralicnum = clralicnum;
		this.totalstrngth = totalstrngth;
		this.noContr = noContr;
		this.location=location;
		this.tohec=tohec;
		this.ton=ton;
		this.esic=esic;
		this.pt=pt;
		this.pfCode=pfCode;
		this.gst=gst;
		this.lwf=lwf; 
		this.rc=rc;
		this.rcfd=rcfd;
		this.rced=rced;
		this.fl=fl;
		this.flfd=flfd;
		this.fled=fled;
		this.sne=sne;
		this.snefd=snefd;
		this.sneed=sneed;
		this.wcin=wcin;
		this.wcinfd=wcinfd;
		this.wcined=wcined;
		this.Hin=Hin;
		this.Hinfd=Hinfd;
		this.Hined=Hined;
		this.tli=tli;
		this.tlifd=tlifd; 
		this.tlied=tlied; 
		this.ismw=ismw;
		this.ismwfd=ismwfd; 
		this.ismwed=ismwed;
	}

	public PrincipalEmployee() {
		// TODO Auto-generated constructor stub
	}

	public ObjectId getUnitid() {
		return unitid;
	}

	public void setUnitiD(long id)
	{
		unitid = new ObjectIdLong(id);
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getUnitcode() {
		return unitcode;
	}

	public void setUnitcode(String unitcode) {
		this.unitcode = unitcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPeaddress() {
		return peaddress;
	}

	public void setPeaddress(String peaddress) {
		this.peaddress = peaddress;
	}

	public String getHrmcode() {
		return hrmcode;
	}

	public void setHrmcode(String hrmcode) {
		this.hrmcode = hrmcode;
	}

	public String getHrmname() {
		return hrmname;
	}

	public void setHrmname(String hrmname) {
		this.hrmname = hrmname;
	}

	public String getFmcode() {
		return fmcode;
	}

	public void setFmcode(String fmcode) {
		this.fmcode = fmcode;
	}

	public String getFmname() {
		return fmname;
	}

	public void setFmname(String fmname) {
		this.fmname = fmname;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public List<CustomProperties> getProperties() {
		return properties;
	}

	public void setProperties(List<CustomProperties> properties) {
		this.properties = properties;
	}


	public String getClralicnum() {
		return clralicnum;
	}

	public void setClralicnum(String clralicnum) {
		this.clralicnum = clralicnum;
	}

	public String getTotalstrngth() {
		return totalstrngth;
	}

	public void setTotalstrngth(String totalstrngth) {
		this.totalstrngth = totalstrngth;
	}

	public String getNoContr() {
		return noContr;
	}

	public void setNoContr(String noContr) {
		this.noContr = noContr;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTohec() {
		return tohec;
	}

	public void setTohec(String tohec) {
		this.tohec = tohec;
	}

	public String getTon() {
		return ton;
	}

	public void setTon(String ton) {
		this.ton = ton;
	}

	public String getEsic() {
		return esic;
	}

	public void setEsic(String esic) {
		this.esic = esic;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getLwf() {
		return lwf;
	}

	public void setLwf(String lwf) {
		this.lwf = lwf;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getRcfd() {
		return rcfd;
	}

	public void setRcfd(String rcfd) {
		this.rcfd = rcfd;
	}

	public String getRced() {
		return rced;
	}

	public void setRced(String rced) {
		this.rced = rced;
	}

	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getFlfd() {
		return flfd;
	}

	public void setFlfd(String flfd) {
		this.flfd = flfd;
	}

	public String getFled() {
		return fled;
	}

	public void setFled(String fled) {
		this.fled = fled;
	}

	public String getSne() {
		return sne;
	}

	public void setSne(String sne) {
		this.sne = sne;
	}

	public String getSnefd() {
		return snefd;
	}

	public void setSnefd(String snefd) {
		this.snefd = snefd;
	}

	public String getSneed() {
		return sneed;
	}

	public void setSneed(String sneed) {
		this.sneed = sneed;
	}

	public String getWcin() {
		return wcin;
	}

	public void setWcin(String wcin) {
		this.wcin = wcin;
	}

	public String getWcinfd() {
		return wcinfd;
	}

	public void setWcinfd(String wcinfd) {
		this.wcinfd = wcinfd;
	}

	public String getWcined() {
		return wcined;
	}

	public void setWcined(String wcined) {
		this.wcined = wcined;
	}

	public String getHin() {
		return Hin;
	}

	public void setHin(String hin) {
		Hin = hin;
	}

	public String getHinfd() {
		return Hinfd;
	}

	public void setHinfd(String hinfd) {
		Hinfd = hinfd;
	}

	public String getHined() {
		return Hined;
	}

	public void setHined(String hined) {
		Hined = hined;
	}

	public String getTli() {
		return tli;
	}

	public void setTli(String tli) {
		this.tli = tli;
	}

	public String getTlifd() {
		return tlifd;
	}

	public void setTlifd(String tlifd) {
		this.tlifd = tlifd;
	}

	public String getTlied() {
		return tlied;
	}

	public void setTlied(String tlied) {
		this.tlied = tlied;
	}

	public String getIsmw() {
		return ismw;
	}

	public void setIsmw(String ismw) {
		this.ismw = ismw;
	}

	public String getIsmwfd() {
		return ismwfd;
	}

	public void setIsmwfd(String ismwfd) {
		this.ismwfd = ismwfd;
	}

	public String getIsmwed() {
		return ismwed;
	}

	public void setIsmwed(String ismwed) {
		this.ismwed = ismwed;
	}

	public String getPfCode() {
		return pfCode;
	}

	public void setPfCode(String pfCode) {
		this.pfCode = pfCode;
	}

	public static PrincipalEmployee doRetrieveForUpdate(String unitName)
	{
		if(unitName != null){
			PrincipalEmployeeService service = new PrincipalEmployeeService();
			PrincipalEmployee employee = service.retrieveByCode(unitName);
			return employee;
		}
		return null;
	}


	public static PrincipalEmployee doRetrieveById(ObjectIdLong oid) {
		if(oid != null){
			PrincipalEmployeeService service = new PrincipalEmployeeService();
			PrincipalEmployee employee = service.retrieveById(oid);
			return employee;
		}
		return null;
	}

	public static PrincipalEmployee doRetrieveByCode(String name) {
		if(name != null){
			PrincipalEmployeeService service = new PrincipalEmployeeService();
			PrincipalEmployee employee = service.retrieveByCode(name);
			return employee;
		}
		return null;
	}

	public static PrincipalEmployee doRetrievePe() {
		PrincipalEmployeeService service = new PrincipalEmployeeService();
		PrincipalEmployee employee = service.retrieveData();
		return employee;

	}

	public  List<PrincipalEmployee> doRetrieveByUnitCode(String uCode) {
		PrincipalEmployeeService service = new PrincipalEmployeeService();
		List<PrincipalEmployee> employees = service.retrieveByUnitCode(uCode);
		return employees;

	}
	public static List<PrincipalEmployee> doRetrieveAll() {
		PrincipalEmployeeService service = new PrincipalEmployeeService();
		List<PrincipalEmployee> employees = service.retrieveAll();
		return employees;

	}
	/*
	 * public void doUpdate() { (new
	 * PrincipalEmployeeService()).updateContractor(this); }
	 */

	public void doUpdate() {
		validateAccessRight("Update");

		List employees = new ArrayList(1);

		PrincipalEmployeeService service = new PrincipalEmployeeService();

		if(unitid != null) 
		{ 
			PrincipalEmployee employee = service.retrieveById(unitid); 
			if(employee != null) 
			{
				employee.updateFields(this); 
				employees.add(employee);
				service.updatePrincipalEmployee(employees); 
			} 
		}

	}


	/*
	 * Updates the employees
	 */
	/**
	 * @param pe
	 */
	private void updateFields(PrincipalEmployee pe) {
		this.setUnitname(pe.getUnitname());
		this.setUnitcode(pe.getUnitcode());
		this.setName(pe.getName());
		this.setType(pe.getType());
		this.setPeaddress(pe.getPeaddress());
		this.setHrmcode(pe.getHrmcode());
		this.setHrmname(pe.getHrmname());
		this.setFmcode(pe.getFmcode());
		this.setFmname(pe.getFmname());
		this.setOrganization(pe.getOrganization());
		this.setClralicnum(pe.getClralicnum());
		this.setTotalstrngth(pe.getTotalstrngth());
		this.setNoContr(pe.getNoContr());
		this.setLocation(pe.getLocation());
		this.setTohec(pe.getTohec());
		this.setTon(pe.getTon());
		this.setEsic(pe.getEsic());
		this.setPt(pe.getPt());
		this.setPfCode(pe.getPfCode());
		this.setGst(pe.getGst());
		this.setLwf(pe.getLwf());
		this.setRc(pe.getRc());
		this.setRcfd(pe.getRcfd());
		this.setRced(pe.getRced());
		this.setFl(pe.getFl());
		this.setFlfd(pe.getFlfd());
		this.setFled(pe.getFled());
		this.setSne(pe.getSne());
		this.setSnefd(pe.getSnefd());
		this.setSneed(pe.getSneed());
		this.setWcin(pe.getWcin());
		this.setWcinfd(pe.getWcined());
		this.setWcined(pe.getWcined());
		this.setHin(pe.getHin());
		this.setHinfd(pe.getHinfd());
		this.setHined(pe.getHined());
		this.setTli(pe.getTli());
		this.setTlifd(pe.getTlifd());
		this.setTlied(pe.getTlied());
		this.setIsmw(pe.getIsmw());
		this.setIsmwfd(pe.getIsmwfd());
		this.setIsmwed(pe.getIsmwed());
	}

	public static boolean validateAccessRight(String actionName)
	{
		return true;
	}

	public void setPrincipleEmployee(ObjectIdLong id, String unitname, String address)
	{
		setPrincipleEmployee(id, unitname, address);

	}

	public boolean isReadable(String propertyName)
	{
		if(propertyName.equals("unitname"))
			return true;
		if(propertyName.equals("address"))
			return true;
		if(propertyName.equals("managername"))
			return true;
		return propertyName.equals("Properties");
	}


}
