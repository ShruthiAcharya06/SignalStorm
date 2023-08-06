package com.merchant.impl;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultSignalHandler implements SignalHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSignalHandler.class);
    private final Algo algo;
    @Autowired
    public DefaultSignalHandler(Algo algo) {this.algo = algo;}

    @Override
    public void handleSignal(int signal) {
        algo.cancelTrades();
        algo.doAlgo();
        LOGGER.info("Handled Signal {} successfully", signal);
    }
}
