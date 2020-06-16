package com.example.componentesbasicos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ActivityMediaPlayer extends AppCompatActivity {
    private ImageView play_icon;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_media_player );

        reproduzirMusica();
    }

    public void reproduzirMusica(){
        play_icon = (ImageView) findViewById( R.id.image_btn_play);

        play_icon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    play_icon.setImageResource( R.drawable.ic_pause_circle_filled_black_24dp );
                }else{
                    mediaPlayer.pause();
                    play_icon.setImageResource( R.drawable.ic_play_circle_filled_black_24dp );
                }
            }
        } );

        mediaPlayer = MediaPlayer.create( this, R.raw.vintage);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_background, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.image_background_1:
            substituirImagemBackground( item,R.drawable.background );
            return true;
            case R.id.image_background_2:
                substituirImagemBackground( item, R.drawable.background_3 );
            return true;
            case R.id.image_background_3:
                substituirImagemBackground( item,R.drawable.background_2 );
                return true;
            default:
                return onContextItemSelected( item );
        }
    }

    public void substituirImagemBackground(MenuItem item, int drawable){
        LinearLayout linearLayout = (LinearLayout) findViewById( R.id.linear_background_imagem );
            if(item.isChecked()){
                item.setChecked( false );
            }else{
                item.setChecked( true );
                linearLayout.setBackgroundResource( drawable );

            }
    }

    public void proximaActivity( View view ){
        Intent intent = new Intent( this, ActivityToggle.class );
        startActivity( intent );
    }

    public void voltarfActivity( View view ){
        finish();
    }



}
