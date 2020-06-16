package com.example.componentesbasicos.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.componentesbasicos.R;

import org.w3c.dom.Text;

public class Adaptador extends BaseAdapter {
    private Context context;
    private int [] fotos;
    private String [] nome_portugues;
    private String [] nome_ingles;
    private LayoutInflater inflater;

    public Adaptador(Context context, int[] fotos, String[] nome_portugues, String[] nome_ingles) {
        this.context = context;
        this.fotos = fotos;
        this.nome_portugues = nome_portugues;
        this.nome_ingles = nome_ingles;
    }

    @Override
    public int getCount() {
        return nome_portugues.length;
    }

    @Override
    public Object getItem(int position) {
        return nome_portugues[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid_view_img = convertView;
        if(convertView == null){
            inflater = (LayoutInflater)context.getSystemService( context.LAYOUT_INFLATER_SERVICE );
            grid_view_img = inflater.inflate( R.layout.custom_layout, null );
        }
        ImageView img = (ImageView) grid_view_img.findViewById( R.id.imagem_view_1 );
        TextView nome_animal = (TextView) grid_view_img.findViewById( R.id.text_nome_animal );
        img.setImageResource( fotos[position] );
        nome_animal.setText( nome_portugues[position] );
        img.setAdjustViewBounds( true );
        return grid_view_img;
    }
}
