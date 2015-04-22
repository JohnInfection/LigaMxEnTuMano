package com.example.rouse.ligamxentumano;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;


public class PartidosJornada extends ActionBarActivity {

    AdministraSql sqlHandler;
    ListView lvGoleo;

    ListView lista= (ListView) findViewById(R.id.lvPar_Jornada);
    ArrayList<JornadaPojo> ligaJornada=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenaListaJornada();
        setContentView(R.layout.activity_partidos_jornada);
        AdapterJornada adapter=new AdapterJornada(PartidosJornada.this,ligaJornada);
        lista.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_partidos_jornada, menu);
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


    public void llenaListaJornada(){
        ArrayList<JornadaPojo> jornadaList = new ArrayList<JornadaPojo>();
        jornadaList.clear();
        String query = "SELECT * FROM jornada_partido ";
        Cursor c1 = sqlHandler.selectQuery(query);
        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    JornadaPojo jornadaListItems = new JornadaPojo();
                    jornadaListItems.setId(c1.getInt(c1.getColumnIndex("id")));
                    jornadaListItems.setEqLocal(c1.getString(c1.getColumnIndex("local")));
                    jornadaListItems.setEqVisitante(c1.getString(c1.getColumnIndex("visitante")));
                    jornadaListItems.setHorario(c1.getString(c1.getColumnIndex("hr")));
                    jornadaListItems.setLugar(c1.getString(c1.getColumnIndex("lugar")));
                    jornadaListItems.setResultado(c1.getString(c1.getColumnIndex("marcador")));
                    jornadaList.add(jornadaListItems);

                } while (c1.moveToNext());
            }
        }
        c1.close();
        AdapterJornada jornadaListAdapter = new AdapterJornada(
                PartidosJornada.this, jornadaList);
        lvGoleo.setAdapter(jornadaListAdapter);
    }

 }

