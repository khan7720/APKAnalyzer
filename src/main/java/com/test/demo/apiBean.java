package com.test.demo;

public class apiBean {
	
	private int aid;
	private int apkid;
	private String aname;
	private String caller;
	private String routeType;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getApkid() {
		return apkid;
	}
	public void setApkid(int apkid) {
		this.apkid = apkid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public String getRouteType() {
		return routeType;
	}
	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	@Override
	public String toString() {
		return "apiBean [aid=" + aid + ", apkid=" + apkid + ", aname=" + aname + ", caller=" + caller + ", routeType="
				+ routeType + "]";
	}
	

	
	

}
