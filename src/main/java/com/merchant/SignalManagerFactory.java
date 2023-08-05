package com.merchant;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import com.merchant.impl.DefaultSignalHandler;
import com.merchant.impl.SignalHandlerOne;
import com.merchant.impl.SignalHandlerThree;
import com.merchant.impl.SignalHandlerTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class SignalManagerFactory {

    private final Algo algo;

    private final Map<Integer, SignalHandler> signalHandlerMap;

    @Autowired
    public SignalManagerFactory(Algo algo) {
        this.algo = algo;
        this.signalHandlerMap = new HashMap<>();
        initializeHandlerMap();
    }

    private void initializeHandlerMap() {
        signalHandlerMap.put(1, new SignalHandlerOne(algo));
        signalHandlerMap.put(2, new SignalHandlerTwo(algo));
        signalHandlerMap.put(3, new SignalHandlerThree(algo));
    }

    public SignalHandler create(int signal) {
        return signalHandlerMap.getOrDefault(signal, new DefaultSignalHandler(algo));
    }
}
