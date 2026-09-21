
package com.dsassignment.soapclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bookRoomResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookRoomResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookingResponse" type="{http://gateway.dsassignment.com/}BookingResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookRoomResponse", propOrder = {
    "bookingResponse"
})
public class BookRoomResponse {

    protected BookingResult bookingResponse;

    /**
     * Gets the value of the bookingResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BookingResult }
     *     
     */
    public BookingResult getBookingResponse() {
        return bookingResponse;
    }

    /**
     * Sets the value of the bookingResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingResult }
     *     
     */
    public void setBookingResponse(BookingResult value) {
        this.bookingResponse = value;
    }

}
