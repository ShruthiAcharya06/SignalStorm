package com.merchant;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalHandlerOne implements SignalHandler {

    private static final Integer PARAM_TYPE_1 = 1;

    private static final Integer PARAM_VALUE_TYPE_1 = 60;

    private final Algo algo;

    @Autowired
    public SignalHandlerOne(Algo algo) {this.algo = algo;}

    @Override
    public void handleSignal(int signal) {
        algo.setUp();
        algo.setAlgoParam(PARAM_TYPE_1, PARAM_VALUE_TYPE_1);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }
}
