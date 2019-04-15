ALTER TABLE factura_detalhes
ADD COLUMN codigo_factura BIGINT NOT NULL,
ADD CONSTRAINT fk_factura_detalhes_factura
  FOREIGN KEY(codigo_factura) REFERENCES factura(factura_numero);