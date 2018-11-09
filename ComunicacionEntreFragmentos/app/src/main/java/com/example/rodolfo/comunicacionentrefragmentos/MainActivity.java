package com.example.rodolfo.comunicacionentrefragmentos;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentoEmisor.IEnviarmensaje{

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enviarMensaje(String mensaje) {
        //Implementacion
        Fragment fragmento = getSupportFragmentManager().findFragmentById(R.id.fragmento_receptor);
        if (fragmento instanceof FragmentoReceptor){
            FragmentoReceptor fragmentoReceptor = (FragmentoReceptor) fragmento;
            fragmentoReceptor.actualizarVista(mensaje);
        }

    }
}
