package com.dtoa.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:application.properties"})
public class token {

    @Value("${application.Token}")
    private String Token;
    @Value("${application.EncodingAESKey}")
    private String EncodingAESKey;
    @Value("${application.CorpId}")
    private String CorpId;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getEncodingAESKey() {
        return EncodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        EncodingAESKey = encodingAESKey;
    }

    public String getCorpId() {
        return CorpId;
    }

    public void setCorpId(String corpId) {
        CorpId = corpId;
    }
}
