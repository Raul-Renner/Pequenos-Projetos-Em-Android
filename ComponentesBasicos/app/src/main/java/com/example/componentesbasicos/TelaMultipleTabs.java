package com.example.componentesbasicos;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TelaMultipleTabs extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TabItem tabItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tela_multiple_tabs );

        populandoVariaveis();
        criarMultpleTabs();
    }

    public void criarMultpleTabs(){
        actionBarToggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.open, R.string.close );
        drawerLayout.addDrawerListener( actionBarToggle );
        actionBarToggle.setDrawerIndicatorEnabled( true );
        actionBarToggle.syncState();
    }
    public void populandoVariaveis(){
        toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        drawerLayout = (DrawerLayout) findViewById( R.id.drawer_main );
        navigationView = (NavigationView) findViewById( R.id.navigation_view_menu);
        tabLayout = (TabLayout) findViewById( R.id.tabLayout_menu );
        tabItem = (TabItem) findViewById( R.id.tab_item1 );


    }
    public void voltarActivityInicial( View view){
        Intent intent = new Intent( this, MainActivity.class );
        startActivity( intent );
    }
    public void voltarActivity(View view ){
        finish();
    }
}
