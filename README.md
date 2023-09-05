# Backend do Aplicativo de Relacionamento com consumidor da Copel - README

Este é o backend do projeto de aplicativo de gerenciamento de energia, desenvolvido em Java com Spring Boot. O backend fornece as APIs para o aplicativo móvel Flutter e web em HTML, CSS e Javascript a se conectarem e obterem dados relacionados ao consumo de energia e contas dos consumidores.

## Tecnologias Utilizadas

- Backend: Spring Boot (Java)
- Build tool c/ Gradle
- Banco de Dados: MySQL

## Configuração

1.  Clone este repositório.
2. Configure as variáveis de ambiente, como informações do banco de dados, no arquivo `application.properties`.
3. Execute o aplicativo usando o Gradle Wrapper:

./gradlew bootRun


## Estrutura do Projeto

A estrutura do projeto Spring Boot gerenciado pelo Gradle segue a seguinte organização:

- `src/main/java/com/HackathonCopel`: Pacote principal.
- `controller`: Controladores que definem as APIs.
- `modelo`: Modelos de dados da aplicação.
- `repository`: Interfaces de repositório para interação com o banco de dados.
- `service`: Camada de serviço que lida com a lógica de negócios.

## API Endpoints

### Registrar Cliente
- **Descrição:** Registra um novo cliente.
- **Método:** `POST`
- **Endpoint:** `/api/aluno/registrar`
- **Corpo da Requisição:**
  ```json
  {
    "nome": "Neymar",
    "sobrenome": "Jr",
    "email": "neymarjr@gmail.com",
    "password": "123456"
  }
  ```
- **Resposta de sucesso: 200 OK**

### Login Cliente 
- **Descrição:** Autoriza um cliente já registrado.
- **Método:** `POST`
- **Endpoint:** `/api/aluno/login`
- **Corpo da requisição:**
  ```json
    {
      "email": "neymarjr@gmail.com",
      "password": "123456"
    }
- **Resposta de sucesso: "Login sucessfull" 200 OK

### Encontrar Cliente por Email

- **Descrição:** Retorna informações de um cliente com base no endereço de e-mail.
- **Método:** `GET`
- **Endpoint:** `/api/aluno/encontre/{email}`
- **Parâmetros de URL:** email (e-mail do cliente a ser buscado)
- **Resposta de sucesso:** 
  ```json
    {
      "idCliente": 2,
      "nome": "Neymar",
      "sobrenome": "Jr",
      "email": "neymarjr@gmail.com",
      "senha_salt": "Z2NZU3J2OUtsYlZtcmpjbnRUWFBFdz09",
      "senha_hash": "bU15S0N6Q0Zjbms5SWNmWWVSK1FjQWJUSEp1YkhUMlFJeERDUjJtcDhtZ3BLUWdrYStrUlo1VzZ5cUFGWmx3TElEc2VOZzNxSG5ZNTQ2aGhnS0VTemc9PQ==",
      "password": null,
      "conta": [],
      "informacoesConta": []
    }
- **Resposta de erro:** 404 Not Found (se o cliente não for encontrado)

### Atualizar Email do Cliente

- **Descrição:** Atualiza o endereço de e-mail de um cliente existente.
- **Método:** `PUT`
- **Endpoint:** `/api/aluno/update-email/{IdCliente}/{newEmail}`
- **Parâmetros de URL:** IdCliente (ID do cliente a ser atualizado), newEmail (email para qual será atualizado)
- **Parâmetros de Consulta:** newEmail (novo endereço de e-mail a ser definido)
- **Resposta de sucesso:** "Email updated successfully" 200 OK
- **Resposta de erro:** 404 Not Found (se o cliente não for encontrado)

### Pegar informações do cliente por ID

- **Descrição:** Retorna informações de um cliente com base no ID.
- **Método:** `GET`
- **Endpoint:** `/api/aluno/cliente_info/{IdCliente}`
- **Parâmetros de URL:** IdCliente (ID do cliente a ser buscado)
- **Resposta de sucesso:**
  ```json
    {
      "nome": "Neymar",
      "sobrenome": "Jr",
      "email": "neymarjr@gmail.com"
    }

### Registrar uma nova conta

- **Descrição:** Registra uma nova conta.
- **Método:** `POST`
- **Endpoint:** `/api/conta/registrar/{clienteId}`
- **Corpo da Requisição:**
  ```json
    {
      "idConta": 1,
      "clienteId": 2, 
      "valorAPagar": 25.0, 
      "dataDeVencimento": "2025-03-12",
      "statusPagamento": "PAGO",
      "kilowattsHora": 100
    }
  ```
- **Resposta de sucesso: 200 OK**

### Registrar um novo patch de informações recebidas do arduino

- **Descrição:** Registra uma nova parcela de kilowatts/informações recebidos do arduino.
- **Método:** `POST`
- **Endpoint:** `/api/kilowatts/registrar/{contaId}`
- **Corpo da Requisição:**
  ```json
    {
      "kilowattsPegos": 100, 
      "dataDeEmissao": "2023-09-04" 
    }
  ```
- **Resposta de sucesso: 200 OK**

### Pegar informações da conta pelo ID do cliente

- **Descrição:** Retorna informações de uma conta e de sua energia relacionada com base no ID do cliente.
- **Método:** `GET`
- **Endpoint:** `/api/conta/{clienteId}`
- **Parâmetros de URL:** IdCliente (ID do cliente a ser buscado)
- **Resposta de sucesso:**
  ```json
    {
      "kilowattsRecebidos": [
          {
              "dataDeEmissao": 1693785600000,
              "contaId": 7,
              "kilowattsPegos": 100,
              "idKilowatts": 2
          }
      ],
      "idInformacoesConta": 7,
      "dataDeVencimento": 1741737600000,
      "valorAPagar": 25.00,
      "statusPagamento": "PAGO",
      "kilowattsHora": 100,
      "clienteId": 2
    }

## Contribuição

Se você deseja contribuir para este projeto, sinta-se à vontade para enviar pull requests ou relatar problemas na seção de issues.
