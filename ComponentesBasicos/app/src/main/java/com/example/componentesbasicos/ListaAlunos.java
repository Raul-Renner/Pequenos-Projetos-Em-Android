package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.componentesbasicos.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunos extends AppCompatActivity {
    private List<Aluno>alunos = new ArrayList<Aluno>();
    private ArrayAdapter<Aluno> adapter;
    private ListView lista_view_alunos;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String sobrenome = intent.getStringExtra("sobrenome");
        String matricula = intent.getStringExtra("matricula");
        String curso = intent.getStringExtra("curso");
        String utilizacao_laboratorio = intent.getStringExtra("utilizcao_laboratorio");
        String qualidade_laboratorio = intent.getStringExtra("qualidade_laboratorio");
        String disponibilidade_laboratorio = intent.getStringExtra("disponibilidade_laboratorio");

        aluno = new Aluno(nome,sobrenome,matricula,curso,utilizacao_laboratorio,qualidade_laboratorio,disponibilidade_laboratorio);
        alunos.add(aluno);

        lista_view_alunos = (ListView) findViewById(R.id.list_view_aluno);
        adapter = new ArrayAdapter<>(ListaAlunos.this,android.R.layout.simple_list_item_1,alunos);
        lista_view_alunos.setAdapter(adapter);




    }
    public void proximaActivity( View view ){
        Intent intent = new Intent(ListaAlunos.this, GridViewImagens.class);
        startActivity( intent );
    }
    public void voltar(View view){
        finish();
    }

}
