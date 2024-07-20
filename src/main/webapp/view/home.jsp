<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/css/bootstrap.min.css">
    <title>Bem-vindo</title>
</head>
<body>
<div class="container">
    <h1 class="mt-4">Bem-vindo à Gestão de Projetos</h1>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/projetos" class="btn btn-primary">Projetos</a>
        <a href="${pageContext.request.contextPath}/membros" class="btn btn-secondary">Membros</a>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/node_modules/jquery/dist/jquery.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
