package com.merchant;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import com.merchant.impl.DefaultSignalHandler;
import com.merchant.impl.SignalHandlerOne;
import com.merchant.impl.SignalHandlerThree;
import com.merchant.impl.SignalHandlerTwo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;

public class SignalManagerFactoryTest {
    @Mock
    private Algo algo;

    private SignalManagerFactory classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new SignalManagerFactory(algo);
    }

    @Test
    public void testSignalHandlerOne() {
        //when
        SignalHandler signalHandler = classUnderTest.create(1);
        //then
        assertTrue(signalHandler instanceof SignalHandlerOne);
    }

    @Test
    public void testSignalHandlerTwo() {
        //when
        SignalHandler signalHandler = classUnderTest.create(2);
        //then
        assertTrue(signalHandler instanceof SignalHandlerTwo);
    }

    @Test
    public void testSignalHandlerThree() {
        //when
        SignalHandler signalHandler = classUnderTest.create(3);
        //then
        assertTrue(signalHandler instanceof SignalHandlerThree);
    }

    @Test
    public void testSignalHandlerDefault() {
        //when
        SignalHandler signalHandler = classUnderTest.create(34);
        //then
        assertTrue(signalHandler instanceof DefaultSignalHandler);
    }

}
