
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userDelete complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userDelete">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userDeleteRequest" type="{http://personws.services.company.ru/}tUserDeleteRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userDelete", propOrder = {
    "userDeleteRequest"
})
public class UserDelete {

    protected TUserDeleteRequest userDeleteRequest;

    /**
     * Gets the value of the userDeleteRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TUserDeleteRequest }
     *     
     */
    public TUserDeleteRequest getUserDeleteRequest() {
        return userDeleteRequest;
    }

    /**
     * Sets the value of the userDeleteRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUserDeleteRequest }
     *     
     */
    public void setUserDeleteRequest(TUserDeleteRequest value) {
        this.userDeleteRequest = value;
    }

}
