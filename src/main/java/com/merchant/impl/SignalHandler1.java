package com.merchant.impl;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import com.merchant.service.SignalHandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalHandler1 implements SignalHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignalHandler1.class);
    private static final Integer PARAM_TYPE_1 = 1;
    private static final Integer PARAM_VALUE_TYPE_1 = 60;
    private final Algo algo;

    @Autowired
    public SignalHandler1(Algo algo) {this.algo = algo;}

    @Override
    public void handleSignal(int signal) {
        algo.setUp();
        algo.setAlgoParam(PARAM_TYPE_1, PARAM_VALUE_TYPE_1);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
        LOGGER.info("Handled Signal {} successfully", signal);
    }
}
