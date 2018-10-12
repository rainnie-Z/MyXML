package com.rainnie.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class XPathTest2 {
	@Test
	public void test1() throws DocumentException {
		SAXReader read = new SAXReader();
		Document document = read.read("src/Dom4jTest.xml");
		List selectNodes = document.selectNodes("//bookstore//book//title");
		for(int i=0;i<selectNodes.size();i++) {
			Node node= (Node) selectNodes.get(i);
			System.out.println(node.getText());
		}
	}
}
