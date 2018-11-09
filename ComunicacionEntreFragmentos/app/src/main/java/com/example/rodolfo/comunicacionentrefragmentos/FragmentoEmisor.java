package com.example.rodolfo.comunicacionentrefragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentoEmisor extends Fragment {

    private IEnviarmensaje implementacion;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof IEnviarmensaje){
             this.implementacion = (IEnviarmensaje) context;
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_emisor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText editMensaje = view.findViewById(R.id.edit_mensaje);

        Button button = view.findViewById(R.id.btn_enviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementacion.enviarMensaje(editMensaje.getText().toString());
            }
        });
    }

    public interface IEnviarmensaje{
        void enviarMensaje(String mensaje);
    }

}
