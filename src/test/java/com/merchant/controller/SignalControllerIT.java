package com.merchant.controller;

import com.merchant.service.SignalHandlerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SignalControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SignalHandlerService signalHandlerService;

    @Test
    public void testSignalSuccess() throws Exception {

        mockMvc.perform(post("/signal/handle")
                .param("signal", "1"))
            .andExpect(status().isOk())
            .andExpect(content().string("Signal Handled Successfully"));
    }
}
