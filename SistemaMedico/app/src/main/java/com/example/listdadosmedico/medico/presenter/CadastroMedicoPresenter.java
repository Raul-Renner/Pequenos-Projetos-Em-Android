package com.example.listdadosmedico.medico.presenter;

import android.view.View;
import android.widget.Toast;

import com.example.listdadosmedico.medico.constants.ConstantsDadosMedicos;
import com.example.listdadosmedico.medico.interfacce.ICadastroMedicoContrato;

import java.util.Random;

public class CadastroMedicoPresenter implements ICadastroMedicoContrato.CadastroMedicoPresenter {
    Random random;
    public ICadastroMedicoContrato.CadastroMedicoView view;
    public  CadastroMedicoPresenter(ICadastroMedicoContrato.CadastroMedicoView view){
        this.view = view;
    }

    public  boolean verificacarCampos(String nome, String especializacao, String area_atuacao){
        if(nome.equals( "" ) || especializacao.equals( "" ) || area_atuacao.equals( "" )){
            return false;
        }
        return true;
    }

    public int gerarCRM(){
        random = new Random(  );
        int crm = random.nextInt(80000);

        return  crm;
    }


}
