package com.test.demo;

public class apiBean {
	
	private int aid;
	private int apkid;
	private String aname;
	
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
	@Override
	public String toString() {
		return "apiBean [aid=" + aid + ", apkid=" + apkid + ", aname=" + aname + "]";
	}
	
	

}
