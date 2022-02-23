package com.app.applistviewpersonalizado;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<Item> items;
    TextView tvMatricula,tvNombre,tvNumero;
    public ItemAdapter (Activity activity, ArrayList<Item> items){
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }
    @Override
    public long getItemId(int position) {
        return items.get(position).getClave();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista;
        vista=convertView;
        if(convertView==null){
            LayoutInflater inflater =(LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista= inflater.inflate(R.layout.elemento_lista,null);}

        tvMatricula=(TextView)vista.findViewById(R.id.tvMatricula);
        tvNombre=(TextView)vista.findViewById(R.id.tvNombre);
        tvNumero=(TextView)vista.findViewById(R.id.tvNumero);

        tvMatricula.setText(items.get(position).getMatricula());
        tvNombre.setText(items.get(position).getNombre());
        tvNumero.setText(items.get(position).getNumero());
        return vista;
    }
}