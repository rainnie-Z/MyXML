package com.rainnie.sax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest2 {
	public static void main(String[] args) throws Exception {
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		saxParser.parse("src/Book3.xml", new DefaultHandler() {
			boolean isAuthor=false;
			int authorIndex=1;
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if("作者".equals(qName)) {
					isAuthor=true;
				}
				 //System.out.println(qName);
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if("作者".equals(qName)) {
					isAuthor=false;
					authorIndex++;
				} 
				//System.out.println(qName);
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				 if(isAuthor&&authorIndex==2) {//条件:当前元素是作者,并且是第二个作者
					 System.out.println(new String(ch,start,length));
					 
				 }
			}
			
		});
	}
}
