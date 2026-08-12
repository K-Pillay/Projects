
package com.uniconnect.websockets;

import jakarta.websocket.*;
import java.util.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;


@ServerEndpoint("/chat")
public class chatEndpoint {
    
    //stores connected user session in a synchronised set for thread safety
    private static Set<Session> chatUsers = Collections.synchronizedSet(new HashSet<>());
    
    
   // Called when user connects to a websocket
    @OnOpen
    public void onOpen(Session session){
        chatUsers.add(session); //adds a new session to the set
        System.out.println("User " + session.getId() + "has joined the chatroom");
    }
    
    //called when a client send a message in the chat
    @OnMessage
    public void onMessage(String message, Session sender) throws IOException{
     //broadcasts the message that some has joined to all users
      synchronized(chatUsers){
          for(Session sessions : chatUsers) {
              if(sessions.isOpen()){
                  sessions.getBasicRemote().sendText(message);
              }
          }
      }  
    }
    //called when a user disconnects or exits the chat
    @OnClose
    public void onClose(Session session){
        chatUsers.remove(session);//removes session when a user exits the chat
        System.out.println("Connection has been closed for:" + session.getId());
    }
    
    
    //called when there is an error whne connecting to the chat
    @OnError
    public void onError(Session session, Throwable throwable){
        System.err.println("Error for session " + session.getId() + ": " + throwable.getMessage());
    }
}
