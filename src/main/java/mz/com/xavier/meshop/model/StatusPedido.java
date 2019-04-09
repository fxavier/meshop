package mz.com.xavier.meshop.model;

public enum StatusPedido {

    CANCELADO("Cancelado"),
    APROVADO("Aprovado");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }


}
