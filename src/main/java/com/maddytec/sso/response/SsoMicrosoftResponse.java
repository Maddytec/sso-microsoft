package com.maddytec.sso.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SsoMicrosoftResponse {
    @JsonProperty(value = "access_token")
    private String accessToken;

}
