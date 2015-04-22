package com.example.rouse.ligamxentumano;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by Rouse on 23/03/2015.
 * Descripcion: se crea la base de datos y la version de la misma
 */

public class AdministraSql {


    public static final String DATABASE_NAME = "LIGAMXENTUMANO";
    public static final  int DATABASE_VERSION = 1;
    Context context;
    SQLiteDatabase sqLiteDatabase;
    DbHelper dbHelper;

   public static final String NAME_TABLA_JORNADA = "jornada_partido";
    public static final String ID_JOR = "id";
   public static final String NOMJUG_J = "nom_jug";
   public static final String EQUIPO_J = "equipo";
   public static final String LOGO_J = "logo";
   public static final String LUGAR_J = "lugar";
   public static final String MARCADOR_J  = "marcador";

   public static final String NAME_TABLA_POS = "Posiciones";
   public static final String ID_POS = "id";
    public static final String NOMBRE_POS = "nombre";
    public static final String LOGO_POS = "logo";
    public static final String JJ_POS = "JJ";
    public static final String JG_POS = "JG";
    public static final String JP_POS = "JP";
    public static final String JE_POS = "JE";
    public static final String JF_POS = "JF";
    public static final String GF_POS = "JF";
    public static final String GC_POS= "GC";
    public static final String DGO_POS = "dif_goles";
    public static final String PTS_POS = "pts";

    public static final String NAME_TABLA_INFO = "informacion";
    public static final String ID_INFO = "id";
    public static final String LOGO_INFO = "logo";
    public static final String DESC_INFO = "historial";
    public static final String DIREST_INFO = "direccion_estadio";

    public static final String NAME_TABLA_GOLEO = "goleo";
    public static final String ID_GOLEO = "id";
   public static final String NOM_GOLEO = "nom_jug";
    public static final String EQ_GOLEO = "equipo";
    public static final String LOGO_GOLEO = "logo";
    public static final String GOLES= "goles";

    public static final String NAME_TABLA_DECENSO = "decenso";
    public static final String ID_DES = "id";
    public static final String NOM_DES = "nombre";
    public static final String LOGO_DES = "logo";
    public static final String PORCEN_DES = "Porcentaje";


    public AdministraSql(Context context) {
        dbHelper=new DbHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void  executeQuery (String query){//metodo para ejecutar la bd e informar si existen errores
        try{
            if (sqLiteDatabase.isOpen()){
                sqLiteDatabase.close();
            }
            sqLiteDatabase =dbHelper.getWritableDatabase();
            sqLiteDatabase.execSQL(query);
        }catch (Exception e){
            System.out.println("Error de BD" +e);
        }
    }

    public  Cursor selectQuery(String query){
        Cursor c1= null;
        try{
            if (sqLiteDatabase.isOpen()){
                sqLiteDatabase.close();
            }
            sqLiteDatabase =dbHelper.getWritableDatabase();
            c1 = sqLiteDatabase.rawQuery(query,null);
        }catch (Exception e){
            System.out.println("Error de BD" +e);
        }
        return  c1;
    }
    //metodo para borrar
    public boolean borrar(String tabla){
      int i=0;
        i= sqLiteDatabase.delete(tabla,null,null);
        return i>0;

    }
    //metodo para agregar
    public long agrega(ContentValues valores,String tabla){
        return sqLiteDatabase.insert(tabla,null,valores);
    }



    private SQLiteDatabase db;

  public void insertarGoleo(String nom_jug, String equipo, String logo, int goles) {
     ContentValues voloresG = new ContentValues();
       voloresG.put(NOM_GOLEO, nom_jug);
        voloresG.put(EQ_GOLEO, equipo);
        voloresG.put(LOGO_GOLEO, logo);
        voloresG.put(GOLES, goles);
        db.insert("NAME_TABLA_GOLEO",null,voloresG);
    }

    public void insertarDecenso(String nombre, String logo, String porcentaje) {
        ContentValues voloresD = new ContentValues();
        voloresD.put(NOM_DES, nombre);
        voloresD.put(LOGO_DES, logo);
        voloresD.put(PORCEN_DES, porcentaje);
        db.insert(NAME_TABLA_GOLEO,null,voloresD);
    }


    public void insertarInf(String logo,String hidtorial,String direccion){
        ContentValues valoresInfo=new ContentValues();
        valoresInfo.put(LOGO_INFO ,logo);
        valoresInfo.put(DESC_INFO,hidtorial);
        valoresInfo.put(DIREST_INFO,direccion);
        db.insert(NAME_TABLA_INFO,null,valoresInfo);
    }

    public void insertarPJor(String nomJug,String nomEq,String logo,String lug,int marcador){
      ContentValues valoresPJ=new ContentValues();
        valoresPJ.put(NOMJUG_J,nomJug);
        valoresPJ.put(EQUIPO_J ,nomEq);
        valoresPJ.put( LOGO_J,logo);
        valoresPJ.put(LUGAR_J,lug);
        valoresPJ.put(MARCADOR_J,marcador);
        db.insert(NAME_TABLA_INFO,null,valoresPJ);
    }

    public  void insertarPos(String nombre,String logo,int jg,int jp,int je,int difGol){
        ContentValues valoresPos=new ContentValues();
        valoresPos.put(NOMBRE_POS,nombre);
        valoresPos.put(LOGO_POS,logo);
        valoresPos.put(JJ_POS ,jg);
        valoresPos.put(JG_POS,jg);
        valoresPos.put(JP_POS,jp);
        valoresPos.put(JE_POS,je);
        valoresPos.put(JF_POS,je);
        valoresPos.put(GF_POS,je);
        valoresPos.put(GF_POS,je);
        valoresPos.put(GC_POS,je);
        valoresPos.put(DGO_POS,difGol);
    }
}
