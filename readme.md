<h1 id="top" align="center">Projeto Final Acelera Devs</h1>

<h2>Tópicos:</h2>

- [Resumo do projeto](#summary)
- [Explicando decisões do projeto](#decisions)
- [Explicando funcionalidades do projeto](#functionalities)
- [Passo a Passo](#stepByStep)

---

<h2 id="summary">📝 Resumo do projeto</h2>

<br>

Este é um Projeto para aplicação e demonstração dos conhecimentos adquiridos durante o programa Acelera Devs da Stefanini
<br>
O projeto consiste em uma API RESTful de controle de vendas e estoque.
Este projeto é desenvolvido na linguagem de programação JAVA


<p align="right"><a href="#top">Voltar ao topo</a></p>

---

<br>

<h2 id="decisions">👨‍💻 Explicando decisões do projeto</h2>
<details><summary>Decisões durante o desenvolvimento do projeto</summary>
<p>

Boa Parte do projeto foi desenvolvido utilizando a biblioteca Lombok para auxiliar e agilizar o desenvolvimento das classes Java.

Utilizei também a biblioteca Flyway para gerenciar a comunicação com banco de dados e o gerenciamento das migrations. 

Neste projeto foi utilizado das seguintes tecnologias.
* Java
* JPA
* MySql
* Springboot
* Maven
* Poi Apache
* Lombok
* Flyway


</p>
</details>

<br>

<p align="right"><a href="#top">Voltar ao topo</a></p>

---

<br>

<h2 id="functionalities">⚙️ Funcionalidades do projeto</h2>

<details><summary>Rotas</summary>

<br>

Como dito já no início da descrição dos requisitos do Projeto, este é composto por 5 seções principais:
1.	Cliente
2.	Produto
3.	Entrada
4.	Venda
5.  Relatórios

Separei as sessões em 5 rotas principais e em cada uma delas suas respectivas necessidades, a baixo temos uma tabela para exemplificar

<br>

<h3>Cliente</h3>

| Endpoint       | Métodos HTTP | Descrição                              |
|----------------|--------------|----------------------------------------|
| /cliente       | POST         | Utilizado para cadastrar um cliente    |
| /cliente       | GET          | Retorna lista de clientes              |
| /cliente/{cpf} | GET          | Retorna os dados do cliente específico |
| /cliente       | PUT          | Altera um cliente a partir do seu CPF  |
| /cliente{cpf}  | DELETE       | Efetua um delete do cliente            |

<br>

<h3>Produto</h3>

| Endpoint      | Métodos HTTP | Descrição                              |
|---------------|--------------|----------------------------------------|
| /produto      | POST         | Utilizado para cadastrar um produto    |
| /produto      | GET          | Retorna lista de produto               |
| /produto/{id} | GET          | Retorna os dados do produto específico |
| /produto      | PUT          | Altera um produto a partir do seu ID   |
| /produto/{id} | DELETE       | Efetua um delete do produto            |

<br>

<h3>Entrada</h3>

| Endpoint      | Métodos HTTP | Descrição                                                               |
|---------------|--------------|-------------------------------------------------------------------------|
| /entrada/{id} | POST         | Utilizado para cadastrar uma venda de um produto a partir do seu código |

<br>

<h3>Vendas</h3>

| Endpoint     | Métodos HTTP | Descrição                                                                                         |
|--------------|--------------|---------------------------------------------------------------------------------------------------|
| /vendas/xlsx | POST         | Utilizado para registrar um arquivo em Excel (xlsx) e cadastrar os campos em uma tabela de vendas |

<h3>Relatórios</h3>

| Endpoint              | Métodos HTTP | Descrição                                                   |
|-----------------------|--------------|-------------------------------------------------------------|
| /relatorio/{cpf}      | GET          | Utilizado para emitir um relatório de compras por CPF       |
| /relatorio/{ano}{mes} | GET          | Utilizado para emitir um relatório de compras por ano e mês |
<br></details>

<p align="right"><a href="#top">Voltar ao topo</a></p>

---

<br>

<h2 id="stepByStep">🦶 Passo a passo</h2>

<br>

<details><summary>Como executar o projeto</summary>
<p>

<details><summary>⚠️ Pré requisitos</summary>
<p>

<br>
 Na sua máquina você deve ter:

- Git
- Java Versão 17
- MySQL

<a href="https://git-scm.com/book/en/v2/Getting-Started-Installing-Git">Git</a>, <a href="https://www.java.com/pt-BR/download/ie_manual.jsp">Java</a> e <a href="https://dev.mysql.com/downloads/installer/">MySQL</a>

<br>

```bash
# Faça o clone do repositório:
$ git clone git@github.com:pablovr1000/aceleraDevsAPI.git
 
# Edite o arquivo application.properties colocando os dados de acesso do seu MySQL Local e o nome do seu Banco de Dados:
 
# Utilize a IDE de sua preferência, sugestão é utilizar o IntelliJ
```
<a href="https://www.jetbrains.com/pt-br/idea/download">IntelliJ</a>

</p>
</details>
</details>

<br>

<details><summary>Como interagir com o projeto</summary>
<p>

 - Na pasta raiz do projeto, importe o arquivo AceleraDevsPabloAPI.postman_collection.Json em seu Postman

</p>
</details>
</details>

<p align="right"><a href="#top">Voltar ao topo</a></p>

<br>