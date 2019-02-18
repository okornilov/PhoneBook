
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkSession complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkSession">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checkSessionRequest" type="{http://personws.services.company.ru/}tCheckSessionRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkSession", propOrder = {
    "checkSessionRequest"
})
public class CheckSession {

    protected TCheckSessionRequest checkSessionRequest;

    /**
     * Gets the value of the checkSessionRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TCheckSessionRequest }
     *     
     */
    public TCheckSessionRequest getCheckSessionRequest() {
        return checkSessionRequest;
    }

    /**
     * Sets the value of the checkSessionRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCheckSessionRequest }
     *     
     */
    public void setCheckSessionRequest(TCheckSessionRequest value) {
        this.checkSessionRequest = value;
    }

}
