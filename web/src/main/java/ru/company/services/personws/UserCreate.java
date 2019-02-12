
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userCreate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userCreate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userCreateRequest" type="{http://personws.services.company.ru/}tUserCreateRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userCreate", propOrder = {
    "userCreateRequest"
})
public class UserCreate {

    protected TUserCreateRequest userCreateRequest;

    /**
     * Gets the value of the userCreateRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TUserCreateRequest }
     *     
     */
    public TUserCreateRequest getUserCreateRequest() {
        return userCreateRequest;
    }

    /**
     * Sets the value of the userCreateRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUserCreateRequest }
     *     
     */
    public void setUserCreateRequest(TUserCreateRequest value) {
        this.userCreateRequest = value;
    }

}
