package br.com.totalvoice.api;

import br.com.totalvoice.*;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Audio extends Api {

    public static final String ROTA_AUDIO = "audio";

    /**
     * @param client
     */
    public Audio(ClientInterface client) {
        super(client);
    }

    /**
     * @param client
     * @param request
     */
    public Audio(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Envia um audio para um número destino
     * @param numero
     * @param urlAudio
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String urlAudio) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("url_audio", urlAudio);

        Path path = new Path();
        path.add(ROTA_AUDIO);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia um audio para um número destino
     * @param numero
     * @param urlAudio
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String urlAudio, boolean respostaUsuario) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("url_audio", urlAudio);
        data.put("resposta_usuario", respostaUsuario);

        Path path = new Path();
        path.add(ROTA_AUDIO);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia um audio para um número destino
     * @param numero
     * @param urlAudio
     * @param respostaUsuario
     * @param bina
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String urlAudio, boolean respostaUsuario, String bina) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("url_audio", urlAudio);
        data.put("resposta_usuario", respostaUsuario);
        data.put("bina", bina);

        Path path = new Path();
        path.add(ROTA_AUDIO);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia um audio para um número destino
     * @param numero
     * @param urlAudio
     * @param bina
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String urlAudio, String bina) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("url_audio", urlAudio);
        data.put("bina", bina);

        Path path = new Path();
        path.add(ROTA_AUDIO);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Busca um envio de audio pelo seu ID
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject buscar(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_AUDIO);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Relatório de mensagens de Audios
     * @param dataInicio
     * @param dataFim
     * @return
     * @throws IOException
     */
    public JSONObject relatorio(Date dataInicio, Date dataFim) throws IOException
    {
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT);

        String dataInicial = formatter.format(dataInicio);
        String dataFinal = formatter.format(dataFim);

        Path path = new Path();
        path.add(ROTA_AUDIO);
        path.add("relatorio");

        QueryString query = new QueryString();
        query.add("data_inicio", dataInicial);
        query.add("data_fim", dataFinal);

        request.setPath(path);
        request.setQuery(query);

        return client.get(request);
    }
}
