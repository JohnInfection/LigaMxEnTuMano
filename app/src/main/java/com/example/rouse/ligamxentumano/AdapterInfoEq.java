package com.example.rouse.ligamxentumano;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rouse on 07/04/2015.
 */
public class AdapterInfoEq  extends BaseAdapter {
   InfoEquipos context;
    ArrayList<PojoInfoEq> listaInfoEq;

    public AdapterInfoEq(InfoEquipos context, ArrayList<PojoInfoEq> listaInfoEq) {
        this.context = context;
        this.listaInfoEq = listaInfoEq;
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
        PojoInfoEq infoListItems = listaInfoEq.get(position);
        if(convertView== null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.info_list_row, null);
        }
        TextView tvNomEq = (TextView) convertView.findViewById(R.id.tvNomEq);
        tvNomEq.setText(infoListItems.getNomEq());
        TextView tvDescEq = (TextView) convertView.findViewById(R.id.tvDescEq);
        tvDescEq.setText(infoListItems.getDesEq());
        ImageView tvImaEq= (ImageView) convertView.findViewById(R.id.tvImaEq);
      //  tvImaEq.setText(infoListItems.getImagEq());
        return convertView;
    }
  }

