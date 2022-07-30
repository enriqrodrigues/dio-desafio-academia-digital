# desafio-academia-digital

## Desafio

Criação de API RESTful com ênfase na modelagem de suas entidades, no domínio de uma academia de ginástica.

## Repositório original

https://github.com/cami-la/academia-digital

## Tecnologia Utilizadas

Java 11 , Maven, Spring Web, Spring Data JPA, MySQL Driver, H2, JUnit, MockMVC, Hibernate Validator, Lombok, IntelliJ IDEA e Postman.

## Considerações

Diferente do projeto original que utilizava o banco de dados PostgreSQL, aqui estou utilizando os bancos de dados MySQL. Para tal precisei adicionar a dependência do banco de dados ao projeto e reconfigurar o arquivo application.yml.

Substitui a anotação @Data das classes de entidade pelas anotações @Getter e @Setter pois não estamos fazendo uso dos demais métodos gerados pela anotação @Data.

Tomei a liberdade de alterar o pacote form para um padrão que estou mais habituado. No caso, utilizo um pacote com as classes de "request" para entrada de dados e outro com as classes de "response" para as classes de saída de dados.

Para auxiliar nos testes, deixei no diretório resource, um arquivo com comandos sql para inserção de dados no banco e outro com o coleção de requisições que utilizei no Postman durante os testes.

Tive algumas dificuldades com o mapeamento das chaves estrangeiras. E no fim não consegui deletar as matrículas através da requisição, apesar tudo parecer correto.

## Links

https://www.linkedin.com/in/enriqrodrigues/
