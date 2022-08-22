package com.nimsoc.wsclient;


import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.xml.stream.XMLStreamException;
import com.nimsoc.wsclient.json.RestCountriesClient;
import com.nimsoc.wsclient.xml.BNRRatesClient;

public class Main {

  public static void main(String[] args) {
    try {

      //json test
      //new RestCountriesClient().download();

      //xml test

      new BNRRatesClient().download();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


}
