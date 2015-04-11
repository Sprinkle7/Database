package com.example.nangyalkhan.database;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Database extends ActionBarActivity {
    Button add, delete,ShowData,Update;
    EditText Name, RollNo,desc;
    DataRet DataRetrival;
    Intent List;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        add = (Button) findViewById(R.id.add);
        delete =(Button)findViewById(R.id.delete);
        ShowData = (Button)findViewById(R.id.show);
        Update = (Button) findViewById(R.id.update);
        Name = (EditText) findViewById(R.id.Lname);
        RollNo = (EditText) findViewById(R.id.rollno);
        desc = (EditText) findViewById(R.id.desc);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = Name.getText().toString();
                String Rollno = RollNo.getText().toString();
                String description = desc.getText().toString();
                DataRetrival = new DataRet(getApplicationContext(),name,Rollno,description);
                Log.d("Done","Inserted");
            }
        });
//        Delete Function Starts Here
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DeleteID = RollNo.getText().toString();
                DataRetrival = new DataRet();
                DataRetrival.DeleteInfo(getApplicationContext(),DeleteID);

            }
        });
//        Update Function Starts Here
        Update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String ID = RollNo.getText().toString();
                String NAMES = Name.getText().toString();
                String DEsc = desc.getText().toString();
                DataRetrival = new DataRet();
                Log.d("DONE", "START");
                DataRetrival.UpdateInfo(getApplicationContext(), NAMES, DEsc, ID);
                Log.d("DONE", "END");
            }
        });
        {
        }
//        Show Data Function and View Starts Here
        ShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List = new Intent(Database.this,Lists.class);
                startActivity(List);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_database, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
