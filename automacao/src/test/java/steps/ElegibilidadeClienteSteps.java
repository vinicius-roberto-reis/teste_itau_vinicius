package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

public class ElegibilidadeClienteSteps {
    private boolean clienteElegivel;
    private String indicadorContaAtiva;
    private String indicadorClienteCorrentista;
    private String codigoTipoProdutoOferta;
    private String codigoProdutoOrigem;
    

    @Dado("que tenho um cliente com o seguinte contrato")
    public void que_tenho_um_cliente_com_o_seguinte_contrato(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> contrato = data.get(0);
        
        indicadorContaAtiva = contrato.get("indicadorContaAtiva");
        indicadorClienteCorrentista = contrato.get("indicadorClienteCorrentista");
        codigoTipoProdutoOferta = contrato.get("codigoTipoProdutoOferta");
        codigoProdutoOrigem = contrato.get("codigoProdutoOrigem");
    }

    @Quando("realizo uma requisição POST para verificar a elegibilidade do cliente")
    public void realizo_uma_requisicao_POST_para_verificar_a_elegibilidade_do_cliente() {
            clienteElegivel = ElegibilidadeClienteApi.verificarElegibilidadeCliente(
            indicadorClienteCorrentista,
            indicadorContaAtiva,
            codigoTipoProdutoOferta,
            codigoProdutoOrigem
        );
    }

    @Então("a resposta deve conter o indicador de elegibilidade {string}")
    public void resposta_deve_conter_o_indicador_de_elegibilidade(String indicadorElegibilidadeEsperado) {
        if (!(indicadorElegibilidadeEsperado.equals("S") || indicadorElegibilidadeEsperado.equals("N"))) {
            fail("A string da step deve ser 'S' ou 'N'.");
        }
        if ((indicadorElegibilidadeEsperado.equals("S") && clienteElegivel) || 
            (indicadorElegibilidadeEsperado.equals("N") && !clienteElegivel)) {
            assertTrue("A condição é verdadeira", clienteElegivel);
        } else {
            fail("O indicador de elegibilidade não corresponde ao esperado.");
        }
    }
}
