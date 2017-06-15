package alpha.study.helloxml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLWithDOM {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadXMLWithDOM.class);

	private static String getAttributes(Node node) {
		String result = "";
        NamedNodeMap attributes = node.getAttributes();
        if (attributes == null) return result;
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            result += attribute.getNodeName()+ " : " + attribute.getNodeValue() + "\n";
        }
		return result;
	}

	public static void readXML(String fileName) throws Exception
    {
		LOGGER.info("read xml file: {}", fileName);
		String content = "";
        // 定义工厂API 使应用程序能够从XML文档获取生成DOM对象树的解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 获取此类的实例之后，将可以从各种输入源解析XML
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Document接口表示整个HTML或XML文档，从概念上讲，它是文档树的根，并提供对文档数据的基本访问
        Document document = builder.parse(new File(fileName));
        
        // 获取根元素
        Element root = document.getDocumentElement();
        content += "element: " + root.getNodeName() + "\n";
        content += root.getNodeName() + " attributes:\n" + getAttributes(root);
        content += root.getNodeName() + " text: " + root.getTextContent().trim() + "\n";

        // 获取所有子元素
        NodeList nodeList = root.getChildNodes();
        content += "root child count: " + nodeList.getLength() + "\n";

        // 迭代输出
        for (int i = 0; i < nodeList.getLength(); i++) {
            // 获取一个节点
            Node node = nodeList.item(i);
            content += "node: " + node.getNodeName()
            		+ ", " + node.getLocalName()
            		+ ", " + node.getPrefix()
            		+ ", " + node.getNodeType()
            		+ ", " + node.getNodeValue()
            		+ ", " + node.getBaseURI() + "\n";
            content += node.getNodeName() + " attributes:\n" + getAttributes(node);
            content += node.getNodeName() + " text: " + node.getTextContent().trim() + "\n";
        }

        LOGGER.info("\n{}", content);
    }
}
