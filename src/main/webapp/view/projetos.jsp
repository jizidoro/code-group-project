<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <title>Gestão de Projetos</title>
</head>
<body>
<div class="container">
    <h1 class="mt-4">Gestão de Projetos</h1>
    <div id="projetos-list">
        <!-- A lista de projetos será carregada aqui via AJAX -->
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination" id="pagination">
            <!-- Os links de paginação serão gerados aqui -->
        </ul>
    </nav>
</div>
<script src="resources/js/bootstrap.min.js"></script>
<script>
    const pageSize = 10; // Defina o tamanho da página
    let currentPage = 1;

    function loadProjects(pageNumber) {
        fetch(`/api/v1/projeto/get-all?pageNumber=${pageNumber}&pageSize=${pageSize}`)
            .then(response => response.json())
            .then(data => {
                const projetosList = document.getElementById('projetos-list');
                projetosList.innerHTML = '';
                data.forEach(projeto => {
                    const projetoItem = `
                            <div class="card mb-3">
                                <div class="card-body">
                                    <h5 class="card-title">${projeto.nome}</h5>
                                    <p class="card-text">${projeto.descricao}</p>
                                    <p class="card-text"><small class="text-muted">Gerente: ${projeto.gerenteResponsavel}</small></p>
                                </div>
                            </div>
                        `;
                    projetosList.innerHTML += projetoItem;
                });
                updatePagination(pageNumber);
            })
            .catch(error => console.error('Error loading projects:', error));
    }

    function updatePagination(currentPage) {
        const pagination = document.getElementById('pagination');
        pagination.innerHTML = '';

        // Supondo que tenhamos 100 páginas no total para exemplo
        const totalPages = 100;
        for (let i = 1; i <= totalPages; i++) {
            const pageItem = document.createElement('li');
            pageItem.className = 'page-item' + (i === currentPage ? ' active' : '');
            pageItem.innerHTML = `<a class="page-link" href="#" onclick="loadProjects(${i})">${i}</a>`;
            pagination.appendChild(pageItem);
        }
    }

    // Carrega a primeira página de projetos quando a página é carregada
    document.addEventListener('DOMContentLoaded', () => {
        loadProjects(currentPage);
    });
</script>
</body>
</html>
