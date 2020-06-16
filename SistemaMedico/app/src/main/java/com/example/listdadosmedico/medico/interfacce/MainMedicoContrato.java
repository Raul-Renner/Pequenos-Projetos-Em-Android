package com.example.listdadosmedico.medico.interfacce;

import android.view.MenuItem;
import android.widget.Toast;


public interface MainMedicoContrato {

      interface MainMedicoView{
        void inicializarListView();
          void adicionar();
          void editar();
          void mostrar(String mensagem);
          void removerItem();

      }

        interface MainMedicoPresenter {
        }
    }