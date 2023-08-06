package com.merchant.service;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import com.merchant.impl.DefaultSignalHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerService {

    private final ApplicationContext applicationContext;

    private static final Logger LOGGER = LoggerFactory.getLogger(SignalHandlerService.class);

    private final Algo algo;

    @Autowired
    public SignalHandlerService(ApplicationContext applicationContext, Algo algo) {
        this.applicationContext = applicationContext;
        this.algo = algo;
    }

    public void handleSignal(int signal) {
        SignalHandler signalHandler = null;
        String beanName = "signalHandler" + signal;
        try {
            signalHandler = applicationContext.getBean(beanName, SignalHandler.class);
        } catch (NoSuchBeanDefinitionException e) {
            if (signalHandler == null) {
                LOGGER.warn("Signal Bean is not defined running default algo. {}", e.getMessage());
                signalHandler = new DefaultSignalHandler(algo);
            }

        }
        signalHandler.handleSignal(signal);
    }

}
