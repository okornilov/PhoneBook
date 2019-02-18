
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userDeleteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userDeleteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userDeleteResponse" type="{http://personws.services.company.ru/}tUserDeleteResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userDeleteResponse", propOrder = {
    "userDeleteResponse"
})
public class UserDeleteResponse {

    protected TUserDeleteResponse userDeleteResponse;

    /**
     * Gets the value of the userDeleteResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TUserDeleteResponse }
     *     
     */
    public TUserDeleteResponse getUserDeleteResponse() {
        return userDeleteResponse;
    }

    /**
     * Sets the value of the userDeleteResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUserDeleteResponse }
     *     
     */
    public void setUserDeleteResponse(TUserDeleteResponse value) {
        this.userDeleteResponse = value;
    }

}
