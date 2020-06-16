package com.example.listdadosmedico.medico.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.listdadosmedico.R;
import com.example.listdadosmedico.medico.MainActivity;
import com.example.listdadosmedico.medico.cadastro.CadastroMedico;
import com.example.listdadosmedico.medico.interfacce.MainMedicoContrato;

public class MainMedicoPresenter implements MainMedicoContrato.MainMedicoPresenter {

    public MainMedicoContrato.MainMedicoView view;

    public  MainMedicoPresenter(MainMedicoContrato.MainMedicoView view){
        this.view = view;
    }



}
