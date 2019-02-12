
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tUserCreateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tUserCreateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseStatus" type="{http://personws.services.company.ru/}tResponseStatus" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tUserCreateResponse", propOrder = {
    "responseStatus",
    "userId"
})
public class TUserCreateResponse {

    protected TResponseStatus responseStatus;
    protected Long userId;

    /**
     * Gets the value of the responseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TResponseStatus }
     *     
     */
    public TResponseStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the value of the responseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TResponseStatus }
     *     
     */
    public void setResponseStatus(TResponseStatus value) {
        this.responseStatus = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserId(Long value) {
        this.userId = value;
    }

}
