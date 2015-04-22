package com.example.rouse.ligamxentumano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rouse on 21/04/2015.
 */
public class AdapterPosiciones extends BaseAdapter {
    Posiciones context;
    ArrayList<Liga> listaPosiciones;

    public AdapterPosiciones(Posiciones context, ArrayList<Liga> listaPosiciones) {
        this.context = context;
        this.listaPosiciones = listaPosiciones;
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
        Liga ligaListItems = listaPosiciones.get(position);
        if(convertView== null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.posiciones_list_row, null);
        }
        TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
        tvId.setText(ligaListItems.getId());
        TextView tvNomEq = (TextView) convertView.findViewById(R.id.tvNomEq);
        tvNomEq.setText(ligaListItems.getNomEq());
        TextView tvLogo = (TextView) convertView.findViewById(R.id.tvLogo);
        tvLogo.setText(ligaListItems.getLogo());
        TextView tvJJ = (TextView) convertView.findViewById(R.id.tvJJ);
        tvJJ.setText(ligaListItems.getJj());
        TextView tvJG = (TextView) convertView.findViewById(R.id.tvJG);
        tvJG.setText(ligaListItems.getJg());
        TextView tvJP = (TextView) convertView.findViewById(R.id.tvJP);
        tvJP.setText(ligaListItems.getJp());
        TextView tvJE = (TextView) convertView.findViewById(R.id.tvJE);
        tvJE.setText(ligaListItems.getJe());
        TextView tvJF = (TextView) convertView.findViewById(R.id.tvJF);
        tvJF.setText(ligaListItems.getJf());
        TextView tvGF = (TextView) convertView.findViewById(R.id.tvGF);
        tvGF.setText(ligaListItems.getGf());
        TextView tvGC = (TextView) convertView.findViewById(R.id.tvGC);
        tvGC.setText(ligaListItems.getGc());
        TextView tvDifG = (TextView) convertView.findViewById(R.id.tvDF);
        tvDifG.setText(ligaListItems.getDifGoles());
        TextView tvPts = (TextView) convertView.findViewById(R.id.tvPTS);
        tvPts.setText(ligaListItems.getPntsGoles());

        return convertView;
    }
    }

