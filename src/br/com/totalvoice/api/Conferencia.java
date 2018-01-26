package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.RequestInterface;
import org.json.JSONObject;

import java.io.IOException;

public class Conferencia extends Api {

    public static final String ROTA_CONFERENCIA = "conferencia";

    public Conferencia(ClientInterface client) {
        super(client);
    }

    public Conferencia(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Cria uma conferencia
     * @return
     * @throws IOException
     */
    public JSONObject criar() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONFERENCIA);
        request.setPath(path);

        return client.post(request, null);
    }

    /**
     * Adiciona numero em uma conferencia
     * @param id
     * @param numero
     * @return
     * @throws IOException
     */
    public JSONObject addNumeroConferencia(int id, String numero) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero", numero);

        Path path = new Path();
        path.add(ROTA_CONFERENCIA);
        path.add(id);

        request.setPath(path);

        return client.post(request, null);
    }

    /**
     * Adiciona numero em uma conferencia
     * @param id
     * @param numero
     * @param bina
     * @return
     * @throws IOException
     */
    public JSONObject addNumeroConferencia(int id, String numero, String bina) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero", numero);
        data.put("bina", bina);

        Path path = new Path();
        path.add(ROTA_CONFERENCIA);
        path.add(id);

        request.setPath(path);

        return client.post(request, null);
    }

    /**
     * Adiciona numero em uma conferencia
     * @param id
     * @param numero
     * @param bina
     * @param gravarAudio
     * @return
     * @throws IOException
     */
    public JSONObject addNumeroConferencia(int id, String numero, String bina, boolean gravarAudio) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero", numero);
        data.put("bina", bina);
        data.put("gravar_audio", gravarAudio);

        Path path = new Path();
        path.add(ROTA_CONFERENCIA);
        path.add(id);

        request.setPath(path);

        return client.post(request, null);
    }

    /**
     * Adiciona numero em uma conferencia
     * @param id
     * @param numero
     * @param gravarAudio
     * @return
     * @throws IOException
     */
    public JSONObject addNumeroConferencia(int id, String numero, boolean gravarAudio) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero", numero);
        data.put("gravar_audio", gravarAudio);

        Path path = new Path();
        path.add(ROTA_CONFERENCIA);
        path.add(id);

        request.setPath(path);

        return client.post(request, null);
    }

    /**
     * Busca uma conferencia
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject buscar(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONFERENCIA);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Remove uma conferencia
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject excluir(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CONFERENCIA);
        path.add(id);

        request.setPath(path);

        return client.delete(request);
    }
}
