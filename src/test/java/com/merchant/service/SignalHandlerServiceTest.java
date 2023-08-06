package com.merchant.service;

import com.merchant.algo.Algo;
import com.merchant.algo.SignalHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SignalHandlerServiceTest {

    @MockBean
    private Algo algo;

    @Mock
    private SignalHandler signalHandler;

    @Mock
    private ApplicationContext applicationContext;

    private SignalHandlerService classUnderTest;

    @BeforeEach
    public void setup() {
        when(applicationContext.getBean("signalHandler1", SignalHandler.class)).thenReturn(signalHandler);
        when(applicationContext.getBean("signalHandler10", SignalHandler.class)).thenThrow(NoSuchBeanDefinitionException.class);
        classUnderTest = new SignalHandlerService(applicationContext, algo);
    }

    @Test
    public void testSignalServiceWithValidSignal() {
        //when
        classUnderTest.handleSignal(1);
        //then
        verify(signalHandler).handleSignal(1);

    }

    @Test
    public void testSignalServiceWithInValidSignal() {
        //when
        classUnderTest.handleSignal(10);
        //then
        verify(algo).cancelTrades();
        verify(algo).doAlgo();
    }
}
