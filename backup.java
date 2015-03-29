import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.*; 

public class StarIslandDemo
{
   public static void main(String[] args)
   {
      StarIsland frame = new StarIsland();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class StarIsland extends JFrame
{
   public StarIsland()
   {
      Container c ; 
      c=getContentPane();
      //end of container class
      
      PlayerStats ps = new PlayerStats(0, 0, 0, 0, 0, 0);
      
      JTextField statusbar;
      statusbar = new JTextField();
      statusbar.setEditable(false);
      statusbar.setText("Player's attributes: PATIENCE: " + ps.getPat() + " CONFIDENCE: " + ps.getCon() + " POLITICIAL: " + ps.getPsavvy() + " NETWORKING: " + ps.getNet() + " MALE AWARENESS: " + ps.getMaleAware() + " MENTORS: " + ps.getMentors());
      
      JTextArea textArea;
      textArea = new JTextArea(20, 20);
      JScrollPane scrollPane = new JScrollPane(textArea); 
      textArea.setEditable(false);
      //end of textA
      
      this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      JPanel mainPanel = new JPanel();
      this.add(mainPanel);
      //end of panels
      JButton btn[] = new JButton[25];
      btn[0] = new JButton("START GAME");


      for( int i = 1; i < 25; i++)
      {
         btn[i] = new JButton();
         btn[i].setVisible(false);
         mainPanel.add(btn[i]);
      }

      for( int i = 1; i < 25; i +=3)
          {
             btn[i].setText("One");   
          }

      for( int i = 2; i < 25; i += 3)
          {
             btn[i].setText("Two");
          }

      for( int i = 3; i < 25; i += 3)
          {
             btn[i].setText("Three");
          }
          
      //Start Button
      btn[0].addActionListener(new StartButtonListener(btn[0], btn[1], btn[2], btn[3], textArea));
      mainPanel.add(btn[0]);
      
      //First Response
      btn[1].addActionListener(new CollegeButtonListener(btn[1], btn[2], btn[3], btn[4], textArea, ps, statusbar));
      btn[2].addActionListener(new CollegeButtonListener(btn[1], btn[2], btn[3], btn[4], textArea, ps, statusbar));
      btn[3].addActionListener(new CollegeButtonListener(btn[1], btn[2], btn[3], btn[4], textArea, ps,statusbar));

      //Second College
      btn[4].addActionListener(new College2Listener(btn[4], btn[5], btn[6], btn[7], textArea));

      //Second Response
      btn[5].addActionListener(new College2ButtonListener(btn[5], btn[6], btn[7], btn[8], textArea, ps, statusbar));
      btn[6].addActionListener(new College2ButtonListener(btn[5], btn[6], btn[7], btn[8], textArea, ps, statusbar));
      btn[7].addActionListener(new College2ButtonListener(btn[5], btn[6], btn[7], btn[8], textArea, ps, statusbar));

       
      c.add(textArea, BorderLayout.NORTH);
      c.add(mainPanel);
      c.add(statusbar, BorderLayout.SOUTH);
      
      textArea.setText("Welcome to Star Island! Click Start Game to play!\n" + "\n" +
      "How to play: \n" + "\n" +
      "Just click on 'START GAME' and you will be transported to Star Island! \n" +
      "You will visit the five different islands and solve issues within each community. \n" +
      "You will gain new experience and various tokens once you complete each island \n" +
      "These new skills will allow you to defeat the boss in the final island \n" +
      "Focus on creating better environments for the civilians. Good luck! \n" );
   }

   public static final int DEFAULT_WIDTH = 900;
   public static final int DEFAULT_HEIGHT = 500;
}//end of StarIsland Constructor

class StartButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[4];
   private boolean finishedReading = false; 
   
   public StartButtonListener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
   {
      btn[0] = btn0;
      btn[1] = btn1;
      btn[2] = btn2;
      btn[3] = btn3;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                  Scanner scan = new Scanner(new FileReader("college.txt"));
                  while (scan.hasNext()) // while there's still something to read
                  textarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
               } 
               catch (Exception ex) 
               { // catch any exceptions, and...
                  // ...write to the debug console
                  System.out.println(ex.getMessage());
               }
       
         btn[0].setVisible(false);
         btn[1].setVisible(true);
         btn[2].setVisible(true);
         btn[3].setVisible(true);
         
       textarea.setLineWrap(true);
   
   }
}//end of Start Button Listener

class College2Listener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[8];
   private boolean finishedReading = false; 
   
   public College2Listener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
   {
      btn[4] = btn0;
      btn[5] = btn1;
      btn[6] = btn2;
      btn[7] = btn3;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                  Scanner scan = new Scanner(new FileReader("college copy.txt"));
                  while (scan.hasNext()) // while there's still something to read
                  textarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
               } 
               catch (Exception ex) 
               { // catch any exceptions, and...
                  // ...write to the debug console
                  System.out.println(ex.getMessage());
               }

       
         btn[4].setVisible(false);
         btn[5].setVisible(true);
         btn[6].setVisible(true);
         btn[7].setVisible(true);
         
       textarea.setLineWrap(true);
   
   }
}//end of College2Listener

class CollegeButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[5];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public CollegeButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[1] = btn1;
      btn[2] = btn2;
      btn[3] = btn3;
      btn[4] = btn4;
      playerstats = ps;
      statusbar = sb;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      int patience = playerstats.getPat();
      int confidence = playerstats.getCon();
      int networking = playerstats.getNet();
      int psavvy = playerstats.getPsavvy();
      int maleAware = playerstats.getMaleAware();

      if(e.getSource() == btn[1])
      {
         
        btn[1].setVisible(false);
        btn[2].setVisible(false);
        btn[3].setVisible(false);
        
        textarea.setText("You eventually find another group but feel slightly defeated and discouraged.");
        textarea.setLineWrap(true);

        patience++;
        confidence--;
        psavvy--;
        maleAware -= 2;

      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[4].setVisible(true);
        btn[4].setText("Continue");   
      }

      else if(e.getSource() == btn[2])
      {
        btn[1].setVisible(false);
        btn[2].setVisible(false);
        btn[3].setVisible(false);
        
        textarea.setText(" Friends say 'Hey, I think we could use her' and override Mr. GitHub.");
        textarea.setLineWrap(true);

        psavvy++;
        confidence++;
        networking += 3;
        maleAware += 3;

        playerstats.setNet(networking);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);

        statusbar.setText("Player's attributes: patience: " + playerstats.getPat() + " confidence: " + playerstats.getCon() + " political: " + playerstats.getPsavvy() + " networking: " + playerstats.getNet() + " male awareness: " + playerstats.getMaleAware());
        btn[4].setVisible(true);
        btn[4].setText("Continue");
      }

      else
      {
        btn[1].setVisible(false);
        btn[2].setVisible(false);
        btn[3].setVisible(false);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        textarea.setLineWrap(true);

        patience -= 1;
        confidence+=3;
        networking += 3;
        maleAware += 1;

        playerstats.setNet(networking);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[4].setVisible(true);
        btn[4].setText("Continue");
      } 
    }  
  }//end of College Button Listener

class College2ButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[9];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public College2ButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[5] = btn1;
      btn[6] = btn2;
      btn[7] = btn3;
      btn[8] = btn4;
      playerstats = ps;
      statusbar = sb;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      int patience = playerstats.getPat();
      int confidence = playerstats.getCon();
      int networking = playerstats.getNet();
      int psavvy = playerstats.getPsavvy();
      int maleAware = playerstats.getMaleAware();

      if(e.getSource() == btn[5])
      {
         
        btn[5].setVisible(false);
        btn[6].setVisible(false);
        btn[7].setVisible(false);
        
        textarea.setText("New choice 1");
        textarea.setLineWrap(true);

        patience++;
        confidence--;
        psavvy--;
        maleAware -= 2;

      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[8].setVisible(true);
        btn[8].setText("Continue");   
      }

      else if(e.getSource() == btn[6])
      {
        btn[5].setVisible(false);
        btn[6].setVisible(false);
        btn[7].setVisible(false);
        
        textarea.setText("New choice 2");
        textarea.setLineWrap(true);

        psavvy++;
        confidence++;
        networking += 3;
        maleAware += 3;

        playerstats.setNet(networking);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[8].setVisible(true);
        btn[8].setText("Continue");
      }

      else
      {
        btn[5].setVisible(false);
        btn[6].setVisible(false);
        btn[7].setVisible(false);
        
        textarea.setText("New choice 3");
        textarea.setLineWrap(true);

        patience -= 1;
        confidence+=3;
        networking += 3;
        maleAware += 1;

        playerstats.setNet(networking);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[8].setVisible(true);
        btn[8].setText("Continue");
      }  
    }
}//end of College Button Listener