# Projeto de Cadastro de Veículos
Projeto desenvolvido com Spring Boot, Spring Web e Spring Data.
Para o Frontend foi utilizado VueJS.

O banco de dados utilizado é o Apache Derby embedded.

### Para rodar o projeto:

Dentro do diretório do projeto
```bash
$ ./gradlew bootRun
```
O sistema será executado e poderá ser acessado e http://localhost:8080

### Acesso ao frontend

O frontend estará disponível acessando http://localhost:8080, que disponibilizará um dashboard com informações sobre os veículos cadastrados e opção para cadastrar veículos, vizualizar veículos cadastrados e editar veículos.

### API

As seguintes APIs estão disponíveis:

#### GET /veiculos
Retorna uma lista com todos os veículos cadastrados

##### Retorno
```json
[
  {
    "id":1,
    "vehicle":"Fit",
    "brand":"Honda",
    "manufactureYear":2007,
    "description":"Test create vehicle",
    "sold":false,
    "created":"2020-10-15T04:58:10.930+00:00",
    "updated":"2020-10-22T04:58:10.930+00:00"
  }
]
```
#### GET /veiculos/find
Retorna uma lista com as informações conforme o termo passado no parâmentro q

##### Termos possíveis:
###### unsold
Retorna lista de veículos não vendidos
###### Retorno igual ao GET /veiculos

###### byDecade
Retorna lista contendo a década e a quantidade de veículos fabricados nessa década
##### Retorno
```json
[
  {
    "decade": 2000,
    "quantity": 5
  }
]
```

###### byBrand
Retorna lista contendo o fabricante e a quantidade de veículos cadastrados do fabricante
##### Retorno
```json
[
  {
    "brand": 2000,
    "quantity": 5
  }
]
```

###### lastWeek
Retorna lista de veículos cadastrado na semana anterior
###### Retorno igual ao GET /veiculos

#### GET /veiculos/{id}
Retorna informações de um veículo passado seu ID
##### Retorno
```json
{
    "id":1,
    "vehicle":"Fit",
    "brand":"Honda",
    "manufactureYear":2007,
    "description":"Test create vehicle",
    "sold":false,
    "created":"2020-10-15T04:58:10.930+00:00",
    "updated":"2020-10-22T04:58:10.930+00:00"
}
```

#### POST /veiculos
Cadastra um veículo no sistema
##### Parmâmetros
```json
{
    "vehicle": "Escort",
    "brand": "Forrrd",
    "manufactureYear": 1997,
    "description": "Teste",
    "sold": false
}
```
##### Retorno
```json
{
    "id":1,
    "vehicle":"Fit",
    "brand":"Honda",
    "manufactureYear":2007,
    "description":"Test create vehicle",
    "sold":false,
    "created":"2020-10-15T04:58:10.930+00:00",
    "updated":"2020-10-22T04:58:10.930+00:00"
}
```

#### PUT /veiculos{id}
Atualiza todos os dados do veículo

###### Parâmetros e Retorno iguais ao POST /veiculos

#### PATCH /veiculos/{id}
Atualiza um ou mais campos do veículo

###### Parâmetros e Retorno iguais ao POST /veiculos, porém nos parâmetros não são enviados todos os campos

#### DELETE /veiculos/{id}
Exclui um veículo passado o ID
##### Retorno
```json
{ "deleted": true }