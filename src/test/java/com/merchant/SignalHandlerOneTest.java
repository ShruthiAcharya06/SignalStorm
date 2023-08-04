package com.merchant;

import com.merchant.algo.Algo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SignalHandlerOneTest {
    @Mock
    private Algo algo;

    private SignalHandlerOne classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new SignalHandlerOne(algo);
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
