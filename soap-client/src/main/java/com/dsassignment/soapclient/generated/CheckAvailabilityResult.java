
package com.dsassignment.soapclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckAvailabilityResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckAvailabilityResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="pricePerNight" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="roomsAvailable" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckAvailabilityResult", propOrder = {
    "available",
    "pricePerNight",
    "roomsAvailable"
})
public class CheckAvailabilityResult {

    protected boolean available;
    protected double pricePerNight;
    protected int roomsAvailable;

    /**
     * Gets the value of the available property.
     * 
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     */
    public void setAvailable(boolean value) {
        this.available = value;
    }

    /**
     * Gets the value of the pricePerNight property.
     * 
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Sets the value of the pricePerNight property.
     * 
     */
    public void setPricePerNight(double value) {
        this.pricePerNight = value;
    }

    /**
     * Gets the value of the roomsAvailable property.
     * 
     */
    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    /**
     * Sets the value of the roomsAvailable property.
     * 
     */
    public void setRoomsAvailable(int value) {
        this.roomsAvailable = value;
    }

}
