
package ru.company.services.personws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkSessionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkSessionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sessionStatus" type="{http://personws.services.company.ru/}tResponseStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkSessionResponse", propOrder = {
    "sessionStatus"
})
public class CheckSessionResponse {

    protected TResponseStatus sessionStatus;

    /**
     * Gets the value of the sessionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TResponseStatus }
     *     
     */
    public TResponseStatus getSessionStatus() {
        return sessionStatus;
    }

    /**
     * Sets the value of the sessionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TResponseStatus }
     *     
     */
    public void setSessionStatus(TResponseStatus value) {
        this.sessionStatus = value;
    }

}
