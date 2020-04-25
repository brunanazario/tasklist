# Task List

Este repositório contém a api Task List. Foram utilizadas as seguintes tecnologias:

[Spring Boot](https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/),
[PostgreSql](https://www.postgresql.org/docs/),
[Docker](https://docs.docker.com/),
[Docker-Compose](https://docs.docker.com/compose/),
[Liquibase](https://www.liquibase.org/documentation/index.html)

- [Quick start](#quickstart)
    - [Pré-requisitos](#prerequisitos)
    - [Iniciando dependências](#iniciandodependencias)  
    - [Executando o projeto](#executandoprojeto)
    - [Executando migrações de banco local](#executandomigracoesbancolocal)
    - [Executando migrações de banco local_teste](#executandomigracoesbancotestesit)
- [Informações adicionais](#infoadicionais)

## Quick start <a name="quickstart"></a>

Siga as instruções abaixo para obter e executar localmente este projeto.

### Pré-requisitos <a name="prerequisitos"></a>
Você vai precisar da [JDK 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) 
instalada para compilar o projeto. Além disso, recomendamos a utilização do [Docker](https://docs.docker.com/) e do 
[Docker-Compose](https://docs.docker.com/compose/) para uma melhor experiência de desenvolvimento.

### Iniciando dependências <a name="iniciandodependencias"></a>

Primeiramente é necessário você ter o docker instalado:

Todos os serviços dos quais a API depende foram configurados num arquivo do *compose*, que pode ser encontrado na raiz do projeto. Acesse este diretório e execute o comando abaixo para iniciar todas as dependências localmente.

```
docker-compose up -d
```

Você também pode iniciar serviços específicos, tal como o banco de dados, por exemplo. Para tanto, execute comandos seguindo o modelo abaixo.

```
docker-compose up -d <servico>
```

Exemplo para subir o banco de dados:

```
docker-compose up -d postgres
```

Para interromper a execução do serviço e remover a imagem, respectivamente, execute os comandos abaixo.

```
docker-compose stop <servico>
docker-compose rm <servico>
```

### Executando o projeto <a name="executandoprojeto"></a>

Para iniciar a aplicação, primeiro inicialize as dependências

```
docker-compose up -d
```

Depois, simplesmente execute o comando abaixo

```
./mvnw -Dspring-boot.run.profiles=local
```

Ou também é possível através da IDE executar a class principal `com.nazario.tasklist.TasklistApplication` ativando
profile `local`


### Executando migrações de banco local <a name="executandomigracoesbancolocal"></a>

Executar o seguinte comando no terminal a partir da raiz do projeto:

```
 mvn liquibase:updateTestingRollback -f migrations/pom.xml 
```

### Executando migrações de banco para execução de testes de integração<a name="executandomigracoesbancotestesit"></a>

Para executar a migração de banco para os testes de integração deve-se executar o seguinte comando no terminal a partir da raiz do projeto:

```
 mvn liquibase:updateTestingRollback -f migrations/pom.xml -DdatabaseUrl=localhost:5433
```

## Informações adicionais <a name="infoadicionais"></a>
