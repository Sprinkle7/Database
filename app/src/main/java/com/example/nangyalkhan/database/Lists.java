package com.example.nangyalkhan.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class Lists extends ActionBarActivity {
    TextView Name,RNumber,DescRiption;
    DataRet DataShow;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);
        String TotalRoll = "";
        DataShow = new DataRet();
          String Desc[] = DataShow.GetNames(getApplicationContext());
//          for (int i=0; i<Desc.length; i++)
//          {
//            TotalRoll += Desc[i];
//          }
        list = (ListView)findViewById(R.id.lvnames);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,Desc);
        list.setAdapter(adapter);
//          String values[] = getResources().getStringArray();
//        Name = (TextView) findViewById(R.id.Lname);
//        RNumber = (TextView) findViewById(R.id.Lrollno);
//        DescRiption = (TextView) findViewById(R.id.Ldesc);
//        DataShow = new DataRet();
//        String totalNames = " ";
//        String TotalDesc = "";
//        String array[] = DataShow.GetNames(getApplicationContext());
//        for (int i=0; i<array.length; i++)
//        {
//            totalNames += array[i] + "\n";
//        }
//        Name.setText(totalNames);
//        String names[] = DataShow.GetRoll(getApplicationContext());
//       for (int i=0; i<names.length; i++)
//       {
//           TotalRoll += names[i] +"\n";
//       }
//        RNumber.setText(TotalRoll);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lists, menu);
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
