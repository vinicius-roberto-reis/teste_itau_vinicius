# language: pt
Funcionalidade: Verificar a elegibilidade do cliente
  Esquema do Cenário: Verificação de elegibilidade do cliente
    Dado que tenho um cliente com o seguinte contrato
      | indicadorContaAtiva | indicadorClienteCorrentista  | codigoTipoProdutoOferta | codigoProdutoOrigem |
      | <ContaAtiva>        | <ClienteCorrentista>         | <TipoProdutoOferta>     | <ProdutoOrigem>     |
    Quando realizo uma requisição POST para verificar a elegibilidade do cliente
    Então a resposta deve conter o indicador de elegibilidade "<ElegibilidadeEsperada>"

    Exemplos:
      | ContaAtiva | ClienteCorrentista | TipoProdutoOferta | ProdutoOrigem | ElegibilidadeEsperada |
      | S          | S                  | AB                | 1234          | S                     |
      | S          | S                  | CB                | 1234          | S                     |
      | S          | S                  | DC                | 1234          | S                     |
      | S          | S                  | AB                | 5678          | S                     |
      | S          | S                  | AB                | 7722          | S                     |
      | S          | S                  | AB                | 5564          | S                     |
      | S          | S                  | AB                | 2286          | S                     |
      | S          | S                  | AB                | 5561          | S                     |
      | S          | S                  | AB                | 9000          | N                     |
      | S          | N                  | AB                | 1234          | N                     |
      | S          | S                  | XX                | 1234          | N                     |
      | S          | S                  | AB                | 5555          | N                     |
      | S          | S                  | XX                | 5555          | N                     |
      | N          | S                  | AB                | 1234          | N                     |
      | S          | S                  | CC                | 1234          | N                     |
      | S          | S                  | AB                | 8888          | N                     |
      | S          | S                  | CC                | 8888          | N                     |

