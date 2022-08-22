package com.nimsoc.wsclient.json;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.xml.stream.XMLStreamException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class RestCountriesClient {

  public void download() throws RuntimeException, IOException, XMLStreamException {
    HttpClient httpclient = HttpClientBuilder.create().build();
    HttpGet get = new HttpGet("https://restcountries.com/v2/regionalbloc/eu");
    HttpResponse response = httpclient.execute(get);

    if (response.getStatusLine().getStatusCode() != 200) {
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
    } else {
      HttpEntity resEntity = response.getEntity();
      if (resEntity != null) {
        String result = new BufferedReader(new InputStreamReader(resEntity.getContent()))
            .lines().collect(Collectors.joining("\n"));


        System.out.println("result:" + result);
      }
    }
  }
}
