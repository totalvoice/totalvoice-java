package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.RequestInterface;
import br.com.totalvoice.Constants;
import org.json.JSONObject;

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
     * @throws Exception
     */
    public JSONObject enviar(String numero, String urlAudio) throws Exception {

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
     * @throws Exception
     */
    public JSONObject enviar(String numero, String urlAudio, boolean respostaUsuario) throws Exception {

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
     * @throws Exception
     */
    public JSONObject enviar(String numero, String urlAudio, boolean respostaUsuario, String bina) throws Exception {

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
     * @param respostaUsuario
     * @param bina
     * @param gravarAudio
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String numero, String urlAudio, boolean respostaUsuario, String bina, boolean gravarAudio) throws Exception {

        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("url_audio", urlAudio);
        data.put("resposta_usuario", respostaUsuario);
        data.put("bina", bina);
        data.put("gravar_audio", gravarAudio);

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
     * @param gravarAudio
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String numero, String urlAudio, boolean respostaUsuario, boolean gravarAudio) throws Exception {

        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("url_audio", urlAudio);
        data.put("resposta_usuario", respostaUsuario);
        data.put("gravar_audio", gravarAudio);

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
     * @param gravarAudio
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String numero, String urlAudio, String bina, boolean gravarAudio) throws Exception {

        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("url_audio", urlAudio);
        data.put("bina", bina);
        data.put("gravar_audio", gravarAudio);

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
     * @throws Exception
     */
    public JSONObject enviar(String numero, String urlAudio, String bina) throws Exception {

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
     * @throws Exception
     */
    public JSONObject buscar(int id) throws Exception {

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
     * @throws Exception
     */
    public JSONObject relatorio(Date dataInicio, Date dataFim) throws Exception {

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
