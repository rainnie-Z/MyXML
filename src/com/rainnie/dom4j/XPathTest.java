package com.rainnie.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;
/**
 * 用来查询。效率快.
 * @author Rainnie
 *
 */
public class XPathTest {
	@Test
	public void test1() throws DocumentException {
		SAXReader read = new SAXReader();
		Document document = read.read("src/Book.xml");
		Node node = document.selectSingleNode("/书架/书[2]/书名");
		System.out.println(node.getText());
	}
	@Test
	public void test2() throws DocumentException {
		SAXReader read = new SAXReader();
		Document document = read.read("src/Book.xml");
		List nodes_list = document.selectNodes("//*");
		for(int i=0;i<nodes_list.size();i++) {
			Node node = (Node) nodes_list.get(i);
			System.out.println(node.getName()+"\t"+node.getText());
		}
	}
}
