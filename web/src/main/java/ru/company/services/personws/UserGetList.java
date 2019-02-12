
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userGetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userGetList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userRequest" type="{http://personws.services.company.ru/}tUser" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userGetList", propOrder = {
    "userRequest"
})
public class UserGetList {

    protected TUser userRequest;

    /**
     * Gets the value of the userRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TUser }
     *     
     */
    public TUser getUserRequest() {
        return userRequest;
    }

    /**
     * Sets the value of the userRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUser }
     *     
     */
    public void setUserRequest(TUser value) {
        this.userRequest = value;
    }

}
