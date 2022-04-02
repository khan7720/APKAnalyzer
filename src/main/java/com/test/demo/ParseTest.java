package com.test.demo;

import java.io.InputStream;
import java.util.List;

public class ParseTest {
    public static void main(String[] args) throws Throwable {
        ParseTest pt = new ParseTest();
        pt.testSAX();
    }
    public void testSAX() throws Throwable{
        SaxParseService sax1 = new SaxParseService();
        SaxParseService sax2 = new SaxParseService();
        InputStream input1 = this.getClass().getClassLoader().getResourceAsStream("sdout.xml");
        InputStream input2 = this.getClass().getClassLoader().getResourceAsStream("sdout.xml");
        List<Sink> sinks = sax1.getSinks(input1);
        List<Source> sources = sax2.getSources(input2);
        for(Sink sink : sinks){
            System.out.println(sink.toString());
        }
        for(Source source : sources){
            System.out.println(source.toString());
        }
    }
}