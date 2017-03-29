package com.example.spectorh.menu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewGroup rl;
    TextView t;
    EditText et;
    DBhandler dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        t=(TextView)findViewById(R.id.textView);
        rl=(ViewGroup) findViewById(R.id.rl);
        et=(EditText)findViewById(R.id.editText);
        dbh=new DBhandler(this,null,null,1);
        /*rl.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        tranny();
                        return true;
                    }
                }
        );*/
    }


    public void change( View view)
    {
        Intent i= new Intent(this,ScrollingActivity.class);
        //EditText et=(EditText)findViewById(R.id.editText);
        //i.putExtra(Send_Msg,et.getText().toString());
        startActivity(i);
    }

    public void sendBroadcast(View view)
    {
        Intent intent=new Intent();
        intent.setAction("com.example.spectorh.menu");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        //TextView t=(TextView)findViewById(R.id.textView);
        sendBroadcast(intent);
        t.setText("broadscast sent");
    }

    public void add(View view)
    {
        Product p=new Product(dbh.countDB(),et.getText().toString());
        dbh.addRow(p);
        String text=dbh.dbToString();
        t.setText(text);
        et.setText("");
    }

    public void addStudent(View v)
    {
        student p=new student(dbh.countStudent(),et.getText().toString(),0);
        dbh.addStudent(p);
        et.setText("");
    }

    public void delete(View view)
    {
        dbh.deleteRow(et.getText().toString());
        t.setText("deleted");
        et.setText("");
    }
    public void tranny()
    {
        TransitionManager.beginDelayedTransition(rl);
        TextView t=(TextView)findViewById(R.id.textView);
        RelativeLayout.LayoutParams rules=new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        rules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        rules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        t.setLayoutParams(rules);
        t.setText("done");


        EditText et=(EditText)findViewById(R.id.editText);
        RelativeLayout.LayoutParams rules2=new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        rules2.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
        rules2.setMargins(0,70,0,0);
        et.setLayoutParams(rules2);
        Button b=(Button)findViewById(R.id.button);
        RelativeLayout.LayoutParams rules3=new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        rules3.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
        rules3.setMargins(0,100,0,0);
        b.setLayoutParams(rules3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void GetCount(View view)
    {
        t.setText(String.valueOf(dbh.countDB()));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        RelativeLayout v=(RelativeLayout) findViewById(R.id.rl);
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
