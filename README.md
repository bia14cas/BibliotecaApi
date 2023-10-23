# BibliotecaApi
Trabalho de Aplicação de dados
Sistema de Biblioteca - Projeto com JPA

Este é um projeto de exemplo para um sistema de biblioteca com mapeamento objeto-relacional (JPA). O projeto é desenvolvido em Java e utiliza o Hibernate como provedor JPA e o banco de dados H2.

## Membros da Equipe
Este projeto foi desenvolvido por:
- Beatriz Cardoso Alves da Silva: [Link para o perfil do Aluno 1](https://github.com/bia14cas)
- Ladiane Pinheiro Santana: [Link para o perfil do Aluno 2](https://github.com/Ladiane-PS)

## Descrição do Projeto

O projeto tem como objetivo demonstrar um sistema de biblioteca com as entidades Publicação, Aluno e Empréstimo, e utiliza o Java JPA para mapeamento objeto-relacional. O sistema permite realizar operações como inclusão, alteração, exclusão e consulta de empréstimos.

## Estrutura do Projeto

O projeto possui a seguinte estrutura de pacotes:

- `com.example.library.model`: Contém as classes de modelo, incluindo `Publicacao`, `Aluno` e `Empréstimo`.
- O package dao: Contém as classes  DAO para acesso ao banco de dados.
- `com.example.library.test`: Contém classes de teste para demonstrar as operações no banco de dados.

## Configuração

Certifique-se de ter o Maven instalado em seu ambiente. O projeto usa o Maven para gerenciar as dependências e compilação.

## Executando o Projeto

Para executar o projeto, siga os passos abaixo:

1. Clone este repositório Git em seu ambiente local.

2. Certifique-se de que as configurações do banco de dados no arquivo `persistence.xml` estão corretas para o ambiente.

3. Use o comando Maven para compilar e executar o projeto:

   ```shell
   mvn clean compile exec:java
