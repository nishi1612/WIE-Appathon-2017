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
import android.widget.TextView;

import org.w3c.dom.Text;

public class FarmerSearch extends AppCompatActivity {

    DBHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_search);
        Intent intent=getIntent();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String address = intent.getStringExtra("Address");
        String crop = intent.getStringExtra("Crop");
        mydb = new DBHelper(this);
        TextView prateek = (TextView)findViewById(R.id.prateek);

        Cursor rs = mydb.search(address,crop);
        String t = " ";

        if(rs.moveToFirst()){
            while(rs.isAfterLast() == false){

                String fullName = rs.getString(rs.getColumnIndex(DBHelper.full_name));
                String add = rs.getString(rs.getColumnIndex(DBHelper.address));
                String email = rs.getString(rs.getColumnIndex(DBHelper.email));
                String contact = rs.getString(rs.getColumnIndex(DBHelper.contact));
                t =t + "FullName: "+ fullName + "\n" + "Address: " + add + "\n"  + "Email-Address: " + email + "\n"  + "Contact-Number: " + contact + "\n \n";
                rs.moveToNext();
            }

        }
        prateek.setText(t);





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
