package com.merchant.controller;

import com.merchant.service.SignalHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signal")
public class SignalController {

    private final SignalHandlerService signalHandlerService;

    @Autowired
    public SignalController(SignalHandlerService signalHandlerService) {
        this.signalHandlerService = signalHandlerService;
    }

    @PostMapping("/handle")
    public ResponseEntity<String> handleSignal(@RequestParam int signal) {
        try {
            signalHandlerService.handleSignal(signal);
            return ResponseEntity.ok("Signal Handled Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Exception occurred while handling signal : " + e.getMessage());
        }
    }
}
