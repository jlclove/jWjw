package com.goodlaike.wjw.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestUtil {

  private static RestTemplate restTemplate;

  static {
    restTemplate = new RestTemplate();
    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
    // 3秒读取超时
    factory.setReadTimeout(3000);
    // 1秒连接超时
    factory.setConnectTimeout(1000);
    restTemplate.setRequestFactory(factory);
  }

  public static <T> T exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) {
    return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables).getBody();
  }
}
