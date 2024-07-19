INSERT INTO projetos (nome, data_inicio, gerente_responsavel, previsao_termino, data_real_termino, orcamento_total, descricao, status, risco)
VALUES
    ('Desenvolvimento de Plataforma E-commerce', '2024-01-15', 'Maria Silva', '2024-12-31', NULL, 50000.00, 'Plataforma completa de E-commerce para clientes B2B e B2C', 'em andamento', 'médio risco'),
    ('Implementação de Sistema CRM', '2023-05-01', 'João Pereira', '2023-12-01', '2023-11-30', 30000.00, 'Sistema de CRM para gestão de clientes e vendas', 'encerrado', 'baixo risco'),
    ('Atualização de Infraestrutura de TI', '2024-03-01', 'Ana Costa', '2024-09-30', NULL, 20000.00, 'Atualização dos servidores e rede interna', 'iniciado', 'alto risco');


select * from projetos
select * from projeto_membros

    INSERT INTO membros (nome, atribuicao)
VALUES
    ('Mariana Almeida', 'Designer'),
    ('Paulo Nunes', 'Administrador de Banco de Dados'),
    ('Julia Ribeiro', 'Engenheira de Software');

INSERT INTO projeto_membros (projeto_id, membro_id)
VALUES
    (1, 4), -- Mariana Almeida no projeto de E-commerce
    (2, 5), -- Paulo Nunes no projeto de CRM
    (3, 6), -- Julia Ribeiro na atualização de infraestrutura
    (1, 6), -- Julia Ribeiro também no projeto de E-commerce
    (2, 1), -- Carlos Sousa no projeto de CRM
    (3, 2); -- Fernanda Lima na atualização de infraestrutura
