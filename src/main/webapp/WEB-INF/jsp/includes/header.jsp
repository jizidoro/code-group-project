<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <button class="btn btn-outline-secondary me-2" type="button" onclick="history.back();">
      <i class="fas fa-arrow-left"></i> Voltar
    </button>
    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/index">
      <i class="fas fa-home"></i> Home
    </a>
    <div class="collapse navbar-collapse justify-content-center">
      <a class="navbar-brand mx-auto" href="${pageContext.request.contextPath}/index">
        Desafio Java Jhonatan
      </a>
    </div>
  </div>
</nav>
