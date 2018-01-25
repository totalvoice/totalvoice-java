package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.RequestInterface;
import org.json.JSONObject;

import java.io.IOException;

public class Conta extends Api {

    public static final String ROTA_CONTA = "conta";

    /**
     * @param client
     */
    public Conta(ClientInterface client) {
        super(client);
    }

    /**
     * @param client
     * @param request
     */
    public Conta(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Cria uma nova conta na plataforma
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject criar(JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Atualiza os dados de uma conta
     * @param id
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject atualizar(int id, JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add(id);

        request.setPath(path);

        return client.put(request, data);
    }

    /**
     * Atualiza os dados de uma conta
     * @param data
     * @return
     * @throws Exception, IOException
     */
    public JSONObject atualizar(JSONObject data) throws Exception, IOException
    {
        Object id = data.get("id");
        if(id == null) {
            throw new Exception("Nao foi possivel recuperar o ID da Conta");
        }
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add(id);

        request.setPath(path);

        return client.put(request, data);
    }

    /**
     * Leitura dos dados da Conta criada
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject buscar(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Remove uma conta
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject excluir(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add(id);

        request.setPath(path);

        return client.delete(request);
    }

    /**
     * Leitura dos dados da Conta criada
     * @return
     * @throws IOException
     */
    public JSONObject relatorio() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONTA);
        path.add("relatorio");

        request.setPath(path);

        return client.get(request);
    }
}
