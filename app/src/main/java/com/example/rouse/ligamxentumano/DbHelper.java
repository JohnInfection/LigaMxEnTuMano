package com.example.rouse.ligamxentumano;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rouse on 04/03/2015.
 *Descripcion: Crea las tablas, campos e inserciones de datos en la bd
 */
public class DbHelper extends SQLiteOpenHelper {

    //DbHelper helper= new DbHelper(context);
    //SQLiteDatabase db= helper.getWritableDatabase();

    public DbHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name,factory,version);

    }


    public static final String NAME_TABLA_POS = "Posiciones";
    public static final String ID_POS = "id";
    public static final String NOMBRE_POS = "nombre";
    public static final String LOGO_POS = "logo";
    public static final String JJ_POS = "JJ";
    public static final String JG_POS = "JG";
    public static final String JP_POS = "JP";
    public static final String JE_POS = "JE";
    public static final String JF_POS = "JF";
    public static final String GF_POS = "GF";
    public static final String GC_POS= "GC";
    public static final String DGO_POS = "dif_goles";
    public static final String PTS_POS = "pts";

    private static final String SCRIPT_CREATE_DATABASE1 = "create table "
            + NAME_TABLA_POS + " (" + ID_POS
            + " integer primary key autoincrement, "
            + NOMBRE_POS + " text not null, "
            + LOGO_POS + " text not null, "
            + JJ_POS + " int not null, "
            + JG_POS + " int not null, "
            + JP_POS+ " int not null, "
            + JE_POS + " int not null, "
            + JF_POS + " int not null, "
            + GF_POS + " int not null, "
            + GC_POS + " int not null, "
            + DGO_POS + " int not null, " 
            + PTS_POS + " int not null );";

    public  static  final String insertarTPEq1= "insert into Posiciones values(null, 'Guadalajara', 'imagen', '14', '7', '3', '4', '0', '16', '10', '6', '25');";
    public  static  final String insertarTPEq2= "insert into Posiciones values(null, 'Veracruz', 'imagen', '14', '6', '2', '6', '0', '22', '11', '11', '24');";
    //----------------------------------------------------------------------------------------------
    public static final String NAME_TABLA_INFO = "informacion";
    public static final String ID_INFO = "id";
    public static final String LOGO_INFO = "logo";
    public static final String DESC_INFO = "historial";


    private static final String SCRIPT_CREATE_DATABASE2 = "create table "
            + NAME_TABLA_INFO + " (" + ID_INFO
            + " integer primary key autoincrement, "
            + DESC_INFO + " text not null, "
            + LOGO_INFO  + " text not null );";

    public static final  String insertarTInGallos= "insert into informacion values(null, 'imagen','Fundado el 8 de julio de 1980,colores tradicionale: Blanco,Azul,Negro" +
            "Estadio: Corregidora, Titulos: 0, Propietario: Grupo Empresarial Angeles DT: Victor Manuel Vucetich',);";
    //----------------------------------------------------------------------------------------------
    public static final String NAME_TABLA_GOLEO = "goleo";
    public static final String ID_GOLEO = "id";
    public static final String NOM_GOLEO = "nom_jug";
    public static final String EQ_GOLEO = "equipo";
    public static final String LOGO_GOLEO = "logo";
    public static final String GOLES= "goles";

    private static final String SCRIPT_CREATE_DATABASE3 = "create table "
            + NAME_TABLA_GOLEO + " (" + ID_GOLEO
            + " integer primary key autoincrement, "
            + NOM_GOLEO + " text not null, "
            + EQ_GOLEO + " text not null, "
            + LOGO_GOLEO + " text not null,"
            + GOLES + "int not null );";
    public static final String TGEJug1= "insert into goleo values(null, 'Rafael Sobis', 'Tigres', 'imagen', 7);";
    public static final String TGEJug2= "insert into goleo values(null, 'Julio Furch', 'Veracruz', 'imagen', 7);";
    public static final String TGEJug3= "insert into goleo values(null, 'Matias Alustiza', 'Puebla', 'imagen', 7);";
    public static final String TGEJug4= "insert into goleo values(null, 'Avilés Hurtado', 'Chiapas', 'imagen', 7);";
    public static final String TGEJug5= "insert into goleo values(null,'Fidel Martinez', 'UDG', 'imagen', 6);";

    //----------------------------------------------------------------------------------------------
    public static final String NAME_TABLA_JORNADA = "jornada_partido";
    public static final String ID_JOR = "id";
    public static final String LOCAL_J = "local";
    public static final String VISI_J = "visitante";
    public static final String HR_J = "hr";
    public static final String LUGAR_J = "lugar";
    public static final String MARCADOR_J  = "marcador";

    private static final String SCRIPT_CREATE_DATABASE4 = "create table "
            + NAME_TABLA_JORNADA + " (" + ID_JOR
            + " integer primary key autoincrement, "
            + LOCAL_J + " text not null, "
            + VISI_J + " text not null, "
            + HR_J + " text not null,"
            + LUGAR_J + "text not null,"
            + MARCADOR_J + " int null );";

    public static final String TJEp1= "insert into jornada_partido values(null, 'Queretaro  VS ', ' Tigres', '19:30', 'Corregidora', 'Pendiente');";
    public static final String TJEp2= "insert into jornada_partido values(null, 'Veracruz  VS ', ' UNAM', '20:30', 'Pirata Fuente', 'Pendiente');";
    public static final String TJEp3= "insert into jornada_partido values(null, 'Guadalajara  VS ', ' America', '17:00', 'Omnilife', 'Pendiente');";
    //----------------------------------------------------------------------------------------------
    public static final String NAME_TABLA_DECENSO = "decenso";
    public static final String ID_DES = "id";
    public static final String NOM_DES = "nombre";
    public static final String LOGO_DES = "logo";
    public static final String PORCEN_DES = "Porcentaje";
    public static final String JJ_DES= "jj";
    public static final String DIF_DES= "dif";
    public static final String PTS_DES= "pts";

    private static final String SCRIPT_CREATE_DATABASE5 = "create table "
            + NAME_TABLA_DECENSO + " (" +  ID_DES
            + " integer primary key autoincrement, "
            + NOM_DES + " text not null, "
            + LOGO_DES  + " text not null, "
            + PORCEN_DES + " double not null, "
            +JJ_DES + " int not null, "
            +DIF_DES +" text not null, "
            +PTS_DES +" int not null );";

    public static final String TDe1= "insert into decenso values(null, 'Guadalajara', 'imagen', 1.1414, 99, '-29', 113);";
    public static final String TDe2= "insert into decenso values(null, 'UDG', 'imagen', 1.0323, 31, '-12', 32);";
    public static final String TDe3= "insert into decenso values(null, 'Puebla', 'imagen', 1.0202, 99, '-31', 101);";
    //----------------------------------------------------------------------------------------------



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_CREATE_DATABASE1);
        db.execSQL(SCRIPT_CREATE_DATABASE2);
        db.execSQL(SCRIPT_CREATE_DATABASE3);
        db.execSQL(SCRIPT_CREATE_DATABASE4);
        db.execSQL(SCRIPT_CREATE_DATABASE5);
        db.execSQL(insertarTPEq1);
        db.execSQL(insertarTPEq2);
        db.execSQL(insertarTInGallos);
        db.execSQL(TGEJug1);
        db.execSQL(TGEJug2);
        db.execSQL(TGEJug3);
        db.execSQL(TGEJug4);
        db.execSQL(TGEJug5);
        db.execSQL(TJEp1);
        db.execSQL(TJEp2);
        db.execSQL(TJEp3);
        db.execSQL(TDe1);
        db.execSQL(TDe2);
        db.execSQL(TDe3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +NAME_TABLA_POS );
        db.execSQL("DROP TABLE IF EXISTS " +NAME_TABLA_INFO );
        db.execSQL("DROP TABLE IF EXISTS " +NAME_TABLA_DECENSO);
        db.execSQL("DROP TABLE IF EXISTS " +NAME_TABLA_GOLEO );
        db.execSQL("DROP TABLE IF EXISTS " +NAME_TABLA_JORNADA );
        onCreate(db);
    }
}
