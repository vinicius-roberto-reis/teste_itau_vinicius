# 📋 Elegibilidade do Cliente - Projeto de Teste

Um projeto de teste para verificar a elegibilidade do cliente com cenários variados.

## 📦 Pré-requisitos

Antes de executar os testes, você precisará ter instalado:

- Java 11
- Maven
- Cucumber
- RestAssured

## 🚀 Como Executar

1. Clone este repositório:

   ```bash
   git clone https://github.com/vinicius-roberto-reis/teste_itau_vinicius.git

2. Navegue até a pasta do projeto:
cd elegibilidade-do-cliente-testes

3. Execute os testes Cucumber com o seguinte comando:
mvn test

🧪 Estrutura de Cenários
O projeto inclui cenários de teste que verificam a elegibilidade do cliente com base nas regras fornecidas. Os cenários incluem combinações de:

```bash
Indicador Cliente Correntista
Indicador Conta Ativa
Código Tipo Produto Oferta
Código Produto Origem
```

📂 Estrutura de Diretórios
A estrutura de diretórios do projeto é organizada da seguinte forma:
```bash
src/test/resources/features: Arquivos .feature que definem os cenários de teste.
src/test/java/steps: Classes de steps definidas em Java.
src/test/java/ElegibilidadeClienteApi.java: Classe que faz a requisição à API.
pom.xml: Arquivo de configuração do Maven.
```
