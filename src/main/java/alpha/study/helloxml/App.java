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
	    	ReadXMLWithDOM.readXML("conf/log4j2.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
