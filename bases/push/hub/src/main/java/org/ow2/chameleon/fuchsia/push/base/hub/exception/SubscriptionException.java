package org.ow2.chameleon.fuchsia.push.base.hub.exception;


public class SubscriptionException extends Exception{

    public SubscriptionException() {
        super();
    }

    public SubscriptionException(String message) {
        super(message);
    }

    public SubscriptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubscriptionException(Throwable cause) {
        super(cause);
    }
}
