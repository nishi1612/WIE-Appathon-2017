package com.example.application.projectx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user ;
    EditText pass;
    String text;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
        mydb = new DBHelper(this);
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

    public void click(View view){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    public void login(View view){
        String username = "";
        username = user.getText().toString();
        String password = "";
        password = pass.getText().toString();
        if("".equals(user) || "".equals(pass)){
            text = "Ensure you enter every information";
            int duration = Toast.LENGTH_LONG;
            Toast t = Toast.makeText(this, text, duration);
            t.show();
        }else{
            int i = mydb.findFarmer(username,password);
            if(i==0){
                text = "Wrong information entered";
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(this, text, duration);
                t.show();
            }else if(i==1){
                text = "Successfully logged in as a farmer";
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(this, text, duration);
                t.show();
                Intent intent = new Intent(this,FarmerLoggedIn.class);
                intent.putExtra("UserName",username);
                intent.putExtra("PassWord",password);
                startActivity(intent);
            }else if(i==2){
                text = "Successfully logged in as a retailer";
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(this, text, duration);
                t.show();
                Intent intent = new Intent(this,RetailerLoggedIn.class);
                startActivity(intent);
            }
        }
    }
}
