package com.example.rouse.ligamxentumano;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class InfoEquipos extends ActionBarActivity {

    TextView descripcionEq= (TextView) findViewById(R.id.tvDescEq);
    ArrayList<PojoInfoEq> ligaInfoEq=new ArrayList<>();
    AdministraSql sqlHandler;
    ListView lvCustomList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenaListaInfo();
        setContentView(R.layout.activity_info_equipos);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_equipos, menu);
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

    public void llenaListaInfo() {
        ArrayList<PojoInfoEq> infoList = new ArrayList<PojoInfoEq>();
        infoList.clear();
        String query = "SELECT * FROM informacion";
        Cursor c1 = sqlHandler.selectQuery(query);
        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {

                    PojoInfoEq infoListItems = new PojoInfoEq();
                    infoListItems.setNomEq(c1.getString(c1.getColumnIndex("id")));
                    infoListItems.setImagEq(c1.getString(c1.getColumnIndex("logo")));
                    infoListItems.setDesEq(c1.getString(c1.getColumnIndex("historial")));
                    infoList.add(infoListItems);
                }while (c1.moveToNext());
            }
            c1.close();
            AdapterInfoEq contactListAdapter=new AdapterInfoEq(InfoEquipos.this,ligaInfoEq);
            lvCustomList.setAdapter(contactListAdapter);
        }
    }
}