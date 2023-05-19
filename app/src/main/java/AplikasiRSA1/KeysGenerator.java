
package AplikasiRSA1;

//import cryptografi.Form_Key;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
//import sun.util.calendar.CalendarUtils.mod;



public class KeysGenerator {
    
    private BigInteger p; 
    private BigInteger q; 
    private BigInteger N; 
    private BigInteger phi; 
    private BigInteger e; 
    private BigInteger d; 
    private final int BITLENGTH = 6;
    private final int BLOCKSIZE = 256; //blocksize in byte 
    
    private String direc;
    private String directory;
    private String id;
    private String[] log = new String[6];
    private Random r;
    
    public KeysGenerator() {
        r = new Random(); 
        p = BigInteger.probablePrime(BITLENGTH, r); 
        q = BigInteger.probablePrime(BITLENGTH, r); 
        N = p.multiply(q); 

        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); 
        e = BigInteger.probablePrime(BITLENGTH/2, r); 

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) { 
            e.add(BigInteger.ONE); 
        } 
        System.out.println(); 
        
        d = e.modInverse(phi); 
                
        // set nilai log
        log[0] = "p : " + String.valueOf(p);
        log[1] = "q : " + String.valueOf(q);
        log[2] = "n : " + String.valueOf(N);
        log[3] = "phi : " + String.valueOf(phi);
        log[4] = "e : " + String.valueOf(e);
        log[5] = "d : " + String.valueOf(d);
    }
    
    public void setDir(String directorypub) {
        this.directory = directorypub; //set directory untuk save public key
    }
    
     public void setDirec(String directorypriv) {
        this.direc = directorypriv; //set directory untuk save private key
    }
    public void setId(String id) {
        this.id = id;
    }
    
        
    public void createpublic(){
           try {
            // menentukan nama file publik dan private
            String fileNamePub = this.id+".public.key";
                        
            // membuat objek file public dan private
            File filePublic = new File(this.directory + fileNamePub);
                       
            // memeriksa kedua file apakah telah ada
            // atau belum ada
            if(!filePublic.exists()){
                filePublic.createNewFile();  
                
            }
            
            // membuat objek FileWriter untuk fwPublic 
            FileWriter fwPublic = new FileWriter(filePublic.getAbsoluteFile());
                        
            // membuat objek Buffer untuk bwPublic 
            BufferedWriter bwPublic = new BufferedWriter(fwPublic);
                        
            // menulis kunci publik
            bwPublic.write(id);
            bwPublic.write("\n");
            bwPublic.write(String.valueOf(this.N));
            bwPublic.write("\n");
            bwPublic.write(String.valueOf(this.e));
            //Session.setN(String.valueOf(this.N));
            //Session.setE(String.valueOf(this.e));       
            
            // close buffer
            bwPublic.close();
                       
            System.out.println("Sukses membuat kunci publik !, cek di : " + this.directory + fileNamePub);
            
        } catch(IOException e) {
        }
    }
    
    public void createprivate(){
        try{
            String fileNamePriv= this.id+".private.key";

            File filePrivate= new File(this.direc + fileNamePriv);
            
              if(!filePrivate.exists()){
                   filePrivate.createNewFile();
          }
            FileWriter fwPrivate= new FileWriter(filePrivate.getAbsoluteFile());
            BufferedWriter bwPrivate= new BufferedWriter(fwPrivate);
               
           // menulis kunci private
            bwPrivate.write(id);
            bwPrivate.write("\n");
            bwPrivate.write(String.valueOf(this.N));// ini yang akan di enkrip
            bwPrivate.write("\n");
            bwPrivate.write(String.valueOf(this.d));// ini yang akan di enkrip
            
             bwPrivate.close();
             System.out.println("Sukses membuat kunci private!, cek di : " + this.direc + fileNamePriv);
       
        } catch(IOException e) {
       }
    }
    
    public String createKeys() throws Exception{
        this.createpublic();
        this.createprivate();
             
        String gab=String.valueOf(this.N)+"#"+String.valueOf(this.e)+"#"+String.valueOf(this.d)+"#";
        return gab;
    }
    public void createKeys2() throws Exception{
        this.createpublic();
        this.createprivate();
             
    }
        
    public void getLog() {
        System.out.println(Arrays.toString(log));
    }
    
    public static void main(String[] args) throws IOException {
       // KeysGenerator data = new KeysGenerator("GenerateRSA");
        //data.createKeys("D:/");
    }
}
