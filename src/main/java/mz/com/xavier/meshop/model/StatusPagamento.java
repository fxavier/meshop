package mz.com.xavier.meshop.model;

public enum StatusPagamento {

    ESPERA("Em espera"),
    EFECTIVADO("Efectivado");

    private String descricao;

    StatusPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
