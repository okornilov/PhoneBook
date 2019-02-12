
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userGetListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userGetListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userListResponse" type="{http://personws.services.company.ru/}tUserListResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userGetListResponse", propOrder = {
    "userListResponse"
})
public class UserGetListResponse {

    protected TUserListResponse userListResponse;

    /**
     * Gets the value of the userListResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TUserListResponse }
     *     
     */
    public TUserListResponse getUserListResponse() {
        return userListResponse;
    }

    /**
     * Sets the value of the userListResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUserListResponse }
     *     
     */
    public void setUserListResponse(TUserListResponse value) {
        this.userListResponse = value;
    }

}
