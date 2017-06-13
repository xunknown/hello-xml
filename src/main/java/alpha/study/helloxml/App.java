package alpha.study.helloxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App
{
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args)
    {
    	LOGGER.info("xml file parse:");
    	try {
			WriteXMLWithDOM4J.writeXML("test.xml");
	    	ReadXMLWithDOM4J.readXML("test.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
