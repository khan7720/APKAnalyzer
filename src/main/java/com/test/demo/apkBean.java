package com.test.demo;

public class apkBean {
	private int apkID;
	private String apkName;
	private int apkSize;
	private int codeSize;
	private float CFGTime;
	private float FastDroidTime;
	private int AnalysedClass;
	private int AnalysedMethod;
	private int AnalysedStatement;
	private int TaintFlow;
	private int MayTaintFlow;
	private String StartTime;
	private int permission;
	private int API;
	
	
	
	public int getApkID() {
		return apkID;
	}
	public void setApkID(int apkID) {
		this.apkID = apkID;
	}
	public String getApkName() {
		return apkName;
	}
	public void setApkName(String apkName) {
		this.apkName = apkName;
	}
	public int getApkSize() {
		return apkSize;
	}
	public void setApkSize(int apkSize) {
		this.apkSize = apkSize;
	}
	public int getCodeSize() {
		return codeSize;
	}
	public void setCodeSize(int codeSize) {
		this.codeSize = codeSize;
	}
	public float getCFGTime() {
		return CFGTime;
	}
	public void setCFGTime(float cFGTime) {
		CFGTime = cFGTime;
	}
	public float getFastDroidTime() {
		return FastDroidTime;
	}
	public void setFastDroidTime(float fastDroidTime) {
		FastDroidTime = fastDroidTime;
	}
	public int getAnalysedClass() {
		return AnalysedClass;
	}
	public void setAnalysedClass(int analysedClass) {
		AnalysedClass = analysedClass;
	}
	public int getAnalysedMethod() {
		return AnalysedMethod;
	}
	public void setAnalysedMethod(int analysedMethod) {
		AnalysedMethod = analysedMethod;
	}
	public int getAnalysedStatement() {
		return AnalysedStatement;
	}
	public void setAnalysedStatement(int analysedStatement) {
		AnalysedStatement = analysedStatement;
	}
	public int getTaintFlow() {
		return TaintFlow;
	}
	public void setTaintFlow(int taintFlow) {
		TaintFlow = taintFlow;
	}
	public int getMayTaintFlow() {
		return MayTaintFlow;
	}
	public void setMayTaintFlow(int mayTaintFlow) {
		MayTaintFlow = mayTaintFlow;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getAPI() {
		return API;
	}
	public void setAPI(int aPI) {
		API = aPI;
	}
	
	@Override
	public String toString() {
		return "apkBean [apkID=" + apkID + ", apkName=" + apkName + ", apkSize=" + apkSize + ", codeSize=" + codeSize
				+ ", CFGTime=" + CFGTime + ", FastDroidTime=" + FastDroidTime + ", AnalysedClass=" + AnalysedClass
				+ ", AnalysedMethod=" + AnalysedMethod + ", AnalysedStatement=" + AnalysedStatement + ", TaintFlow="
				+ TaintFlow + ", MayTaintFlow=" + MayTaintFlow + ", StartTime=" + StartTime + ", permission="
				+ permission + ", API=" + API + "]";
	}
	
	
}
