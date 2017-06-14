package alpha.study.helloxml;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ext.DefaultHandler2;

public class HandleXMLWithSAX extends DefaultHandler2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(HandleXMLWithSAX.class);

	public void warning(SAXParseException exception) throws SAXException {
		LOGGER.info(ExceptionUtils.getStackTrace(exception));
	}

	public void error(SAXParseException exception) throws SAXException {
		LOGGER.info(ExceptionUtils.getStackTrace(exception));		
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		LOGGER.info(ExceptionUtils.getStackTrace(exception));		
	}

	public void setDocumentLocator(Locator locator) {
		LOGGER.info("Locator: {}, {}", locator.getColumnNumber(), locator.getLineNumber());
	}

	public void startDocument() throws SAXException {
		LOGGER.info("startDocument");
	}

	public void endDocument() throws SAXException {
		LOGGER.info("endDocument");		
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		LOGGER.info("startPrefixMapping: {}, {}", prefix, uri);
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		LOGGER.info("endPrefixMapping: {}", prefix);		
	}

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		LOGGER.info("startElement: {}, {}, {}", uri, localName, qName);
		for (int i = 0; i < atts.getLength(); i++) {
			LOGGER.info("{} attribute: {} : {}", localName, atts.getLocalName(i), atts.getValue(i));			
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		LOGGER.info("endElement: {}, {}, {}", uri, localName, qName);
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		// LOGGER.info("characters: {}, {}, {}", ch, start, length);
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		LOGGER.info("ignorableWhitespace: {}, {}, {}", ch, start, length);		
	}

	public void processingInstruction(String target, String data) throws SAXException {
		LOGGER.info("processingInstruction: {}, {}", target, data);
	}

	public void skippedEntity(String name) throws SAXException {
		LOGGER.info("skippedEntity: {}", name);		
	}

	public void notationDecl(String name, String publicId, String systemId) throws SAXException {
		LOGGER.info("notationDecl: {}, {}, {}", name, publicId, systemId);
	}

	public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName)
			throws SAXException {
		LOGGER.info("unparsedEntityDecl: {}, {}, {}, {}", name, publicId, systemId, notationName);
	}

	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		LOGGER.info("resolveEntity: {}, {}", publicId, systemId);
		return null;
	}

	public InputSource getExternalSubset(String name, String baseURI) throws SAXException, IOException {
		LOGGER.info("getExternalSubset: {}, {}", name, baseURI);
		return null;
	}

	public InputSource resolveEntity(String name, String publicId, String baseURI, String systemId)
			throws SAXException, IOException {
		LOGGER.info("resolveEntity: {}, {}, {}, {}", name, publicId, baseURI, systemId);
		return null;
	}

	public void elementDecl(String name, String model) throws SAXException {
		LOGGER.info("elementDecl: {}, {}", name, model);	
	}

	public void attributeDecl(String eName, String aName, String type, String mode, String value) throws SAXException {
		LOGGER.info("attributeDecl: {}, {}, {}, {}, {}", eName, aName, type, mode, value);	
	}

	public void internalEntityDecl(String name, String value) throws SAXException {
		LOGGER.info("internalEntityDecl: {}, {}", name, value);			
	}

	public void externalEntityDecl(String name, String publicId, String systemId) throws SAXException {
		LOGGER.info("externalEntityDecl: {}, {}, {}", name, publicId, systemId);
	}

	public void startDTD(String name, String publicId, String systemId) throws SAXException {
		LOGGER.info("startDTD: {}, {}, {}", name, publicId, systemId);	
	}

	public void endDTD() throws SAXException {
		LOGGER.info("endDTD");
	}

	public void startEntity(String name) throws SAXException {
		LOGGER.info("startEntity: {}", name);
	}

	public void endEntity(String name) throws SAXException {
		LOGGER.info("endEntity: {}", name);		
	}

	public void startCDATA() throws SAXException {
		LOGGER.info("startCDATA");
	}

	public void endCDATA() throws SAXException {
		LOGGER.info("endCDATA");
	}

	public void comment(char[] ch, int start, int length) throws SAXException {
		LOGGER.info("comment: {}, {}, {}", ch, start, length);
	}

}
