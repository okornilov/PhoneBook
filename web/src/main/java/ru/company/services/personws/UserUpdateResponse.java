
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userUpdateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userUpdateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userUpdateResponse" type="{http://personws.services.company.ru/}tUserUpdateResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userUpdateResponse", propOrder = {
    "userUpdateResponse"
})
public class UserUpdateResponse {

    protected TUserUpdateResponse userUpdateResponse;

    /**
     * Gets the value of the userUpdateResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TUserUpdateResponse }
     *     
     */
    public TUserUpdateResponse getUserUpdateResponse() {
        return userUpdateResponse;
    }

    /**
     * Sets the value of the userUpdateResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUserUpdateResponse }
     *     
     */
    public void setUserUpdateResponse(TUserUpdateResponse value) {
        this.userUpdateResponse = value;
    }

}
