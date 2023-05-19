/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiRSA1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Uji {
//
//    
//    public static void main(String[]args){
//    Uji x=new Uji();
//   // x.enkrip();
//        try {
//            //     x.generate();
//            x.daftar();
//        } catch (IOException ex) {
//            Logger.getLogger(Uji.class.getName()).log(Level.SEVERE, null, ex);
//        }
////2491
////957
////5
//        
//    }
//    
    
    String daftar() throws IOException{
      String PATH=System.getProperty("user.dir");
      System.out.println(PATH);
      //C:\NetBeans\aplikasichat\AplikasiChat
      
            
            BigInteger n=new BigInteger("0");
            Integer e=new Integer("0");
            Integer d=new Integer("0");
            
            Uji x=new Uji();
           String gab= x.generate();
            
//             String filePublic=PATH+"\\MYRSA\\mykey.public.key";
//            String filePrivate=PATH+"\\MYRSA\\mykey.private.key";           
//           try {   
//            BufferedReader br = null;
//            
//            int batas = 0;
//            String current;
//            br = new BufferedReader(new FileReader(filePublic));
//            while ((current = br.readLine()) != null) {
//                if (batas == 1) {
//                    n = new BigInteger(current);
//                } else if (batas == 2) {
//                    e = new Integer(current);
//                }
//                batas++;
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Uji.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//          try {   
//            BufferedReader br = null;
//            
//            int batas = 0;
//            String current;
//            br = new BufferedReader(new FileReader(filePrivate));
//            while ((current = br.readLine()) != null) {
//                if (batas == 1) {
//                    n = new BigInteger(current);
//                } else if (batas == 2) {
//                    d = new Integer(current);
//                }
//                batas++;
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Uji.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("#"+n);
//        System.out.println("#"+d);
//        System.out.println("#"+e);
        System.out.println(gab);
        //String  gab=String.valueOf(n)+"#"+String.valueOf(e)+"#"+String.valueOf(d)+"#";
        return gab;
} 

    
    
    

String enkrip(String pesan,String myN,String myE){
    String chipper="";
            myRSA enk = new myRSA();
                try {
                     chipper=   enk.encrypt(pesan,myN,myE);//D:/Lat/Sistem Berjalan.doc
                    System.out.println("CHIPPER="+chipper);
                    } catch (Exception ex) {
                }

return chipper;
}


//String enkrip(String pesan,String myN,String myE){
//    String chipper="";
//    Thread t = new Thread(new Runnable(){
//           
//           public void run(){
//            long start;
//            long end;
//
//            myRSA enk = new myRSA();
//
//                try {
//                    start = System.currentTimeMillis();//menghitung waktu proses dalam detik
//                    chipper=   enk.encrypt(pesan,myN,myE);//D:/Lat/Sistem Berjalan.doc
//                    System.out.println("CHIPPER="+chipper);
//                    
////                        Uji x=new Uji();
////                        x.dekrip(chipper);
//        
//                    end = System.currentTimeMillis();
//                  } catch (Exception ex) {
//                }
//
//           }
//       });
//       t.start();
//return chipper;
//}

//
//void dekrip(String chipper){
//    
//        String myN="2491";
//    String myD="957";
//    
//    
// Thread t = new Thread(new Runnable(){
//            public void run(){
//
//                long start;
//                long end;
//                String kunciPrivate = "";
//                    if (!(chipper.equals(""))){
//                        myRSA dek=new myRSA();
//                        try {
//                           //dek.setPrivateKey("E:\\MYRSA\\mykey.private.key");
//                           start = System.currentTimeMillis();//menghitung waktu proses dalam milidetik
//                           
//                            System.out.println(chipper); 
//                            String hasil=     dek.decrypt(chipper,myN,myD);
//                           System.out.println(hasil); 
//                           
//                                    end = System.currentTimeMillis();
//                              //      JOptionPane.showMessageDialog(null, " Decryption Success with duration : "+ ((end - start) / 1000.0) + " Milidetik" , "Message", JOptionPane.INFORMATION_MESSAGE);;
//                                } catch (Exception e) {
//                            //        JOptionPane.showMessageDialog(null, "Failed Decryption", "Warning", JOptionPane.ERROR_MESSAGE);
//                                }
//
//                            }else{
//                           //     JOptionPane.showMessageDialog(null, "Entry all data", "Warning", JOptionPane.ERROR_MESSAGE);
//                            }
//                        }
//                    });
//                    t.start();
//}


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

                        //key.getLog();
                  
                }catch(Exception e){
                    //JOptionPane.showMessageDialog(null, "Failed Generate Key", "Warning", JOptionPane.ERROR_MESSAGE);
                    }
return gab;
}
//
//void generate(){
//        Thread t = new Thread(new Runnable(){
//            public void run(){
//                long start;
//                long end; 
//
//                String namakunci = ("mykey");
//
//            String PATH=System.getProperty("user.dir");
//            String mypublic=PATH+"\\mykey.public.key";
//            String myprivate=PATH+"\\MYRSA\\mykey.private.key";
//           
//                KeysGenerator key = new KeysGenerator();
//            
//                try{
//
//                        key.setId(namakunci);
//                        key.setDir(mypublic.replace("\\", "/")+"/");
//                        key.setDirec(myprivate.replace("\\", "/")+"/");
//                        start = System.currentTimeMillis();//menghitung waktu proses dalam detik
//                        key.createKeys();                            
//
//                        end = System.currentTimeMillis();
//                        //System.out.println("\nWaktu yang diperlukan selama proses adalah " + ((end - start) / 1000.0) + " detik");
//                     //   JOptionPane.showMessageDialog(null, "Generate Key Success with duration : " +((end - start) / 1000.0) + " Milidetik", "Message", JOptionPane.INFORMATION_MESSAGE);
//
//                        key.getLog();
//                  
//                }catch(Exception e){
//                    //JOptionPane.showMessageDialog(null, "Failed Generate Key", "Warning", JOptionPane.ERROR_MESSAGE);
//                    }
//                    
//            }
//        });
//        t.start();
//     
//       
//}
}
