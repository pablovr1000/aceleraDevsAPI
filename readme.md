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

Este projeto tem como intuito a utilização das seguintes tecnologias e conhecimentos vistos no programa.
* Java
* JUnit
* Swagger


</p>
</details>

<br>

<p align="right"><a href="#top">Voltar ao topo</a></p>

---

<br>

<h2 id="functionalities">⚙️ Funcionalidades do projeto</h2>

<details><summary>Rotas</summary>

<br>

Como dito já no início das descrição dos requisitos do Projeto, este é composto por 4 seções principais:
1.	User e Login
2.	Times (Team’s)
3.	Partidas (Match’s)
4.	Placar (Leaderboard)

Separei as sessões em 4 rotas principais e em cada uma delas suas respectivas necessidades, a baixo temos uma tabela para exemplificar

<br>

<h3>User</h3>

| Endpoint | Métodos HTTP | Descrição |
|---|---|---|
| /login | GET | Usado para logar um usuário, retorna um token |
| /login/validate | POST | Valida o token recebido no Head |

<br>

<h3>Times</h3>

| Endpoint | Métodos HTTP | Descrição |
|---|---|---|
| /teams | GET | Retorna um Array com todos os times |
| /teams/:id | GET | Retorna os dados de um time com base no id |

<br>

<h3>Partidas</h3>

| Endpoint | Métodos HTTP | Descrição |
|---|---|---|
| /matches | GET | Retorna um Array com todas as partidas |
| /matches/:id | GET | Retorna os dados de uma partida com base no id |
| /matches/ | POST | Registra uma nova partida com os dados inseridos |
| /matches/ | PATCH | Atualizar uma partida com os dados inseridos |
| /matches/:id | PATCH | Atualizar o status de uma partida em andamento para finalizada |

<br>

<h3>Tabela de classificação</h3>

| Endpoint | Métodos HTTP | Descrição |
|---|---|---|
| /leaderboard | GET | Retorna um Array com todos os times da tabela de classificação |
| /leaderboard/away | GET | Retorna um Array com os times da tabela de classificação que jogaram fora do próprio Estádio |
| /leaderboard/home | GET | Retorna um Array com os times da tabela de classificação que jogaram no próprio Estádio  |

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

- Sistema Operacional Distribuição Unix
- Node versão 16
- Docker
- Docker-compose versão >=1.29.2

<a href="https://git-scm.com/book/en/v2/Getting-Started-Installing-Git">Git</a>, <a href="https://docs.docker.com/desktop/">Docker</a> e <a href="https://docs.docker.com/compose/install/">docker-compose</a>

<br>

```bash
# Faça o clone do repositório e entre na pasta do projeto:
$ git clone git@github.com:pablovr1000/projeto-trybe-futebol-clube.git && cd projeto-trybe-futebol-clube
 
# Renomeie o arquivo .env.example para .env e edite-o colocando os dados de acesso do seu MySQL Local:
$ mv app/backend/.env.example app/backend/.env
 
# Instale as dependências do projeto e **suas aplicações (front e back)**:
$ npm install
 
# Você pode **subir ou descer uma aplicação do compose**, utilizando os comandos abaixo:
$ npm run compose:up
$ npm run compose:down

```

</p>
</details>

</p>
</details>

<br>

<details><summary>Como interagir com o projeto</summary>
<p>

<details><summary>Utilizando Postman ou insomnia</summary>
<p>

 -

</p>
</details>

<details><summary>Utilizando interface front-end</summary>
<p>

 - 

</p>
</details>

</p>
</details>

<p align="right"><a href="#top">Voltar ao topo</a></p>

<br>