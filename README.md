# SOAP-to-gRPC Hotel Booking Gateway

## Setup & Run
1. Build: `mvn clean install` (from project root)
2. Start gRPC server: run `HotelBookingServer.java` (grpc-server module) — port 9090
3. Start Gateway: run `GatewayServer.java` (gateway module) — port 8080
4. WSDL available at: http://localhost:8080/hotelbooking?wsdl

## Testing every operation without writing a client
See `sample-requests/` folder for raw SOAP XML requests testable via curl:
curl -X POST http://localhost:8080/hotelbooking -H "Content-Type: text/xml;charset=UTF-8" -d @sample-requests/check-availability.xml
Repeat with `book-room.xml`, `cancel-booking.xml` (update the bookingId first),
and `check-availability-invalid-hotel.xml` (demonstrates a SOAP Fault).

## Alternative: run the included Java SOAP client
Run `SoapClientTest.java` in the `soap-client` module — exercises all 3
operations plus 3 intentional error cases.