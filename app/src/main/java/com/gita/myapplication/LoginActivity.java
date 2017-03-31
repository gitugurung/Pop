package com.gita.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    Prefuse pf;

    EditText tname,tpass;
    Button tbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tname=(EditText)findViewById(R.id.name1);
        tpass=(EditText)findViewById(R.id.password1);
        tbutton=(Button)findViewById(R.id.button1);
        pf=new Prefuse(this);
        pf.checkLogin();

        // get user data from session
        HashMap<String, String> user = pf.getUserDetails();

        // name
        String name = user.get(Prefuse.NAME);

        // email
        String pass = user.get(Prefuse.PASSWORD);
        tname.setText(name);
        tpass.setText(pass);
      /*  if(tbutton.isClickable()) {
            tbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pf.logoutUser();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));


                }
            });
        }
        else{
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }


 */


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.menubar:
                pf.logoutUser();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                default:
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}

