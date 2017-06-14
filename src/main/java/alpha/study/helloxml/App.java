package alpha.study.helloxml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOGGER.info("xml file parse:");
		SAXParser parser = null;
		try {
			// 构建SAXParser
			parser = SAXParserFactory.newInstance().newSAXParser();
			
			// XML文件
			InputStream stream = new FileInputStream("conf/log4j2.xml");

			// 调用parse()方法
			parser.parse(stream, new HandleXMLWithSAX());
		} catch (IllegalArgumentException | ParserConfigurationException | SAXException | IOException e) {
			LOGGER.info(ExceptionUtils.getStackTrace(e));
		}
	}
}
