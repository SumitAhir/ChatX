
package chat;

import chat.Model.ChatModel;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Sumit Ahir
 */
public class ReceiveController implements Initializable {

   
    @FXML
    private TableView<ChatModel> msgTable;
    
    @FXML
    private TableColumn<ChatModel, String> msgTableColumn ;
     
    @FXML
    private TextField EnterMsg;
    
    @FXML
    private Button SendMsg;
    
    @FXML
    private Label lableMsg;
    
    @FXML
    private ListView<String> listMsg;
   
    @FXML
    private HBox box;
    
    private Chat ct;
    
   final ObservableList<String> listItems = FXCollections.observableArrayList("Messages");
    
    public ReceiveController(){
        
    }
    
    @FXML
    private void addAction(ActionEvent action) throws Exception{
        String msg = EnterMsg.getText();
        
        if(msg.isEmpty()){
            System.out.println("Please Enter msg");
        }
        else{
            listItems.add(msg);
            EnterMsg.setText("");
           
        Socket client_socket = new Socket("localhost",1234);
        DataOutputStream server_out = new DataOutputStream(client_socket.getOutputStream());
        
       
        server_out.writeBytes(msg);
        client_socket.close();
        
        //Connection
        Connection con=null;
        Statement stat = null;
        ResultSet rs=null;
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Chat","","");
            stat = con.createStatement();
            rs = stat.executeQuery("SELECT * from APP.NAME");
            
            while(rs.next()){
                System.out.println("ID" + rs.getObject(1).toString());
                System.out.println("Name" + rs.getObject(2).toString());
            }
            rs=null;
        }
            
        catch(ClassNotFoundException e){}
        catch(SQLException s){}
        
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event1) throws Exception {
        String msg = EnterMsg.getText();
        listItems.add(msg);
       
    
    }
    
    
   @FXML
   private void initialize(){
     
       
       
       
   }
   
   /**
     * Is called by the main application to give a reference back to itself
     * @param ct
     */
   public void setChat(Chat ct) {
        this.ct = ct;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listMsg.setItems(listItems);
        
         
    }    
    
}
