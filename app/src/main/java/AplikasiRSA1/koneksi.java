package AplikasiRSA1;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class koneksi {
public koneksi(){}
Connection con=null;
Statement st=null;

public Connection open(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_chatroom?enabledTLSProtocols=TLSv1.2","root","");
        return con;
    }
    catch(SQLException sqle){
    System.out.print("Tida Ada Koneksi Yang Terbuka");
    return null;
    }
    catch(Exception e){
        javax.swing.JOptionPane.showMessageDialog(null,"koneksi gagal " +e.getMessage());
        System.out.print("Tidak Bisa Membuka Koneksi........"+e.getMessage());
        return null;
    }
}

public void QUERY(String data , String option){
 try{
if(con==null) con=open();
if(st==null) st=con.createStatement();
st.executeUpdate(data);
javax.swing.JOptionPane.showMessageDialog(null,"Data Berhasil "+option);
}
catch(SQLException sqle){
 sqle.printStackTrace();
javax.swing.JOptionPane.showMessageDialog(null,"Data Gagal "+option+" masalahnya: "+sqle.getMessage());
}
}

public void QUERY2(String data , String option){
try{
if(con==null) con=open();
if(st==null) st=con.createStatement();
st.executeUpdate(data);
//javax.swing.JOptionPane.showMessageDialog(null,"Data Berhasil "+option);
}
catch(SQLException sqle){
sqle.printStackTrace();
//javax.swing.JOptionPane.showMessageDialog(null,"Data Gagal"+option+"SalahNya:"+sqle.getMessage());
}
}

    public void QUERY(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}




