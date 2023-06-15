package dev.android.santos.applistacompras.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import dev.android.santos.applistacompras.model.Compras;
import dev.android.santos.applistacompras.view.MainActivity;

public class ComprasController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFENCES = "pref_listavip";

    public ComprasController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFENCES, 0);
        listaVip = preferences.edit();
    }

    public void salvar(Compras compras){
        Log.d("MVC_Controller", "Salvo: " + compras.toString());
        listaVip.putString("nomeItem", compras.getNomeItem());
        listaVip.putString("localCompra", compras.getLocalCompra());
    }

    public Compras procurar(Compras compras){
        compras.setNomeItem(preferences.getString("nomeItem", ""));
        compras.setLocalCompra(preferences.getString("localCompra", ""));
        return compras;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }

    @NonNull
    @Override
    public String toString(){
        Log.d("MVC_Controller", "Controller iniciada...");
        return super.toString();
    }
}
