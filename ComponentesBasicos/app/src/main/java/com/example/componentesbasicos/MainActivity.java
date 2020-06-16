package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.componentesbasicos.model.Aluno;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, PopupMenu.OnMenuItemClickListener {

   private  AutoCompleteTextView auto_complete_curso;
   private Spinner spinner_turno;
   private RadioGroup radioGroup_qld_lab;
   private RadioButton rad_btn_qld_lab;
   private RadioGroup radioGroup_disp_lab;
   private RadioButton radioButton_disp_lab;
   Aluno aluno;
   private EditText nome;
   private EditText sobrenome;
   private EditText matricula;
   private Button btn_cadastrar_aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = (EditText) findViewById(R.id.editText_nome);
        sobrenome = (EditText) findViewById(R.id.editText_sobrenome);
        matricula = ( EditText ) findViewById(R.id.editText_matricula);
        radioGroup_disp_lab = (RadioGroup) findViewById(R.id.rad_gp_disp_lab);
        radioGroup_qld_lab = (RadioGroup) findViewById(R.id.rad_group_qld_lab);
        auto_complete_curso = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);




        AutoComplete();
        spinnerTurno();

        adicionarAluno();

    }

    public void spinnerTurno(){
        spinner_turno = (Spinner) findViewById(R.id.spinner_turno);

        ArrayAdapter adapter_spinner_turno =
                ArrayAdapter.createFromResource(this,R.array.turno,android.R.layout.simple_spinner_item);
        adapter_spinner_turno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_turno.setOnItemSelectedListener(this);
        spinner_turno.setAdapter(adapter_spinner_turno);

    }
    public void AutoComplete(){

        ArrayAdapter<String> adapter_auto_complete =
                new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,cursos);
        auto_complete_curso.setThreshold(1);
        auto_complete_curso.setAdapter(adapter_auto_complete);


    }

    private static final String[] cursos = new String[]{
    "Ciencia da Computacao","Designer Digital","Engenharia da Computacao","Engenharia de Software"
            ,"Redes de Computadores","Sistema de Informação"
    };

    public void avaliarQualidadeLaboratorio(){


    }
    public void avaliarDisponibilidadeLaboratorio(){


    }
    public void adicionarAluno(){


        btn_cadastrar_aluno = (Button) findViewById(R.id.btn_cadastrar_aluno);


       btn_cadastrar_aluno.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {



                int id_rad_group_qld_lab = radioGroup_qld_lab.getCheckedRadioButtonId();
                rad_btn_qld_lab =  findViewById(id_rad_group_qld_lab);



                int id_radio_group_disp_lab = radioGroup_disp_lab.getCheckedRadioButtonId();
                radioButton_disp_lab = (RadioButton) findViewById(id_radio_group_disp_lab);

                Toast.makeText(MainActivity.this,spinner_turno.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();




               Intent intent = new Intent(MainActivity.this, ListaAlunos.class);
                intent.putExtra("nome", nome.getText().toString());
                intent.putExtra("sobrenome", sobrenome.getText().toString());
                intent.putExtra("matricula", matricula.getText().toString());
                intent.putExtra("curso",  auto_complete_curso.getText().toString());
                intent.putExtra("utilizcao_laboratorio", spinner_turno.getSelectedItem().toString());
                intent.putExtra("qualidade_laboratorio", rad_btn_qld_lab.getText().toString());
                intent.putExtra("disponibilidade_laboratorio", radioButton_disp_lab.getText().toString());


                startActivityForResult(intent, 18);
            }
        });



   }
   public void limparDados( View view  ){
       PopupMenu popupMenu = new PopupMenu( this, view );
       popupMenu.setOnMenuItemClickListener( this );
       popupMenu.inflate( R.menu.menu_drop_down_popup_menu );
       popupMenu.show();
   }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.spinner_turno.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.limpar_campos:
            nome.setText( "" );
            sobrenome.setText( "" );
            matricula.setText( "" );
            auto_complete_curso.setText( "" );
            radioGroup_disp_lab.clearCheck();
            radioGroup_qld_lab.clearCheck();


            return true;

        }
        return false;
    }
}
