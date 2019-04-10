CREATE TABLE user_account(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(250) NOT NULL,
email VARCHAR(250) NOT NULL,
password VARCHAR(500) NOT NULL,
phone VARCHAR(100),
numero_visitas INTEGER,
numero_transacoes INTEGER,
valor_total_transacao NUMERIC(19, 2),
data_criacao DATE,
PRIMARY KEY(codigo)
);

CREATE TABLE user_session(
codigo BIGSERIAL NOT NULL,
numero_clicks NUMERIC(19, 2),
data_sessao DATE NOT NULL,
codigo_user BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_user_account_user_session
  FOREIGN KEY(codigo_user) REFERENCES user_account(codigo)
);

CREATE TABLE cartao_credito(
codigo BIGSERIAL NOT NULL,
numero_cartao VARCHAR(100),
codigo_user BIGINT NOT NULL,
data_expiracao DATE,
PRIMARY KEY(codigo),
CONSTRAINT fk_cartao_credito_user_account
  FOREIGN KEY(codigo_user) REFERENCES user_account(codigo)
);

CREATE TABLE pedido_compra(
codigo BIGSERIAL NOT NULL,
data_pedido DATE,
valor_total NUMERIC(19, 2),
status VARCHAR(20) NOT NULL,
codigo_user BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_pedido_user_account
  FOREIGN KEY(codigo_user) REFERENCES user_account(codigo)
);

CREATE TABLE detalhes_pedido(
codigo BIGSERIAL NOT NULL,
codigo_produto BIGINT NOT NULL,
quantidade INTEGER NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_detalhes_pedido_codigo_produto
  FOREIGN KEY(codigo) REFERENCES produto(codigo)
);

CREATE TABLE factura(
factura_numero BIGSERIAL NOT NULL,
data_criacao DATE,
valor_total NUMERIC(19, 2) NOT NULL,
codigo_user BIGINT NOT NULL,
status VARCHAR(100) NOT NULL,
PRIMARY KEY(factura_numero),
CONSTRAINT fk_factura_user_account
  FOREIGN KEY(codigo_user) REFERENCES user_account(codigo)
);

CREATE TABLE factura_detalhes(
codigo BIGSERIAL NOT NULL,
codigo_produto BIGINT NOT NULL,
quantidade INTEGER NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_factura_factura_detalhes
  FOREIGN KEY(codigo_produto) REFERENCES produto(codigo)
);

CREATE TABLE pagamento(
codigo BIGSERIAL NOT NULL,
valor NUMERIC(19, 2) NOT NULL,
status VARCHAR(50) NOT NULL,
data_pagamento DATE,
codigo_cartao BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_pagamento_cartao_credito
  FOREIGN KEY(codigo) REFERENCES cartao_credito(codigo)
);

CREATE TABLE carrinho_compras(
codigo BIGSERIAL NOT NULL,
valor_total NUMERIC(19, 2) NOT NULL,
activo BOOLEAN NOT NULL,
data_expiracao DATE,
status VARCHAR(50) NOT NULL,
codigo_user BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_carrinho_compras_user_account
  FOREIGN KEY(codigo_user) REFERENCES user_account(codigo)
);

CREATE TABLE carrinho_detalhes(
codigo BIGSERIAL NOT NULL,
codigo_produto BIGINT NOT NULL,
quantidade INTEGER NOT NULL,
codigo_carrinho BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_carrinho_carrinho_detalhes_produto
  FOREIGN KEY(codigo_produto) REFERENCES produto(codigo),
CONSTRAINT fk_carrinho_detalhes_carrinho_compras
  FOREIGN KEY(codigo_carrinho) REFERENCES carrinho_compras(codigo)
);

CREATE TABLE endereco(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(250) NOT NULL,
end1 VARCHAR(250),
end2 VARCHAR(250),
cidade VARCHAR(100),
bairro VARCHAR(100),
av_rua VARCHAR(200),
numero_casa VARCHAR(100),
PRIMARY KEY(codigo)
);

CREATE TABLE frete(
codigo BIGSERIAL NOT NULL,
metodo_frete VARCHAR(100),
charge_code BIGINT,
status VARCHAR(100),
data_frete DATE,
valor_frete NUMERIC(19, 2) NOT NULL,
codigo_pedido BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_frete_encomenda
  FOREIGN KEY(codigo_pedido) REFERENCES pedido_compra(codigo)
);