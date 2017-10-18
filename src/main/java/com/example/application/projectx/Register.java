package com.example.application.projectx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    String text="";
    EditText reg_fullname;
    EditText reg_email;
    EditText reg_username;
    EditText reg_password;
    EditText reg_repassword;
    EditText reg_address;
    EditText reg_contact;
    DBHelper mydb;
    RadioGroup category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mydb = new DBHelper(this);
        reg_fullname = (EditText)findViewById(R.id.reg_fullname);
        reg_email = (EditText)findViewById(R.id.reg_email);
        reg_username = (EditText)findViewById(R.id.reg_username);
        reg_password = (EditText)findViewById(R.id.reg_password);
        reg_repassword = (EditText)findViewById(R.id.reg_repassword);
        reg_address = (EditText)findViewById(R.id.reg_address);
        reg_contact = (EditText)findViewById(R.id.reg_contact);
        category = (RadioGroup)findViewById(R.id.category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.info){
            Intent intent = new Intent(this,Info.class);
            startActivity(intent);
            return true;
        }else if(id==R.id.home){
            Intent intent = new Intent(this,StartUp.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void registers(View view) {

        int ids = category.getCheckedRadioButtonId();
        int j=0;
        if(ids==R.id.retailer) j=2;
        else j=1;
        String fullname = "";
        fullname = reg_fullname.getText().toString();
        String email = "";
        email = reg_email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (!email.matches(emailPattern)) {
            text = "Invalid email address";
            int duration = Toast.LENGTH_LONG;
            Toast t = Toast.makeText(this, text, duration);
            t.show();
        } else {
            String username = "";
            username = reg_username.getText().toString();
            String password = "";
            password = reg_password.getText().toString();
            String repassword = "";
            repassword = reg_repassword.getText().toString();
            if (!password.equals(repassword)) {
                text = "The re entered password does not match password";
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(this, text, duration);
                t.show();
            } else {
                String address = reg_address.getText().toString();
                String contact = reg_contact.getText().toString();

                if ("".equals(fullname) || "".equals(email) || "".equals(username) || "".equals(password) || "".equals(address) || "".equals(contact) || j==0) {
                    text = "Ensure that every category is filled";
                    int duration = Toast.LENGTH_LONG;
                    Toast t = Toast.makeText(this, text, duration);
                    t.show();
                } else {
                    if (j==1) {
                        mydb.insertFarmerInfo(fullname, email, username, password, address, contact);
                        text = "Farmer registered successfully";
                        int duration = Toast.LENGTH_LONG;
                        Toast t = Toast.makeText(this, text, duration);
                        t.show();
                        Intent intent = new Intent(this,MainActivity.class);
                        startActivity(intent);
                    } else if (j==2) {
                        mydb.insertRetailerInfo(fullname, email, username, password, address, contact);
                        text = "Retailer register successfully";
                        int duration = Toast.LENGTH_LONG;
                        Toast t = Toast.makeText(this, text, duration);
                        t.show();
                        Intent intent = new Intent(this,MainActivity.class);
                        startActivity(intent);
                    }else{
                        /*text = "Not working";
                        */int duration = Toast.LENGTH_LONG;
                        Toast t = Toast.makeText(this, text + String.valueOf(100), duration);
                        t.show();
                    }
                }
            }
        }


    }

    public void pastry(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}


