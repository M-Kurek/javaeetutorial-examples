/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.mailconnector.api;

import javax.mail.Message;

/**
 * JavaMailMessageListener interface implemented by JavaMailMessageBean.
 * 
 * @author Alejandro E. Murillo
 */
public interface JavaMailMessageListener
{
    /**
     * Message-driven bean method invoked by the EJB container.
     *
     * @param message  the incoming message
     */
    public void onMessage(Message message);
}
