package com.example.spectorh.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBhandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="PRODUCTS.db";
    public static final String TABLE_NAME="products";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_NAME="name";


    public static final String TABLE_STUDENTS="students";
    public static final String COLUMN_RNO="_rNo";
    public static final String COLUMN_NAMESTU="namestu";
    public static final String COLUMN_BRANCH="branch";


    public DBhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory,DATABASE_VERSION);
    }
    public int countStudent()
    {
        String q="SELECT * FROM "+TABLE_STUDENTS ;
        SQLiteDatabase db =getReadableDatabase();
        Cursor c=db.rawQuery(q,null);

        int cnt=c.getCount();
        c.close();
        db.close();
        return cnt;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

               String q="CREATE TABLE "+TABLE_NAME+" ( "+ COLUMN_ID +" INTEGER PRIMARY KEY,"
                + COLUMN_NAME +" TEXT );";
        db.execSQL(q);

        String q1="CREATE TABLE "+TABLE_STUDENTS+" ( "+ COLUMN_RNO +" INTEGER,"
                + COLUMN_NAMESTU +" TEXT,"+ COLUMN_BRANCH +" INTEGER," +
                "PRIMARY KEY("+COLUMN_RNO+","+COLUMN_NAMESTU+")"+
                " FOREIGN KEY ("+ COLUMN_BRANCH +" ) REFERENCES " + TABLE_NAME + "( "+COLUMN_ID +"));";
        db.execSQL(q1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+ " ;");

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENTS+ " ;");
        onCreate(db);
    }

    public void addStudent(student s)
    {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_RNO,s.get_rNo());
        cv.put(COLUMN_NAMESTU,s.get_name());
        cv.put(COLUMN_BRANCH,s.get_branch());

        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_STUDENTS , null, cv);
        db.close();
    }

    public void addRow(Product product)
    {
        ContentValues v=new ContentValues();
        v.put(COLUMN_ID,product.get_id());
        v.put(COLUMN_NAME,product.get_name());

        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NAME , null, v);
        db.close();
    }


    public void deleteRow(String product_name)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME+ " WHERE "+COLUMN_NAME+ "=\"" + product_name + "\";") ;
        db.close();
    }

    public String dbToString()
    {
        String output="";
        String q="SELECT * FROM "+TABLE_NAME +" WHERE 1 ";

        SQLiteDatabase db =getReadableDatabase();
        Cursor c=db.rawQuery(q,null);
        c.moveToFirst();

        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(COLUMN_NAME))!=null)
            {
                output+=c.getString(c.getColumnIndex(COLUMN_NAME)) ;
                output+=" ";
                output+=c.getString(c.getColumnIndex(COLUMN_ID)) ;
                output+=" \n";
            }
            c.moveToNext();
        }
        c.close();
        db.close();
        return output;
    }
    public int countDB()
    {
        String q="SELECT * FROM "+TABLE_NAME ;
        SQLiteDatabase db =getReadableDatabase();
        Cursor c=db.rawQuery(q,null);

        int cnt=c.getCount();
        c.close();
        db.close();
        return cnt;
    }
}
