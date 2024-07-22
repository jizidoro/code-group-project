<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/css/bootstrap.min.css">
    <title>Gestão de Projetos</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            flex: 1;
        }
        footer {
            background-color: #f8f9fa;
            padding: 10px 0;
            text-align: center;
            width: 100%;
            bottom: 0;
            position: absolute;
        }
        .form-control-margin-right {
            margin-right: 1%;
        }
    </style>
</head>
<body>
<%@ include file="../includes/header.jsp" %>

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="mt-4">Gestão de Projetos</h1>
        <!-- Botão Incluir Projeto -->
        <a href="${pageContext.request.contextPath}/projetos/form" class="btn btn-primary">Incluir Projeto</a>
    </div>

    <!-- Nova Barra de Busca -->
    <div class="input-group mb-3">
        <input type="text" id="searchInput" class="form-control form-control-margin-right" placeholder="Buscar">
        <div class="input-group-append">
            <button class="btn btn-primary" type="button" id="searchButton">Buscar</button>
        </div>
    </div>
    <div id="searchResults"></div>
</div>

<%@ include file="../includes/footer.jsp" %>

<script src="${pageContext.request.contextPath}/static/node_modules/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function() {
        carregarProjetos(1, 10);

        $('#searchButton').click(function() {
            var query = $('#searchInput').val();
            if(query) {
                buscarProjetos(query);
            } else {
                $('#searchResults').html('<p>Por favor, insira um termo de busca.</p>');
            }
        });

        $('#searchInput').keypress(function(event) {
            if(event.which == 13) {
                var query = $('#searchInput').val();
                if(query) {
                    buscarProjetos(query);
                } else {
                    $('#searchResults').html('<p>Por favor, insira um termo de busca.</p>');
                }
                event.preventDefault();
            }
        });

        function carregarProjetos(pageNumber, pageSize) {
            $.ajax({
                url: '${pageContext.request.contextPath}/api/v1/projeto/get-all',
                type: 'GET',
                data: {
                    pageNumber: pageNumber,
                    pageSize: pageSize
                },
                success: function(data) {
                    atualizarTabela(data);
                },
                error: function(xhr, status, error) {
                    $('#searchResults').html('<p>Erro ao carregar projetos.</p>');
                }
            });
        }

        function buscarProjetos(query) {
            $.ajax({
                url: '${pageContext.request.contextPath}/api/v1/projeto/buscar',
                type: 'GET',
                data: {
                    nome: query
                },
                success: function(data) {
                    atualizarTabela(data);
                },
                error: function(xhr, status, error) {
                    $('#searchResults').html('<p>Erro ao buscar projetos.</p>');
                }
            });
        }

        function atualizarTabela(projetos) {
            var tabela = '<table class="table table-striped">';
            tabela += '<thead><tr><th>Nome</th><th>Data de Início</th><th>Gerente</th><th>Status</th><th>Ações</th></tr></thead><tbody>';
            projetos.forEach(function(projeto) {
                tabela += '<tr>';
                tabela += '<td>' + projeto.nome + '</td>';
                tabela += '<td>' + projeto.dataInicio + '</td>';
                tabela += '<td>' + projeto.gerente + '</td>';
                tabela += '<td>' + projeto.status + '</td>';
                tabela += '<td>';
                tabela += '<a href="${pageContext.request.contextPath}/projetos/detalhes?id=' + projeto.id + '" class="btn btn-primary btn-sm">Visualizar/Editar</a> ';
                tabela += '<button type="button" class="btn btn-danger btn-sm delete-button" data-id="' + projeto.id + '"' + (projeto.status == 'INICIADO' || projeto.status == 'EM_ANDAMENTO' || projeto.status == 'ENCERRADO' ? ' disabled' : '') + '>Excluir</button>';
                tabela += '</td>';
                tabela += '</tr>';
            });
            tabela += '</tbody></table>';
            $('#searchResults').html(tabela);

            $('.delete-button').click(function() {
                var projectId = $(this).data('id');
                if (confirm('Tem certeza que deseja excluir este projeto?')) {
                    $.ajax({
                        url: '${pageContext.request.contextPath}/api/v1/projeto/' + projectId,
                        type: 'DELETE',
                        success: function(result) {
                            carregarProjetos(1, 10);
                        },
                        error: function(xhr, status, error) {
                            alert('Erro ao excluir o projeto.');
                        }
                    });
                }
            });
        }
    });
</script>
</body>
</html>
