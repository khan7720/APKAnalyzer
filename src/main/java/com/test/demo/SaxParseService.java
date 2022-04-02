package com.test.demo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SaxParseService extends DefaultHandler {
    private List<Sink> sinks = null;
    private List<Source> sources = null;
    private Sink sink = null;
    private Source source = null;
    private String preTag = null;

    public List<Sink> getSinks(InputStream xmlStream) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxParseService handler = new SaxParseService();
        parser.parse(xmlStream, handler);
        return handler.getSinks();
    }

    public List<Source> getSources(InputStream xmlStream) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxParseService handler = new SaxParseService();
        parser.parse(xmlStream, handler);
        return handler.getSources();
    }

    public List<Sink> getSinks(){
        return sinks;
    }

    public List<Source> getSources(){
        return sources;
    }

    @Override
    public void startDocument() throws SAXException {
        sinks = new ArrayList<>();
        sources = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("Sink".equals(qName)){
            sink = new Sink();
            sink.setInvokeType(StringParse.getSinkInvokeType(attributes.getValue(0)));
            sink.setInvokeMethod(StringParse.getInvokeMethod(attributes.getValue(0)));
            sink.setSinkMethod(StringParse.getSinkMethod(attributes.getValue(1)));
        }
        if("Source".equals(qName)){
            source = new Source();
            source.setInvokeType(StringParse.getSourceInvokeType(attributes.getValue(0)));
            source.setInvokeMethod(StringParse.getInvokeMethod(attributes.getValue(0)));
            source.setSourceMethod(StringParse.getSinkMethod(attributes.getValue(1)));
        }
        preTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("Sink".equals(qName)){
            sinks.add(sink);
            sink = null;
        }
        if("Source".equals(qName)){
            sources.add(source);
            source = null;
        }
        preTag = null;
    }
}