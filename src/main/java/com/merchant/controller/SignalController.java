package com.merchant.controller;

import com.merchant.SignalManagerFactory;
import com.merchant.algo.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignalController {

    private final SignalManagerFactory signalManagerFactory;

    @Autowired
    public SignalController(SignalManagerFactory signalManagerFactory) {
        this.signalManagerFactory = signalManagerFactory;
    }

    @PostMapping("/handle-signal")
    public void handleSignal(@RequestParam int signal) {
        SignalHandler signalHandler = signalManagerFactory.create(signal);
        signalHandler.handleSignal(signal);
    }
}
