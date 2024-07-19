-- Criação da Tabela projetos
CREATE TABLE projetos (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          data_inicio DATE NOT NULL,
                          gerente_responsavel VARCHAR(255) NOT NULL,
                          previsao_termino DATE NOT NULL,
                          data_real_termino DATE,
                          orcamento_total NUMERIC(10, 2) NOT NULL,
                          descricao TEXT,
                          status VARCHAR(50) NOT NULL CHECK (status IN ('em análise', 'análise realizada', 'análise aprovada', 'iniciado', 'planejado', 'em andamento', 'encerrado', 'cancelado')),
                          risco VARCHAR(50) NOT NULL CHECK (risco IN ('baixo risco', 'médio risco', 'alto risco'))
);

-- Criação da Tabela membros
CREATE TABLE membros (
                         id SERIAL PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         atribuicao VARCHAR(255) NOT NULL
);

-- Criação da Tabela projeto_membros
CREATE TABLE projeto_membros (
                                 id SERIAL PRIMARY KEY,
                                 projeto_id INT NOT NULL,
                                 membro_id INT NOT NULL,
                                 FOREIGN KEY (projeto_id) REFERENCES projetos(id) ON DELETE CASCADE,
                                 FOREIGN KEY (membro_id) REFERENCES membros(id) ON DELETE CASCADE
);

-- Função em vez de Trigger para impedir a exclusão de projetos em certos status
CREATE OR REPLACE FUNCTION check_project_delete() RETURNS TRIGGER AS $$
BEGIN
    IF OLD.status IN ('iniciado', 'em andamento', 'encerrado') THEN
        RAISE EXCEPTION 'Cannot delete project with status iniciado, em andamento or encerrado';
END IF;
RETURN OLD;
END;
$$ LANGUAGE plpgsql;

-- Trigger para usar a função acima
CREATE TRIGGER before_project_delete
    BEFORE DELETE ON projetos
    FOR EACH ROW EXECUTE FUNCTION check_project_delete();

-- Procedimento para adicionar membro via JSON (PostgreSQL usa funções em vez de procedimentos)
CREATE OR REPLACE FUNCTION add_membro(json_data JSON) RETURNS VOID AS $$
DECLARE
nome VARCHAR(255);
    atribuicao VARCHAR(255);
BEGIN
SELECT json_data->>'nome' INTO nome;
SELECT json_data->>'atribuicao' INTO atribuicao;

INSERT INTO membros (nome, atribuicao) VALUES (nome, atribuicao);
END;
$$ LANGUAGE plpgsql;
