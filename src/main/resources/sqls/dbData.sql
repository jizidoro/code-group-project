INSERT INTO tb_pessoa (tx_nome, dt_data_nascimento, tx_cpf, is_funcionario, is_gerente)
VALUES
    ('Mariana Almeida', '1990-05-01', '123.321.211-43', true, false),
    ('Paulo Nunes', '1980-10-12', '110.221.111-13', true, true),
    ('Julia Ribeiro', '1970-02-10', '100.024.210-10', true, true)
;

INSERT INTO tb_projeto (tx_nome, dt_data_inicio, dt_previsao_fim, dt_data_fim, tx_descricao, tx_status, num_orcamento, tx_risco, cd_gerente)
VALUES
    ('Desenvolvimento de Plataforma E-commerce', '2024-01-15', '2024-12-31', NULL, 'Plataforma completa de E-commerce para clientes B2B e B2C', 'em andamento', 50000.00, 'médio risco', 2),
    ('Implementação de Sistema CRM', '2023-05-01', '2023-12-01', '2023-11-30', 'Sistema de CRM para gestão de clientes e vendas', 'encerrado', 30000.00, 'baixo risco', 3),
    ('Atualização de Infraestrutura de TI', '2024-03-01', '2024-09-30', NULL, 'Atualização dos servidores e rede interna', 'iniciado', 20000.00, 'alto risco', 3)
;

INSERT INTO tb_membro (id_projeto, id_pessoa)
VALUES
    (1, 1), -- Mariana Almeida no projeto de E-commerce
    (2, 2), -- Paulo Nunes no projeto de CRM
    (3, 3), -- Julia Ribeiro na atualização de infraestrutura
    (1, 3)  -- Julia Ribeiro também no projeto de E-commerce
;

select * from tb_pessoa;
select * from tb_projeto;
select * from tb_membro;