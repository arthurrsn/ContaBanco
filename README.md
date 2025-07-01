# 🏦 Projeto ContaBanco

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Status](https://img.shields.io/badge/Status-Finalizado-green?style=for-the-badge)

Um projeto de terminal interativo para simular operações de uma conta bancária, desenvolvido como um exercício prático para solidificar conceitos de Java, Programação Orientada a Objetos e Arquitetura de Software.

## 📖 Sobre o Projeto
O `ContaBanco` é uma aplicação de console que permite ao usuário criar uma conta bancária fictícia através de um menu interativo. O sistema foi projetado com uma arquitetura de 3 camadas (MVC) para separar responsabilidades e garantir um código limpo, organizado e de fácil manutenção. O foco principal foi a criação de um sistema robusto, com tratamento de erros e validação de dados em todas as etapas do processo.

## ✨ Funcionalidades
* **Menu Interativo:** Navegação simples através de opções no terminal.
* **Cadastro de Nova Conta:** Coleta de dados do usuário para criar uma nova conta.
* **Validação de Dados em Tempo Real:** O sistema valida cada informação fornecida pelo usuário (formato, regras de negócio) e fornece feedback imediato em caso de erro.
* **Exibição de Resultados:** Apresentação clara dos dados da conta criada com sucesso.

## 🛠️ Tecnologias Utilizadas
* **Java 21**

## 🚀 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/arthurrsn/ContaBanco.git](https://github.com/arthurrsn/ContaBanco.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd ContaBanco
    ```

3.  **Compile os arquivos Java:**
    (Assumindo que seus arquivos `.java` estão dentro da estrutura de pacotes `src/edu/arthur/contabanco/...`)
    ```bash
    javac -d bin src/edu/arthur/contabanco/model/*.java src/edu/arthur/contabanco/controller/*.java src/edu/arthur/contabanco/*.java
    ```

4.  **Execute a aplicação:**
    ```bash
    java -cp bin edu.arthur.contabanco.ContaTerminal
    ```

## 🧠 Conceitos Aplicados
Este projeto foi uma oportunidade para aplicar e aprofundar os seguintes conceitos de Engenharia de Software:
* **Programação Orientada a Objetos (POO):**
    * **Encapsulamento:** Proteção dos dados do modelo, com acesso controlado por getters e setters.
    * **Abstração:** Criação de uma classe `Conta` que representa uma entidade do mundo real.
* **Arquitetura MVC (Model-View-Controller):**
    * **Model (`Conta`):** Representa os dados e as regras de negócio fundamentais.
    * **View (`ContaTerminal`):** Camada de apresentação e interação com o usuário.
    * **Controller (`ContaController`):** Orquestra a comunicação entre a View e o Model.
* **Tratamento de Exceções:** Uso de `try-catch` e `throws` para lidar com erros de entrada do usuário (`InputMismatchException`) e erros de validação de regras de negócio (`IllegalArgumentException`).
* **Validação de Dados em Camadas:** Demonstração de como a validação pode ocorrer tanto na View (para tipos de dados) quanto no Controller/Model (para regras de negócio).
* **Qualidade de Código:** Foco em código limpo, legível e com documentação profissional (Javadoc).

## ✒️ Autor
* **Arthur Ribeiro**
    * **LinkedIn:** [www.linkedin.com/in/arthurrsdn](https://www.linkedin.com/in/arthurrsdn/)
    * **GitHub:** [github.com/arthurrsn](https://github.com/arthurrsn)
