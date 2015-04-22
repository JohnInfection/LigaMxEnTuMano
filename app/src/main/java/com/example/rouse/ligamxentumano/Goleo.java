package com.example.rouse.ligamxentumano;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class Goleo extends ActionBarActivity {

    AdministraSql sqlHandler;
    ListView lvGoleo;

    ListView lista= (ListView) findViewById(R.id.lvGoleo);
    ArrayList<GoleoPojo> ligaGoleo=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenaListaGoleo();
        setContentView(R.layout.activity_goleo);
        AdapterGoleo adapter=new AdapterGoleo(Goleo.this,ligaGoleo);
        lista.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_goleo, menu);
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


    private void llenaListaGoleo() {
        ArrayList<GoleoPojo> goleoList = new ArrayList<GoleoPojo>();
        goleoList.clear();
        String query = "SELECT * FROM goleo ";
        Cursor c1 = sqlHandler.selectQuery(query);
        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    GoleoPojo goleoListItems = new GoleoPojo();
                    goleoListItems.setNo(c1.getInt(c1.getColumnIndex("id")));
                    goleoListItems.setNomJug(c1.getString(c1.getColumnIndex("nom_jug")));
                    goleoListItems.setEquipo(c1.getString(c1.getColumnIndex("equipo")));
                    goleoListItems.setLogo(c1.getString(c1.getColumnIndex("logo")));
                    goleoListItems.setGoles(c1.getInt(c1.getColumnIndex("goles")));
                    goleoList.add(goleoListItems);

                } while (c1.moveToNext());
            }
        }
        c1.close();
        AdapterGoleo contactListAdapter = new AdapterGoleo(
                Goleo.this, goleoList);
        lvGoleo.setAdapter(contactListAdapter);
    }
}
