package com.merchant;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import org.springframework.stereotype.Component;

@Component
public class SignalManagerFactory {

    private Algo algo;

    public SignalManagerFactory(Algo algo) {
        this.algo = algo;
    }

    public SignalHandler create(int signal) {
        if (signal == 1) {
            return new SignalHandlerOne(algo);
        } else if (signal == 2) {
            return new SignalHandlerTwo(algo);
        } else if (signal == 3) {
            return new SignalHandlerThree(algo);
        } else {
            return new DefaultSignalHandler(algo);
        }
    }
}
