
package com.dsassignment.soapclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dsassignment.soapclient.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GatewayFault_QNAME = new QName("http://gateway.dsassignment.com/", "GatewayFault");
    private final static QName _BookRoom_QNAME = new QName("http://gateway.dsassignment.com/", "bookRoom");
    private final static QName _BookRoomResponse_QNAME = new QName("http://gateway.dsassignment.com/", "bookRoomResponse");
    private final static QName _CancelBooking_QNAME = new QName("http://gateway.dsassignment.com/", "cancelBooking");
    private final static QName _CancelBookingResponse_QNAME = new QName("http://gateway.dsassignment.com/", "cancelBookingResponse");
    private final static QName _CheckAvailability_QNAME = new QName("http://gateway.dsassignment.com/", "checkAvailability");
    private final static QName _CheckAvailabilityResponse_QNAME = new QName("http://gateway.dsassignment.com/", "checkAvailabilityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dsassignment.soapclient.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GatewayFaultDetail }
     * 
     */
    public GatewayFaultDetail createGatewayFaultDetail() {
        return new GatewayFaultDetail();
    }

    /**
     * Create an instance of {@link BookRoom }
     * 
     */
    public BookRoom createBookRoom() {
        return new BookRoom();
    }

    /**
     * Create an instance of {@link BookRoomResponse }
     * 
     */
    public BookRoomResponse createBookRoomResponse() {
        return new BookRoomResponse();
    }

    /**
     * Create an instance of {@link CancelBooking }
     * 
     */
    public CancelBooking createCancelBooking() {
        return new CancelBooking();
    }

    /**
     * Create an instance of {@link CancelBookingResponse }
     * 
     */
    public CancelBookingResponse createCancelBookingResponse() {
        return new CancelBookingResponse();
    }

    /**
     * Create an instance of {@link CheckAvailability }
     * 
     */
    public CheckAvailability createCheckAvailability() {
        return new CheckAvailability();
    }

    /**
     * Create an instance of {@link CheckAvailabilityResponse }
     * 
     */
    public CheckAvailabilityResponse createCheckAvailabilityResponse() {
        return new CheckAvailabilityResponse();
    }

    /**
     * Create an instance of {@link CancelResult }
     * 
     */
    public CancelResult createCancelResult() {
        return new CancelResult();
    }

    /**
     * Create an instance of {@link CheckAvailabilityResult }
     * 
     */
    public CheckAvailabilityResult createCheckAvailabilityResult() {
        return new CheckAvailabilityResult();
    }

    /**
     * Create an instance of {@link BookingResult }
     * 
     */
    public BookingResult createBookingResult() {
        return new BookingResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GatewayFaultDetail }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GatewayFaultDetail }{@code >}
     */
    @XmlElementDecl(namespace = "http://gateway.dsassignment.com/", name = "GatewayFault")
    public JAXBElement<GatewayFaultDetail> createGatewayFault(GatewayFaultDetail value) {
        return new JAXBElement<GatewayFaultDetail>(_GatewayFault_QNAME, GatewayFaultDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookRoom }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BookRoom }{@code >}
     */
    @XmlElementDecl(namespace = "http://gateway.dsassignment.com/", name = "bookRoom")
    public JAXBElement<BookRoom> createBookRoom(BookRoom value) {
        return new JAXBElement<BookRoom>(_BookRoom_QNAME, BookRoom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookRoomResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BookRoomResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://gateway.dsassignment.com/", name = "bookRoomResponse")
    public JAXBElement<BookRoomResponse> createBookRoomResponse(BookRoomResponse value) {
        return new JAXBElement<BookRoomResponse>(_BookRoomResponse_QNAME, BookRoomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBooking }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelBooking }{@code >}
     */
    @XmlElementDecl(namespace = "http://gateway.dsassignment.com/", name = "cancelBooking")
    public JAXBElement<CancelBooking> createCancelBooking(CancelBooking value) {
        return new JAXBElement<CancelBooking>(_CancelBooking_QNAME, CancelBooking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBookingResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelBookingResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://gateway.dsassignment.com/", name = "cancelBookingResponse")
    public JAXBElement<CancelBookingResponse> createCancelBookingResponse(CancelBookingResponse value) {
        return new JAXBElement<CancelBookingResponse>(_CancelBookingResponse_QNAME, CancelBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAvailability }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckAvailability }{@code >}
     */
    @XmlElementDecl(namespace = "http://gateway.dsassignment.com/", name = "checkAvailability")
    public JAXBElement<CheckAvailability> createCheckAvailability(CheckAvailability value) {
        return new JAXBElement<CheckAvailability>(_CheckAvailability_QNAME, CheckAvailability.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAvailabilityResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckAvailabilityResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://gateway.dsassignment.com/", name = "checkAvailabilityResponse")
    public JAXBElement<CheckAvailabilityResponse> createCheckAvailabilityResponse(CheckAvailabilityResponse value) {
        return new JAXBElement<CheckAvailabilityResponse>(_CheckAvailabilityResponse_QNAME, CheckAvailabilityResponse.class, null, value);
    }

}
