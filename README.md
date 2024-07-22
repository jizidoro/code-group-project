# DEVAFIO-JAVA-JHONATAN

## Introdução:
Esse projeto visa modelar e desenvolver uma aplicação que gerencia e organiza os dados de portifólio de projetos de uma empresa.
 
O sistema permite cadastrar e organizar cada projeto específico e permite associar funcionários como membros desse projeto.

## Estruturas:
- "src/main/java": Código fonte principal da aplicação.
  - "api": Pacote com as classes e controladores (responsáveis pelas requisições HTTP) necessários para a comunicação entre o Swagger e os serviços da aplicação.
  - "application": Contém as classes de serviço que implementam a lógica de negócios, assim como seus dtos, mapeadores (dto <-> entidade) e outras classes relacionadas.
  - "core": Possui os casos de uso e a lógica central do sistema.
  - "domain/models": Classes de entidades que representam os modelos mapeados do banco de dados usadas pela aplicação.
  - "config": Contém classes relacionadas à infraestrutura do projeto como configurações Web, mensagens, banco de dados e casos de uso.
  - "persistence/repositories": Interfaces/implementações dos repositórios que interagem com o banco de dados via Jpa.
- "src/main/resources": Arquivos de recursos que não são código-fonte Java, como arquivos de configuração.
- "src/main/webapp": Paconte com os recursos web da aplicação, como arquivos estáticos (CSS, JavaScript, imagens) e configuração web e páginas JSP (WEB_INF).
- "src/test/java": Pacote que possui todos os testes unitários da aplicação.

## Tecnologias:
- Java 17
- Maven 3.9.8
- Spring Boot 2.6.6
- Servlet API 4.0.1
- JSP 2.3, HTML 5, JS, CSS, BootStrap 5.2.3, JQuery 3.6.1
- Swagger 1.5.12, Lombok 1.18.24, Mapstruct 1.5.2.Final, JPA 2.6.3
- JUnit com Mockito
- Docker 3.8 (docker-compose)
- Tomcat 9.0.74 (Porta 8080)
- PostgreSQL 14 (drive 42.2.23, Porta 5432)
- SonarQube Community 10.6.0.92116 (Porta 9000)

## Instalar e Executar:
1. Para limpar e instalar a aplicação Maven use:
    ```bash
    $ mvn clean install -DskipTests
    ```
2. Para criar e rodar a aplicação Spring Boot, execute o comando:
    ```bash
    $ mvn spring-boot:run
    ```
3. Para rodar os testes unitários:
   ```bash
    $ mvn test
    ```

## Acessar:
- Frontend (JSP): http://localhost:8080
- Backend (Swagger): http://localhost:8080/swagger-ui.html
- SonarQube: http://localhost:9000

## Próximos Passos:
- Aprimorar as regras de negócio implementadas para refletir melhor a realidade.
- Adicionar um sistema de notificações para alertar os usuários sobre prazos e mudanças no status dos projetos.
- Implementar funcionalidades adicionais, como relatórios detalhados dos projetos, incluindo gráficos e estatísticas.
- Integrar com serviços de autenticação e autorização, como OAuth, para gerenciamento de usuários e permissões mais robusto.
- Implementar paginação, filtros e ordenação nos endpoints para melhorar a performance e a usabilidade.
- Otimizar consultas ao banco de dados para melhorar a performance do sistema.
- Implementar cacheamento de dados frequentemente acessados para reduzir a carga no banco de dados.
- Adicionar exemplos de uso da API e casos de uso comuns na documentação do Swagger.
- Adicionar proteção contra ataques comuns, como SQL Injection e Cross-Site Scripting (XSS).
- Configurar pipelines CI/CD (Integração Contínua/Entrega Contínua) para automação de testes e deploys.

## Contribuir:
Para qualquer problema, comentário ou feedback: 
[here](https://github.com/egnaf/spring-web-jsp-example/issues).
<br>
