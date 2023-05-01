package com.maddytec.sso.controller;

import com.maddytec.sso.response.SsoMicrosoftResponse;
import com.maddytec.sso.client.SsoMicrosoftClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final SsoMicrosoftClient ssoMicrosoftClient;

    @PostMapping
    public SsoMicrosoftResponse authenticate(@RequestParam("username") String username,
                                             @RequestParam("password") String password) {

        return ssoMicrosoftClient.authenticate(username, password);
    }
}