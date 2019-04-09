package mz.com.xavier.meshop.model;

public enum StatusFactura {
    PAGA("paga"),
    CANCELADA("Cancelada"),
    NAO_PAGA("Nao paga");

    public String getDescricao() {
        return descricao;
    }

    private String descricao;

    StatusFactura(String descricao) {
        this.descricao = descricao;
    }


}
