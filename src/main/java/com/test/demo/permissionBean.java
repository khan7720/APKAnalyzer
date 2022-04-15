package com.test.demo;

public class permissionBean {
	private int pid;
	private int apkid;
	private String pname;
	private String plevel;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getApkid() {
		return apkid;
	}
	public void setApkid(int apkid) {
		this.apkid = apkid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPlevel() {
		return plevel;
	}
	public void setPlevel(String plevel) {
		this.plevel = plevel;
	}
	
	@Override
	public String toString() {
		return "permissionBean [pid=" + pid + ", apkid=" + apkid + ", pname=" + pname + ", plevel=" + plevel + "]";
	}
	

}
