package com.test.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ResultExtractor {
	
	public static void main(String[] args) {
		String fileName = "D:\\BISHE\\NewTest\\out";
		
		apkBean a = new apkBean();
		
		try (Scanner sc = new Scanner(new FileReader(fileName))) { //try-with-resources
		      while (sc.hasNextLine()) {  //按行读取字符串
		         String line = sc.nextLine();
		         extract(line,a);
		        // System.out.println(line);
		        		         
		      }
		      
		      System.out.println(a.toString());
		      
//		      MyDAO md = new MyDAO();
//		         ArrayList<apkBean> array = md.select_all_apk();
//		         for(apkBean a: array) {
//		        	 System.out.println(a.toString()); }
		      
		      
		         
		} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
	}
	
	
	public static void extract(String line, apkBean a) {
		if(line.startsWith("Analyse")) {
			a.setApkName(line.substring(line.indexOf('<')+1, line.indexOf('>')));
		}else if(line.startsWith("Permission")) {
			a.setPermission(a.getPermission()+1);
		}else if(line.startsWith("Totally")) {
			a.setAnalysedClass(Integer.parseInt(line.substring(line.indexOf("analysis:")+9, line.indexOf("Classes")-1)));
			a.setAnalysedMethod(Integer.parseInt(line.substring(line.indexOf("Classes")+9, line.indexOf("Methods")-1)));
			a.setAnalysedStatement(Integer.parseInt(line.substring(line.indexOf("Methods")+9, line.indexOf("Statements")-1)));
		}else if(line.startsWith("Apk Size")) {
			a.setApkSize(Integer.parseInt(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("code size")) {
			a.setCodeSize(Integer.parseInt(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("CFG")) {
			a.setCFGTime(Float.parseFloat(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("Fastdroid")) {
			a.setFastDroidTime(Float.parseFloat(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("TaintFlow totally")){
			a.setTaintFlow(Integer.parseInt(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}else if(line.startsWith("MayTaintFlow")) {
			a.setMayTaintFlow(Integer.parseInt(line.substring(line.indexOf('<')+1, line.indexOf('>'))));
		}
		
		
		
	}


}
