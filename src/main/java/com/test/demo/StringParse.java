package com.test.demo;

public class StringParse {

    public static String getSinkInvokeType(String info){
        String[] infos = info.split(" ");
        return infos[0];
    }

    public static String getSourceInvokeType(String info){
        String[] infos = info.split(" ");
        return infos[2];
    }

    public static String getInvokeMethod(String info){
        String ss = info.substring(info.indexOf("<"), info.length());
        return ss;
    }

    public static String getSinkMethod(String info){
        return info;
    }

}
