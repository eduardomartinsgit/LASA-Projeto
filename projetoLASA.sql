CREATE DATABASE projetoLASA;
use projetoLASA;

CREATE TABLE tb_venda (
	id_venda int not null,
	data Date,
    loja int,
    pdv int,
    status VARCHAR(100),
	PRIMARY KEY (id_venda)
);

CREATE TABLE tb_item_venda (
    id_venda int,
    id_item_venda int not null,
    produto VARCHAR(256),
	preco_unitario DECIMAL,
    desconto decimal,
    PRIMARY KEY (id_item_venda),
    FOREIGN KEY (id_venda) REFERENCES tb_venda(id_venda)
);

CREATE TABLE tb_processamento (
	id_processamento int not null auto_increment,
    data Date,
    loja int,
    pdv int,
    nome_arquivo VARCHAR(256),
    status VARCHAR(100),
    PRIMARY KEY (id_processamento)
);