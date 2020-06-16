package com.example.navegacaoentretelas_aula5;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.example.navegacaoentretelas_aula5.model.Contato;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contato> lista;
    private ArrayAdapter adapter;
    private ListView listView_contato;
    private Contato contato;
    private int selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        selected = -1;
        lista = new ArrayList<Contato>(  );

        adapter = new ArrayAdapter( MainActivity.this,android.R.layout.simple_list_item_1, lista);
        listView_contato = (ListView) findViewById( R.id.list_contatos );
        listView_contato.setAdapter( adapter );
        listView_contato.setSelection( android.R.color.holo_green_dark );

        listView_contato.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( MainActivity.this, "Item selecionado", Toast.LENGTH_LONG ).show();
                selected = position;
            }
        } );



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_activity_principal, menu );
        return super.onCreateOptionsMenu( menu );

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.adicionar:
                adicionar();
                break;
            case R.id.edit:
                editar();
                break;
            case R.id.delete:
                removerItem();
                break;

        }
        selected = - 1;
        return true;
    }

    public void adicionar(){
        Intent intent = new Intent( MainActivity.this, ActivityContatoAula5.class );
        startActivityForResult( intent, Constants.REQUEST_ADD );
    }

    public void editar(){
        if(selected >= 0) {
            Intent intent = new Intent( MainActivity.this, ActivityContatoAula5.class );
            intent.putExtra( "id", lista.get( selected ).getId_contato() );
            intent.putExtra( "nome", lista.get( selected ).getNome() );
            intent.putExtra( "telefone", lista.get( selected ).getTelefone() );
            intent.putExtra( "endereco", lista.get( selected ).getEndereco() );
            startActivityForResult( intent, Constants.REQUEST_EDIT );
        }else{
            Toast.makeText( MainActivity.this, "Selecione um item", Toast.LENGTH_LONG ).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (requestCode == Constants.REQUEST_ADD && resultCode == Constants.RESULT_ADD) {

                String nome = (String) data.getExtras().get( "nome" );
                String telefone = (String) data.getExtras().get( "telefone" );
                String endereco = (String) data.getExtras().get( "endereco" );
                contato = new Contato( nome,telefone, endereco );
                lista.add( contato );
                adapter.notifyDataSetChanged();

        }else if ( requestCode == Constants.REQUEST_EDIT && resultCode == Constants.RESULT_ADD){
            int id_contato;
            String nome = (String) data.getExtras().get( "nome" );
            String telefone = (String) data.getExtras().get( "telefone" );
            String endereco = (String) data.getExtras().get( "endereco" );
            id_contato = (int) data.getExtras().get( "id" );

            for(Contato contato : lista){
                if (contato.getId_contato() == id_contato){
                    contato.setNome( nome );
                    contato.setTelefone( telefone );
                    contato.setEndereco( endereco );
                }
            }

            adapter.notifyDataSetChanged();
        }else if(resultCode == Constants.RESULT_CANCEL){
            Toast.makeText( MainActivity.this, "CANCELADO", Toast.LENGTH_LONG ).show();
        }
    }
    public void removerItem(){
        if(selected >= 0){
            lista.remove( selected );
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText( this, "Selecione um item para remover!",Toast.LENGTH_LONG ).show();
        }
    }

}
