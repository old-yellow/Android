package com.example.administrator.networktest;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Administrator on 2019/3/9.
 */

public class ContentHandler extends DefaultHandler {

    private static final String TAG = "ContentHandler";
    
    private String nodeName;
    
    private StringBuilder id;
    
    private StringBuilder name;
    
    private StringBuilder version;

    @Override
    public void startDocument() throws SAXException {
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //记录当前节点名
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //根据当前节点名判断将内容添加到哪一个StringBuilder对象中
        switch (nodeName) {
            case "id" :
                id.append(ch, start, length);
                break;
            case "version" :
                version.append(ch, start, length);
                break;
            case "name" :
                name.append(ch, start, length);
                break;
            default:
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("app".equals(localName)) {
            Log.d(TAG, "id is " + id.toString().trim());
            Log.d(TAG, "name is " + name.toString().trim());
            Log.d(TAG, "version is " + version.toString().trim());
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
