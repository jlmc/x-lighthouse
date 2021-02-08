package org.xine.ligthouse.core.logging;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggingSystem {

    @Produces
    public System.Logger produceLogger(InjectionPoint ip) {
        final String loggerName = ip.getMember().getDeclaringClass().getName();

        return System.getLogger(loggerName);
    }
}
