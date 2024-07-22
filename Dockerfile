# Fase de build usando Maven com JDK 17
FROM maven:3.8.1-openjdk-17 AS builder

# Copie os arquivos de origem do projeto para o contêiner
COPY . /usr/src/app
WORKDIR /usr/src/app

# Compile o projeto Maven
RUN mvn clean install package

# Fase de execução usando Tomcat com JDK 17
FROM tomcat:9.0.74-jdk17

# Copie o arquivo WAR gerado para o diretório de implantação do Tomcat
COPY --from=builder /usr/src/app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Exponha a porta em que o Tomcat estará em execução
EXPOSE 8080

# Comando para iniciar o Tomcat
CMD ["catalina.sh", "run"]
