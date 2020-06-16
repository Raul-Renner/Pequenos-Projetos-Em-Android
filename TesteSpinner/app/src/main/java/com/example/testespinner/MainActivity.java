package com.example.testespinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner;
    private EditText text_valor;
    private EditText text_valor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);



        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.teste_spinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);



    }
    public void realizarSoma(View view){
        text_valor = (EditText) findViewById(R.id.edit_valor1);
        int valor1 = Integer.parseInt(text_valor.getText().toString());
        text_valor2 = (EditText) findViewById(R.id.edit_valor2);
        int valor2 = Integer.parseInt(text_valor2.getText().toString());

        String operacao = spinner.getSelectedItem().toString();
         int resultado = verificarOperacao(valor1,valor2,operacao);

         Toast.makeText(this,"Resultado: " + resultado,Toast.LENGTH_LONG).show();
    }

    public int verificarOperacao(int valor1, int valor2,String operacao){
        switch (operacao){
            case "+":
                return valor1 + valor2;
            case "-":
                return valor1 - valor2;
            case "*":
                return valor1 * valor2;
            case "/":
                return valor1 / valor2;
        }
        return 0;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
