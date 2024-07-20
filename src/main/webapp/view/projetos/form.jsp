<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/css/bootstrap.min.css">
  <title>Incluir Projeto</title>
</head>
<body>
<div class="container">
  <h1 class="mt-4">Incluir Projeto</h1>
  <form action="${pageContext.request.contextPath}/api/v1/projeto" method="post">
    <div class="form-group">
      <label for="nome">Nome do Projeto</label>
      <input type="text" class="form-control" id="nome" name="nome" required>
    </div>
    <div class="form-group">
      <label for="dataInicio">Data de Início</label>
      <input type="date" class="form-control" id="dataInicio" name="dataInicio" required>
    </div>
    <div class="form-group">
      <label for="gerenteResponsavel">Gerente Responsável</label>
      <input type="text" class="form-control" id="gerenteResponsavel" name="gerenteResponsavel" required>
    </div>
    <div class="form-group">
      <label for="previsaoTermino">Previsão de Término</label>
      <input type="date" class="form-control" id="previsaoTermino" name="previsaoTermino" required>
    </div>
    <div class="form-group">
      <label for="dataRealTermino">Data Real de Término</label>
      <input type="date" class="form-control" id="dataRealTermino" name="dataRealTermino">
    </div>
    <div class="form-group">
      <label for="orcamentoTotal">Orçamento Total</label>
      <input type="number" step="0.01" class="form-control" id="orcamentoTotal" name="orcamentoTotal" required>
    </div>
    <div class="form-group">
      <label for="descricao">Descrição</label>
      <textarea class="form-control" id="descricao" name="descricao" required></textarea>
    </div>
    <div class="form-group">
      <label for="risco">Classificação de Risco</label>
      <select class="form-control" id="risco" name="risco" required>
        <option value="BAIXO">Baixo Risco</option>
        <option value="MEDIO">Médio Risco</option>
        <option value="ALTO">Alto Risco</option>
      </select>
    </div>
    <div class="form-group">
      <label for="status">Status</label>
      <select class="form-control" id="status" name="status" required>
        <option value="EM_ANALISE">Em Análise</option>
        <option value="ANALISE_REALIZADA">Análise Realizada</option>
        <option value="ANALISE_APROVADA">Análise Aprovada</option>
        <option value="INICIADO">Iniciado</option>
        <option value="PLANEJADO">Planejado</option>
        <option value="EM_ANDAMENTO">Em Andamento</option>
        <option value="ENCERRADO">Encerrado</option>
        <option value="CANCELADO">Cancelado</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Salvar</button>
  </form>
</div>
<script src="${pageContext.request.contextPath}/static/node_modules/jquery/dist/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
