package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.Request;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

public class Perfil {

    public static final String ROTA_CONTA = "conta";
    public static final String ROTA_WEBHOOK = "webhook";
    public static final String ROTA_SALDO = "saldo";

    private ClientInterface client;

    public Perfil(ClientInterface client) {
        this.client = client;
    }

    /**
     * Consulta o saldo da conta
     * @return
     * @throws IOException
     */
    public JSONObject consultaSaldo() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_SALDO);

        Request r = new Request();
        r.setPath(path);

        return client.get(r);
    }

    /**
     * Consulta os dados da Minha Conta
     * @return
     * @throws IOException
     */
    public JSONObject minhaConta() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);

        Request r = new Request();
        r.setPath(path);

        return client.get(r);
    }

    /**
     * Atualiza os dados da Minha
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject atualizaDadosConta(JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);

        Request r = new Request();
        r.setPath(path);

        return client.put(r, data);
    }

    /**
     * Consulta o saldo da conta
     * @return
     * @throws IOException
     */
    public JSONObject relatorioRecarga() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add("recargas");

        Request r = new Request();
        r.setPath(path);

        return client.get(r);
    }
    
    /**
     * Gera uma URL para recarga de créditos
     * @return
     * @throws IOException
     */
    public JSONObject urlRecarga(String urlRetorno) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add("urlrecarga");
        
        QueryString query = new QueryString();
        query.add("url_retorno", urlRetorno);
        
        Request r = new Request();
        r.setPath(path);
        r.setQuery(query);        

        return client.get(r);
    }
}

