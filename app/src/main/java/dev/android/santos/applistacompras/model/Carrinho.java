package dev.android.santos.applistacompras.model;

public class Carrinho {
    private String qtdDesejada;

    public Carrinho() {
    }

    public Carrinho(String qtdDesejada){
        this.qtdDesejada = qtdDesejada;
    }

    public String getQtdDesejada() {
        return qtdDesejada;
    }

    public void setQtdDesejada(String itemDesejado) {
        this.qtdDesejada = itemDesejado;
    }
}
