
package ru.company.services.personws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tUserListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tUserListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseStatus" type="{http://personws.services.company.ru/}tResponseStatus" minOccurs="0"/>
 *         &lt;element name="user" type="{http://personws.services.company.ru/}tUser" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tUserListResponse", propOrder = {
    "responseStatus",
    "user"
})
public class TUserListResponse {

    protected TResponseStatus responseStatus;
    protected List<TUser> user;

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
     * Gets the value of the user property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the user property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TUser }
     * 
     * 
     */
    public List<TUser> getUser() {
        if (user == null) {
            user = new ArrayList<TUser>();
        }
        return this.user;
    }

}
