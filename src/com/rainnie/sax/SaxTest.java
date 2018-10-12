package com.rainnie.sax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest {
	public static void main(String[] args) throws Exception {
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		saxParser.parse("src/Book3.xml", new DefaultHandler() {

			@Override
			public void startDocument() throws SAXException {
				System.out.println("文档开始了...");
			}

			@Override
			public void endDocument() throws SAXException {
				System.out.println("文档结束了...");
			}

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				System.out.println("元素开始了...");
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				System.out.println("元素结束了...");
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				System.out.println("aaa"+new String(ch,start,length)+"bbb");
			}
			
		});
	}
}
