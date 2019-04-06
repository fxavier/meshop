CREATE TABLE categoria(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE subcategoria(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
codigo_categoria BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_categoria_subcategoria
  FOREIGN KEY(codigo_categoria) REFERENCES categoria(codigo)
);

