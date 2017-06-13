package alpha.study.helloxml;

import java.io.FileWriter;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteXMLWithDOM4J {
	private static final Logger LOGGER = LoggerFactory.getLogger(WriteXMLWithDOM4J.class);

	private static void addAttributes(Element element, String prefix, int count) {
		for (int i = 0; i < count; i++) {
			element.addAttribute(prefix + i, prefix + i);
		}
	}

	private static void addElements(Element element, String prefix, int count) {
		for (int i = 0; i < count; i++) {
			element.addElement(prefix + i).setText(prefix + i);
		}
	}

	public static void writeXML(String fileName) throws Exception {
		LOGGER.info("write xml file: {}", fileName);
		// 创建文档
		Document document = DocumentHelper.createDocument();
		// 创建根节点
		Element root = DocumentHelper.createElement("root");
		// 添加根节点进文档
		document.setRootElement(root);

		// 添加属性
		addAttributes(root, "attribute", 3);

		// 添加子节点
		addElements(root, "element", 3);
		
		// 格式设置缩进为4个空格，并且另起一行为true
		OutputFormat format = new OutputFormat("    ", true);
		
		// 输出到控制台
		XMLWriter consoleWriter = new XMLWriter(format);
		consoleWriter.write(document);

		// 输出到文件，记得要调用flush()方法,否则输出的文件中显示空白
		XMLWriter fileWriter = new XMLWriter(new FileWriter(fileName), format);
		fileWriter.write(document);
		fileWriter.flush();
	}
}
