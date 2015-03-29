public class PlayerStats
{
   private int patience, confidence, psavvy, networking, maleaware;
   
   public PlayerStats(int patience, int confidence, int psavvy, int networking, int maleaware)
   {
      this.patience = patience;
      this.confidence = confidence;
      this.psavvy = psavvy; 
      this.networking = networking;
      this.maleaware = maleaware;   
   }
   
   //Beginning of Get Methods 
   public int getPat()
   {  
      return patience;
   }
   
   public int getCon()
   {  
      return confidence;
   }
   
   public int getPsavvy()
   {  
      return psavvy;
   }
   
   public int getNet()
   {  
      return networking;
   }
   
   public int getMaleAware()
   {  
      return maleaware;
   }
   
   //Beginning of Set Methods
   
   public void setPat (int patience)
   {  
      this.patience = patience;
   }
   
   public void setCon(int confidence)
   {  
      this.confidence = confidence;
   }
   
   public void setPsavvy(int psavvy)
   {  
      this.psavvy = psavvy;
   }
   
   public void setNet(int networking)
   {  
      this.networking = networking;
   }
   
   public void setMaleAware(int maleaware)
   {  
      this.maleaware = maleaware;
   }
   
}