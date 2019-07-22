CREATE TABLE grupo(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE user_account(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
sobrenome VARCHAR(50),
apelido VARCHAR(50) NOT NULL,
email VARCHAR(250) NOT NULL,
password VARCHAR(500) NOT NULL,
phone VARCHAR(100),
numero_visitas INTEGER,
numero_transacoes INTEGER,
valor_total_transacao NUMERIC(19, 2),
data_criacao DATE,
PRIMARY KEY(codigo)

);

CREATE TABLE usuario_grupo(
codigo_usuario BIGINT NOT NULL,
codigo_grupo BIGINT NOT NULL,
PRIMARY KEY(codigo_usuario, codigo_grupo),
CONSTRAINT fk_usuario
  FOREIGN KEY(codigo_usuario) REFERENCES user_account(codigo),
CONSTRAINT fk_grupo
  FOREIGN KEY(codigo_grupo) REFERENCES grupo(codigo)
);



CREATE TABLE produto(
codigo BIGSERIAL NOT NULL,
sku VARCHAR(50),
nome VARCHAR(250) NOT NULL,
descricao TEXT,
preco_compra NUMERIC(19, 2) NOT NULL,
preco_venda NUMERIC(19, 2) NOT NULL,
iva NUMERIC(19, 2) NOT NULL,
preco_iva NUMERIC(19, 2) NOT NULL,
outras_despesas NUMERIC(19, 2) NOT NULL,
lucro NUMERIC(19, 2),
stock_min BIGINT NOT NULL,
stock_max BIGINT NOT NULL,
quantidade BIGINT,
image1 VARCHAR(100),
content_type1 VARCHAR(100),
image2 VARCHAR(100),
content_type2 VARCHAR(100),
image3 VARCHAR(100),
content_type3 VARCHAR(100),
image4 VARCHAR(100),
content_type4 VARCHAR(100),
image5 VARCHAR(100),
content_type5 VARCHAR(100),
image6 VARCHAR(100),
content_type6 VARCHAR(100),
codigo_subcategoria BIGINT NOT NULL,
codigo_user BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_produto_subcategoria
  FOREIGN KEY(codigo_subcategoria) REFERENCES subcategoria(codigo),
CONSTRAINT fk_produto_user
  FOREIGN KEY(codigo_user) REFERENCES user_account(codigo)
);

