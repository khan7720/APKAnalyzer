package com.test.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class htmlUnitTest {

	public static String generateHTML(String filename, String currentID)
			throws IOException, UnsupportedEncodingException, FileNotFoundException, MalformedURLException {
		String path = "D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\output\\intermediateHTML\\";
		String pageHead = "http://localhost:8080/TestProject/ReportGenerateServlet?filename=";
		String pageTail = "&currentID=";
		String pageURL = pageHead+filename+pageTail+currentID;
		System.out.println(pageURL);
		String newfile = path+filename+"ID-"+currentID+".html";
		
		//filenameTemp 为定义的本地路径文件            
		File file = new File(newfile);
		file.createNewFile();
		OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(newfile), "UTF-8");   
		WebClient webClient = new WebClient();
		webClient.getOptions().setJavaScriptEnabled(true);//设置javascript和css
		webClient.getOptions().setCssEnabled(true);
		//获得你想要页面的路径（网址换成本项目想生成的页面的请求路径）
		HtmlPage page = webClient.getPage(pageURL);
		String str = page.asXml();
		//html头
		write.write("<!DOCTYPE html>"+str);     
		write.close(); 
		webClient.close();
		System.out.println(newfile+"中间HTML生成成功");
		
		return newfile;
	}
}
