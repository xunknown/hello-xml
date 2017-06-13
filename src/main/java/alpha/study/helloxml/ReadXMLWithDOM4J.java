package alpha.study.helloxml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadXMLWithDOM4J {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadXMLWithDOM4J.class);

	private static String getAttributes(Element element) {
		String result = "";
		for (int i = 0; i < element.attributeCount(); i++) {
			Attribute attribute = element.attribute(i);
			result += attribute.getName() + " : " + attribute.getValue() + "\n";
		}
		return result;
	}

	public static void readXML(String fileName) throws Exception
    {
		LOGGER.info("read xml file: {}", fileName);
		String content = "";
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(fileName));

        // 获取根元素
        Element root = document.getRootElement();
        content += "element: " + root.getName() + "\n";
        content += root.getName() + " attributes:\n" + getAttributes(root);
        content += root.getName() + " text: " + root.getTextTrim() + "\n";

        // 获取所有子元素
        List<?> elements = root.elements();
        content += "root child count: " + elements.size() + "\n";

        // 迭代输出
        for (Iterator<?> iterator = root.elementIterator(); iterator.hasNext();)
        {
            Element element = (Element)iterator.next();
            content += "element: " + element.getName() + "\n";
            content += element.getName() + " attributes:\n" + getAttributes(element);
            content += element.getName() + " text: " + element.getTextTrim() + "\n";
        }

        LOGGER.info("\n{}", content);
    }
}
