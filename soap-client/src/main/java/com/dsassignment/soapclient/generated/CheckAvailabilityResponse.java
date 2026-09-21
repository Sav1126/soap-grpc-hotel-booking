
package com.dsassignment.soapclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkAvailabilityResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkAvailabilityResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="checkAvailabilityResponse" type="{http://gateway.dsassignment.com/}CheckAvailabilityResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkAvailabilityResponse", propOrder = {
    "checkAvailabilityResponse"
})
public class CheckAvailabilityResponse {

    protected CheckAvailabilityResult checkAvailabilityResponse;

    /**
     * Gets the value of the checkAvailabilityResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CheckAvailabilityResult }
     *     
     */
    public CheckAvailabilityResult getCheckAvailabilityResponse() {
        return checkAvailabilityResponse;
    }

    /**
     * Sets the value of the checkAvailabilityResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckAvailabilityResult }
     *     
     */
    public void setCheckAvailabilityResponse(CheckAvailabilityResult value) {
        this.checkAvailabilityResponse = value;
    }

}
