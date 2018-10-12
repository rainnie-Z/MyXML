package com.rainnie.dom4j;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jTest {
	@Test
	public void test1() throws DocumentException {
		SAXReader reader = new SAXReader();
        Document document = reader.read("src/Book.xml");
        Element root=document.getRootElement();
       /* Element bookNode=root.element("书");
        System.out.println(bookNode.getName());*/
        /*List elist=root.elements();
        Iterator it=elist.iterator();
        while(it.hasNext()) {
        	Element e=(Element) it.next();
        	System.out.print(e.getName()+"-");
        	//结果是 书-书-
        }*/
        List elist=root.elements();
        Element secondeBook=(Element) elist.get(1);
        String name=secondeBook.element("书名").getText();
        System.out.println(name);//葵花宝典
        
	}
	
	@Test
	public void test2() throws DocumentException {
		SAXReader reader = new SAXReader();
        Document document = reader.read("src/Book.xml");
        Element root=document.getRootElement();
        treeWalk(root);
	}

	private void treeWalk(Element ele) {//输出当前节点的名子
		 System.out.println(ele.getName());
		 for(int i=0;i<ele.nodeCount();i++) {//ele.nodeCount()得到当前节点的所有子节点的数量
			 Node node=ele.node(i);
			 if(node instanceof Element) {//判断当前节点是否为标签
				 treeWalk((Element)node);
			 }else {
				 System.out.println(node.getText());
			 }
		 }
	}
}
