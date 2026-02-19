# 🛒 ProjetoVendas

Projeto desenvolvido durante curso de **Java EE**, com foco na prática dos principais conceitos da plataforma enterprise. A aplicação realiza o cadastro e gerenciamento de produtos (CRUD completo).

## 📚 Tecnologias estudadas

| Tecnologia | Uso no projeto |
|---|---|
| **Java EE 8** | Plataforma base |
| **JSF + Facelets** | Interface web com páginas `.xhtml` |
| **JPA + Hibernate** | Mapeamento objeto-relacional (ORM) |
| **CDI** | Injeção de dependências (`@Inject`, `@Named`) |
| **PostgreSQL** | Banco de dados relacional |
| **WildFly** | Servidor de aplicação |
| **Maven** | Gerenciamento de dependências e build |

## 🗂️ Estrutura do projeto

```
src/main/java/br/com/renan/
├── model/           # Entidade JPA (Produto)
├── dao/             # Acesso ao banco de dados
├── service/         # Regras de negócio
├── controller/      # ManagedBean JSF (ProdutoController)
└── exception/       # Exceções personalizadas

src/main/webapp/
├── index.xhtml      # Página inicial
├── produtos.xhtml   # Listagem e formulário de produtos
└── WEB-INF/
```

## ⚙️ Pré-requisitos

- Java 17+
- Maven 3.8+
- PostgreSQL
- WildFly 27+ configurado localmente

## 🚀 Como executar

**1. Configure o banco de dados** no PostgreSQL:
```sql
CREATE DATABASE projetovendas;
```

**2. Configure o DataSource** no WildFly com o nome `java:jboss/datasources/PostGreDS`.

**3. Faça o deploy** via Maven:
```bash
mvn wildfly:deploy
```

**4. Acesse** em: `http://localhost:8080/ProjetoVendas`

## 📝 Funcionalidades

- [x] Cadastrar produto (código, nome, descrição, preço, estoque)
- [x] Listar produtos
- [x] Editar produto
- [x] Remover produto
- [x] Validação de regras de negócio com mensagens de feedback

## 🎓 Objetivo

Este projeto faz parte do meu aprendizado em desenvolvimento Java EE. O foco é entender na prática como as tecnologias da plataforma se integram: camada de apresentação (JSF), lógica de negócio (EJB/CDI) e persistência (JPA).
