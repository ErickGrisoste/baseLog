# 📊 BaseLog

**BaseLog** é um projeto pessoal de estudos, desenvolvido com base em um problema real. A ideia principal surgiu da necessidade de visualizar, em tempo real, o status de diversas **bases operacionais distribuídas pelo Brasil**, permitindo identificar quais estão **ativas (ON)** ou **inativas (OFF)** de forma simples e centralizada.

Este projeto também serviu como prática de conceitos de **Java com Spring Boot**, modelagem de banco de dados relacional, consumo de APIs REST, controle de acesso, autenticação e front-end básico com HTML, CSS e JavaScript.

---

## 🎯 Objetivo

Criar um **painel administrativo (dashboard)** que mostra o status de funcionamento de todas as bases da empresa com base em:

- Ação de "bater ponto" dos funcionários
- Feriados locais
- Status manual (OFF, ALMOÇO, FERIADO)

---

## 🚀 Funcionalidades

- [x] Cadastro de bases e endereços
- [x] Cadastro e autenticação de funcionários
- [x] Criptografia de senhas com `BCryptPasswordEncoder`
- [x] Funcionário pode bater ponto (alterna seu status entre ON/OFF)
- [x] Atualização automática do status da base com base nos funcionários
- [x] Dashboard com lista de bases e botão para exibir funcionários
- [x] Login com retorno de ID do funcionário para uso no front
- [x] Controle de CORS e CSRF liberado para testes locais
- [x] Enum para status (base e funcionário)
- [ ] Feriados locais (em desenvolvimento)

---

## 🛠️ Tecnologias

### Back-end:
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate
- PostgreSQL
- Maven

### Front-end:
- HTML5
- CSS3
- JavaScript 

---
## 🧠 Aprendizados
### Esse projeto serviu como prática de:

- Arquitetura MVC com Spring Boot

- Validação com Bean Validation

- Boas práticas de modelagem com JPA

- Front-end consumindo API REST

---
## 👨‍💻 Autor
Desenvolvido por **Erick Grisoste**, como projeto pessoal para estudos de back-end Java + Spring e integração com front-end básico.


