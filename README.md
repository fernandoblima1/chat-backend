# Chat Backend + RabbitMQ

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

### 📋 Pré-requisitos

Você precisará de uma máquina com Docker instalado. Se o ambiente for Windows por favor verifique também a instalação do docker-compose. No terminal digite:

```
$ docker --version && docker-compose --version
```

A resposta esperada deve ser algo semelhante a isso:

```
Docker version 25.0.3, build 4debf41
Docker Compose version v2.24.5-desktop.1
```

### 🔧 Instalação

Inicialize o container do RabbitMQ

```
docker compose up -d
```

Após isso execute o projeto com o comando abaixo (Ubuntu ou outra disto Linux)

```
make start
```

Caso esteja utilizando Windows ou MacOS execute o projeto em sua IDE de preferida

## 📦 Implantação

## 🛠️ Construído com

Ferramentas usadas

- [Spring Boot](https://spring.io/projects/spring-boot) - O framework web usado
- [Maven](https://maven.apache.org/) - Gerente de Dependência
- [Docker](https://www.docker.com/) - Orquestrador de containers
- [RabbitMQ](https://www.rabbitmq.com/) - Broker de mensagens

## ✒️ Autores

- [Fernandoblima1](https://github.com/fernandoblima1)

---
