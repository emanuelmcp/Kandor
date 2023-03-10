package io.github.emanuelmcp.minecraftcore.api.rest;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class EndpointFactory {
    public static <T> T create(Class<T> endpointClass, String baseUrl) {
        return Feign
                .builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(endpointClass, baseUrl);
    }
}
