
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tUserUpdateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tUserUpdateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseStatus" type="{http://personws.services.company.ru/}tResponseStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tUserUpdateResponse", propOrder = {
    "responseStatus"
})
public class TUserUpdateResponse {

    protected TResponseStatus responseStatus;

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

}
