# SOAP-to-gRPC Hotel Booking Gateway

Distributed Systems Assignment 02 — a SOAP client talks to a gRPC service
through a translating gateway, simulating a legacy travel agency (SOAP)
booking rooms via a modern hotel chain's gRPC API.

## Components
- `grpc-server/` — gRPC service exposing hotel booking operations
- `gateway/` — SOAP endpoint (WSDL) that translates to/from gRPC
- `soap-client/` — SOAP client exercising every WSDL operation

## Setup & Run
(To be filled in Phase 5)