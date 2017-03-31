package com.gita.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by adv on 2/23/2017.
 */

public class Prefuse {
    Context cv;
    SharedPreferences pf;
    int PRIVATE_MODE=0;
    public final static String PREF_NAME="pref";
    public final static String NAME="name";
    public final static String PASSWORD="pass";
    SharedPreferences.Editor editor;
    private static final String IS_LOGIN = "IsLoggedIn";
    public Prefuse(Context ctx) {
        this.cv = ctx;
        pf = cv.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
         editor=pf.edit();
    }
    public void loginAp(String name, String pass){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(NAME, name);

        // Storing email in pref
        editor.putString(PASSWORD, pass);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity

            Intent i = new Intent(cv, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            cv.startActivity(i);
        }

    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(NAME, pf.getString(NAME, null));

        // user email id
        user.put(PASSWORD, pf.getString(PASSWORD, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(cv, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        cv.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pf.getBoolean(IS_LOGIN, false);
    }



}
