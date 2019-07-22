CREATE TABLE permissao(
codigo BIGINT NOT NULL,
descricao VARCHAR(100) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE grupo_permissao(
codigo_grupo BIGINT NOT NULL,
codigo_permissao BIGINT NOT NULL,
PRIMARY KEY(codigo_grupo, codigo_permissao),
CONSTRAINT fk_grupo_codigo
  FOREIGN KEY(codigo_grupo) REFERENCES grupo(codigo),
CONSTRAINT fk_codigo_permissao
  FOREIGN KEY(codigo_permissao) REFERENCES permissao(codigo)
);

/*
CREATE TABLE user_account_permissao(
codigo_usuario BIGINT NOT NULL,
codigo_permissao BIGINT NOT NULL,
PRIMARY KEY(codigo_usuario, codigo_permissao),
CONSTRAINT fk_usuario_permissao
  FOREIGN KEY(codigo_usuario) REFERENCES user_account(codigo),
CONSTRAINT fk_permissao_codigo_usuario
  FOREIGN KEY(codigo_permissao) REFERENCES permissao(codigo)
);*/
