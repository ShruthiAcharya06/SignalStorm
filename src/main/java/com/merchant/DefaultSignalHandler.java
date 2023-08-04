package com.merchant;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;

public class DefaultSignalHandler implements SignalHandler {

    private final Algo algo;

    public DefaultSignalHandler(Algo algo) {this.algo = algo;}

    @Override
    public void handleSignal(int signal) {
        algo.cancelTrades();
        algo.doAlgo();
    }
}
