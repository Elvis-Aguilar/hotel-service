package com.eatsleep.hotel.config.infrastructure.property;


import org.springframework.boot.context.properties.ConfigurationProperties;
import java.security.interfaces.RSAPublicKey;


@ConfigurationProperties("security.rsa")
public record RsaProperty(
        RSAPublicKey publicKey) {
}