package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.RequestInterface;
import org.json.JSONObject;

public class Did extends Api {

    public static final String ROTA_DID = "did";

    /**
     * @param client
     */
    public Did(ClientInterface client) {
        super(client);
    }

    /**
     * @param client
     * @param request
     */
    public Did(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Lista todos os DIDs pertencentes
     * @return
     * @throws Exception
     */
    public JSONObject listar() throws Exception {

        Path path = new Path();
        path.add(ROTA_DID);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Remove um DID
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject excluir(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_DID);
        path.add(id);

        request.setPath(path);

        return client.delete(request);
    }

    /**
     * Atualiza um did
     * @param id
     * @param data
     * @return
     * @throws Exception
     */
    public JSONObject atualizar(int id, JSONObject data) throws Exception {

        Path path = new Path();
        path.add(ROTA_DID);
        path.add(id);

        request.setPath(path);

        return client.put(request, data);
    }

    /**
     * Atualiza um did
     * @param data
     * @return
     * @throws Exception
     */
    public JSONObject atualizar(JSONObject data) throws Exception {

        Object id = data.get("id");
        if(id == null) {
            throw new Exception("Nao foi possivel recuperar o ID da Conta");
        }
        Path path = new Path();
        path.add(ROTA_DID);
        path.add(id);

        request.setPath(path);

        return client.put(request, data);
    }

    /**
     * Lista todos os DIDs disponiveis
     * @return
     * @throws Exception
     */
    public JSONObject estoque() throws Exception {

        Path path = new Path();
        path.add(ROTA_DID);
        path.add("estoque");

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Adquire um novo did para sua conta
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject adquirir(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_DID);
        path.add("estoque");
        path.add(id);

        request.setPath(path);

        return client.post(request, null);
    }

    /**
     * Lista todos os DIDs disponiveis
     * @return
     * @throws Exception
     */
    public JSONObject buscaChamadaRecebida(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_DID);
        path.add("chamada");
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }
}
