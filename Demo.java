import javax.swing.JFrame;

public class Demo 
{
   public static void main (String[] args)   
			{
            SwingUtilities.invokeLater(new Runnable() 
           {
             public void run() 
             {
				   new StarIsland();
            }
            });
	  		}//end of Main
}