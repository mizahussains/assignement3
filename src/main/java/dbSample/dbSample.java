/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbSample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c0652847
 */
public class dbSample {
        private static Connection getConnection() throws SQLException{
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(dbSample.class.getName()).log(Level.SEVERE, null, ex);
            }
            String host=System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            String port= System.getenv("OPENSHIFT_MYSQL_DB_PORT");
            String username= System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
            String password= System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
            String name="jbosswildfly";
            String url="jdbc:mysql://" + host +":" +port+ "/" +name;
            return DriverManager.getConnection(url,username,password);
        }
        public static String getTable() {
        String output="";
        try {
            Connection con=getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from people");
            while (rs.next()){
                output+="<h2>"+rs.getString("name")+"</h2>";
                output+="<p>" + rs.getString("bio")+ "</p>";
        
            }con.close();
        } catch (SQLException ex) {
            output="SQL Exception:" +ex.getMessage();
        }
    
        return output;
     }
        
}
