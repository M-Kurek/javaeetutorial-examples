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
import java.util.logging.Level;
import java.util.logging.Logger;
import javaeetutorial.rsvp.entity.Event;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ievans
 */
@Named
@ConversationScoped
public class StatusManager implements Serializable {

    private static final long serialVersionUID = 1;
    private static final Logger logger = Logger.getLogger(StatusManager.class.getName());
    private Event event;
    private List<Event> events;
    private Client client;
    private String baseUri = "http://localhost:8080/rsvp/status/";
    private WebTarget target;

    /**
     * Default constructor creates the JAX-RS client
     */
    public StatusManager() {
        client = ClientBuilder.newClient();
    }
    
    @PreDestroy
    private void clean() {
        client.close();
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Sets the event
     * 
     * @param event the current event
     * @return a JSF action string
     */
    public String getEventStatus(Event event) {
        this.setEvent(event);
        return "eventStatus";
    }

    /**
     * Get all the events
     * 
     * @return all the events
     */
    public List<Event> getEvents() {
        List<Event> returnedEvents = null;
        try {
            returnedEvents = client.target(baseUri)
                    .path("all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<Event>>() {
            });
            if (returnedEvents == null) {
                logger.log(Level.SEVERE, "Returned events null.");
            } else {
                logger.log(Level.INFO, "Events have been returned.");
            }
        } catch (WebApplicationException ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        } catch (ResponseProcessingException ex) {
            logger.log(Level.SEVERE, "ReponseProcessingException thrown.");
            logger.log(Level.SEVERE, "Error is {0}", ex.getMessage());
        } catch (ProcessingException ex) {
            logger.log(Level.SEVERE, "ProcessingException thrown.");
            logger.log(Level.SEVERE, "Error is {0}", ex.getMessage());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error retrieving all events.");
            logger.log(Level.SEVERE, "base URI is {0}", baseUri);
            logger.log(Level.SEVERE, "path is {0}", "all");
            logger.log(Level.SEVERE, "Exception is {0}", ex.getMessage());
        }
        return returnedEvents;
    }

    /**
     * Setter for all the events
     * 
     * @param events the events to set
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
