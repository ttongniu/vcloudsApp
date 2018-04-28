
package com.boco.app.simbaWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.isimba.appcenter.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RequestResponseReturn_QNAME = new QName("http://ws.appcenter.isimba.cn", "return");
    private final static QName _RequestArgs1_QNAME = new QName("http://ws.appcenter.isimba.cn", "args1");
    private final static QName _RequestArgs0_QNAME = new QName("http://ws.appcenter.isimba.cn", "args0");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.isimba.appcenter.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestResponse }
     * 
     */
    public RequestResponse createRequestResponse() {
        return new RequestResponse();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.appcenter.isimba.cn", name = "return", scope = RequestResponse.class)
    public JAXBElement<String> createRequestResponseReturn(String value) {
        return new JAXBElement<String>(_RequestResponseReturn_QNAME, String.class, RequestResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.appcenter.isimba.cn", name = "args1", scope = Request.class)
    public JAXBElement<String> createRequestArgs1(String value) {
        return new JAXBElement<String>(_RequestArgs1_QNAME, String.class, Request.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.appcenter.isimba.cn", name = "args0", scope = Request.class)
    public JAXBElement<String> createRequestArgs0(String value) {
        return new JAXBElement<String>(_RequestArgs0_QNAME, String.class, Request.class, value);
    }

}
