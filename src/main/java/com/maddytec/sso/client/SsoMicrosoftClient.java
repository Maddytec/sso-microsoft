package com.maddytec.sso.client;

import com.maddytec.sso.response.SsoMicrosoftResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SsoMicrosoftClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${sso.clientId}")
    private String clientId;

    @Value("${sso.clientSecret}")
    private String clientSecret;

    @Value("${sso.scope}")
    private String scope;

    @Value("${sso.grantType}")
    private String grantType;

    @Value("${sso.tokenUrl}")
    private String urlSsoMicrosoft;

    public SsoMicrosoftResponse authenticate(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("username", username);
        body.add("password", password);
        body.add("scope", scope);
        body.add("grant_type", grantType);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
        try {
            return restTemplate.exchange(
                    urlSsoMicrosoft,
                    HttpMethod.POST,
                    entity,
                    SsoMicrosoftResponse.class
            ).getBody();

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}