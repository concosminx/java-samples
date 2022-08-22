package com.nimsoc.wsclient.xml;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class BNRRatesClient {


  public void download() throws RuntimeException, IOException, XMLStreamException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    SSLContext sslContext = new SSLContextBuilder()
        .loadTrustMaterial(null, (TrustStrategy) (chain, authType) -> true).build();

    CloseableHttpClient httpClient = HttpClients
        .custom()
        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
        .setSSLContext(sslContext)
        .build();

    List<NameValuePair> params = new LinkedList<>();
    params.add(new BasicNameValuePair("noop1", "bogus1"));
    params.add(new BasicNameValuePair("noop2", "bogus2"));
    String paramString = URLEncodedUtils.format(params, "utf-8");

    HttpGet httpGet = new HttpGet("https://www.bnr.ro/nbrfxrates.xml");

    //httpGet.addHeader("bogusheader", "bogusheadervalue");
    HttpResponse response = httpClient.execute(httpGet);

    Map<String, BigDecimal> rates = new TreeMap<>();

    if (response.getStatusLine().getStatusCode() != 200) {
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
    } else {
      HttpEntity resEntity = response.getEntity();
      if (resEntity != null) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try (BufferedInputStream bf = new BufferedInputStream((resEntity.getContent()));) {
          XMLEventReader reader = null;

          try {
            reader = xmlInputFactory.createXMLEventReader(bf);

            while (reader.hasNext()) {
              XMLEvent nextEvent = reader.nextEvent();
              if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                  case "Rate":
                    Attribute currencyAtt = startElement.getAttributeByName(new QName("currency"));
                    nextEvent = reader.nextEvent();
                    rates.put(currencyAtt.getValue(), new BigDecimal(nextEvent.asCharacters().getData()));
                    break;
                  default:
                    System.out.println(startElement.getName().getLocalPart());
                }
              }

              //if (nextEvent.isEndElement()) {
              //  EndElement endElement = nextEvent.asEndElement();
              //  if (endElement.getName().getLocalPart().equals("xyz")) {
              //
              //  }
              //}
            }

            //display exchange rates
            System.out.println("Rates:");
            rates.forEach((k,v) -> System.out.println(k + " = " + v));

          } finally {
            if (reader != null) {
              reader.close();
            }
          }
        }
      }
    }
  }
}
