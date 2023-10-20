# Plano de Testes: Verificação de Elegibilidade do Cliente

## Objetivo
Dado que um cliente deseja verificar sua elegibilidade com base em regras específicas.

## Escopo
O teste abrangerá a verificação da elegibilidade do cliente com base nas seguintes regras:
Se todas as condições forem verdadeiras:
 - indicador cliente correntista = “S”
 - indicador conta ativa = “S”
 - código tipo produto oferta está entre (“AB”, “CB”, “DC”)
 - código tipo produto oferta produto oferta não está entre (“CC”, “CD”, “AC”)
 - codigo produto origem está entre (1234, 5678, 7722, 5564, 2286, 5561)
 - codigo produto origem não está entre (5555, 7777, 8888, 9999, 1010)
Então
 - atribuir ao indicador_elegibilidade_cliente = “S”

## Levantamento dos Cenários
### Funcionalidade: Verificação de Elegibilidade do Cliente

#### Cenário: Cliente com todos os critérios de elegibilidade é elegível
- Dado que um cliente possui um ou mais contratos
- E o indicador cliente correntista é "S"
- E o indicador conta ativa é "S"
- E o código tipo produto oferta está entre "AB", "CB", "DC"
- E o código tipo produto oferta não está entre "CC", "CD", "AC"
- E o codigo produto origem está entre 1234, 5678, 7722, 5564, 2286, 5561
- E o codigo produto origem não está entre 5555, 7777, 8888, 9999, 1010
- Quando verifico a elegibilidade do cliente
- Então o indicador de elegibilidade deve ser "S"

#### Cenário: Cliente com todos os critérios de elegibilidade, exceto o indicador cliente correntista
- Dado que um cliente possui um ou mais contratos
- E o indicador cliente correntista é "N"
- E o indicador conta ativa é "S"
- E o código tipo produto oferta está entre "AB", "CB", "DC"
- E o código tipo produto oferta não está entre "CC", "CD", "AC"
- E o codigo produto origem está entre 1234, 5678, 7722, 5564, 2286, 5561
- E o codigo produto origem não está entre 5555, 7777, 8888, 9999, 1010
- Quando verifico a elegibilidade do cliente
- Então o indicador de elegibilidade deve ser "N"

#### Cenário: Cliente com todos os critérios de elegibilidade, exceto o indicador conta ativa
- Dado que um cliente possui um ou mais contratos
- E o indicador cliente correntista é "S"
- E o indicador conta ativa é "N"
- E o código tipo produto oferta está entre "AB", "CB", "DC"
- E o código tipo produto oferta não está entre "CC", "CD", "AC"
- E o codigo produto origem está entre 1234, 5678, 7722, 5564, 2286, 5561
- E o codigo produto origem não está entre 5555, 7777, 8888, 9999, 1010
- Quando verifico a elegibilidade do cliente
- Então o indicador de elegibilidade deve ser "N"

#### Cenário: Cliente com todos os critérios de elegibilidade, exceto código tipo produto oferta
- Dado que um cliente possui um ou mais contratos
- E o indicador cliente correntista é "S"
- E o indicador conta ativa é "S"
- E o código tipo produto oferta não está entre "AB", "CB", "DC"
- E o código tipo produto oferta não está entre "CC", "CD", "AC"
- E o codigo produto origem está entre 1234, 5678, 7722, 5564, 2286, 5561
- E o codigo produto origem não está entre 5555, 7777, 8888, 9999, 1010
- Quando verifico a elegibilidade do cliente
- Então o indicador de elegibilidade deve ser "N"

#### Cenário: Cliente com todos os critérios de elegibilidade, exceto código produto origem
- Dado que um cliente possui um ou mais contratos
- E o indicador cliente correntista é "S"
- E o indicador conta ativa é "S"
- E o código tipo produto oferta está entre "AB", "CB", "DC"
- E o código tipo produto oferta não está entre "CC", "CD", "AC"
- E o codigo produto origem não está entre 1234, 5678, 7722, 5564, 2286, 5561
- Quando verifico a elegibilidade do cliente
- Então o indicador de elegibilidade deve ser "N"

#### Cenário: Cliente com todos os critérios de elegibilidade, exceto código tipo produto oferta e código produto origem
- Dado que um cliente possui um ou mais contratos
- E o indicador cliente correntista é "S"
- E o indicador conta ativa é "S"
- E o código tipo produto oferta não está entre "AB", "CB", "DC"
- E o código tipo produto oferta não está entre "CC", "CD", "AC"
- E o codigo produto origem não está entre 1234, 5678, 7722, 5564, 2286, 5561
- Quando verifico a elegibilidade do cliente
- Então o indicador de elegibilidade deve ser "N"

#### Cenário: Cliente com múltiplos contratos, pelo menos um elegível
- Dado que um cliente possui um ou mais contratos
- E pelo menos um contrato atende a todas as condições de elegibilidade
- Quando verifico a elegibilidade do cliente
- Então o indicador de elegibilidade deve ser "S"

#### Cenário: Cliente com múltiplos contratos, todos não elegíveis
- Dado que um cliente possui um ou mais contratos
- E nenhum contrato atende a todas as condições de elegibilidade
- Quando verifico a elegibilidade do cliente
- Então o indicador de elegibilidade deve ser "N"

## Estratégia de Testes
Os testes serão automatizados usando: Java (11+), Maven, Junit, Cucumber em conjunto com o Rest Assured para verificar a elegibilidade do cliente. Os cenários de teste serão criados com base nas regras especificadas.

## Critérios de Aceitação
- Os testes devem ser bem-sucedidos para os cenários de clientes elegíveis e não elegíveis.
- A verificação da elegibilidade do cliente deve estar de acordo com as regras especificadas no escopo.

## Configuração de Testes
O ambiente de teste deve ser configurado com acesso à API de elegibilidade do cliente (URL: [https://teste/1.0/elegibilidade_cliente](https://teste/1.0/elegibilidade_cliente)).
- Content-Type: application/json 
- Accept: application/json
