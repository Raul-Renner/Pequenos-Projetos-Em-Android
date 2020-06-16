package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityClickLong extends AppCompatActivity {

    private Button btn_clique_longo;
    private int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_click_long );

        calcular_numero_de_cliques_long();
    }
    public void calcular_numero_de_cliques_long(){
        btn_clique_longo = (Button) findViewById( R.id.btn_clique_longo );
        btn_clique_longo.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText( ActivityClickLong.this, "soma: "+ (cont = cont + 1),Toast.LENGTH_SHORT ).show();
                return false;
            }
        } );
    }
    public void voltarActivityAnterior( View view ){
        finish();
    }
    public void proximaActivity( View view ){
        Intent intent = new Intent( this, TelaMultipleTabs.class );
        startActivity( intent );
    }
}
