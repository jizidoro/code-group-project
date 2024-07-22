<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/css/bootstrap.min.css">
  <title>Incluir Projeto</title>
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
      display: flex;
      justify-content: flex-end;
    }
  </style>
</head>
<body>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-4">
  <div class="form-container">
    <h1 class="mb-4 text-center">Incluir Projeto</h1>
    <form id="projetoForm" method="post">
      <div class="form-group mb-3">
        <label for="nome">Nome do Projeto</label>
        <input type="text" class="form-control" id="nome" name="nome" required>
      </div>
      <div class="form-group mb-3">
        <label for="dataInicio">Data de Início</label>
        <input type="date" class="form-control" id="dataInicio" name="dataInicio" required>
      </div>
      <div class="form-group mb-3">
        <label for="idGerenteResponsavel">ID do Gerente Responsável</label>
        <input type="number" class="form-control" id="idGerenteResponsavel" name="idGerenteResponsavel" required>
      </div>
      <div class="form-group mb-3">
        <label for="previsaoTermino">Previsão de Término</label>
        <input type="date" class="form-control" id="previsaoTermino" name="previsaoTermino" required>
      </div>
      <div class="form-group mb-3">
        <label for="dataRealTermino">Data Real de Término</label>
        <input type="date" class="form-control" id="dataRealTermino" name="dataRealTermino">
      </div>
      <div class="form-group mb-3">
        <label for="orcamentoTotal">Orçamento Total</label>
        <input type="number" step="0.01" class="form-control" id="orcamentoTotal" name="orcamentoTotal" required>
      </div>
      <div class="form-group mb-3">
        <label for="descricao">Descrição</label>
        <textarea class="form-control" id="descricao" name="descricao" rows="3" required></textarea>
      </div>
      <div class="form-group mb-3">
        <label for="risco">Classificação de Risco</label>
        <select class="form-control" id="risco" name="risco" required>
          <option value="BAIXO">Baixo Risco</option>
          <option value="MEDIO">Médio Risco</option>
          <option value="ALTO">Alto Risco</option>
        </select>
      </div>
      <div class="form-group mb-3">
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
      <div class="form-actions">
        <a href="${pageContext.request.contextPath}/projetos" class="btn btn-secondary me-2">Cancelar</a>
        <button type="submit" class="btn btn-primary">Salvar</button>
      </div>
    </form>
  </div>
</div>

<%@ include file="../includes/footer.jsp" %>

<script src="${pageContext.request.contextPath}/static/node_modules/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script>
  $(document).ready(function() {
    $('#projetoForm').on('submit', function(event) {
      event.preventDefault();
      if (!this.checkValidity()) {
        event.stopPropagation();
        $(this).addClass('was-validated');
      } else {
        var riscoMap = {
          'BAIXO': 'baixo risco',
          'MEDIO': 'médio risco',
          'ALTO': 'alto risco'
        };

        var statusMap = {
          'EM_ANALISE': 'em análise',
          'ANALISE_REALIZADA': 'análise realizada',
          'ANALISE_APROVADA': 'análise aprovada',
          'INICIADO': 'iniciado',
          'PLANEJADO': 'planejado',
          'EM_ANDAMENTO': 'em andamento',
          'ENCERRADO': 'encerrado',
          'CANCELADO': 'cancelado'
        };

        var formData = {
          nome: $('#nome').val(),
          dataInicio: $('#dataInicio').val(),
          gerente: $('#idGerenteResponsavel').val(),
          previsaoFim: $('#previsaoTermino').val(),
          dataFim: $('#dataRealTermino').val(),
          orcamento: $('#orcamentoTotal').val(),
          descricao: $('#descricao').val(),
          risco: riscoMap[$('#risco').val()],
          status: statusMap[$('#status').val()]
        };

        $.ajax({
          type: 'POST',
          url: '${pageContext.request.contextPath}/api/v1/projeto',
          contentType: 'application/json',
          data: JSON.stringify(formData),
          success: function(response) {
            window.location.href = '${pageContext.request.contextPath}/projetos';
          },
          error: function() {
            window.location.href = '${pageContext.request.contextPath}/projetos?success=false';
          }
        });
      }
    });
  });
</script>
</body>
</html>
