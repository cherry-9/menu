package com.example.spectorh.menu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i=getIntent();
        DBhandler dbh=new DBhandler(this,null,null,1);
        String text=dbh.dbToString();
        TextView t=(TextView)findViewById(R.id.textView2);
        t.setText(text);
        t.setTextSize(40);
        t.setTextColor(Color.GREEN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        RelativeLayout v=(RelativeLayout) findViewById(R.id.activity_main2);
        //noinspection SimplifiableIfStatement
        if (id == R.id.green) {
            if(item.isChecked()) {
                item.setChecked(false);
            }

            else {
                item.setChecked(true);}
            v.setBackgroundColor(Color.GREEN);


            return true;
        }
        else if(id==R.id.red){
            if(item.isChecked()) {
                item.setChecked(false);
            }

            else {
                item.setChecked(true);}
            v.setBackgroundColor(Color.RED);


            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}
