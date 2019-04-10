package mz.com.xavier.meshop.model;

public enum StatusFrete {
    EMPACOTAR("empacotar"),
    ENVIAR("Enviar"),
    RECEBIDO("Recebido");

    private String descricao;

    StatusFrete(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
