package com.merchant.impl;

import com.merchant.algo.Algo;
import com.merchant.impl.SignalHandlerThree;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SignalHandlerThreeTest {
    @Mock
    private Algo algo;

    private SignalHandlerThree classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new SignalHandlerThree(algo);
    }

    @Test
    public void testAlgoForSignalThree() {
        //when
        classUnderTest.handleSignal(3);
        //then
        Mockito.verify(algo).setAlgoParam(1, 90);
        Mockito.verify(algo).setAlgoParam(2, 15);
        Mockito.verify(algo).doAlgo();
        Mockito.verify(algo).performCalc();
        Mockito.verify(algo).submitToMarket();
        Mockito.verifyNoMoreInteractions(algo);

    }

}
