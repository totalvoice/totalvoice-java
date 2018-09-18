package br.com.totalvoice.api;

import br.com.totalvoice.*;
import org.json.JSONObject;

public class Bina extends Api {

    public static final String ROTA_BINA = "bina";

    /**
     * @param client
     */
    public Bina(ClientInterface client) {
        super(client);
    }

    /**
     * @param client
     * @param request
     */
    public Bina(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Envia um número pra receber um código de validação
     *
     * @param telefone
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String telefone) throws Exception {

        JSONObject data = new JSONObject();
        data.put("telefone", telefone);

        Path path = new Path();
        path.add(ROTA_BINA);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Verifica se o código é válido para o telefone
     *
     * @param codigo
     * @param telefone
     * @return
     * @throws Exception
     */
    public JSONObject validar(String codigo, String telefone) throws Exception {

        Path path = new Path();
        path.add(ROTA_BINA);
        request.setPath(path);

        QueryString query = new QueryString();
        query.add("codigo", codigo);
        query.add("telefone", telefone);

        return client.get(request);
    }

    /**
     * Remove o telefone cadastrado na sua Conta
     *
     * @param telefone
     * @return
     * @throws Exception
     */
    public JSONObject excluir(String telefone) throws Exception {

        Path path = new Path();
        path.add(ROTA_BINA);
        path.add(telefone);

        request.setPath(path);

        return client.delete(request);
    }

    /**
     * Gera relatório com os números cadastrados
     *
     * @return
     * @throws Exception
     */
    public JSONObject relatorio() throws Exception {

        Path path = new Path();
        path.add(ROTA_BINA);
        path.add("relatorio");

        request.setPath(path);

        return client.get(request);
    }
}
