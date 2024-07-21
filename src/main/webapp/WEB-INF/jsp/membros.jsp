<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <title>Gestão de Membros</title>
</head>
<body>
<div class="container">
    <h1 class="mt-4">Gestão de Membros</h1>
    <form id="membroForm">
        <div class="form-group">
            <label for="nome">Nome do Membro</label>
            <input type="text" class="form-control" id="nome" name="nome" required>
        </div>
        <div class="form-group">
            <label for="cargo">Cargo</label>
            <input type="text" class="form-control" id="cargo" name="cargo" required>
        </div>
        <button type="submit" class="btn btn-primary">Salvar Membro</button>
    </form>

    <h2 class="mt-5">Associar Membro ao Projeto</h2>
    <form id="associarMembroForm">
        <div class="form-group">
            <label for="membroId">ID do Membro</label>
            <input type="number" class="form-control" id="membroId" name="membroId" required>
        </div>
        <div class="form-group">
            <label for="projetoId">ID do Projeto</label>
            <input type="number" class="form-control" id="projetoId" name="projetoId" required>
        </div>
        <button type="submit" class="btn btn-primary">Associar</button>
    </form>
</div>
<script src="resources/js/bootstrap.min.js"></script>
<script>
    document.getElementById('membroForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const nome = document.getElementById('nome').value;
        const cargo = document.getElementById('cargo').value;

        fetch('/api/v1/membros', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nome, cargo })
        })
            .then(response => response.json())
            .then(data => {
                alert('Membro salvo com sucesso!');
                document.getElementById('membroForm').reset();
            })
            .catch(error => console.error('Erro ao salvar membro:', error));
    });

    document.getElementById('associarMembroForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const membroId = document.getElementById('membroId').value;
        const projetoId = document.getElementById('projetoId').value;

        fetch('/api/v1/membros/associar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ membroId, projetoId })
        })
            .then(response => response.json())
            .then(data => {
                alert('Membro associado ao projeto com sucesso!');
                document.getElementById('associarMembroForm').reset();
            })
            .catch(error => console.error('Erro ao associar membro ao projeto:', error));
    });
</script>
</body>
</html>
