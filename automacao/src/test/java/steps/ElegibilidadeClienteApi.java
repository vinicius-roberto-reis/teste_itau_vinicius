package steps;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ElegibilidadeClienteApi {
    private static final String BASE_URL = "https://teste/1.0/elegibilidade_cliente";

    public static boolean verificarElegibilidadeCliente(String indicadorClienteCorrentista, String indicadorContaAtiva, String codigoTipoProdutoOferta, String codigoProdutoOrigem) {
        // Construindo o body para requisição
        String requestBody = "{\"elegibilidade_cliente_entrada\": {\"contratos\": [{\"indicador_conta_ativa\": \"" +
                            indicadorContaAtiva + "\", \"indicador_cliente_correntista\": \"" + indicadorClienteCorrentista + "\", " +
                            "\"codigo_tipo_produto_oferta\": \"" + codigoTipoProdutoOferta + "\", \"codigo_produto_origem\": " +
                            codigoProdutoOrigem + "}]}}";
    
        Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(requestBody)
            .post(BASE_URL);
    
    String responseBody = response.getBody().asString();

    boolean clienteElegivel = false;
    if (responseBody.contains("\"indicador_elegebilidade_client\": \"S\"")) {
        clienteElegivel = true;
    }

    return clienteElegivel;
    }
    
}
