package com.dsassignment.gateway;

import javax.xml.ws.WebFault;

@WebFault(name = "GatewayFault", targetNamespace = "http://gateway.dsassignment.com/")
public class GatewayFault extends Exception {

    private GatewayFaultInfo faultInfo;

    public GatewayFault(String message, GatewayFaultInfo faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public GatewayFault(String message, GatewayFaultInfo faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public GatewayFaultInfo getFaultInfo() {
        return faultInfo;
    }
}