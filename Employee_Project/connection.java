package Employee_Project;
import java.sql.*;
import javax.swing.JOptionPane;
public class connection {
   public Connection con=null;
   public static Connection ConnectDB(){
      try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:vyom","c##admin","admin");
           System.out.println("load Driver");
           return con;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }      
    }
}