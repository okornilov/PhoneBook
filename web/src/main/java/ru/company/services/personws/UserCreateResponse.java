
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userCreateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userCreateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userCreateResponse" type="{http://personws.services.company.ru/}tUserCreateResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userCreateResponse", propOrder = {
    "userCreateResponse"
})
public class UserCreateResponse {

    protected TUserCreateResponse userCreateResponse;

    /**
     * Gets the value of the userCreateResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TUserCreateResponse }
     *     
     */
    public TUserCreateResponse getUserCreateResponse() {
        return userCreateResponse;
    }

    /**
     * Sets the value of the userCreateResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUserCreateResponse }
     *     
     */
    public void setUserCreateResponse(TUserCreateResponse value) {
        this.userCreateResponse = value;
    }

}
