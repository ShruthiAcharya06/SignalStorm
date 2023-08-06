package com.merchant.impl;

import com.merchant.algo.Algo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DefaultSignalHandlerTest {
    @Mock
    private Algo algo;
    private DefaultSignalHandler classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new DefaultSignalHandler(algo);
    }

    @Test
    public void testAlgoDefaultSignal() {
        //when
        classUnderTest.handleSignal(0);
        //then
        Mockito.verify(algo).cancelTrades();
        Mockito.verify(algo).doAlgo();
        Mockito.verifyNoMoreInteractions(algo);
    }
}
