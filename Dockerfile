# Fase de build usando Maven com JDK 17 em uma imagem baseada em Alpine
FROM maven:3.8.1-openjdk-17-slim AS builder

# Copie apenas o arquivo de configuração do Maven primeiro para tirar proveito do cache de dependências
COPY pom.xml /usr/src/app/
WORKDIR /usr/src/app

# Baixe as dependências do Maven (com cache)
RUN mvn dependency:go-offline -B

# Agora copie o restante dos arquivos do projeto
COPY src /usr/src/app/src

# Compile o projeto Maven
RUN mvn clean install package -DskipTests --no-transfer-progress

# Fase de execução usando Tomcat com JDK 17
FROM tomcat:9.0.74-jdk17

# Copie o arquivo WAR gerado para o diretório de implantação do Tomcat
COPY --from=builder /usr/src/app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Exponha a porta em que o Tomcat estará em execução
EXPOSE 8080

# Comando para iniciar o Tomcat
CMD ["catalina.sh", "run"]
