package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.RequestInterface;
import org.json.JSONObject;

public class Fila extends Api {

    public static final String ROTA_FILA = "fila";

    public Fila(ClientInterface client) {
        super(client);
    }

    public Fila(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Cria uma fila
     * @param nome
     * @param estrategiaRing
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String nome, String estrategiaRing) throws Exception {

        JSONObject data = new JSONObject();
        data.put("nome", nome);
        data.put("estrategia_ring", estrategiaRing);

        Path path = new Path();
        path.add(ROTA_FILA);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Cria uma fila
     * @param nome
     * @param estrategiaRing
     * @param timeoutRing
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String nome, String estrategiaRing, int timeoutRing) throws Exception {

        JSONObject data = new JSONObject();
        data.put("nome", nome);
        data.put("estrategia_ring", estrategiaRing);
        data.put("timeout_ring", timeoutRing);

        Path path = new Path();
        path.add(ROTA_FILA);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Adiciona um ramal na fila
     * @param id
     * @param ramalId
     * @return
     * @throws Exception
     */
    public JSONObject adicionaRamalFila(int id, int ramalId) throws Exception {

        JSONObject data = new JSONObject();
        data.put("ramalId", ramalId);

        Path path = new Path();
        path.add(ROTA_FILA);
        path.add(id);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Atualiza fila
     * @param data
     * @return
     * @throws Exception
     */
    public JSONObject atualizar(JSONObject data) throws Exception {

        Object id = data.get("id");
        if(id == null) {
            throw new Exception("Nao foi possivel recuperar o ID da Fila");
        }
        Path path = new Path();
        path.add(ROTA_FILA);
        path.add(id);

        request.setPath(path);

        return client.put(request, data);
    }

    /**
     * Leitura dos dados da Fila
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject buscar(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_FILA);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Leitura dos dados da Fila
     * @param id
     * @param ramalId
     * @return
     * @throws Exception
     */
    public JSONObject buscar(int id, int ramalId) throws Exception {

        Path path = new Path();
        path.add(ROTA_FILA);
        path.add(id);
        path.add(ramalId);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Remove uma fila
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject excluir(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_FILA);
        path.add(id);

        request.setPath(path);

        return client.delete(request);
    }

}