-- Criação da Tabela pessoa
CREATE TABLE tb_pessoa (
                           id_pessoa           BIGSERIAL       NOT NULL,
                           tx_nome             VARCHAR(100)    NOT NULL,
                           dt_data_nascimento  DATE            NOT NULL,
                           tx_cpf              VARCHAR(14)     NOT NULL,
                           is_funcionario      BOOLEAN                 ,
                           is_gerente          BOOLEAN                 ,
                           CONSTRAINT pk_pessoa PRIMARY KEY (id_pessoa)
);

-- Criação da Tabela projeto
CREATE TABLE tb_projeto (
                            id_projeto          BIGSERIAL       NOT NULL,
                            tx_nome             VARCHAR(200)    NOT NULL,
                            dt_data_inicio      DATE                    ,
                            dt_previsao_fim     DATE                    ,
                            dt_data_fim         DATE                    ,
                            tx_descricao        VARCHAR(5000)           ,
                            tx_status           VARCHAR(45)     CHECK (tx_status IN ('em análise', 'análise realizada', 'análise aprovada', 'iniciado', 'planejado', 'em andamento', 'encerrado', 'cancelado')),
                            num_orcamento       FLOAT                   ,
                            tx_risco            VARCHAR(45)     CHECK (tx_risco IN ('baixo risco', 'médio risco', 'alto risco')),
                            cd_gerente          BIGINT          NOT NULL,
                            CONSTRAINT pk_projeto PRIMARY KEY (id_projeto),
                            CONSTRAINT fk_gerente FOREIGN KEY (cd_gerente) REFERENCES tb_pessoa (id_pessoa) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Criação da Tabela membro
CREATE TABLE tb_membro (
                           id_membro           BIGSERIAL       NOT NULL,
                           id_projeto          BIGINT          NOT NULL,
                           id_pessoa           BIGINT          NOT NULL,
                           CONSTRAINT pk_membro PRIMARY KEY (id_membro),
                           CONSTRAINT fk_projeto FOREIGN KEY (id_projeto) REFERENCES tb_projeto (id_projeto) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
                           CONSTRAINT fk_pessoa FOREIGN KEY (id_pessoa) REFERENCES tb_pessoa (id_pessoa) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Função em vez de Trigger para impedir a exclusão de projetos em certos status
CREATE OR REPLACE FUNCTION func_check_project_delete() RETURNS TRIGGER AS $$
BEGIN
    IF OLD.tx_status IN ('iniciado', 'em andamento', 'encerrado') THEN
        RAISE EXCEPTION 'Não é possível apagar um projeto com tx_status iniciado, em andamento or encerrado';
END IF;
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

-- Trigger para usar a função acima
CREATE TRIGGER trig_before_project_delete
    BEFORE DELETE ON tb_projeto
    FOR EACH ROW EXECUTE FUNCTION func_check_project_delete();


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