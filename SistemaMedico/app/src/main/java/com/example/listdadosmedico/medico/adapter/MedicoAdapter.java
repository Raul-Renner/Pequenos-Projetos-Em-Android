//package com.example.listdadosmedico.medico.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.listdadosmedico.R;
//import com.example.listdadosmedico.medico.model.Medico;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class MedicoAdapter extends ArrayAdapter<Medico> {
//    public MedicoAdapter(Context context, List<Medico> medicoList) {
//        super(context,0,medicoList);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        Medico medico = getItem( position );
//
//        if(convertView == null){
//            convertView = LayoutInflater.from( getContext()).inflate( R.layout.activity_main, parent, false);
//
//        }
////        EditText edt_nome = convertView.findViewById( R.id.edit_nome);
////        EditText edt_area_atuacao = convertView.findViewById( R.id.edit_area_atuacao );
////
////        edt_nome.setText(medico.getNome().toString());
////        edt_area_atuacao.setText(medico.getArea_atuacao().toString());
//        return convertView;
//    }
//}
//
//
