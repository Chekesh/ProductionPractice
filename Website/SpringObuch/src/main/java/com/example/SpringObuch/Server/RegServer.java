package com.example.SpringObuch.Server;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RegServer{
    public static void Reg(String floatingFIO, String floatingTelephone, String floatingDateBirsd, String countries){
        JsonObject personJson = new JsonObject();
        personJson.addProperty("fullname", floatingFIO);
        personJson.addProperty("dateofbirth", floatingDateBirsd);
        personJson.addProperty("contactinfo", floatingTelephone);
        personJson.addProperty("sporttype", countries);
        String json = personJson.toString();
        WebClient webClient = WebClient.create();
        WebClient.ResponseSpec answer = webClient.post()
                .uri("http://192.168.15.19:8081/students/add")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(json))
                .retrieve();
        String responseBody = answer.bodyToMono(String.class).block();
    }
}
