
package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
/**
 *
 * @author Sumit Ahir
 */
public class Chat extends Application {
    
    private AnchorPane root;
 
    
    public Chat(){
     // Add some sample data
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Chat.class.getResource("Receive.fxml"));
        root = (AnchorPane) loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
       
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        Connection con=null;
        Statement stat = null;
        ResultSet rs=null;
        try{
            Class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Chat");
            stat = con.createStatement();
            rs = stat.executeQuery("SELECT * from APP.NAME");
        }
            
        catch(ClassNotFoundException e){
                
                }
        catch(SQLException s){
            
        }
        
    }
    }
   
