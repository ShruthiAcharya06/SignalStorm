package com.merchant.impl;

import com.merchant.algo.Algo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SignalHandler1Test {
    @Mock
    private Algo algo;
    private SignalHandler1 classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new SignalHandler1(algo);
    }

    @Test
    public void testAlgoForSignalOne() {
        //when
        classUnderTest.handleSignal(1);
        //then
        Mockito.verify(algo).setAlgoParam(1, 60);
        Mockito.verify(algo).setUp();
        Mockito.verify(algo).performCalc();
        Mockito.verify(algo).submitToMarket();
        Mockito.verify(algo).doAlgo();
        Mockito.verifyNoMoreInteractions(algo);
    }
}
