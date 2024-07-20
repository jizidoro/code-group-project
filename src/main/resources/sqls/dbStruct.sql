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