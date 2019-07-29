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
preco_antigo NUMERIC(19, 2),
preco_novo NUMERIC(19, 2) NOT NULL,
quantidade BIGINT,
codigo_subcategoria BIGINT,
codigo_imagem BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_produto_subcategoria
  FOREIGN KEY(codigo_subcategoria) REFERENCES subcategoria(codigo)
);

CREATE TABLE imagem(
codigo BIGSERIAL NOT NULL,
imagem_url VARCHAR(250) NOT NULL,
content_type VARCHAR,
codigo_produto BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_produto_imagem
  FOREIGN KEY(codigo_produto) REFERENCES produto(codigo)
);
