
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userUpdate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userUpdate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userUpdateRequest" type="{http://personws.services.company.ru/}tUserUpdateRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userUpdate", propOrder = {
    "userUpdateRequest"
})
public class UserUpdate {

    protected TUserUpdateRequest userUpdateRequest;

    /**
     * Gets the value of the userUpdateRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TUserUpdateRequest }
     *     
     */
    public TUserUpdateRequest getUserUpdateRequest() {
        return userUpdateRequest;
    }

    /**
     * Sets the value of the userUpdateRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUserUpdateRequest }
     *     
     */
    public void setUserUpdateRequest(TUserUpdateRequest value) {
        this.userUpdateRequest = value;
    }

}
