
package com.uniconnect.tempUserStorage;

import java.util.Map;
import java.util.HashMap;

//Class that TEMPORARILIY stores newly registered users and their passwords.
public class tempUserStorage {
    
    private static final HashMap<String, String> users = new HashMap<>();
    
    
    //add new users to the data base
    
    public static void addNewUser(String username, String password){
        users.put(username, password);
    }
    
    
    //Validate newly added users at login
    public static boolean isValidUser(String username, String password){
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
