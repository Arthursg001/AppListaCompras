package dev.android.santos.applistacompras.controller;

import java.util.ArrayList;
import java.util.List;

import dev.android.santos.applistacompras.model.Carrinho;

public class CarrinhoController {
    private List listaCompras;

    public List getListaCompras() {
        listaCompras = new ArrayList<Carrinho>();

        listaCompras.add(new Carrinho("1"));
        listaCompras.add(new Carrinho("2"));
        listaCompras.add(new Carrinho("3"));
        listaCompras.add(new Carrinho("4"));
        listaCompras.add(new Carrinho("5"));
        listaCompras.add(new Carrinho("6"));
        listaCompras.add(new Carrinho("7"));
        listaCompras.add(new Carrinho("8"));
        listaCompras.add(new Carrinho("9"));
        listaCompras.add(new Carrinho("10"));

        return listaCompras;
    }

    public ArrayList<String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCompras().size(); i++){
            Carrinho objeto = (Carrinho) getListaCompras().get(i);
            dados.add(objeto.getQtdDesejada());
        }
        return dados;
    }
}
