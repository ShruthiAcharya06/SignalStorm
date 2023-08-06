package com.merchant.impl;

import com.merchant.algo.Algo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SignalHandler2Test {
    @Mock
    private Algo algo;

    private SignalHandler2 classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new SignalHandler2(algo);
    }

    @Test
    public void testAlgoForSignalTwo() {
        //when
        classUnderTest.handleSignal(2);
        //then
        Mockito.verify(algo).setAlgoParam(1, 80);

        Mockito.verify(algo).submitToMarket();
        Mockito.verify(algo).doAlgo();
        Mockito.verify(algo).reverse();
        Mockito.verifyNoMoreInteractions(algo);

    }

}
