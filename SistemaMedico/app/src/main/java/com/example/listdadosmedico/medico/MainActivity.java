package com.example.listdadosmedico.medico;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listdadosmedico.R;
import com.example.listdadosmedico.medico.cadastro.CadastroMedico;
import com.example.listdadosmedico.medico.constants.ConstantsDadosMedicos;
import com.example.listdadosmedico.medico.interfacce.MainMedicoContrato;
import com.example.listdadosmedico.medico.model.Medico;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainMedicoContrato.MainMedicoView{
    private int selected;
    private ArrayAdapter adapter;
    private Medico medico;
    private ListView listView ;
    private List<Medico> lista_medicos = new ArrayList<Medico>();


    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        selected = -1;

        listView = (ListView) findViewById( R.id.list_view_medicos );

        inicializarListView();

        inicializarFirebase();
        eventListDatabase();



    }
    public void eventListDatabase(){
        databaseReference.child( "Medico" ).addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                  lista_medicos.clear();

                for (DataSnapshot objectSnapshot : dataSnapshot.getChildren()) {
                    Medico medico = objectSnapshot.getValue( Medico.class );
                    lista_medicos.add( medico );
                }
                adapter = new ArrayAdapter<Medico>( MainActivity.this, android.R.layout.simple_list_item_1, lista_medicos );
                listView.setAdapter( adapter );



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void inicializarListView() {


        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostrar( ConstantsDadosMedicos.MENSAGEM_ITEM_SELECIONADO );
                selected = position;
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu, menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public void adicionar() {
        Intent intent = new Intent( MainActivity.this, CadastroMedico.class );
        startActivityForResult( intent, ConstantsDadosMedicos.REQUEST_ADD );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.adicionar:
                adicionar();
                break;
            case R.id.editar:
                editar();
                break;
            case R.id.remover:
                removerItem();
                break;

        }
        selected = -1;
        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (requestCode == ConstantsDadosMedicos.REQUEST_ADD && resultCode == ConstantsDadosMedicos.RESULT_ADD) {

            String nome = (String) data.getExtras().get(ConstantsDadosMedicos.CAMPO_NOME);
            String especializacao = (String) data.getExtras().get( ConstantsDadosMedicos.CAMPO_ESPECIALIDADE );
            String area_atuacao = (String) data.getExtras().get( ConstantsDadosMedicos.CAMPO_AREA_ATUACAO );
            String crm = (String) data.getExtras().get( ConstantsDadosMedicos.CAMPO_CRM);
            medico = new Medico( nome,especializacao, area_atuacao, crm);
            databaseReference.child( "Medico" ).child( medico.getCrm() ).setValue( medico );
            adapter.notifyDataSetChanged();
            mostrar( ConstantsDadosMedicos.MENSAGEM_SUCESSO_CADASTRO );

        }else if ( requestCode == ConstantsDadosMedicos.REQUEST_EDIT && resultCode == ConstantsDadosMedicos.RESULT_ADD){
            String crm;
            String nome = (String) data.getExtras().get( ConstantsDadosMedicos.CAMPO_NOME );
            String especializacao = (String) data.getExtras().get( ConstantsDadosMedicos.CAMPO_ESPECIALIDADE );
            String area_atuacao = (String) data.getExtras().get( ConstantsDadosMedicos.CAMPO_AREA_ATUACAO);
            crm = data.getExtras().getString( ConstantsDadosMedicos.CAMPO_CRM);

            for(Medico medico : lista_medicos){
                if (medico.getCrm().equals( crm )){
                   medico = new Medico( nome, especializacao, area_atuacao, crm );
                   databaseReference.child( "Medico" ).child( medico.getCrm() ).setValue( medico );
                }
            }

            adapter.notifyDataSetChanged();
            mostrar( ConstantsDadosMedicos.MENSAGEM_SUCESSO_ATUALIZACAO );
        }else if(resultCode == ConstantsDadosMedicos.OPTION_CANCEL){
                mostrar( ConstantsDadosMedicos.MENSAGEM_CANCELAMENTO );
        }
    }

    @Override
    public void editar() {
        if (selected >= 0) {
            Intent intent = new Intent( MainActivity.this, CadastroMedico.class );
            intent.putExtra( ConstantsDadosMedicos.CAMPO_CRM, lista_medicos.get( selected ).getCrm() );
            intent.putExtra( ConstantsDadosMedicos.CAMPO_NOME, lista_medicos.get( selected ).getNome() );
            intent.putExtra( ConstantsDadosMedicos.CAMPO_ESPECIALIDADE, lista_medicos.get( selected ).getEspecialidade() );
            intent.putExtra( ConstantsDadosMedicos.CAMPO_AREA_ATUACAO, lista_medicos.get( selected ).getArea_atuacao() );
            startActivityForResult( intent, ConstantsDadosMedicos.REQUEST_EDIT );
        } else {
            mostrar(ConstantsDadosMedicos.MENSAGEM_ITEM_NAO_SELECIONADO);
        }
    }

    @Override
    public void removerItem() {
        if (selected >= 0) {
            String crm_medico = lista_medicos.get( selected ).getCrm();
            medico = new Medico(  );
            medico.setCrm( crm_medico );
            databaseReference.child( "Medico" ).child( medico.getCrm() ).removeValue();
            mostrar( ConstantsDadosMedicos.MENSAGEM_SUCESSO_REMOCAO );
            adapter.notifyDataSetChanged();
        } else {
            mostrar(ConstantsDadosMedicos.MENSAGEM_ITEM_NAO_SELECIONADO);
        }
    }

    @Override
    public void mostrar(String mensagem) {
        Toast.makeText( MainActivity.this, mensagem, Toast.LENGTH_LONG ).show();

    }


    public void inicializarFirebase(){
        FirebaseApp.initializeApp( MainActivity.this );
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled( true );
        databaseReference = firebaseDatabase.getReference();
    }


}


