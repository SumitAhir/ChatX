
package chat.Model;

import java.io.DataOutputStream;
import java.net.Socket;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



/**
 *
 * @author Sumit Ahir
 */
public class ChatModel {

    private final StringProperty listMsg;
    private String msg;
    
    
    public ChatModel(){
        this(null);
    }
    
    public ChatModel(String listMsg){
        this.listMsg = new SimpleStringProperty(listMsg);
    }
    
    public String getlistMsgs(){
        return listMsg.get();
    }
    
    public void setlistMsg(String listMsg){
        this.listMsg.set(listMsg);
    }
    
    public StringProperty listMsgProperty(){
        return listMsg;
    }
    
   
    
}

