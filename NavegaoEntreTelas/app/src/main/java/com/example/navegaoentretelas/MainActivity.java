package com.example.navegaoentretelas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navegaoentretelas.model.Constants;
import com.example.navegaoentretelas.model.Medico;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Medico> medicos;
    private Medico medico;
    private String crm_Medico;
    private ListView lista_view_medicos;
    private ArrayAdapter adapter_medico;
    private EditText edit_CRM_medico;
    private Button btn_editar;
    private int selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        selected = -1;

        instanciarListViewMedicos();
        selecionarItemListView();
        editarDadosMedico();
    }

    public void cadastrarMedico( View view ){
        Intent intent = new Intent( this, ActivityCadastramento.class );
        startActivityForResult( intent, Constants.REQUEST_ADD );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        medico = new Medico(  );
        super.onActivityResult( requestCode, resultCode, data );

        if( requestCode == Constants.REQUEST_ADD && resultCode == Constants.RESULT_ADD){
            medico.setNome_completo( data.getStringExtra( "NOME_COMPLETO" ) );
            medico.setEspecialidade( data.getStringExtra( "ESPECIALIZACAO" ));
            medico.setAreaAtuacao( data.getStringExtra( "AREA ATUACAO" ) );
            medico.setCRM( data.getStringExtra( "CRM" ));


            medicos.add( medico );
            adapter_medico.notifyDataSetChanged();

        }else if(requestCode == Constants.REQUEST_EDIT && resultCode == Constants.RESULT_ADD){
                medicos.remove( selected );
                medico.setNome_completo( (String) data.getExtras().get( "NOME_COMPLETO" ) );
                medico.setEspecialidade( (String) data.getExtras().get( "ESPECIALIZACAO" ) );
                medico.setAreaAtuacao( (String) data.getExtras().get( "AREA ATUACAO" ) );
                medico.setCRM( (String) data.getExtras().get( "CRM" ));

                medicos.add( medico );
                adapter_medico.notifyDataSetChanged();
        }else if (resultCode == Constants.RESULT_CANCEL){
            Toast.makeText( MainActivity.this, "Cancelado", Toast.LENGTH_LONG ).show();
        }
        edit_CRM_medico.setText( "" );
        selected = -1;
    }

    public void instanciarListViewMedicos(){
        medicos = new ArrayList<Medico>(  );
        edit_CRM_medico = (EditText) findViewById( R.id.editText_CRM_medico);

        adapter_medico = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, medicos );
        lista_view_medicos = (ListView) findViewById( R.id.list_view_medicos );

        lista_view_medicos.setAdapter( adapter_medico );
        lista_view_medicos.setSelection( android.R.color.holo_green_dark );

    }
    public void selecionarItemListView(){
        edit_CRM_medico = (EditText) findViewById( R.id.editar_CRM_medico);
        lista_view_medicos.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( MainActivity.this, "Item selecionado", Toast.LENGTH_LONG ).show();
                selected = position;
                edit_CRM_medico.setText( medicos.get( selected ).getCRM() );

            }
        } );
    }

    public void editarDadosMedico(){

        btn_editar = (Button) findViewById( R.id.btn_editar_dados_medicos );
//
        btn_editar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected >= 0){
                    Intent intent = new Intent( MainActivity.this, ActivityCadastramento.class );
                    intent.putExtra( "NOME_COMPLETO", medicos.get( selected ).getNome_completo() );
                    intent.putExtra( "ESPECIALIZACAO", medicos.get( selected ).getEspecialidade() );
                    intent.putExtra( "AREA ATUACAO", medicos.get( selected ).getAreaAtuacao() );
                    intent.putExtra( "CRM" , medicos.get( selected ).getCRM());

                    startActivityForResult(intent,Constants.REQUEST_EDIT);
                }else {
                    Toast.makeText( MainActivity.this, "Nenhum item selecionado", Toast.LENGTH_LONG ).show();
                }

            }
        } );


    }
//    public void onClickListView(){
//        Medico medico2 = new Medico(  );
//        lista_view_medicos.setOnItemClickListener( new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              edit_crm_medico.setText(medicos.get( position ).getCRM());
//
//            }
//        });0
//    }
}
