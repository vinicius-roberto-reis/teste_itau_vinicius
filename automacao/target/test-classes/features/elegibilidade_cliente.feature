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

