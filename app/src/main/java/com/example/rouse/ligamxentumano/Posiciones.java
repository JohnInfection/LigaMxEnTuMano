package com.example.rouse.ligamxentumano;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class Posiciones extends ActionBarActivity {
   // private String [] posiciones;
    AdministraSql sqlHandler;
    ListView lvCustomList;

    ListView lista= (ListView) findViewById(R.id.lvPosiciones);
    ArrayList<Liga> ligaPosiciones=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaP();
        setContentView(R.layout.activity_posiciones);//falta asyntax
        AdapterPosiciones adapter=new AdapterPosiciones(Posiciones.this,ligaPosiciones);
        lista.setAdapter(adapter);

       // ArrayList<PojoPosiciones> p;

        //posiciones = new String [] {"tvId", "tvNomEq", "tvLogo", "tvJJ", "tvJG", "tvJP", "tvJE","tvJF", "tvGF", "tvGC", "tvDF", "tvPTS"};
        //ArrayAdapter<String> adapter;
        //adapter = new ArrayAdapter<String>(Posiciones.this,android.R.layout.simple_list_item_1,posiciones);

       // final ListView lvPosiciones = (ListView) findViewById(R.id.lvPosiciones);
      // lvPosiciones.setAdapter(adapter);
        //----- genera una accion en la lista como la navegacion entre activity
    //    lvPosiciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      //      @Override
        //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getApplicationContext(), "Has seleccionado: " + posiciones[position], Toast.LENGTH_SHORT).show();

         //   }
       // });
        //sqlHandler=new AdministraSql(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_posiciones, menu);
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

    private void llenarListaP() {
        ArrayList<Liga> ligaList = new ArrayList<Liga>();
        ligaList.clear();
        String query = "SELECT * FROM Posiciones";
        Cursor c1 = sqlHandler.selectQuery(query);
        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                //mandamos los valores de la bd
                do {//checar las variables que se le manda de Sqlite
                    Liga LigaListItems = new Liga();
                    LigaListItems.setId(c1.getInt(c1.getColumnIndex("id")));
                    LigaListItems.setNomEq(c1.getString(c1.getColumnIndex("nombre")));
                    LigaListItems.setLogo(c1.getString(c1.getColumnIndex("logo")));
                    LigaListItems.setJj(c1.getInt(c1.getColumnIndex("JJ")));
                    LigaListItems.setJp(c1.getInt(c1.getColumnIndex("JP")));
                    LigaListItems.setJg(c1.getInt(c1.getColumnIndex("JG")));
                    LigaListItems.setJe(c1.getInt(c1.getColumnIndex("JE")));
                    LigaListItems.setJf(c1.getInt(c1.getColumnIndex("JF")));
                    LigaListItems.setGf(c1.getInt(c1.getColumnIndex("Gf")));
                    LigaListItems.setGc(c1.getInt(c1.getColumnIndex("GC")));
                    LigaListItems.setDifGoles(c1.getInt(c1.getColumnIndex("dif_goles")));
                    LigaListItems.setDifGoles(c1.getColumnIndex("pts"));
                    ligaList.add(LigaListItems);
                } while (c1.moveToNext());
            }
        }
        c1.close();//cerramos bd
        AdapterPosiciones contactListAdapter = new AdapterPosiciones(Posiciones.this, ligaList);
        lvCustomList.setAdapter(contactListAdapter);
    }
}

