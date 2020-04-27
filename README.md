# Task List

Este repositório contém a api Task List, para ser integrado com esta [APP](https://github.com/brunanazario/tasklist-app).
Foram utilizadas as seguintes tecnologias:

[Spring Boot](https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/),
[PostgreSql](https://www.postgresql.org/docs/),
[Docker](https://docs.docker.com/),
[Docker-Compose](https://docs.docker.com/compose/),
[Liquibase](https://www.liquibase.org/documentation/index.html)

# Passos para execução do projeto

Siga as instruções abaixo para executar o projeto localmente.

## Pré-requisitos
[JDK 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) 
instalada para compilar o projeto. 
Utilize o [Docker](https://docs.docker.com/) e o 
[Docker-Compose](https://docs.docker.com/compose/).

## Iniciando dependências

Primeiramente é necessário você ter o docker instalado:

Todos os serviços dos quais a API depende foram configurados no arquivo *docker-compose*, que pode ser encontrado na raiz do projeto. Acesse este diretório e execute o comando abaixo para iniciar todas as dependências localmente.

```
docker-compose up -d
```

Para interromper a execução do serviço e remover a imagem, respectivamente, execute os comandos abaixo.

```
docker-compose stop <servico>
docker-compose rm <servico>
```

## Executando o projeto

Para iniciar a aplicação, primeiro inicialize as dependências

```
docker-compose up -d
```

Depois, execute o comando abaixo:

```
./mvnw -Dspring-boot.run.profiles=local
```

Ou também é possível através da IDE executar a class principal `com.nazario.tasklist.TasklistApplication` ativando
profile `local`


### Executando migrações de banco local

Executar o seguinte comando no terminal a partir da raiz do projeto:

```
 mvn liquibase:updateTestingRollback -f migrations/pom.xml 
```

Foi configurada a criação de banco para testes, porém nessa versão os testes ainda não foram implementados.
