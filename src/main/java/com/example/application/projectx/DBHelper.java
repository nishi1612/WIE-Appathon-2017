package com.example.application.projectx;

/**
 * Created by nish_1612 on 10/09/17.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by prateek on 09/09/17.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    String text;
    public static final String database = "MyDBName.db";
    public static final String farmer = "farmer";
    public static final String retailer = "retailer";
    public static final String id = "id";
    public static final String full_name = "full_name";
    public static final String email = "email";
    public static final String username = "username";
    public static final String password = "password";
    public static final String address = "address";
    public static final String contact = "contact";
    public static final String crop = "crop";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table farmer " +
                        "(id integer primary key, full_name text,email text,username text,password text, address text,contact text,crop text, weight int, days int, price int)"
        );


        db.execSQL(
                "create table retailer " +
                        "(id integer primary key, full_name text,email text,username text,password text, address text,contact text,crop text, weight int, days int, price int)"
        );

    }

    /*public integer inserts(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String stat = "ANDHRA PRADESH";
        contentValues.put("name",stat);
        db.insert("state",null,contentValues);

        //db.insert("state",null,contentValues);
        //contentValues.clear();
        /*contentValues.put("name","ARUNACHAL PRADESH");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","ASSAM");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","BIHAR");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","CHHATISGARH");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","GOA");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","GUJARAT");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","HARYANA");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","HIMACHAL PRADESH");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","JAMMU AND KASHMIR");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","JHARKHAND");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","KARNATAKA");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","KERALA");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","MADHYA PRADESH");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","MAHARASHTRA");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","MANIPUR");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","MEGHALAYA");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","MIZORAM");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","NAGALAND");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","ODISHA");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","PUNJAB");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","RAJASTAN");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","SIKKIM");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","TAMIL NADU");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","TRIPURA");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","UTTRAKHAND");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","UTTAR PRADESH");
        db.insert("state",null,contentValues);
        contentValues.clear();
        contentValues.put("name","WEST BENGAL");
        db.insert("state",null,contentValues);
        contentValues.clear();*/
    //}*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS farmer");
        db.execSQL("DROP TABLE IF EXISTS retailer");
        db.execSQL("DROP TABLE IF EXISTS state");
        onCreate(db);
    }

    public boolean insertFarmerInfo(String full_name, String email, String username, String password, String address,String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", full_name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("contact", contact);
        db.insert("farmer", null, contentValues);
        return true;
    }

    public boolean insertFarmerContent(String full_name, String email, String username, String password, String address, String contact,String crop,int weight,int date,int price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", full_name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("contact", contact);
        contentValues.put("crop", crop);
        contentValues.put("weight", weight);
        contentValues.put("days", date);
        contentValues.put("price", price);
        long i =  db.insert("farmer", null, contentValues);
        if(i==-1){
            return false;
        }else {
            return true;
        }
    }

    public boolean insertRetailerContent(String full_name, String email, String username, String password, String address, String contact,String crop,int weight,int date,int price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", full_name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("contact", contact);
        contentValues.put("crop", crop);
        contentValues.put("weight", weight);
        contentValues.put("days", date);
        contentValues.put("price", price);
        long i= db.insert("retailer", null, contentValues);
        if(i==-1){
            return false;
        }else {
            return true;
        }
    }

    public boolean insertRetailerInfo(String full_name, String email, String username, String password, String address,String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", full_name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("contact", contact);
        db.insert("retailer", null, contentValues);
        return true;
    }

    public Cursor getFarmerData(String user,String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM farmer  WHERE username = '" + user + "' and password = '" + pass + "'";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;

    }

    public Cursor getRetailerData(String user,String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM retailer  WHERE username = '" + user + "' and password = '" + pass + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor;
        }else {
            return null;
        }

    }

    /*public Cursor getRetailerData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from retailer where id=" + id + "", null);
        return res;
    }*/

    public int farmerRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, farmer);
        return numRows;
    }


    public int RetailerRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, retailer);
        return numRows;
    }

    public boolean updateFarmerContact(Integer id, String full_name, String email, String username, String password, String address, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", full_name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("contact", contact);
        db.update("farmer", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public boolean updateRetailerContact(Integer id, String full_name, String email, String username, String password, String address, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", full_name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("contact", contact);
        db.update("retailer", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public void updateFarmerPost(String username,String crop,int weight,int days,int price ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("crop", crop);
        contentValues.put("weight",weight );
        contentValues.put("days", days);
        contentValues.put("price", price);
        db.update("farmer", contentValues, "username = ? ", new String[]{username});
    }

    public Integer deleteFarmerContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("farmer",
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public Integer deleteRetailerContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("retailer",
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<String> getFarmerInfo() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from farmer", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(full_name)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String> getRetailerInfo() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from retailer", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(full_name)));
            res.moveToNext();
        }
        return array_list;
    }

    public int findFarmer(String user, String pass) {
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM farmer  WHERE username = '" + user + "' and password = '" + pass + "'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.getCount()>0) {
            return 1;
        } else {
            query = "SELECT * FROM retailer  WHERE username = '" + user + "' and password = '" + pass + "'";

            cursor = db.rawQuery(query, null);
            if (cursor != null && cursor.getCount() > 0) {
                return 2;
            } else {
                return 0;
            }
        }

    }

    public void findFarmerInfo(String user,String pass){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM farmer  WHERE username = '" + user + "' and password = '" + pass + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor != null && cursor.getCount() == 1) {

        }
    }

    public Cursor search(String address,String crop){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM retailer WHERE address like '" + address + "' or crop like '" + crop + "'" ;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


}