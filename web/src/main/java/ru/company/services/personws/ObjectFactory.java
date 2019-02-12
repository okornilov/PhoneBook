
package ru.company.services.personws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.company.services.personws package. 
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

    private final static QName _TAuthRequest_QNAME = new QName("http://personws.services.company.ru/", "tAuthRequest");
    private final static QName _Auth_QNAME = new QName("http://personws.services.company.ru/", "auth");
    private final static QName _TResponseStatus_QNAME = new QName("http://personws.services.company.ru/", "tResponseStatus");
    private final static QName _AuthResponse_QNAME = new QName("http://personws.services.company.ru/", "authResponse");
    private final static QName _TAuthResponse_QNAME = new QName("http://personws.services.company.ru/", "tAuthResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.company.services.personws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthResponse }
     * 
     */
    public AuthResponse createAuthResponse() {
        return new AuthResponse();
    }

    /**
     * Create an instance of {@link Auth }
     * 
     */
    public Auth createAuth() {
        return new Auth();
    }

    /**
     * Create an instance of {@link TResponseStatus }
     * 
     */
    public TResponseStatus createTResponseStatus() {
        return new TResponseStatus();
    }

    /**
     * Create an instance of {@link TAuthRequest }
     * 
     */
    public TAuthRequest createTAuthRequest() {
        return new TAuthRequest();
    }

    /**
     * Create an instance of {@link TAuthResponse }
     * 
     */
    public TAuthResponse createTAuthResponse() {
        return new TAuthResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAuthRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tAuthRequest")
    public JAXBElement<TAuthRequest> createTAuthRequest(TAuthRequest value) {
        return new JAXBElement<TAuthRequest>(_TAuthRequest_QNAME, TAuthRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Auth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "auth")
    public JAXBElement<Auth> createAuth(Auth value) {
        return new JAXBElement<Auth>(_Auth_QNAME, Auth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TResponseStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tResponseStatus")
    public JAXBElement<TResponseStatus> createTResponseStatus(TResponseStatus value) {
        return new JAXBElement<TResponseStatus>(_TResponseStatus_QNAME, TResponseStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "authResponse")
    public JAXBElement<AuthResponse> createAuthResponse(AuthResponse value) {
        return new JAXBElement<AuthResponse>(_AuthResponse_QNAME, AuthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAuthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://personws.services.company.ru/", name = "tAuthResponse")
    public JAXBElement<TAuthResponse> createTAuthResponse(TAuthResponse value) {
        return new JAXBElement<TAuthResponse>(_TAuthResponse_QNAME, TAuthResponse.class, null, value);
    }

}
