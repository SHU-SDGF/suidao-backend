package com.tunnel.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tunnel.exception.AppException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static com.tunnel.util.WebUtils.loggedInUser;

import java.io.IOException;

/**
 * Created by Wayne Cao on 6/25/2016.
 */

@Component
@Slf4j
public class RestAPIUtils {

    private RestTemplate restTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    private void init(){
        restTemplate = new RestTemplate();
    }

    private HttpHeaders httpHeaders() {
        HttpHeaders headers = AuthUtil.buildAuthHeaders(loggedInUser().getLoginId(), loggedInUser().getPassword());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public <T> T get(String url, TypeReference returnType, HttpHeaders httpHeaders) {
        try {

            HttpEntity request = new HttpEntity<>(httpHeaders);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            return mapper.readValue(response.getBody(), returnType);
        } catch (HttpClientErrorException ex) {
            log.error("Error occurred while hitting url " + url + ".Response body :" +
                    ex.getResponseBodyAsString(), ex);
            throw new AppException("Error occurred while hitting url " + url, ex);
        } catch (IOException ex) {
            log.error("Error occurred", ex);
            throw new AppException("Error occurred", ex);
        }
    }

    public <T> T post(String url, HttpEntity request, TypeReference returnType) {
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
            return mapper.readValue(response.getBody(), returnType);
        } catch (HttpClientErrorException ex) {
            log.error("Error occurred while hitting url " + url + ".Response body :" +
                    ex.getResponseBodyAsString(), ex);
            throw new AppException("Error occurred while hitting url " + url , ex);
        } catch (IOException ex) {
            log.error("Error occurred", ex);
            throw new AppException("Error occurred while hitting url " + url + ex.getMessage(), ex);
        }
    }

    public <T> T post(String url, HttpEntity request, Class<T> responseType) {
        try {
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, request, responseType);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error("Error occurred while hitting url " + url + ".Response body :" +
                    ex.getResponseBodyAsString(), ex);
            throw new AppException("Error occurred while hitting url " + url, ex);
        }
    }


    public <T> T get(String url, TypeReference returnType) {
        return get(url, returnType, httpHeaders());
    }
}
