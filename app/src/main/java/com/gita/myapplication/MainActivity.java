package com.gita.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Prefuse pf;

    EditText tname,tpass;
    Button tbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tname=(EditText)findViewById(R.id.name);
        tpass=(EditText)findViewById(R.id.password);
        tbutton=(Button)findViewById(R.id.button);
        pf=new Prefuse(this);
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = tname.getText().toString();
                String userpass = tpass.getText().toString();

                if (!username.isEmpty() && !userpass.isEmpty()) {
                    pf.loginAp(username,userpass);
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));


                }
                else{
                    Toast.makeText(getApplicationContext(),"please correct it",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
