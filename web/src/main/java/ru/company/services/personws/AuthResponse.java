
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for authResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authResponse" type="{http://personws.services.company.ru/}tAuthResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authResponse", propOrder = {
    "authResponse"
})
public class AuthResponse {

    protected TAuthResponse authResponse;

    /**
     * Gets the value of the authResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TAuthResponse }
     *     
     */
    public TAuthResponse getAuthResponse() {
        return authResponse;
    }

    /**
     * Sets the value of the authResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAuthResponse }
     *     
     */
    public void setAuthResponse(TAuthResponse value) {
        this.authResponse = value;
    }

}
