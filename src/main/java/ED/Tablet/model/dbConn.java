package ED.Tablet.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.checkerframework.common.reflection.qual.ForName;

import sun.security.util.Password;
import sun.tools.tree.FinallyStatement;

public class dbConn {

    //Attributes:
    protected String host = "https://db.course.hst.aau.dk/phpmyadmin/";
    protected String DBPassword = "pheyiesiehafileingei";
    protected String username = "hst_2020_20gr5404";
   // protected int port = 3306


    // Lave en constructor 
    public dbConn(String host, String DBPassword, String username){
    this.host=host;
    this.DBPassword=DBPassword;
    this.username=username; 
    }

   

    //Methods
    protected Connection connectToDB(String host, String DBPassword, String username) {
            Connection myDB =null;
            
        try {
           Connection myDB = DriverManager.getConnection(host, DBPassword, username);
        
        }
    
        return myDB;
    }

    protected ResultSet executeQuery(String sqlStatement){

        Connection myDB = connectToDB();
        
        Statement stmt = null;
        ResultSet rs = null;

        if (myDB != null){
            try {
                
                stmt = myDB.createStatement();
                rs = stmt.executeQuery(sqlStatement);
                
                
            } 

    }
    
}

