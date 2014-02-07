/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.rsvp.web;

import java.io.Serializable;
import java.util.List;
import javaeetutorial.rsvp.entity.Event;
import javaeetutorial.rsvp.entity.Response;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ievans
 */
@Named
@ConversationScoped
public class EventManager implements Serializable {

    private static final long serialVersionUID = -3240069895629955984L;
    protected Event currentEvent;
    private Client client;
    private String baseUri = "http://localhost:8080/rsvp/status/";
    private WebTarget target;

    /**
     * Default constructor that creates the JAX-RS client
     */
    public EventManager() {
        this.client = ClientBuilder.newClient();
    }

    @PreDestroy
    private void clean() {
        client.close();
    }

    /**
     * Get the value of currentEvent
     *
     * @return the value of currentEvent
     */
    public Event getCurrentEvent() {

        return currentEvent;
    }

    /**
     * Set the value of currentEvent
     *
     * @param currentEvent new value of currentEvent
     */
    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

    /**
     * Gets a collection of responses for the current event
     *
     * @return a List of responses
     */
    public List<Response> getEventResponses() {
        Event event = client.target(baseUri)
                .path(this.currentEvent.getId().toString())
                .request(MediaType.APPLICATION_XML)
                .get(Event.class);
        return event.getResponses();
    }

    /**
     * Sets the current event
     *
     * @param event the current event
     * @return a JSF action string
     */
    public String getEventStatus(Event event) {
        this.setCurrentEvent(event);
        return "eventStatus";
    }
}
