package com.example.listdadosmedico.medico.interfacce;

import android.view.View;

import com.example.listdadosmedico.medico.constants.ConstantsDadosMedicos;

public interface ICadastroMedicoContrato {
    interface CadastroMedicoView{
        void inicializarComponentes();
        void mostrarMensagam(String mensagem);
        void cancelar(View view);
        void salvar(View view);
    }

    interface CadastroMedicoPresenter{
        boolean verificacarCampos(String nome, String especializacao, String area_atuacao);
        int gerarCRM();
    }
}
