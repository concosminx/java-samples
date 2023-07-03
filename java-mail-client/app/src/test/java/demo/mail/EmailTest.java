package demo.mail;

import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.search.*;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
import java.security.GeneralSecurityException;
import java.util.Properties;

/*you will need an app password to use this*/

public class EmailTest {
  @Test
  public void SearchEmailTest() throws GeneralSecurityException {

//    TrustManager[] trustAllCerts = new TrustManager[]{
//            new X509TrustManager() {
//              public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                return null;
//              }
//
//              public void checkClientTrusted(
//                      java.security.cert.X509Certificate[] certs, String authType) {
//              }
//
//              public void checkServerTrusted(
//                      java.security.cert.X509Certificate[] certs, String authType) {
//              }
//            }};
//
//    try {
//      SSLContext sc = SSLContext.getInstance("SSL");
//      sc.init(null, trustAllCerts, new java.security.SecureRandom());
//      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//    } catch (Exception e) {
//    }


    Properties props = new Properties();

    props.setProperty("mail.store.protocol", "imaps");
    props.setProperty("mail.imaps.ssl.trust", "*");

    try {
      Session session = Session.getInstance(props, null);
      Store store = session.getStore();
      store.connect("imap.gmail.com", "none", "none");
      Folder inbox = store.getFolder("INBOX");
      inbox.open(Folder.READ_ONLY);

      GetMessage(inbox);
      //SearchEmail(inbox, "Security alert", "check activity");
      //SearchEmail(inbox, "Security alert", "check activity", false, false);
      //SearchEmail(inbox, "Security alert", "check activity", true, false);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void SearchEmail(Folder folder, String subject, String body, boolean seen, boolean recent) {
    System.out.println("=====SearchEmail with seen and recent======");
    try {
      SearchTerm[] srchTerms = new SearchTerm[4];
      srchTerms[0] = new SubjectTerm(subject);
      srchTerms[1] = new BodyTerm(body);
      srchTerms[2] = new FlagTerm(new Flags(Flags.Flag.SEEN), seen);
      srchTerms[3] = new FlagTerm(new Flags(Flags.Flag.RECENT), recent);

      SearchTerm searchTerm = new AndTerm(srchTerms);
      Message[] messages = folder.search(searchTerm);
      System.out.println("Message count: " + messages.length);
      Message msg = messages[0];
      PrintMsg(msg);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  public void SearchEmail(Folder folder, String subject, String body) {
    System.out.println("=====SearchEmail======");
    try {
      SearchTerm searchTerm = new AndTerm(new SubjectTerm(subject), new BodyTerm(body));
      Message[] messages = folder.search(searchTerm);
      System.out.println("Message count: " + messages.length);
      Message msg = messages[0];
      PrintMsg(msg);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  public void GetMessage(Folder folder) {
    System.out.println("=====GetMessage======");
    try {
      System.out.println("Message count: " + folder.getMessageCount());
      Message msg = folder.getMessage(folder.getMessageCount() - 8);
      PrintMsg(msg);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void PrintMsg(Message msg) {
    try {
      Address[] in = msg.getFrom();
      for (Address address : in) {
        System.out.println("FROM:" + address.toString());
      }
      Multipart mp = (Multipart) msg.getContent();
      int count = mp.getCount();
      System.out.println("body count: " + count);
      for (int i = 0; i < count; i++) {
        System.out.println("===========Body no. " + i);
        BodyPart bp = mp.getBodyPart(i);
        System.out.println("SENT DATE:" + msg.getSentDate());
        System.out.println("SUBJECT:" + msg.getSubject());
        System.out.println("CONTENT:" + bp.getContent());

        System.out.println("CONTENT TYPE:" + bp.getContentType());
        System.out.println("disposition :" + bp.getDisposition());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
