<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/css/bootstrap.min.css">
    <title>Gestão de Projetos</title>
</head>
<body>
<div class="container mt-5">
    <h1 class="mt-4">Gestão de Projetos</h1>

    <!-- Nova Barra de Busca -->
    <div class="input-group mb-3">
        <input type="text" id="searchInput" class="form-control" placeholder="Buscar">
        <div class="input-group-append">
            <button class="btn btn-primary" type="button" id="searchButton">Buscar</button>
        </div>
    </div>
    <div id="searchResults"></div>

    <!-- Botão Incluir Projeto -->
    <a href="${pageContext.request.contextPath}/projetos/form" class="btn btn-primary mb-3">Incluir Projeto</a>

    <!-- Inclusão da Lista de Projetos -->
    <jsp:include page="list.jsp"/>
</div>

<script src="${pageContext.request.contextPath}/static/node_modules/jquery/dist/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function() {
        $('#searchButton').click(function() {
            var query = $('#searchInput').val();
            if(query) {
                $('#searchResults').html('<p>Você buscou por: ' + query + '</p>');
                // Adicione a lógica de pesquisa aqui
            } else {
                $('#searchResults').html('<p>Por favor, insira um termo de busca.</p>');
            }
        });
    });
</script>
</body>
</html>
