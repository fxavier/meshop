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
img_url1 VARCHAR(500),
img_url2 VARCHAR(500),
img_url3 VARCHAR(500),
img_url4 VARCHAR(500),
img_url5 VARCHAR(500),
img_url6 VARCHAR(500),
codigo_subcategoria BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_produto_subcategoria
  FOREIGN KEY(codigo_subcategoria) REFERENCES subcategoria(codigo)
);

