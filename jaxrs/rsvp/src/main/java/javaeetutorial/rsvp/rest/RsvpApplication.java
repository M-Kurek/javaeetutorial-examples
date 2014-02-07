/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.rsvp.rest;

import java.util.HashSet;
import java.util.Set;
import javaeetutorial.rsvp.ejb.ResponseBean;
import javaeetutorial.rsvp.ejb.StatusBean;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author ievans
 */
@ApplicationPath("/")
public class RsvpApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // register root resource
        classes.add(StatusBean.class);
        classes.add(ResponseBean.class);
        return classes;
    }
}
