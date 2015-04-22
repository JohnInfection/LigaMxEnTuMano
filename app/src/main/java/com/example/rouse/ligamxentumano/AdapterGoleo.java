package com.example.rouse.ligamxentumano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rouse on 23/03/2015.
 */
public class AdapterGoleo extends BaseAdapter {

    Context context;
    ArrayList<GoleoPojo> listaGoleo;


    public AdapterGoleo(Context context, ArrayList<GoleoPojo> listaGoleo) {
        this.context = context;
        this.listaGoleo = listaGoleo;
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

        GoleoPojo ligaListItems = listaGoleo.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.goleo_list_row, null);
        }

            TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
            tvId.setText(ligaListItems.getNo());
            TextView tvNomJ = (TextView) convertView.findViewById(R.id.tvNomJ);
            tvNomJ.setText(ligaListItems.getNomJug());
            TextView tvEq = (TextView) convertView.findViewById(R.id.tvEq);
            tvEq.setText(ligaListItems.getEquipo());
            TextView tvLogo = (TextView) convertView.findViewById(R.id.tvLogo);
            tvLogo.setText(ligaListItems.getLogo());
            TextView tvNoGol = (TextView) convertView.findViewById(R.id.tvNoGol);
            tvNoGol.setText(ligaListItems.getGoles());
            return convertView;

        }
    }



