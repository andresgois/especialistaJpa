insert into tb_produto (id,nome,preco, descricao) values (1,'Kindle', 499.0,'Conheça o novo kindle');
insert into tb_produto (id,nome,preco, descricao) values (3,'Java TDD', 879.90,'Livro de programação em Java');

insert into tb_cliente (id, nome,sexo) values (1,'André Gois','MASCULINO');
insert into tb_cliente (id, nome,sexo) values (2,'Andreia Erica','FEMININO');
insert into tb_cliente (id, nome,sexo) values (3,'Ana Beatriz','FEMININO');

insert into tb_pedido (id, cliente_id, data_pedido, total, status) values (1,1, sysdate(), 1000.0, 'AGUARDADO');

insert into tb_item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1,1,1,5.0,2);

insert into tb_categoria (id, nome) values (2, "Eletrodomésticos");