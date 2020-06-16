package com.example.listdadosmedico.medico.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listdadosmedico.R;
import com.example.listdadosmedico.medico.constants.ConstantsDadosMedicos;
import com.example.listdadosmedico.medico.interfacce.ICadastroMedicoContrato;
import com.example.listdadosmedico.medico.presenter.CadastroMedicoPresenter;

public class CadastroMedico extends AppCompatActivity implements ICadastroMedicoContrato.CadastroMedicoView {
    private EditText edt_nome;
    private EditText edt_especializacao;
    private EditText edt_area_atuacao;
    private EditText edt_crm;
    private Button btn_adicionar;
    private Button btn_cancelar;
    private boolean verificacao = false;
    private ICadastroMedicoContrato.CadastroMedicoPresenter cadastroMedicoPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cadastro_medico );
        inicializarComponentes();
        verificacarRequest();
        cadastroMedicoPresenter = new CadastroMedicoPresenter(this);

    }

    @Override
    public void inicializarComponentes(){
        edt_nome = (EditText) findViewById( R.id.edit_nome );
        edt_especializacao = (EditText) findViewById( R.id.edit_especializacao );
        edt_area_atuacao = (EditText) findViewById( R.id.edit_area_atuacao);
        edt_crm = (EditText) findViewById( R.id.edt_crm);
        edt_crm.setEnabled( false );

    }

    public void verificacarRequest(){
        if(getIntent().getExtras() != null){
            edt_nome.setText( (String) getIntent().getExtras().get( ConstantsDadosMedicos.CAMPO_NOME) );
            edt_especializacao.setText( (String) getIntent().getExtras().get( ConstantsDadosMedicos.CAMPO_ESPECIALIDADE) );
            edt_area_atuacao.setText( (String) getIntent().getExtras().get( ConstantsDadosMedicos.CAMPO_AREA_ATUACAO ) );
            edt_crm.setText((String) getIntent().getExtras().get(ConstantsDadosMedicos.CAMPO_CRM));
            edt_crm.setEnabled( false );

            verificacao = true;

        }
    }

    @Override
    public void salvar( View view ){
        Intent intent = new Intent(  );
        String nome = edt_nome.getText().toString();
        String especializacao = edt_especializacao.getText().toString();
        String area_atuacao = edt_area_atuacao.getText().toString();
        String crm;
        if(!verificacao){

            int valor = cadastroMedicoPresenter.gerarCRM();
            crm = Integer.toString( valor );

        }else {
           crm = edt_crm.getText().toString();
        }
        if(!cadastroMedicoPresenter.verificacarCampos( nome, especializacao, area_atuacao )){
                mostrarMensagam( ConstantsDadosMedicos.CAMPOS_VAZIOS );
        }else {
            intent.putExtra( ConstantsDadosMedicos.CAMPO_NOME, nome );
            intent.putExtra( ConstantsDadosMedicos.CAMPO_ESPECIALIDADE, especializacao );
            intent.putExtra( ConstantsDadosMedicos.CAMPO_AREA_ATUACAO, area_atuacao );
            intent.putExtra( ConstantsDadosMedicos.CAMPO_CRM, crm );
            setResult( ConstantsDadosMedicos.RESULT_ADD, intent );
            finish();
        }
    }

    @Override
    public void cancelar(View view ){
        setResult( ConstantsDadosMedicos.OPTION_CANCEL );
        finish();
    }

    @Override
    public void mostrarMensagam(String mensagem) {
        Toast.makeText( CadastroMedico.this, mensagem, Toast.LENGTH_LONG ).show();
    }

}
