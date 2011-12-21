/*
 * SpagoBI, the Open Source Business Intelligence suite
 * � 2005-2015 Engineering Group
 *
 * This file is part of SpagoBI. SpagoBI is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 2.1 of the License, or any later version. 
 * SpagoBI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details. You should have received
 * a copy of the GNU Lesser General Public License along with SpagoBI. If not, see: http://www.gnu.org/licenses/.
 * The complete text of SpagoBI license is included in the COPYING.LESSER file. 
 */

package it.eng.spagobi.services.event.stub;

public class EventServiceServiceLocator extends org.apache.axis.client.Service implements it.eng.spagobi.services.event.stub.EventServiceService {

    public EventServiceServiceLocator() {
    }


    public EventServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EventServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EventService
    private java.lang.String EventService_address = "http://localhost:8080/SpagoBI/services/EventService";

    public java.lang.String getEventServiceAddress() {
        return EventService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EventServiceWSDDServiceName = "EventService";

    public java.lang.String getEventServiceWSDDServiceName() {
        return EventServiceWSDDServiceName;
    }

    public void setEventServiceWSDDServiceName(java.lang.String name) {
        EventServiceWSDDServiceName = name;
    }

    public it.eng.spagobi.services.event.stub.EventService getEventService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EventService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEventService(endpoint);
    }

    public it.eng.spagobi.services.event.stub.EventService getEventService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.eng.spagobi.services.event.stub.EventServiceSoapBindingStub _stub = new it.eng.spagobi.services.event.stub.EventServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEventServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEventServiceEndpointAddress(java.lang.String address) {
        EventService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.eng.spagobi.services.event.stub.EventService.class.isAssignableFrom(serviceEndpointInterface)) {
                it.eng.spagobi.services.event.stub.EventServiceSoapBindingStub _stub = new it.eng.spagobi.services.event.stub.EventServiceSoapBindingStub(new java.net.URL(EventService_address), this);
                _stub.setPortName(getEventServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EventService".equals(inputPortName)) {
            return getEventService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:spagobievent", "EventServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:spagobievent", "EventService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EventService".equals(portName)) {
            setEventServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
