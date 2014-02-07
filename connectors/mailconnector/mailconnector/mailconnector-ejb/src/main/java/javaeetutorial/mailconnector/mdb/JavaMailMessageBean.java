/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.mailconnector.mdb;

import java.util.logging.Logger;
import javaeetutorial.mailconnector.api.JavaMailMessageListener;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.mail.Message;

/**
 * A simple message-driven bean that implements JavaMailMessageListener. The
 * @MessageDriven annotation's activationConfig element is commented out,
 * because the properties are specified elsewhere. 
 */
@MessageDriven
  /*  (activationConfig = {
    @ActivationConfigProperty(propertyName = "serverName",
    propertyValue = "localhost"),
    @ActivationConfigProperty(propertyName = "userName",
    propertyValue = "user1"),
    @ActivationConfigProperty(propertyName = "password",
    propertyValue = "user1"),
    @ActivationConfigProperty(propertyName = "folderName",
    propertyValue = "INBOX"),
    @ActivationConfigProperty(propertyName = "protocol",
    propertyValue = "IMAP"),
    @ActivationConfigProperty(propertyName = "interval",
    propertyValue = "30")
})*/
public class JavaMailMessageBean implements JavaMailMessageListener {

    static final Logger logger =
            Logger.getLogger("mailconnector.mdb");

    /**
     * Default constructor. Creates a bean.
     */
    public JavaMailMessageBean() {
        logger.info("[MDB] In JavaMailMessageBean.JavaMailMessageBean()");
    }

    /**
     * When the inbox receives a message, the EJB container invokes the
     * <code>onMessage</code> method of the message-driven bean.
     *
     * @param message incoming message
     */
    @Override
    public void onMessage(Message message) {
        logger.info("[MDB] In JavaMailMessageBean.onMessage");
    }
}
