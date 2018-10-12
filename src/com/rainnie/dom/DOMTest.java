package com.rainnie.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest {
	public static void main(String[] args) throws Exception {
		//创建解析器工厂
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		//通过解析器工厂得到解析器
		DocumentBuilder documentBuilder=builderFactory.newDocumentBuilder();
		//通过解析器得到Document对象
		Document document = documentBuilder.parse("src/Book2.xml");
		//System.out.println(document);
		//test1(document);
		test2(document);
		//test3(document);
		//test4(document);
		//test5(document);
		//test6(document);
		//test7(document);
		
	}
	 


	//1.得到葵花宝典
	private static void test1(Document document) {
		String name=document.getElementsByTagName("书名").item(1).getTextContent();
		System.out.println(name);
	}
	//2.遍历所有节点
	private static void test2(Node node) {
		 if(node.getNodeType()==Node.ELEMENT_NODE) {
			 System.out.println(node.getNodeName());
		 }
		 NodeList childNodes=node.getChildNodes();
		 for(int i=0;i<childNodes.getLength();i++) {
			 Node item=childNodes.item(i);
			 test2(item);
		 }
		
	}
	//3.修改某个节点的内容，如第二本书的售价为20
	private static void test3(Document document) throws Exception {
		 Node price=document.getElementsByTagName("单价").item(1);
		 price.setTextContent("20");//这里只是修改了内存中的数据
		 
		 //回显数据
		 Transformer tf=TransformerFactory.newInstance().newTransformer();
		 tf.transform(new DOMSource(document),new StreamResult("src/Book2.xml"));
		 
	}
	//4.向指定元素节点增加子元素节点:<批发价>20</批发价>
	private static void test4(Document document) throws Exception{
		//先创建要添加的节点
		Element price = document.createElement("批发价");
		price.setTextContent("20");
		//获得第一本书的节点
		Node firstBook = document.getElementsByTagName("书").item(0);
		//将批发价节点追加
		firstBook.appendChild(price);
		 
	

		 //回显数据
		 Transformer tf=TransformerFactory.newInstance().newTransformer();
		 tf.transform(new DOMSource(document),new StreamResult("src/Book2.xml"));
	}
	//5.像指定元素节点上增加同级元素节点:第一本书中国添加<内部价>5</内部价>
	private static void test5(Document document) throws Exception {
		//先创建要添加的节点
		Element innerprice = document.createElement("内部价");
		innerprice.setTextContent("5");
		//获得第一本书的指定节点
		Node firstBook = document.getElementsByTagName("单价").item(0);
		//将批发价节点追加
		//Node priceNode = firstBook.getChildNodes().item(2);
		firstBook.getParentNode().insertBefore(innerprice, firstBook);
	

		 //回显数据
		 Transformer tf=TransformerFactory.newInstance().newTransformer();
		 tf.transform(new DOMSource(document),new StreamResult("src/Book2.xml"));
		
	}
	//6.刪除指定元素節點<内部价>5</内部价>

	private static void test6(Document document) throws Exception {
		 Node node=document.getElementsByTagName("内部价").item(0);
		 node.getParentNode().removeChild(node);
		 //回显数据
		 Transformer tf=TransformerFactory.newInstance().newTransformer();
		 tf.transform(new DOMSource(document),new StreamResult("src/Book2.xml"));
	}
	//7.操作xml文件属性:第一本书节点添加属性，出版社="黑马"
	private static void test7(Document document) throws Exception{
		Node firstBook=document.getElementsByTagName("书").item(0);
		Element e=(Element) firstBook;
		e.setAttribute("出版社", "人民版");
		 //回显数据
		 Transformer tf=TransformerFactory.newInstance().newTransformer();
		 tf.transform(new DOMSource(document),new StreamResult("src/Book2.xml"));
		
	}
}
