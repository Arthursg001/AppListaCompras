package dev.android.santos.applistacompras.model;

public class Compras {
    private String nomeItem;
    private String qtdDesejada;
    private String localCompra;

    public Compras() {
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getQtdDesejada() {
        return qtdDesejada;
    }

    public void setQtdDesejada(String qtdDesejada) {
        this.qtdDesejada = qtdDesejada;
    }

    public String getLocalCompra() {
        return localCompra;
    }

    public void setLocalCompra(String localCompra) {
        this.localCompra = localCompra;
    }
}
