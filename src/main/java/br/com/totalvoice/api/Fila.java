package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.RequestInterface;
import br.com.totalvoice.Constants;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fila extends Api {

    public static final String ROTA_FILA = "fila";

    public Tts(ClientInterface client) {
        super(client);
    }

    public Tts(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Cria uma fila
     * @param nome
     * @param estrategia_ring
     * @param timeout_ring
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String nome, String estrategia_ring) throws Exception {

        JSONObject data = new JSONObject();
        data.put("nome", nome);
        data.put("estrategia_ring", estrategia_ring);

        Path path = new Path();
        path.add(ROTA_FILA);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Cria uma fila
     * @param nome
     * @param estrategia_ring
     * @param timeout_ring
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String nome, String estrategia_ring, int timeout_ring) throws Exception {

        JSONObject data = new JSONObject();
        data.put("nome", nome);
        data.put("estrategia_ring", estrategia_ring);
        data.put("timeout_ring", timeout_ring);

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

        Object id = data.get("id");
        if(id == null) {
            throw new Exception("Nao foi possivel recuperar o ID da Fila");
        }

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