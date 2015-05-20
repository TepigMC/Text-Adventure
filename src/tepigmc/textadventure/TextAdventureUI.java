package tepigmc.textadventure;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import tepigmc.textadventure.entity.Player;
import tepigmc.textadventure.room.Room;

public class TextAdventureUI implements KeyListener {
  //private Scanner scanner = new Scanner(System.in);
  public JFrame frame;
  public JTextArea output;
  public JTextArea roomArea;
  public JTextField input;

  public TextAdventureUI() {
    try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
    catch (Exception e) { e.printStackTrace(); }

    frame = new JFrame("Text Adventure");
    output = new JTextArea(10, 50);
    roomArea = new JTextArea(10, 15);
    input = new JTextField(65);

    output.setEditable(false);
    output.setRequestFocusEnabled(false);
    output.setLineWrap(true);

    roomArea.setFont(new Font("Courier New", 0, 14));
    roomArea.setEditable(false);
    roomArea.setRequestFocusEnabled(false);

    input.addKeyListener(this);

    frame.add(output, BorderLayout.CENTER);
    frame.add(roomArea, BorderLayout.LINE_START);
    frame.add(input, BorderLayout.PAGE_END);

    frame.addWindowListener(new WindowAdapter(){ 
      public void windowOpened(WindowEvent e){ 
        input.requestFocusInWindow(); //input.requestFocus();
      } 
    });

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setIconImage(new ImageIcon(getClass().getResource("resources/icon.png")).getImage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    drawRoom();
    displayText(getPlayer().getRoom().getSetting());
  }

  public Player getPlayer() { return TextAdventure.getPlayer(); }

  public void setPlayer(Player player) { TextAdventure.setPlayer(player); }

  public void keyPressed(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_ENTER) {
      String command = this.input.getText();
      System.out.println("Executing: " + command);
      executeCommand(command);
    }
    if (key == KeyEvent.VK_UP) { executeCommand("north"); }
    if (key == KeyEvent.VK_DOWN) { executeCommand("south"); }
    if (key == KeyEvent.VK_LEFT) { executeCommand("west"); }
    if (key == KeyEvent.VK_RIGHT) { executeCommand("east"); }
  }
  public void keyTyped(KeyEvent e) {}

  public void executeCommand(String command) {
    if (getPlayer().executeCommand(command)) {
      this.input.setText("");
      drawRoom();
    }
    else {
      displayText("\"" + command + "\" is not a recognized command!");
    }
  }

  public void drawRoom() {
    drawRoom(getPlayer().getRoom(), getPlayer());
  }
  
  public void drawRoom(Room room, Player player) {
    this.roomArea.setText(room.renderRoomCropped(player, 15, 10));
  }

  public void displayText(List<String> text) {
    for (String line : text) {
      displayText(line);
    }
  }
  
  public void displayText(String text) {
    System.out.println("Print: " + text);
    for (int i = 0; i < text.length(); i++) {
      this.output.setText(output.getText() + text.charAt(i));
      sleep(25);
    }
    this.output.setText(output.getText() + "\n");
    sleep(500);
  }

  public void sleep(int milli) {
    try {
      Thread.sleep(milli);
    }
    catch (Exception e) {
      System.err.println("sleep(" + milli + ") threw exception");
    }
  }
}