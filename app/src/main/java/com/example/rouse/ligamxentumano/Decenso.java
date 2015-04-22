package com.example.rouse.ligamxentumano;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Decenso extends ActionBarActivity {

    private String [] posiciones;
    ListView lista= (ListView) findViewById(R.id.lvDecenso);
    ArrayList<DecensoPojo> ligaDecenso=new ArrayList<>();
    AdministraSql sqlHandler;
    ListView lvCustomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        llenarListaD();
        setContentView(R.layout.activity_decenso);
        AdapterDecenso adapter= new AdapterDecenso(Decenso.this,ligaDecenso);
        lista.setAdapter(adapter);
        ArrayList <String> adapterd;

        //posiciones = new String [] {"tvId", "tvNomEq", "tvLogo", "tvJJ", "tvJG", "tvJP", "tvJE","tvJF", "tvGF", "tvGC", "tvDF", "tvPTS"};
        //ArrayAdapter<String> adapter;
        //adapterd = new ArrayAdapter<String>(Decenso.this,android.R.layout.simple_list_item_1,posiciones);

      //  final ListView lvPosiciones = (ListView) findViewById(R.id.lvPosiciones);
       // lvPosiciones.setAdapter(adapter);
        //----- genera una accion en la lista como la navegacion entre activity
       // lvPosiciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           // @Override
           // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getApplicationContext(), "Has seleccionado: " + posiciones[position], Toast.LENGTH_SHORT).show();
           // }
       // });
       // sqlHandler=new AdministraSql(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_decenso, menu);
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

    private void llenarListaD() {
        ArrayList<DecensoPojo> decensoList = new ArrayList<DecensoPojo>();
        decensoList.clear();
        String query = "SELECT * FROM DECENSO ";
        Cursor c1 = sqlHandler.selectQuery(query);
        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    DecensoPojo decensoListItems = new DecensoPojo();
                    decensoListItems.setNo(c1.getInt(c1.getColumnIndex("No")));
                    decensoListItems.setEquipo(c1.getString(c1.getColumnIndex("Equipo")));
                    decensoListItems.setLogo(c1.getString(c1.getColumnIndex("Logo")));
                    decensoListItems.setJj(c1.getInt(c1.getColumnIndex("Jj")));
                    decensoListItems.setDifGol(c1.getInt(c1.getColumnIndex("DifGoles")));
                    decensoListItems.setPts(c1.getInt(c1.getColumnIndex("PTS")));
                    decensoListItems.setPorcent(c1.getDouble(c1.getColumnIndex("Porcentaje")));
                    decensoList.add(decensoListItems);

                } while (c1.moveToNext());
            }
        }
        c1.close();
        AdapterDecenso contactListAdapter = new AdapterDecenso(Decenso.this, decensoList);
        lvCustomList.setAdapter(contactListAdapter);
    }


}
