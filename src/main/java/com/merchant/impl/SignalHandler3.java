package com.merchant.impl;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalHandler3 implements SignalHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignalHandler3.class);
    private static final Integer PARAM_TYPE_1_1 = 1;
    private static final Integer PARAM_VALUE_TYPE_1_1 = 90;
    private static final Integer PARAM_TYPE_1_2 = 2;
    private static final Integer PARAM_VALUE_TYPE_1_2 = 15;
    private final Algo algo;

    @Autowired
    public SignalHandler3(Algo algo) {
        this.algo = algo;
    }

    @Override
    public void handleSignal(int signal) {
        setParams();
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
        LOGGER.info("Handled Signal {} successfully", signal);
    }

    private void setParams() {
        algo.setAlgoParam(PARAM_TYPE_1_1, PARAM_VALUE_TYPE_1_1);
        algo.setAlgoParam(PARAM_TYPE_1_2, PARAM_VALUE_TYPE_1_2);
    }
}
