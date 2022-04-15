package com.test.demo;

import java.io.File;

public class HTMLtoPDF {
	
	private static final String toPdfTool = "D:\\BISHE\\newWorkSpace\\TestProject\\src\\main\\webapp\\core\\wkhtmltopdf\\bin\\wkhtmltopdf";
	
	public static boolean convert(String srcPath, String destPath){
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if(!parent.exists()){
            parent.mkdirs();
        }
        
        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);
        
        boolean result = true;
        try{
            Process proc = Runtime.getRuntime().exec(cmd.toString());
//            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
//            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
//            error.start();
//            output.start();
            proc.waitFor();
            System.out.println("pdf创建成功");
        }catch(Exception e){
            result = false;
            e.printStackTrace();
            System.out.println("pdf创建失败");
        }
        
        return result;
    }
	

}
