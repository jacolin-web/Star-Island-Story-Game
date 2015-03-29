import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.*; 
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StarIslandDemo
{
   public static void main(String[] args)
   {
      StarIsland frame = new StarIsland();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setResizable(false);
   }
}

class StarIsland extends JFrame
{
   public StarIsland()
   {
      Container c ; 
      c=getContentPane();
      //end of container class
      
      this.setLayout(new GridLayout(4,1));
      this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      JPanel mainPanel = new JPanel();
      JPanel txtPanel = new JPanel();
      JPanel imgPanel = new JPanel();
      JPanel stsPanel = new JPanel();
      
      
      this.add(imgPanel);
      this.add(txtPanel);
      this.add(mainPanel);
      this.add(stsPanel);
      //Setting Up Panel

      txtPanel.setBackground(Color.white);
      mainPanel.setBackground(Color.white);
      
      PlayerStats ps = new PlayerStats(0, 0, 0, 0, 0, 0);
      
      try
      {
         BufferedImage myPicture = ImageIO.read(new File("img/BryceBrogrammers.jpg"));
         JLabel picLabel = new JLabel(new ImageIcon(myPicture));
         imgPanel.add(picLabel);
      } 
      
       catch (Exception ex) 
       { 
         System.out.println(ex.getMessage());
       }
      
      
      JTextField statusbar;
      statusbar = new JTextField();
      statusbar.setEditable(false);
      statusbar.setText("Player's attributes: PATIENCE: " + ps.getPat() + " CONFIDENCE: " + ps.getCon() + " POLITICIAL: " + ps.getPsavvy() + " NETWORKING: " + ps.getNet() + " MALE AWARENESS: " + ps.getMaleAware() + " MENTORS: " + ps.getMentors());
      stsPanel.add(statusbar);
      
      JTextArea textArea;
      textArea = new JTextArea(100, 65);
      JScrollPane scrollPane = new JScrollPane(textArea); 
      textArea.setEditable(false);
      txtPanel.add(textArea);
      txtPanel.add(scrollPane);
      //end of textArea
      
      
      
      JButton btn[] = new JButton[45];
      btn[0] = new JButton("START GAME");


      for( int i = 1; i < 45; i++)
      {
         btn[i] = new JButton();
         btn[i].setVisible(false);
         mainPanel.add(btn[i]);
      }

      for( int i = 1; i < 45; i +=4)
          {
             btn[i].setText("One");   
          }

      for( int i = 2; i < 45; i += 4)
          {
             btn[i].setText("Two");
          }

      for( int i = 3; i < 45; i += 4)
          {
             btn[i].setText("Three");
          }
          
      //Start Button
      btn[0].addActionListener(new StartButtonListener(btn[0], btn[1], btn[2], btn[3], textArea));
      mainPanel.add(btn[0]);
      
      //College 1abc
      btn[1].addActionListener(new CollegeButtonListener(btn[1], btn[2], btn[3], btn[4], textArea, ps, statusbar));
      btn[2].addActionListener(new CollegeButtonListener(btn[1], btn[2], btn[3], btn[4], textArea, ps, statusbar));
      btn[3].addActionListener(new CollegeButtonListener(btn[1], btn[2], btn[3], btn[4], textArea, ps,statusbar));

      //Second College
      btn[4].addActionListener(new College2Listener(btn[4], btn[5], btn[6], btn[7], textArea));

      //College 2abc
      btn[5].addActionListener(new College2ButtonListener(btn[5], btn[6], btn[7], btn[8], textArea, ps, statusbar));
      btn[6].addActionListener(new College2ButtonListener(btn[5], btn[6], btn[7], btn[8], textArea, ps, statusbar));
      btn[7].addActionListener(new College2ButtonListener(btn[5], btn[6], btn[7], btn[8], textArea, ps, statusbar));

       //WallSt Button
      btn[8].addActionListener(new WallSTListener(btn[8], btn[9], btn[10], btn[11], textArea));
      
      //WallST 9abc
      btn[9].addActionListener(new WallSTButtonListener(btn[9], btn[10], btn[11], btn[12], textArea, ps, statusbar));
      btn[10].addActionListener(new WallSTButtonListener(btn[9], btn[10], btn[11], btn[12], textArea, ps, statusbar));
      btn[11].addActionListener(new WallSTButtonListener(btn[9], btn[10], btn[11], btn[12], textArea, ps,statusbar));

      //Second WallST
      btn[12].addActionListener(new WallST2Listener(btn[12], btn[13], btn[14], btn[15], textArea));

      //WallST 2abc
      btn[13].addActionListener(new WallST2ButtonListener(btn[13], btn[14], btn[15], btn[16], textArea, ps, statusbar));
      btn[14].addActionListener(new WallST2ButtonListener(btn[13], btn[14], btn[15], btn[16], textArea, ps, statusbar));
      btn[15].addActionListener(new WallST2ButtonListener(btn[13], btn[14], btn[15], btn[16], textArea, ps, statusbar));


      //Media Button
      btn[16].addActionListener(new MediaListener(btn[16], btn[17], btn[18], btn[19], textArea));
      
      //Media 1abc
      btn[17].addActionListener(new MediaButtonListener(btn[17], btn[18], btn[19], btn[20], textArea, ps, statusbar));
      btn[18].addActionListener(new MediaButtonListener(btn[17], btn[18], btn[19], btn[20], textArea, ps, statusbar));
      btn[19].addActionListener(new MediaButtonListener(btn[17], btn[18], btn[19], btn[20], textArea, ps,statusbar));

      //Second Media
      btn[20].addActionListener(new Media2Listener(btn[20], btn[21], btn[22], btn[23], textArea));

      //Media 2abc
      btn[21].addActionListener(new Media2ButtonListener(btn[21], btn[22], btn[23], btn[24], textArea, ps, statusbar));
      btn[22].addActionListener(new Media2ButtonListener(btn[21], btn[22], btn[23], btn[24], textArea, ps, statusbar));
      btn[23].addActionListener(new Media2ButtonListener(btn[21], btn[22], btn[23], btn[24], textArea, ps, statusbar));

      //PoliticsScenario Button
      btn[24].addActionListener(new PoliticsScenarioListener(btn[24], btn[25], btn[26], btn[27], textArea));
      
      //PoliticsScenario 1abc
      btn[25].addActionListener(new PoliticsScenarioButtonListener(btn[25], btn[26], btn[27], btn[28], textArea, ps, statusbar));
      btn[26].addActionListener(new PoliticsScenarioButtonListener(btn[25], btn[26], btn[27], btn[28], textArea, ps, statusbar));
      btn[27].addActionListener(new PoliticsScenarioButtonListener(btn[25], btn[26], btn[27], btn[28], textArea, ps,statusbar));

      //Second PoliticsScenario
      btn[28].addActionListener(new PoliticsScenario2Listener(btn[28], btn[29], btn[30], btn[31], textArea));

      //PoliticsScenario 1abc
      btn[29].addActionListener(new PoliticsScenario2ButtonListener(btn[29], btn[30], btn[31], btn[32], textArea, ps, statusbar));
      btn[30].addActionListener(new PoliticsScenario2ButtonListener(btn[29], btn[30], btn[31], btn[32], textArea, ps, statusbar));
      btn[31].addActionListener(new PoliticsScenario2ButtonListener(btn[29], btn[30], btn[31], btn[32], textArea, ps, statusbar));

      //TechScenario Button
      btn[32].addActionListener(new TechScenarioListener(btn[32], btn[33], btn[34], btn[35], textArea));
      
      //TechScenario 1abc
      btn[33].addActionListener(new TechScenarioButtonListener(btn[33], btn[34], btn[35], btn[36], textArea, ps, statusbar));
      btn[34].addActionListener(new TechScenarioButtonListener(btn[33], btn[34], btn[35], btn[36], textArea, ps, statusbar));
      btn[35].addActionListener(new TechScenarioButtonListener(btn[33], btn[34], btn[35], btn[36], textArea, ps,statusbar));

      //Second TechScenario
      btn[36].addActionListener(new TechScenario2Listener(btn[36], btn[37], btn[38], btn[39], textArea));

      //TechScenario 2abc
      btn[37].addActionListener(new TechScenario2ButtonListener(btn[37], btn[38], btn[39], btn[40], textArea, ps, statusbar));
      btn[38].addActionListener(new TechScenario2ButtonListener(btn[37], btn[38], btn[39], btn[40], textArea, ps, statusbar));
      btn[39].addActionListener(new TechScenario2ButtonListener(btn[37], btn[38], btn[39], btn[40], textArea, ps, statusbar));
     
      //END BUTTON WOOOO
      btn[40].addActionListener(new EndButtonListener(btn[40], textArea, ps));
      
      textArea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/start.txt"));
                  while (scan.hasNext()) 
                  textArea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textArea.setLineWrap(true);
   }

   public static final int DEFAULT_WIDTH = 800;
   public static final int DEFAULT_HEIGHT = 600;
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
                  Scanner scan = new Scanner(new FileReader("storyscripts/college1.txt"));
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[1])
      {
         
        btn[1].setVisible(false);
        btn[2].setVisible(false);
        btn[3].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/college1a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

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
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/college1b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

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
        btn[4].setVisible(true);
        btn[4].setText("Continue");
      }

      else
      {
        btn[1].setVisible(false);
        btn[2].setVisible(false);
        btn[3].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/college1c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

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
                  Scanner scan = new Scanner(new FileReader("storyscripts/college2.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

       
         btn[4].setVisible(false);
         btn[5].setVisible(true);
         btn[6].setVisible(true);
         btn[7].setVisible(true);

       textarea.setLineWrap(true);
   
   }
}//end of College2Listener

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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[5])
      {
         
        btn[5].setVisible(false);
        btn[6].setVisible(false);
        btn[7].setVisible(false);
        
        textarea.setText(""); 
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/college2a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=0;
        confidence+=1;
        psavvy+=2;
        maleAware-=0;
        networking+=3;

      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[8].setVisible(true);
        btn[8].setText("Continue");   
      }

      else if(e.getSource() == btn[6])
      {
        btn[5].setVisible(false);
        btn[6].setVisible(false);
        btn[7].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/college2b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=1;
        psavvy+=2;
        maleAware+=0;
        networking+=5;
        mentor+=1;

      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[8].setVisible(true);
        btn[8].setText("Continue");
      }

      else
      {
        btn[5].setVisible(false);
        btn[6].setVisible(false);
        btn[7].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/college2c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience-=1;
        confidence+=0;
        psavvy-=1;
        maleAware+=0;
        networking-=1;
        
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[8].setVisible(true);
        btn[8].setText("Continue");
      }  
    }
}//end of College Button Listener

class WallSTListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[4];
   private boolean finishedReading = false; 
   
   public WallSTListener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
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
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_Street_1.txt"));
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
class WallSTButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[13];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public WallSTButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[9] = btn1;
      btn[10] = btn2;
      btn[11] = btn3;
      btn[12] = btn4;
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[9])
      {
         
        btn[9].setVisible(false);
        btn[10].setVisible(false);
        btn[11].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_street_1a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence-=1;
        psavvy-=1;
        maleAware -= 2;

      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[12].setVisible(true);
        btn[12].setText("Continue");   
      }

      else if(e.getSource() == btn[10])
      {
        btn[9].setVisible(false);
        btn[10].setVisible(false);
        btn[11].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_Street_1b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=3;
        confidence+=3;
        psavvy+=2;
        maleAware+=1;
        networking+=3;
        mentor+=1;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[12].setVisible(true);
        btn[12].setText("Continue");
      }

      else
      {
        btn[9].setVisible(false);
        btn[10].setVisible(false);
        btn[11].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_Street_1c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=3;
        confidence+=1;
        psavvy+=1;
        maleAware+=0;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[12].setVisible(true);
        btn[12].setText("Continue");
      } 
    }  
  }//end of College Button Listener

class WallST2Listener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[16];
   private boolean finishedReading = false; 
   
   public WallST2Listener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
   {
      btn[12] = btn0;
      btn[13] = btn1;
      btn[14] = btn2;
      btn[15] = btn3;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_Street_2.txt"));
                  while (scan.hasNext()) // while there's still something to read
                  textarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
               } 
               catch (Exception ex) 
               { // catch any exceptions, and...
                  // ...write to the debug console
                  System.out.println(ex.getMessage());
               }

       
         btn[12].setVisible(false);
         btn[13].setVisible(true);
         btn[14].setVisible(true);
         btn[15].setVisible(true);
       textarea.setLineWrap(true);
   
   }
}//end of WallST2Listener

class WallST2ButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[17];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public WallST2ButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[13] = btn1;
      btn[14] = btn2;
      btn[15] = btn3;
      btn[16] = btn4;
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[13])
      {
         
        btn[13].setVisible(false);
        btn[14].setVisible(false);
        btn[15].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_Street_2a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=3;
        confidence+=3;
        psavvy+=2;
        maleAware+=1;
        networking+=3;
        mentor+=1;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[16].setVisible(true);
        btn[16].setText("Continue");   
      }

      else if(e.getSource() == btn[14])
      {
        btn[13].setVisible(false);
        btn[14].setVisible(false);
        btn[15].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_Street_2b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=1;
        psavvy+=0;
        maleAware+=1;
        networking+=1;
        mentor+=1;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[16].setVisible(true);
        btn[16].setText("Continue");
      }

      else
      {
        btn[13].setVisible(false);
        btn[14].setVisible(false);
        btn[15].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_Street_2c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=0;
        confidence-=3;
        psavvy+=0;
        maleAware+=0;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[16].setVisible(true);
        btn[16].setText("Continue");
      }  
    }
}//end of WallST2Button Listener

class MediaListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[4];
   private boolean finishedReading = false; 
   
   public MediaListener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
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
                  Scanner scan = new Scanner(new FileReader("storyscripts/Media1.txt"));
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
}//end of MediaListener
class MediaButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[21];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public MediaButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[17] = btn1;
      btn[18] = btn2;
      btn[19] = btn3;
      btn[20] = btn4;
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[17])
      {
         
        btn[17].setVisible(false);
        btn[18].setVisible(false);
        btn[19].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_street_1a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence-=1;
        psavvy+=0;
        maleAware-=1;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[20].setVisible(true);
        btn[20].setText("Continue");   
      }

      else if(e.getSource() == btn[18])
      {
        btn[17].setVisible(false);
        btn[18].setVisible(false);
        btn[19].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Media1b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=2;
        psavvy+=2;
        maleAware+=3;
        networking+=3;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[20].setVisible(true);
        btn[20].setText("Continue");
      }

      else
      {
        btn[17].setVisible(false);
        btn[18].setVisible(false);
        btn[19].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Media1c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=3;
        confidence-=1;
        psavvy+=2;
        maleAware+=0;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[20].setVisible(true);
        btn[20].setText("Continue");
      } 
    }  
  }//end of MediaButtonListener

class Media2Listener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[24];
   private boolean finishedReading = false; 
   
   public Media2Listener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
   {
      btn[20] = btn0;
      btn[21] = btn1;
      btn[22] = btn2;
      btn[23] = btn3;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                  Scanner scan = new Scanner(new FileReader("storyscripts/Media2.txt"));
                  while (scan.hasNext()) // while there's still something to read
                  textarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
               } 
               catch (Exception ex) 
               { // catch any exceptions, and...
                  // ...write to the debug console
                  System.out.println(ex.getMessage());
               }

       
         btn[20].setVisible(false);
         btn[21].setVisible(true);
         btn[22].setVisible(true);
         btn[23].setVisible(true);
       textarea.setLineWrap(true);
   
   }
}//end of Media2Listener

class Media2ButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[25];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public Media2ButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[21] = btn1;
      btn[22] = btn2;
      btn[23] = btn3;
      btn[24] = btn4;
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[21])
      {
         
        btn[21].setVisible(false);
        btn[22].setVisible(false);
        btn[23].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Media2a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=0;
        confidence+=2;
        psavvy+=2;
        maleAware+=3;
        networking+=3;
        mentor+=1;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[24].setVisible(true);
        btn[24].setText("Continue");   
      }

      else if(e.getSource() == btn[22])
      {
        btn[21].setVisible(false);
        btn[22].setVisible(false);
        btn[23].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Media2b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=0;
        psavvy+=1;
        maleAware+=0;
        networking+=1;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[24].setVisible(true);
        btn[24].setText("Continue");
      }

      else
      {
        btn[21].setVisible(false);
        btn[22].setVisible(false);
        btn[23].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Media2c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=1;
        psavvy+=2;
        maleAware+=1;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[24].setVisible(true);
        btn[24].setText("Continue");
      }  
    }
}//end of Media2ButtonListener

class PoliticsScenarioListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[28];
   private boolean finishedReading = false; 
   
   public PoliticsScenarioListener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
   {
      btn[24] = btn0;
      btn[25] = btn1;
      btn[26] = btn2;
      btn[27] = btn3;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                  Scanner scan = new Scanner(new FileReader("storyscripts/PoliticsScenario1.txt"));
                  while (scan.hasNext()) // while there's still something to read
                  textarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
               } 
               catch (Exception ex) 
               { // catch any exceptions, and...
                  // ...write to the debug console
                  System.out.println(ex.getMessage());
               }
       
         btn[24].setVisible(false);
         btn[25].setVisible(true);
         btn[26].setVisible(true);
         btn[27].setVisible(true);
         
       textarea.setLineWrap(true);
   
   }
}//end of PoliticsScenarioListener
class PoliticsScenarioButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[29];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public PoliticsScenarioButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[25] = btn1;
      btn[26] = btn2;
      btn[27] = btn3;
      btn[28] = btn4;
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[28])
      {
         
        btn[25].setVisible(false);
        btn[26].setVisible(false);
        btn[27].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_street_1a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence-=1;
        psavvy+=0;
        maleAware-=1;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[28].setVisible(true);
        btn[28].setText("Continue");   
      }

      else if(e.getSource() == btn[26])
      {
        btn[25].setVisible(false);
        btn[26].setVisible(false);
        btn[27].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/PoliticsScenario1b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=2;
        psavvy+=2;
        maleAware+=3;
        networking+=3;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[28].setVisible(true);
        btn[28].setText("Continue");
      }

      else
      {
        btn[25].setVisible(false);
        btn[26].setVisible(false);
        btn[27].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/PoliticsScenario1c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=3;
        confidence-=1;
        psavvy+=2;
        maleAware+=0;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[28].setVisible(true);
        btn[28].setText("Continue");
      } 
    }  
  }//end of PoliticsScenarioButtonListener

class PoliticsScenario2Listener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[33];
   private boolean finishedReading = false; 
   
   public PoliticsScenario2Listener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
   {
      btn[28] = btn0;
      btn[29] = btn1;
      btn[30] = btn2;
      btn[31] = btn3;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                  Scanner scan = new Scanner(new FileReader("storyscripts/PoliticsScenario2.txt"));
                  while (scan.hasNext()) // while there's still something to read
                  textarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
               } 
               catch (Exception ex) 
               { // catch any exceptions, and...
                  // ...write to the debug console
                  System.out.println(ex.getMessage());
               }

       
         btn[28].setVisible(false);
         btn[29].setVisible(true);
         btn[30].setVisible(true);
         btn[31].setVisible(true);
       textarea.setLineWrap(true);
   
   }
}//end of PoliticsScenario2Listener

class PoliticsScenario2ButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[33];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public PoliticsScenario2ButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[29] = btn1;
      btn[30] = btn2;
      btn[31] = btn3;
      btn[32] = btn4;
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[29])
      {
         
        btn[29].setVisible(false);
        btn[30].setVisible(false);
        btn[31].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/PoliticsScenario2a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=0;
        confidence+=2;
        psavvy+=2;
        maleAware+=3;
        networking+=3;
        mentor+=1;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[32].setVisible(true);
        btn[32].setText("Continue");   
      }

      else if(e.getSource() == btn[30])
      {
        btn[29].setVisible(false);
        btn[30].setVisible(false);
        btn[31].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/PoliticsScenario2b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=0;
        psavvy+=1;
        maleAware+=0;
        networking+=1;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[32].setVisible(true);
        btn[32].setText("Continue");
      }

      else
      {
        btn[29].setVisible(false);
        btn[30].setVisible(false);
        btn[31].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/PoliticsScenario2c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=1;
        psavvy+=2;
        maleAware+=1;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[32].setVisible(true);
        btn[32].setText("Continue");
      }  
    }
}//end of PoliticsScenario2ButtonListener

class TechScenarioListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[36];
   private boolean finishedReading = false; 
   
   public TechScenarioListener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
   {
      btn[32] = btn0;
      btn[33] = btn1;
      btn[34] = btn2;
      btn[35] = btn3;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                  Scanner scan = new Scanner(new FileReader("storyscripts/TechScenario1.txt"));
                  while (scan.hasNext()) // while there's still something to read
                  textarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
               } 
               catch (Exception ex) 
               { // catch any exceptions, and...
                  // ...write to the debug console
                  System.out.println(ex.getMessage());
               }
       
         btn[32].setVisible(false);
         btn[33].setVisible(true);
         btn[34].setVisible(true);
         btn[35].setVisible(true);
         
       textarea.setLineWrap(true);
   
   }
}//end of TechScenarioListener
class TechScenarioButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[37];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public TechScenarioButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[33] = btn1;
      btn[34] = btn2;
      btn[35] = btn3;
      btn[36] = btn4;
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[33])
      {
         
        btn[33].setVisible(false);
        btn[34].setVisible(false);
        btn[35].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/Wall_street_1a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence-=1;
        psavvy+=0;
        maleAware-=1;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[36].setVisible(true);
        btn[36].setText("Continue");   
      }

      else if(e.getSource() == btn[34])
      {
        btn[33].setVisible(false);
        btn[34].setVisible(false);
        btn[35].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/TechScenario1b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=2;
        psavvy+=2;
        maleAware+=3;
        networking+=3;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[36].setVisible(true);
        btn[36].setText("Continue");
      }

      else
      {
        btn[33].setVisible(false);
        btn[34].setVisible(false);
        btn[35].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/TechScenario1c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=3;
        confidence-=1;
        psavvy+=2;
        maleAware+=0;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[36].setVisible(true);
        btn[36].setText("Continue");
      } 
    }  
  }//end of TechScenarioButtonListener

class TechScenario2Listener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[40];
   private boolean finishedReading = false; 
   
   public TechScenario2Listener(JButton btn0, JButton btn1, JButton btn2, JButton btn3, JTextArea t)
   {
      btn[36] = btn0;
      btn[37] = btn1;
      btn[38] = btn2;
      btn[39] = btn3;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  // create a scanner to read the file (getSelectedFile().getPath() will get the path to the file)
                  Scanner scan = new Scanner(new FileReader("storyscripts/TechScenario2.txt"));
                  while (scan.hasNext()) // while there's still something to read
                  textarea.append(scan.nextLine() + "\n"); // append the line to the TextArea
               } 
               catch (Exception ex) 
               { // catch any exceptions, and...
                  // ...write to the debug console
                  System.out.println(ex.getMessage());
               }

       
         btn[36].setVisible(false);
         btn[37].setVisible(true);
         btn[38].setVisible(true);
         btn[39].setVisible(true);
       textarea.setLineWrap(true);
   
   }
}//end of TechScenario2Listener

class TechScenario2ButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[41];
   private JTextField statusbar;
   private PlayerStats playerstats;
   private boolean finishedReading = false; 
   
   public TechScenario2ButtonListener(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JTextArea t, PlayerStats ps, JTextField sb)
   {
      btn[37] = btn1;
      btn[38] = btn2;
      btn[39] = btn3;
      btn[40] = btn4;
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
      int mentor = playerstats.getMentors();

      if(e.getSource() == btn[37])
      {
         
        btn[37].setVisible(false);
        btn[38].setVisible(false);
        btn[39].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/TechScenario2a.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=0;
        confidence+=2;
        psavvy+=2;
        maleAware+=3;
        networking+=3;
        mentor+=1;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);
        
        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[40].setVisible(true);
        btn[40].setText("Continue");   
      }

      else if(e.getSource() == btn[38])
      {
        btn[37].setVisible(false);
        btn[38].setVisible(false);
        btn[39].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/TechScenario2b.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=0;
        psavvy+=1;
        maleAware+=0;
        networking+=1;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[40].setVisible(true);
        btn[40].setText("Continue");
      }

      else
      {
        btn[37].setVisible(false);
        btn[38].setVisible(false);
        btn[39].setVisible(false);
        
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/TechScenario2c.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);

        patience+=1;
        confidence+=1;
        psavvy+=2;
        maleAware+=1;
        networking+=0;
        mentor+=0;
      
        playerstats.setPat(patience);
        playerstats.setCon(confidence);
        playerstats.setPsavvy(psavvy);
        playerstats.setMaleAware(maleAware);
        playerstats.setNet(networking);
        playerstats.setMentors(mentor);

        statusbar.setText("Player's attributes: PATIENCE: " + playerstats.getPat() + " CONFIDENCE: " + playerstats.getCon() + " POLITICIAL: " + playerstats.getPsavvy() + " NETWORKING: " + playerstats.getNet() + " MALE AWARENESS: " + playerstats.getMaleAware() + " MENTORS: " + playerstats.getMentors());
        btn[40].setVisible(true);
        btn[40].setText("Continue");
      }  
    }
}//end of TechScenario2ButtonListener

class EndButtonListener implements ActionListener
{
   private JTextArea textarea;
   private JButton btn[] = new JButton[41];
   private PlayerStats playerstats;
   private JTextField statusbar;
   private boolean finishedReading = false; 
   
   public EndButtonListener(JButton btn1, JTextArea t, PlayerStats ps)
   {
      btn[40] = btn1;
      playerstats = ps;
      textarea = t;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      int patience = playerstats.getPat();
      int confidence = playerstats.getCon();
      int networking = playerstats.getNet();
      int psavvy = playerstats.getPsavvy();
      int maleAware = playerstats.getMaleAware();
      int mentor = playerstats.getMentors();


      if ((maleAware==5)&&(confidence==10)&&(mentor==3))
      {
         textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/goodend.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);
        btn[40].setVisible(false);

      }
      else
      {
         
        textarea.setText(""); // clear the TextArea before applying the file contents
               try 
               {
                  Scanner scan = new Scanner(new FileReader("storyscripts/badend.txt"));
                  while (scan.hasNext()) 
                  textarea.append(scan.nextLine() + "\n"); 
               } 
               catch (Exception ex) 
               { 
                  System.out.println(ex.getMessage());
               }

        textarea.setLineWrap(true);
        btn[40].setVisible(false);  
      }

    }  
  }//end of EndButtonListener