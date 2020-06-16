package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.componentesbasicos.model.Adaptador;

public class GridViewImagens extends AppCompatActivity {
    GridView gridView;
    private int [] imagens_aimais;
    private String [] nome_animais_pt;
    private String [] nome_animais_eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_grid_view_imagens );
        setVetores();
        gridView_imagens();
    }

    public void gridView_imagens(){
        gridView = (GridView) findViewById( R.id.grid_view_imagens_animais );

        Adaptador adaptador = new Adaptador(GridViewImagens.this,imagens_aimais,nome_animais_pt,nome_animais_eng);
        gridView.setAdapter( adaptador );

        gridView.setOnItemClickListener( new GridView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(GridViewImagens.this,nome_animais_eng[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void proximaActivity( View view ){
        Intent intent = new Intent( GridViewImagens.this, ActivityMediaPlayer.class );
        startActivity( intent );
    }
    public void voltarActivity(View view ){
        finish();
    }

    public  void setVetores(){
        imagens_aimais = new int []{R.drawable.araras,R.drawable.dromedario,R.drawable.gato,
                R.drawable.tucano,R.drawable.girafa,R.drawable.leao};
        nome_animais_pt = new String[]{"Arara","Dromedário","Gato","Tucano","Girafa","Leão"};
        nome_animais_eng = new String[] {"Macaw","Dromedary","Cat","Toucan","Giraffe","Lion"};
    }
}
