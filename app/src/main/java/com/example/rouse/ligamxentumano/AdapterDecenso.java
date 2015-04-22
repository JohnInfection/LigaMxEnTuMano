package com.example.rouse.ligamxentumano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rouse on 31/03/2015.
 */
public class AdapterDecenso extends BaseAdapter {
    Decenso context;
    ArrayList<DecensoPojo> listaDecenso;

    public AdapterDecenso(Decenso context, ArrayList<DecensoPojo> listaDecenso) {
        this.context = context;
        this.listaDecenso = listaDecenso;
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
        DecensoPojo decensoListItems = listaDecenso.get(position);
        if(convertView== null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.decenso_list_row, null);
        }
            TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
            tvId.setText(decensoListItems.getNo());
            TextView tvNomEq = (TextView) convertView.findViewById(R.id.tvNomEq);
            tvNomEq.setText(decensoListItems.getEquipo());
            TextView tvLogo = (TextView) convertView.findViewById(R.id.tvLogo);
            tvLogo.setText(decensoListItems.getLogo());
            TextView tvPorcent = (TextView) convertView.findViewById(R.id.tvPorcent);
            tvPorcent.setText(decensoListItems.getLogo());
            TextView tvJJ = (TextView) convertView.findViewById(R.id.tvJJ);
            tvJJ.setText(decensoListItems.getLogo());
            TextView tvDif = (TextView) convertView.findViewById(R.id.tvDif);
            tvDif.setText(decensoListItems.getLogo());
            TextView tvPTS = (TextView) convertView.findViewById(R.id.tvPTS);
            tvPTS.setText(decensoListItems.getLogo());
            return convertView;
        }
}
