<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/css/bootstrap.min.css">
  <title>Detalhes do Projeto</title>
  <style>
    .form-container {
      max-width: 800px;
      margin: auto;
      padding: 20px;
      background-color: #f7f7f7;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .form-actions {
      margin-top: 20px;
    }
  </style>
</head>
<body>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-4">
  <div class="form-container">
    <h1 class="mb-4 text-center">Detalhes do Projeto</h1>
    <form id="projetoForm" method="post">
      <div class="form-group mb-3">
        <label for="nome">Nome do Projeto</label>
        <input type="text" class="form-control" id="nome" name="nome" value="${projeto.nome}" required>
      </div>
      <div class="form-group mb-3">
        <label for="dataInicio">Data de Início</label>
        <input type="date" class="form-control" id="dataInicio" name="dataInicio" value="${projeto.dataInicio}" required>
      </div>
      <div class="form-group mb-3">
        <label for="gerenteResponsavel">Gerente Responsável</label>
        <input type="text" class="form-control" id="gerenteResponsavel" name="gerenteResponsavel" value="${projeto.gerenteResponsavel}" required>
      </div>
      <div class="form-group mb-3">
        <label for="previsaoTermino">Previsão de Término</label>
        <input type="date" class="form-control" id="previsaoTermino" name="previsaoTermino" value="${projeto.previsaoTermino}" required>
      </div>
      <div class="form-group mb-3">
        <label for="dataRealTermino">Data Real de Término</label>
        <input type="date" class="form-control" id="dataRealTermino" name="dataRealTermino" value="${projeto.dataRealTermino}">
      </div>
      <div class="form-group mb-3">
        <label for="orcamentoTotal">Orçamento Total</label>
        <input type="number" step="0.01" class="form-control" id="orcamentoTotal" name="orcamentoTotal" value="${projeto.orcamentoTotal}" required>
      </div>
      <div class="form-group mb-3">
        <label for="descricao">Descrição</label>
        <textarea class="form-control" id="descricao" name="descricao" rows="3" required>${projeto.descricao}</textarea>
      </div>
      <div class="form-group mb-3">
        <label for="risco">Classificação de Risco</label>
        <select class="form-control" id="risco" name="risco" required>
          <option value="BAIXO" ${projeto.risco == 'BAIXO' ? 'selected' : ''}>Baixo Risco</option>
          <option value="MEDIO" ${projeto.risco == 'MEDIO' ? 'selected' : ''}>Médio Risco</option>
          <option value="ALTO" ${projeto.risco == 'ALTO' ? 'selected' : ''}>Alto Risco</option>
        </select>
      </div>
      <div class="form-group mb-3">
        <label for="status">Status</label>
        <select class="form-control" id="status" name="status" required>
          <option value="EM_ANALISE" ${projeto.status == 'EM_ANALISE' ? 'selected' : ''}>Em Análise</option>
          <option value="ANALISE_REALIZADA" ${projeto.status == 'ANALISE_REALIZADA' ? 'selected' : ''}>Análise Realizada</option>
          <option value="ANALISE_APROVADA" ${projeto.status == 'ANALISE_APROVADA' ? 'selected' : ''}>Análise Aprovada</option>
          <option value="INICIADO" ${projeto.status == 'INICIADO' ? 'selected' : ''}>Iniciado</option>
          <option value="PLANEJADO" ${projeto.status == 'PLANEJADO' ? 'selected' : ''}>Planejado</option>
          <option value="EM_ANDAMENTO" ${projeto.status == 'EM_ANDAMENTO' ? 'selected' : ''}>Em Andamento</option>
          <option value="ENCERRADO" ${projeto.status == 'ENCERRADO' ? 'selected' : ''}>Encerrado</option>
          <option value="CANCELADO" ${projeto.status == 'CANCELADO' ? 'selected' : ''}>Cancelado</option>
        </select>
      </div>
      <div class="form-actions">
        <button type="submit" class="btn btn-primary">Salvar</button>
        <a href="${pageContext.request.contextPath}/projetos" class="btn btn-primary btn-custom">Cancelar</a>
      </div>
    </form>
    <form action="${pageContext.request.contextPath}/api/v1/projeto/${projeto.id}" method="post" class="mt-3">
      <input type="hidden" name="_method" value="delete">
      <button type="submit" class="btn btn-danger" ${projeto.status == 'INICIADO' || projeto.status == 'EM_ANDAMENTO' || projeto.status == 'ENCERRADO' ? 'disabled' : ''}>Excluir</button>
    </form>
  </div>
</div>

<%@ include file="../includes/footer.jsp" %>

<script src="${pageContext.request.contextPath}/static/node_modules/jquery/dist/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script>
  $(document).ready(function() {
    const projectId = '${projeto.id}';
    const form = $('#projetoForm');

    if (projectId) {
      form.attr('action', `${pageContext.request.contextPath}/api/v1/projeto/${projectId}`);
      form.prepend('<input type="hidden" name="_method" value="put">');
    } else {
      form.attr('action', `${pageContext.request.contextPath}/api/v1/projeto`);
    }

    form.on('submit', function(event) {
      if (!this.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
        $(this).addClass('was-validated');
      }
    });
  });
</script>
</body>
</html>
