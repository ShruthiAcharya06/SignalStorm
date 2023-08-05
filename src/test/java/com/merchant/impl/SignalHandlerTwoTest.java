package com.merchant.impl;

import com.merchant.algo.Algo;
import com.merchant.impl.SignalHandlerTwo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SignalHandlerTwoTest {
    @Mock
    private Algo algo;

    private SignalHandlerTwo classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new SignalHandlerTwo(algo);
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
