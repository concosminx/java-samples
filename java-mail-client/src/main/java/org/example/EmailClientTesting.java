package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Properties;

public class EmailClientTesting {

  private static final String USER = System.getenv("USER_EMAIL");
  private static final String PASSWORD = System.getenv("USER_PASSWORD");

  public static void main(String[] args) throws Exception {
    EmailClientTesting app = new EmailClientTesting();
    System.out.println(" -----------POP3----------- ");
    app.testPop3Connection();
    System.out.println(" -----------IMAP----------- ");
    app.testImapConnection();
  }

  /**
   * POP3 Connection test
   * see https://javaee.github.io/javamail/docs/api/com/sun/mail/pop3/package-summary.html
   *
   * @throws MessagingException
   */
  public void testPop3Connection() throws MessagingException {
    Folder emailFolder = null;
    Store store = null;
    try {
      Properties properties = new Properties();
      properties.put("mail.pop3.host", "pop.gmail.com");
      properties.put("mail.pop3.port", Integer.toString(995));
      properties.put("mail.pop3.starttls.enable", "true");
      properties.put("mail.pop3.ssl.trust", "*");

      Session emailSession = Session.getDefaultInstance(properties);
      store = emailSession.getStore("pop3s");
      store.connect("pop.gmail.com", USER, PASSWORD);

      emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_ONLY);
      Message[] messages = emailFolder.getMessages();

      Arrays.stream(messages).forEach(this::printMsg);
    } finally {
      if (emailFolder != null) {
        emailFolder.close(false);
      }
      if (store != null) {
        store.close();
      }
    }
  }

  /**
   * IMAP connection test
   */
  public void testImapConnection() {
    Properties props = new Properties();
    props.setProperty("mail.store.protocol", "imaps");
    props.setProperty("mail.imaps.ssl.trust", "*");

    try {
      Session session = Session.getInstance(props, null);
      Store store = session.getStore();
      store.connect("imap.gmail.com", USER, PASSWORD);
      Folder inbox = store.getFolder("INBOX");
      inbox.open(Folder.READ_ONLY);

      SearchTerm searchTerm = new AndTerm(new SubjectTerm("test1"), new BodyTerm(""));
      Message[] messages = inbox.search(searchTerm);

      Arrays.stream(messages).forEach(this::printMsg);

    } catch (Exception ex) {
      throw new RuntimeException("Cannot iterate messages using IMAP protocol", ex);
    }
  }

  /**
   * Prints some info about the message
   *
   * @param msg
   */
  public void printMsg(Message msg) {
    final StringBuilder sb = new StringBuilder();
    sb.append("Message info").append("\n");
    try {
      Address[] from = msg.getFrom();
      Arrays.stream(from).forEach(
          address -> sb.append("From: " + ((InternetAddress)address).getAddress())
      );
      sb.append("\n");
      sb.append("Sent date:" + msg.getSentDate()).append("\n");
      sb.append("Subject:" + msg.getSubject()).append("\n");

      Multipart mp = (Multipart) msg.getContent();
      int count = mp.getCount();
      sb.append("Body count: " + count).append("\n");

      for (int i = 0; i < count; i++) {
        sb.append("---------- Body no. " + i).append("\n");
        BodyPart bp = mp.getBodyPart(i);
        sb.append("Content: ").append(bp.getContent()).append("\n");
        sb.append("Content type: ").append(bp.getContentType()).append("\n");
        sb.append("Disposition: ").append(bp.getDisposition()).append("\n");
        sb.append("File name: ").append(bp.getFileName()).append("\n");
        sb.append("Size: ").append(bp.getSize()).append("\n");


        if (Part.ATTACHMENT.equalsIgnoreCase(bp.getDisposition())) {
          String file = bp.getFileName();

          File targetFile = new File(file);
          InputStream initialStream = bp.getInputStream();
          Files.copy(
              initialStream,
              targetFile.toPath(),
              StandardCopyOption.REPLACE_EXISTING
          );
          initialStream.close();
        }
      }

      System.out.println(sb);
    } catch (Exception ex) {
      throw new RuntimeException("Printing failed for msg " + msg);
    }
  }

}