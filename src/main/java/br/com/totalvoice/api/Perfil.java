package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.RequestInterface;
import org.json.JSONObject;

public class Perfil extends Api {

    public static final String ROTA_CONTA   = "conta";
    public static final String ROTA_WEBHOOK = "webhook";
    public static final String ROTA_SALDO   = "saldo";

    /**
     * @param client
     */
    public Perfil(ClientInterface client) {
        super(client);
    }

    /**
     * @param client
     * @param request
     */
    public Perfil(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Consulta o saldo da conta
     * @return
     * @throws Exception
     */
    public JSONObject consultaSaldo() throws Exception {

        Path path = new Path();
        path.add(ROTA_SALDO);
        request.setPath(path);

        return client.get(request);
    }

    /**
     * Consulta os dados da Minha Conta
     * @return
     * @throws Exception
     */
    public JSONObject minhaConta() throws Exception {

        Path path = new Path();
        path.add(ROTA_CONTA);
        request.setPath(path);

        return client.get(request);
    }

    /**
     * Atualiza os dados da Minha
     * @param data
     * @return
     * @throws Exception
     */
    public JSONObject atualizaDadosConta(JSONObject data) throws Exception {

        Path path = new Path();
        path.add(ROTA_CONTA);
        request.setPath(path);

        return client.put(request, data);
    }

    /**
     * Consulta o saldo da conta
     * @return
     * @throws Exception
     */
    public JSONObject relatorioRecarga() throws Exception {

        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add("recargas");
        request.setPath(path);

        return client.get(request);
    }
    
    /**
     * Gera uma URL para recarga de créditos
     * @return
     * @throws Exception
     */
    public JSONObject urlRecarga(String urlRetorno) throws Exception {

        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add("urlrecarga");
        
        QueryString query = new QueryString();
        query.add("url_retorno", urlRetorno);
        
        request.setPath(path);
        request.setQuery(query);        

        return client.get(request);
    }
    
    /**
     * Retorna a lista de webhooks configurados para esta conta
     * @return
     * @throws Exception
     */
    public JSONObject webhooks() throws Exception {

        Path path = new Path();
        path.add(ROTA_WEBHOOK);
                
        request.setPath(path);     

        return client.get(request);
    }

    /**
     * Apaga um Webhook
     * @return
     * @throws Exception
     */
    public JSONObject excluirWebhook(String nome) throws Exception {

        Path path = new Path();
        path.add(ROTA_WEBHOOK);
        path.add(nome);

        request.setPath(path);

        return client.delete(request);
    }

    /**
     * Cadastra ou atualiza um webhook
     * @return
     * @throws Exception
     */
    public JSONObject salvaWebhook(String nome, String url) throws Exception {

        Path path = new Path();
        path.add(ROTA_WEBHOOK);
        path.add(nome);

        request.setPath(path);

        JSONObject data = new JSONObject();
        data.put("url", url);

        return client.put(request, data);
    }
}

