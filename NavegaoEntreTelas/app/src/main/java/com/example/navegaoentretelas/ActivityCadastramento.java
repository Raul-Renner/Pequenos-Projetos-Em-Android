package com.example.navegaoentretelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.navegaoentretelas.model.Constants;

public class ActivityCadastramento extends AppCompatActivity {
    private EditText edit_nome;
    private EditText edit_especialidade;
    private EditText edt_AreaAtuacao;
    private EditText edt_CRM;
    private Button btn_salvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cadastramento );

        recebendoDados();
        cadastrarMedico();
    }
    public void recebendoDados() {

        edit_nome = (EditText) findViewById( R.id.edit_nome_medico );
        edit_especialidade = (EditText) findViewById( R.id.edit_especialidade);
        edt_AreaAtuacao = (EditText) findViewById( R.id.edit_area_atuacao);
        edt_CRM = (EditText) findViewById( R.id.editText_CRM_medico);
        if(getIntent().getExtras() != null){
            edit_nome.setText( (String) getIntent().getExtras().get( "NOME_COMPLETO" ) );
            edit_especialidade.setText( (String) getIntent().getExtras().get( "ESPECIALIZACAO" ) );
            edt_AreaAtuacao.setText( (String) getIntent().getExtras().get( "AREA ATUACAO" ));
            edt_CRM.setText( (String) getIntent().getExtras().get( "CRM" ));
            edt_CRM.setEnabled( false );
        }

    }

    public void cadastrarMedico(){
        btn_salvar = (Button) findViewById( R.id.btn_salvar_dados_medico );

        btn_salvar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra( "NOME_COMPLETO", edit_nome.getText().toString() );
                intent.putExtra( "ESPECIALIZACAO",edit_especialidade.getText().toString());
                intent.putExtra( "AREA ATUACAO", edt_AreaAtuacao.getText().toString() );
                intent.putExtra( "CRM", edt_CRM.getText().toString() );
                setResult( Constants.RESULT_ADD, intent );
                finish();


            }
        } );
    }
    public void cancelar(View view ){
        setResult( Constants.RESULT_CANCEL );
        finish();
    }
}
