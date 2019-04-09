package mz.com.xavier.meshop.model;

public enum StatusCarrinho {

    ESPERA("Em espera"),
    EFECTIVADO("Efectivado");

    private String descricao;

    StatusCarrinho(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
