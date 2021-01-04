package com.cic.demo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class SwingPopup extends JFrame {

  private final int width;
  private final int height;
  private final String headingIconPath;
  private final String content;
  private final String header;
  private final SwingPopupAbstractAction swingPopupAbstractAction;
  
  public SwingPopup() {
    this(200, 120, null, null, null, null);
  }

  public SwingPopup(int width, int height, String headingIconPath, String header, String content, SwingPopupAbstractAction swingPopupAbstractAction) {
    this.width = width;
    this.height = height;
    if (headingIconPath != null) {
      this.headingIconPath = headingIconPath;
    } else {
      this.headingIconPath = "icon.png";
    }
    if (header != null) {
      this.header = header;
    } else {
      this.header = "Titlu notificare";
    }
    if (content != null) {
      this.content = content;
    } else {
      this.content = "Continut notificare. Continut notificare. Continut notificare. Continut notificare.";
    }
    
    this.swingPopupAbstractAction = swingPopupAbstractAction;
    
    initGUI();
  }

  private void initGUI() {
    ImageIcon headingIcon = new ImageIcon(getClass().getResource(headingIconPath));

    this.setSize(this.width, this.height);
    this.setUndecorated(true);
    this.setLayout(new GridBagLayout());

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx = 1.0;
    constraints.weighty = 1.0;
    constraints.insets = new Insets(5, 5, 5, 5);
    constraints.fill = GridBagConstraints.BOTH;

    JLabel headingLabel = new JLabel(header);
    headingLabel.setIcon(headingIcon);
    headingLabel.setOpaque(false);
    this.add(headingLabel, constraints);
    constraints.gridx++;
    constraints.weightx = 0;
    constraints.weighty = 0;
    constraints.fill = GridBagConstraints.NONE;
    constraints.anchor = GridBagConstraints.NORTH;

    JButton closeButton = new JButton(new AbstractAction("x") {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (SwingPopup.this.swingPopupAbstractAction != null) {
          SwingPopup.this.swingPopupAbstractAction.actionPerformed(SwingPopup.this);
        }
        SwingPopup.this.dispose();
      }
    });
    closeButton.setMargin(new Insets(1, 4, 1, 4));
    closeButton.setFocusable(false);

    this.add(closeButton, constraints);
    constraints.gridx = 0;
    constraints.gridy++;
    constraints.weightx = 1.0f;
    constraints.weighty = 1.0f;
    constraints.insets = new Insets(5, 5, 5, 5);
    constraints.fill = GridBagConstraints.BOTH;
    JLabel messageLabel = new JLabel("<html>" + this.content);
    this.add(messageLabel, constraints);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setAlwaysOnTop(true);
    this.setVisible(true);

    Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
    Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());// height of the task bar
    this.setLocation(scrSize.width - this.getWidth(), scrSize.height - toolHeight.bottom - this.getHeight());
  }
  
  public static abstract class SwingPopupAbstractAction {
    public abstract void actionPerformed(final JFrame frame);
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    //create notification
    final SwingPopup fp = new SwingPopup(200, 120, null, null, null, new SwingPopupAbstractAction() {
      @Override
      public void actionPerformed(JFrame frame) {
        System.out.println("Exemplu actiune pe inchidere popup");
      }
    });

    //time before notification disappears    
    final long ttl = 5000;

    //wat ttl before dispose
    new Thread() {
      @Override
      public void run() {
        try {
          Thread.sleep(ttl);
          fp.dispose();
        } catch (InterruptedException e) {
        }
      }
    };
  }
  
  
}
