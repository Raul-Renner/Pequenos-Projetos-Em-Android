package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class ActivityToggle extends AppCompatActivity {
    private ToggleButton btn_power;
    private ImageView img_lampada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_toggle );
        powerLampada();
    }

    public void powerLampada(){
        btn_power = (ToggleButton) findViewById( R.id.toggle_btn);
        img_lampada = (ImageView) findViewById( R.id.img_lampada);

        btn_power.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_power.isChecked()){
                    img_lampada.setImageDrawable(getResources().getDrawable( R.drawable.light_off ));

                }else{
                    img_lampada.setImageDrawable( getResources().getDrawable( R.drawable.light_on ));
                }

            }
        });
    }

    public void proximaActivity( View view){
        Intent intent = new Intent( ActivityToggle.this, ActivityClickLong.class);
        startActivity( intent );
    }

    public void voltarActivity(View view ){
        finish();
    }

}
