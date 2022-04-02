package com.test.demo;


import java.io.*;
import java.util.Base64;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException; 
import freemarker.template.TemplateExceptionHandler;

public class DocUtil {
    public Configuration configure=null;
    
    public DocUtil(){
        configure=new Configuration(Configuration.VERSION_2_3_22);
        configure.setDefaultEncoding("utf-8");
    }

    public void createDoc(Map<String,Object> dataMap,String downloadType,String savePath){
        try {
            
            Template template=null;
            configure.setClassForTemplateLoading(this.getClass(), "/testDoc");
            configure.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            template=configure.getTemplate(downloadType+".xml");
            File outFile=new File(savePath);
            Writer out=null;
            out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            template.process(dataMap, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    
    public String getImageStr(String imgFile){
        InputStream in=null;
        byte[] data=null;
        try {
            in=new FileInputStream(imgFile);
            data=new byte[in.available()];
            in.read(data);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);
    }
}