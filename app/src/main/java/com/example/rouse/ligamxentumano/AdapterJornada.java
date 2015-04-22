package com.example.rouse.ligamxentumano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CeSar on 31/03/2015.
 */
public class AdapterJornada extends BaseAdapter {
    Context context;
    ArrayList<JornadaPojo> listaJornada;

    public AdapterJornada(Context context, ArrayList<JornadaPojo> listaJornada) {
        this.context = context;
        this.listaJornada = listaJornada;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JornadaPojo ligaListItems = listaJornada.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.partidos_jor_list_row, null);
        }

        TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
        tvId.setText(ligaListItems.getId());
        TextView tvLocal = (TextView) convertView.findViewById(R.id.tvLocal);
        tvLocal.setText(ligaListItems.getEqLocal());
        TextView tvVisita = (TextView) convertView.findViewById(R.id.tvVisita);
        tvVisita.setText(ligaListItems.getEqVisitante());
        TextView tvHr = (TextView) convertView.findViewById(R.id.tvHr);
        tvHr.setText(ligaListItems.getHorario());
        TextView tvLugar = (TextView) convertView.findViewById(R.id.tvLugar);
        tvLugar.setText(ligaListItems.getLugar());
        return convertView;
    }
}
