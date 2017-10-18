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

public class FarmerLoggedIn extends AppCompatActivity {

    DBHelper mydb;
    Cursor rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_logged_in);
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

    public void post(View view){
        Intent intent = new Intent(this,FarmerPost.class);
        Intent intents=getIntent();
        String user = intents.getStringExtra("UserName");
        String pass = intents.getStringExtra("PassWord");
        intent.putExtra("UserName",user);
        intent.putExtra("PassWord",pass);
        startActivity(intent);
    }

    public void search(View view){

        Intent intent = new Intent(this,FarmerSearch.class);
        Intent intents=getIntent();
        String user = intents.getStringExtra("UserName");
        String pass = intents.getStringExtra("PassWord");
        rs = mydb.getFarmerData(user,pass);
        String address = rs.getString(rs.getColumnIndex(DBHelper.address));
        String crop = rs.getString(rs.getColumnIndex(DBHelper.crop));
        intent.putExtra("Address",address);
        intent.putExtra("Crop",crop);
        startActivity(intent);
    }

}
