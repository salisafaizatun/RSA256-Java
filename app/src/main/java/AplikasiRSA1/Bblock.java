
package AplikasiRSA1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Bblock {

    
    public static void main(String[]args){
    Uji x=new Uji();
     String gab;
        try {
            gab = x.daftar();
            String[]ar=gab.split("#");
            //String myN=ar[0];
            //String myE=ar[1];
            //String myD=ar[2];
            
            String myN="2773";//ar[0];
            String myE="5";//ar[1];
            String myD="1601";//ar[2];
            // System.out.println(gab);
             
             String pesan="Halo Apa Kabar";
             String chipper=x.enkrip(pesan,myN,myE);
             
             
              myRSA dek = new myRSA();
                try {
                    String plaintext=   dek.decrypt(chipper,myN,myD);
                    System.out.println("plaintext="+plaintext);
                    } catch (Exception ex) {
                }
     
             
             
        } catch (IOException ex) {
            Logger.getLogger(Bblock.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   
    }
    
    
    String daftar() throws IOException{
            BigInteger n=new BigInteger("0");
            Integer e=new Integer("0");
            Integer d=new Integer("0");
            
            Bblock x=new Bblock();
           String gab= x.generate();
            
        return gab;
} 

    
String enkrip(String pesan,String myN,String myE){
    String chipper="";
            myRSA enk = new myRSA();
                try {
                     chipper=   enk.encrypt(pesan,myN,myE);
                    } catch (Exception ex) {
                }

return chipper;
}

String generate(){
   String gab="";
          String namakunci = ("mykey");

            String PATH=System.getProperty("user.dir");
            String mypublic=PATH+"\\MYRSA\\";
            String myprivate=PATH+"\\MYRSA\\";
                KeysGenerator key = new KeysGenerator();
            
                try{

                        key.setId(namakunci);
                        key.setDir(mypublic.replace("\\", "/")+"/");
                        key.setDirec(myprivate.replace("\\", "/")+"/");
                         gab= key.createKeys();                            

                }catch(Exception e){
                    }
return gab;
}

}
