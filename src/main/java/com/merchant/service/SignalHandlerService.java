package com.merchant.service;

import com.merchant.SignalManagerFactory;
import com.merchant.algo.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerService {

    private final SignalManagerFactory signalManagerFactory;

    @Autowired
    public SignalHandlerService(SignalManagerFactory signalManagerFactory) {this.signalManagerFactory = signalManagerFactory;}

    public void handleSignal(int signal) {
        SignalHandler signalHandler = signalManagerFactory.create(signal);
        signalHandler.handleSignal(signal);
    }

}
