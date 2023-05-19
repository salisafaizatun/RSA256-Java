
package AplikasiRSA1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;


   
public class myRSA {
private BigInteger n;
private Integer e;
private Integer d;  

 public void setPublicKey(String filePublic) throws IOException {
        BufferedReader br = null;
        try {
            int batas = 0;
            String current;
            br = new BufferedReader(new FileReader(filePublic));//mebaca file PublicKey
            //jkw=0
            //1927=1
            //7 =2
            while ((current = br.readLine()) != null) {
                if (batas == 1) {
                    // set nilai modulo dari file kunci publik
                    this.n = new BigInteger(current);
                } else if (batas == 2) {
                    // set nilai eksponen e dari file kunci publik
                    this.e = new Integer(current);
                }
                batas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {br.close();}
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("nilai n : " + this.n);
        System.out.println("nilai e : " + this.e);
    }

    public String encrypt(String pesan,String myN,String myE) {
        this.n=new BigInteger(myN);
        this.e=new Integer(myE);
        
        char[]ar=pesan.toCharArray();
        String[] data1 = new String[pesan.length()];
        for(int i=0; i < pesan.length(); i++) {
            data1[i] = String.valueOf(ar[i] & 0xff); //& 0xff unsigned integer
         }
        
        BigInteger[] data2 = new BigInteger[data1.length];
        for (int i = 0; i < data1.length; i++) {
             data2[i] = (new BigInteger(data1[i])).pow(this.e);
             data2[i] = data2[i].mod(this.n);
           }
       
        String[] x = new String[data2.length];
        for(int i = 0; i < data2.length; i++) {
            x[i] = String.valueOf(data2[i]);      
        }
        
        String data5 = StringUtils.join(x, " ");//menggabungkan file dengan spasi

        return data5;
    }
         


  public void setPrivateKey(String filePrivate) {
         BufferedReader br = null;
        try {
            int batas = 0;
            String current;
            br = new BufferedReader(new FileReader(filePrivate));
            while ((current = br.readLine()) != null) {
                if (batas == 1) {
                    // set nilai modulo dari file kunci publik
                    this.n = new BigInteger(current);
                } else if (batas == 2) {
                    // set nilai eksponen e dari file kunci publik
                    this.d = new Integer(current);
                }
                batas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {br.close();}
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("nilai n : " + this.n);
        System.out.println("nilai d : " + this.d);
    }
    

    public String decrypt(String Chipper,String myN,String myD) {
        this.n=new BigInteger(myN);
        this.d=new Integer(myD);
        
            String[] data1 = Chipper.split(" "); // 
            
            BigInteger[] data2 = new BigInteger[data1.length];
            for (int i=0; i < data1.length; i++){
                data2[i] = (new BigInteger(String.valueOf(data1[i]))).pow(this.d);
                data2[i] = data2[i].mod(this.n);
             }
            
            byte[] data3 = new byte[data2.length];
           // String hasil="";
             for (int i=0; i < data2.length; i++){
                data3[i] = (byte) (data2[i].byteValue());
                //hasil=String.valueOf(data3[i]);
            }
             String s = new String(data3);
             return s;   
    }







    
}
