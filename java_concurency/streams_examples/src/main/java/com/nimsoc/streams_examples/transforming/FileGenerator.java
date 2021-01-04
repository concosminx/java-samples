package com.nimsoc.streams_examples.transforming;

import java.util.ArrayList;
import java.util.List;

public class FileGenerator {

  public static List<String> generateFile(int size) {
    List<String> file = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      file.add("Bacon ipsum dolor amet brisket filet mignon t-bone chislic tail, flank venison strip steak rump pig. Landjaeger ground round corned beef, pork loin boudin beef cow. Short ribs short loin filet mignon andouille turkey shank drumstick ground round kevin sausage kielbasa bacon turducken pancetta. Corned beef sirloin short ribs meatloaf, t-bone leberkas rump pork loin hamburger ham pork. Cupim sirloin pork capicola kielbasa shank, pork loin venison buffalo picanha ribeye turducken beef ribs frankfurter. Tenderloin chuck shankle buffalo alcatra");
    }
    return file;
  }

}
