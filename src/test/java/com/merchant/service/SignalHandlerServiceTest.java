package com.merchant.service;

import com.merchant.SignalManagerFactory;
import com.merchant.algo.SignalHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class SignalHandlerServiceTest {
    @Mock
    private SignalManagerFactory signalManagerFactory;
    @Mock
    private SignalHandler signalHandler;
    private SignalHandlerService classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new SignalHandlerService(signalManagerFactory);
    }

    @Test
    public void testSignalService() {
        //given
        when(signalManagerFactory.create(1)).thenReturn(signalHandler);
        //when
        classUnderTest.handleSignal(1);

        //then
        Mockito.verify(signalManagerFactory).create(1);
        Mockito.verify(signalHandler).handleSignal(1);
        Mockito.verifyNoMoreInteractions(signalManagerFactory, signalHandler);
    }

}
