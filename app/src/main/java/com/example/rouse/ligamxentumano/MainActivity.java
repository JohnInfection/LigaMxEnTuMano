package com.example.rouse.ligamxentumano;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
/*
* Autor: Jeray Mobile Interprise.
* Fecha de creacion: 20/02/2015
*Descripcion: clase principal de la aplicacion
*
* */

public class MainActivity extends ActionBarActivity {

    private String [] goleo;
    AdministraSql sqlHandler;
    ListView lvGoleo;
    ListView lvDecenso;
    ListView lvPar_jornada;
    ListView lvPosiciones;
    String ip= "162.33.25.17";
    int puerto=7788;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // direccionamiento de los botones
        findViewById(R.id.btnPart_Jornada).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PartidosJornada.class));

                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket jornada= new Socket(ip, puerto);
                            DataInputStream is= new DataInputStream(jornada.getInputStream());
                            DataOutputStream op= new DataOutputStream(jornada.getOutputStream());
                            sqlHandler.borrar("jornada_partido");
                            op.writeInt(3);
                            int i= is.readInt();
                            while (i>0){
                                String id= is.readUTF();
                                String nombre= is.readUTF();
                                String logo= is.readUTF();
                                String jj=is.readUTF();
                                String jg=is.readUTF();
                                String jp=is.readUTF();
                                String je=is.readUTF();
                                String jf=is.readUTF();
                                String gf=is.readUTF();
                                String gc=is.readUTF();
                                String dif=is.readUTF();
                                String pts=is.readUTF();
                                ContentValues valores= new ContentValues();
                                valores.put("id",id);
                                valores.put("nombre",nombre);
                                valores.put("logo",logo);
                                valores.put("jj",jj);
                                valores.put("jg",jg);
                                valores.put("jp",jp);
                                valores.put("je",je);
                                valores.put("jf",jf);
                                valores.put("gf",gf);
                                valores.put("gc",gc);
                                valores.put("dif",dif);
                                valores.put("pts",pts);
                                i--;
                            }
                            is.close();
                            jornada.close();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }catch (IOException ea){
                            ea.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
        findViewById(R.id.btnTabDesc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Decenso.class));


                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket descenso= new Socket(ip, puerto);
                            DataInputStream is= new DataInputStream(descenso.getInputStream());
                            DataOutputStream op= new DataOutputStream(descenso.getOutputStream());
                            sqlHandler.borrar("decenso");
                            op.writeInt(2);
                            int i= is.readInt();
                            while (i>0){
                                String id= is.readUTF();
                                String nombre= is.readUTF();
                                String logo= is.readUTF();
                                String porcentaje=is.readUTF();
                                String jj=is.readUTF();
                                String dif=is.readUTF();
                                String pts=is.readUTF();
                                ContentValues valores= new ContentValues();
                                valores.put("id",id);
                                valores.put("nombre",nombre);
                                valores.put("logo",logo);
                                valores.put("porcentaje",porcentaje);
                                valores.put("jj",jj);
                                valores.put("dif",dif);
                                valores.put("pts",pts);
                                i--;
                            }
                            is.close();
                            descenso.close();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }catch (IOException ea){
                            ea.printStackTrace();
                        }
                    }
                });
                thread.start();

            }
        });
        findViewById(R.id.btnTab_Goleador).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Goleo.class));
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket descenso= new Socket(ip, puerto);
                            DataInputStream is= new DataInputStream(descenso.getInputStream());
                            DataOutputStream op= new DataOutputStream(descenso.getOutputStream());
                            sqlHandler.borrar("goleo");
                            op.writeInt(4);
                            int i= is.readInt();
                            while (i>0){
                                String id= is.readUTF();
                                String nom_jug= is.readUTF();
                                String equipo= is.readUTF();
                                String logo=is.readUTF();
                                String goles=is.readUTF();
                                ContentValues valores= new ContentValues();
                                valores.put("id",id);
                                valores.put("nom_jug",nom_jug);
                                valores.put("nombre",equipo);
                                valores.put("logo",logo);
                                valores.put("goles",goles);
                                i--;
                            }
                            is.close();
                            descenso.close();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }catch (IOException ea){
                            ea.printStackTrace();
                        }
                    }
                });
                thread.start();


            }
        });
        findViewById(R.id.btnInfo_eq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfoEquipos.class));
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket descenso= new Socket(ip, puerto);
                            DataInputStream is= new DataInputStream(descenso.getInputStream());
                            DataOutputStream op= new DataOutputStream(descenso.getOutputStream());
                            sqlHandler.borrar("infoEq");
                            op.writeInt(1);
                            int i= is.readInt();
                            while (i>0){
                                String id= is.readUTF();
                                String logo= is.readUTF();
                                String historia=is.readUTF();
                                ContentValues valores= new ContentValues();
                                valores.put("id",id);
                                valores.put("logo",logo);
                                valores.put("historia",historia);
                                i--;
                            }
                            is.close();
                            descenso.close();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }catch (IOException ea){
                            ea.printStackTrace();
                        }
                    }
                });
                thread.start();


            }
        });
        findViewById(R.id.btnTabPos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Posiciones.class));


                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket posicion= new Socket(ip, puerto);
                            DataInputStream is= new DataInputStream(posicion.getInputStream());
                            DataOutputStream op= new DataOutputStream(posicion.getOutputStream());
                            sqlHandler.borrar("Posiciones");
                            op.writeInt(1);
                            int i= is.readInt();
                            while (i>0){
                                String id= is.readUTF();
                                String equipo= is.readUTF();
                                String logo= is.readUTF();
                                String jg= is.readUTF();
                                String jp= is.readUTF();
                                String je= is.readUTF();
                                String jj= is.readUTF();
                                String jf= is.readUTF();
                                String gf= is.readUTF();
                                String gc= is.readUTF();
                                String dg= is.readUTF();
                                String pts= is.readUTF();
                                ContentValues valores= new ContentValues();
                                valores.put("id",id);
                                valores.put("nombre",equipo);
                                valores.put("logo",logo);
                                valores.put("JG",jg);
                                valores.put("JP",jp);
                                valores.put("JE",je);
                                valores.put("JJ",jj);
                                valores.put("JF",jf);
                                valores.put("GF",gf);
                                valores.put("GC",gc);
                                valores.put("dif_goles",dg);
                                valores.put("PTS",pts);
                                i--;
                            }
                            is.close();
                            posicion.close();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }catch (IOException ea){
                            ea.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        //Thread thread=new Thread(new Runnable() {
          //  @Override
            //public void run() {

              //  try {
                //    Socket posicion= new Socket(ip, puerto);
                  //  DataInputStream is= new DataInputStream(posicion.getInputStream());
                    //DataOutputStream op= new DataOutputStream(posicion.getOutputStream());
                    //sqlHandler.borrar("Posiciones");
                    //op.writeInt(1);
                    //int i= is.readInt();
                    //while (i>0){
                      //  String id= is.readUTF();
                        //String equipo= is.readUTF();
                        //String logo= is.readUTF();
                        //String jg= is.readUTF();
                        //String jp= is.readUTF();
                        //String je= is.readUTF();
                        //String jj= is.readUTF();
                        //String jf= is.readUTF();
                        //String gf= is.readUTF();
                        //String gc= is.readUTF();
                        //String dg= is.readUTF();
                        //String pts= is.readUTF();
                        //ContentValues valores= new ContentValues();
                        //valores.put("id",id);
                        //valores.put("nombre",equipo);
                        //valores.put("logo",logo);
                        //valores.put("JG",jg);
                        //valores.put("JP",jp);
                        //valores.put("JE",je);
                        //valores.put("JJ",jj);
                        //valores.put("JF",jf);
                        //valores.put("GF",gf);
                        //valores.put("GC",gc);
                        //valores.put("dif_goles",dg);
                        //valores.put("PTS",pts);
                        //i--;
                    //}
                    //is.close();
                    //posicion.close();
                //} catch (UnknownHostException e) {
                  //  e.printStackTrace();
                //}catch (IOException ea){
                  //  ea.printStackTrace();
                //}
           // }
        //});
          // thread.start();
        }
        return super.onOptionsItemSelected(item);
    }
}
