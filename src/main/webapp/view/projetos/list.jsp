<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:choose>
  <c:otherwise>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>Nome</th>
        <th>Data de Início</th>
        <th>Gerente</th>
        <th>Status</th>
        <th>Ações</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="projeto" items="${projetos}">
        <tr>
          <td>${projeto.nome}</td>
          <td>${projeto.dataInicio}</td>
          <td>${projeto.gerenteResponsavel}</td>
          <td>${projeto.status}</td>
          <td>
            <a href="${pageContext.request.contextPath}/projetos/detalhes?id=${projeto.id}" class="btn btn-primary btn-sm">Visualizar/Editar</a>
            <form action="${pageContext.request.contextPath}/api/v1/projeto/${projeto.id}" method="post" style="display:inline;">
              <input type="hidden" name="_method" value="delete">
              <button type="submit" class="btn btn-danger btn-sm" ${projeto.status == 'INICIADO' || projeto.status == 'EM_ANDAMENTO' || projeto.status == 'ENCERRADO' ? 'disabled' : ''}>Excluir</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:otherwise>
</c:choose>
