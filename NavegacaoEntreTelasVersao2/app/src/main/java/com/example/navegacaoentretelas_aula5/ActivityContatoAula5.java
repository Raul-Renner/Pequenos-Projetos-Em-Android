package com.example.navegacaoentretelas_aula5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityContatoAula5 extends AppCompatActivity {
    public static int RESULT_ADD = 1;
    public static int RESULT_CANCEL = 2;
    public static Constants Constants;


    private EditText editTextNome;
    private EditText editTextTelefone;
    private EditText editTextEndereco;
    private int id_contato;
    private boolean edit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_contato_aula5 );

//        String nome = ( String ) getIntent().getExtras().get( "nome" );
//        String sobrenome = ( String ) getIntent().getExtras().get( "sobrenome" );
//
        String nome;
        String telefone;

        editTextNome = (EditText) findViewById( R.id.editText_nome );
        editTextTelefone = (EditText) findViewById( R.id.editText_tel );
        editTextEndereco = (EditText) findViewById( R.id.editText_endereco );

        if(getIntent().getExtras() != null){
            nome = (String) getIntent().getExtras().get( "nome" );
            editTextNome.setText( nome );
            editTextTelefone.setText( (String) getIntent().getExtras().get( "telefone" ) );
            editTextEndereco.setText( (String) getIntent().getExtras().get( "endereco" ) );
            id_contato = (int) getIntent().getExtras().get( "id" ) ;

            edit = true;
        }
    }

    public void cancelar(View view ){
        setResult( Constants.RESULT_CANCEL );
        finish();
    }

    public void salvar( View view ){
        Intent intent = new Intent(  );
        String nome = editTextNome.getText().toString();
        String telefone = editTextTelefone.getText().toString();
        String endereco = editTextEndereco.getText().toString();
        intent.putExtra( "nome", nome );
        intent.putExtra( "telefone", telefone );
        intent.putExtra( "endereco", endereco );

        if(edit){
            intent.putExtra( "crm", id_contato );
        }
        setResult( Constants.RESULT_ADD, intent );
        finish();
    }

}
