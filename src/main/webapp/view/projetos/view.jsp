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

    <!-- Botão Incluir Projeto -->
    <a href="${pageContext.request.contextPath}/projetos/form" class="btn btn-primary mb-3">Incluir Projeto</a>


    <div id="searchResults"></div>


</div>

<script src="${pageContext.request.contextPath}/static/node_modules/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function() {
        $('#searchButton').click(function() {
            var query = $('#searchInput').val();
            console.log('Button clicked. Query:', query);
            if(query) {
                buscarProjetos(query);
            } else {
                $('#searchResults').html('<p>Por favor, insira um termo de busca.</p>');
            }
        });

        $('#searchInput').keypress(function(event) {
            if(event.which == 13) {
                var query = $('#searchInput').val();
                console.log('Enter pressed. Query:', query);
                if(query) {
                    buscarProjetos(query);
                } else {
                    $('#searchResults').html('<p>Por favor, insira um termo de busca.</p>');
                }
            }
        });

        function buscarProjetos(query) {
            console.log('Sending AJAX request to search projects.');
            $.ajax({
                url: '${pageContext.request.contextPath}/api/v1/projeto/buscar',
                type: 'GET',
                data: {
                    nome: query
                },
                success: function(data) {
                    console.log('AJAX request successful. Data:', data);
                    atualizarTabela(data);
                },
                error: function(xhr, status, error) {
                    console.log('AJAX request failed. Status:', status, 'Error:', error);
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
                tabela += '<td>' + projeto.gerenteResponsavel + '</td>';
                tabela += '<td>' + projeto.status + '</td>';
                tabela += '<td>';
                tabela += '<a href="${pageContext.request.contextPath}/projetos/detalhes?id=' + projeto.id + '" class="btn btn-primary btn-sm">Visualizar/Editar</a> ';
                tabela += '<form action="${pageContext.request.contextPath}/api/v1/projeto/' + projeto.id + '" method="post" style="display:inline;">';
                tabela += '<input type="hidden" name="_method" value="delete">';
                tabela += '<button type="submit" class="btn btn-danger btn-sm" ' + (projeto.status == 'INICIADO' || projeto.status == 'EM_ANDAMENTO' || projeto.status == 'ENCERRADO' ? 'disabled' : '') + '>Excluir</button>';
                tabela += '</form>';
                tabela += '</td>';
                tabela += '</tr>';
            });
            tabela += '</tbody></table>';
            $('#searchResults').html(tabela);
        }
    });
</script>
</body>
</html>
