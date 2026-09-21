
package com.dsassignment.soapclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelBookingResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelBookingResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cancelResponse" type="{http://gateway.dsassignment.com/}CancelResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelBookingResponse", propOrder = {
    "cancelResponse"
})
public class CancelBookingResponse {

    protected CancelResult cancelResponse;

    /**
     * Gets the value of the cancelResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CancelResult }
     *     
     */
    public CancelResult getCancelResponse() {
        return cancelResponse;
    }

    /**
     * Sets the value of the cancelResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelResult }
     *     
     */
    public void setCancelResponse(CancelResult value) {
        this.cancelResponse = value;
    }

}
