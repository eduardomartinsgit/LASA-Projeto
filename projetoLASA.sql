CREATE DATABASE vendas;
use vendas;

CREATE TABLE tb_venda (
	id_venda int not null,
	data timestamp,
    loja int,
    pdv int,
    status VARCHAR(100)
);

CREATE TABLE tb_item_venda (
    id_venda int,
    id_item_venda int,
    produto VARCHAR(256),
	preco_unitario DECIMAL(4,2),
    desconto DECIMAL(4,2)
);

CREATE TABLE tb_processamento (
	id_processamento int not null auto_increment,
    data timestamp,
    loja int,
    pdv int,
    nome_arquivo VARCHAR(256),
    status VARCHAR(100),
    PRIMARY KEY (id_processamento)
);

SELECT * FROM tb_venda;
SELECT * FROM tb_item_venda;
SELECT * FROM tb_processamento;

DROP TABLE tb_processamento;
DROP TABLE tb_venda;
DROP TABLE tb_item_venda;
