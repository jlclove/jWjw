package com.goodlaike.wjw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Resource {

  @Autowired
  private ProxyResource proxyResource;
  
  public String getDistrictUrl(){
    return this.proxyResource.getDistrictUrl();
  }

  @Configuration
  @ConfigurationProperties(prefix = "proxy")
  static class ProxyResource {

    private String key;
    private String districtUrl;

    public String getKey() {
      return this.key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getDistrictUrl() {
      return this.districtUrl;
    }

    public void setDistrictUrl(String districtUrl) {
      this.districtUrl = districtUrl;
    }


  }
}
