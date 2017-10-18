package com.example.application.projectx;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FarmerPost extends AppCompatActivity {

    DBHelper mydb;
    Cursor rs;
    int id;
    String fullName;
    String username ;
    String password ;
    String address ;
    String email;
    String contact;
    EditText reg_crop;
    EditText reg_price;
    EditText reg_weight;
    EditText reg_days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_post);
        mydb = new DBHelper(this);

        Intent intent=getIntent();
        String user = intent.getExtras().getString("UserName","");
        String pass = intent.getExtras().getString("PassWord","");

        reg_crop =(EditText)findViewById(R.id.reg_crop);
        reg_days = (EditText)findViewById(R.id.reg_days);
        reg_price = (EditText)findViewById(R.id.reg_price);
        reg_weight = (EditText) findViewById(R.id.reg_weight);

        rs = mydb.getFarmerData(user,pass);
        id = rs.getInt(rs.getColumnIndex(DBHelper.id));
        fullName = rs.getString(rs.getColumnIndex(DBHelper.full_name));
        username = rs.getString(rs.getColumnIndex(DBHelper.username));
        password = rs.getString(rs.getColumnIndex(DBHelper.password));
        address = rs.getString(rs.getColumnIndex(DBHelper.address));
        email = rs.getString(rs.getColumnIndex(DBHelper.email));
        contact = rs.getString(rs.getColumnIndex(DBHelper.contact));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    String text = " ";

    public void done(View view){
        mydb.deleteFarmerContact(id);
        String weight = reg_weight.getText().toString();
        String days = reg_days.getText().toString();
        String crop = reg_crop.getText().toString();
        String price = reg_price.getText().toString();
        if ("".equals(fullName) || "".equals(email) || "".equals(username) || "".equals(password) || "".equals(address) || "".equals(contact)  || "".equals(crop) || "".equals(price) || "".equals(weight) || "".equals(days)) {
            text = "Ensure that every category is filled";
            int duration = Toast.LENGTH_LONG;
            Toast t = Toast.makeText(this, text, duration);
            t.show();
        } else {
            boolean flag = mydb.insertFarmerContent(fullName, email, username, password, address, contact,crop,Integer.parseInt(weight),Integer.parseInt(days),Integer.parseInt(price));
            if(flag==true) {
                text = fullName + " " + email + " " + username + " " + password + " " + address + " " + contact + " " + price;
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(this, text, duration);
                t.show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                text = fullName + " " + email + " " + username + " " + password + " " + address + " " + contact + " " + price;
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(this, text, duration);
                t.show();
            }
        }

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
}
