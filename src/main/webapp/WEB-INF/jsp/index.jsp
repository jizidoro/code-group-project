<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Desafio Java</title>

    <link href="<c:url value='/static/node_modules/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            flex: 1;
        }
        .btn-custom {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<%@ include file="includes/header.jsp" %>

<div class="container mt-5">
    <h1 class="mb-4">Bem-vindo à Gestão de Projetos</h1>
    <div class="mb-4">
        <a href="${pageContext.request.contextPath}/projetos" class="btn btn-primary btn-custom">Projetos</a>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>

<script src="<c:url value='/static/node_modules/jquery/dist/jquery.min.js'/>"></script>
<script src="<c:url value='/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>
