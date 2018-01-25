package br.com.totalvoice.api;

import br.com.totalvoice.*;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tts extends Api {

    public static final String ROTA_TTS = "tts";

    public Tts(ClientInterface client) {
        super(client);
    }

    public Tts(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param velocidade
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, int velocidade) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("velocidade", velocidade);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param velocidade
     * @param respostaUsuario
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, int velocidade, boolean respostaUsuario) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("velocidade", velocidade);
        data.put("resposta_usuario", respostaUsuario);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param velocidade
     * @param respostaUsuario
     * @param tipoVoz
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, int velocidade, boolean respostaUsuario, String tipoVoz) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("velocidade", velocidade);
        data.put("resposta_usuario", respostaUsuario);
        data.put("tipo_voz", tipoVoz);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param velocidade
     * @param respostaUsuario
     * @param tipoVoz
     * @param bina
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, int velocidade, boolean respostaUsuario, String tipoVoz, String bina) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("velocidade", velocidade);
        data.put("resposta_usuario", respostaUsuario);
        data.put("tipo_voz", tipoVoz);
        data.put("bina", bina);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param respostaUsuario
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, boolean respostaUsuario) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("resposta_usuario", respostaUsuario);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param respostaUsuario
     * @param tipoVoz
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, boolean respostaUsuario, String tipoVoz) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("resposta_usuario", respostaUsuario);
        data.put("tipo_voz", tipoVoz);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param respostaUsuario
     * @param tipoVoz
     * @param bina
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, boolean respostaUsuario, String tipoVoz, String bina) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("resposta_usuario", respostaUsuario);
        data.put("tipo_voz", tipoVoz);
        data.put("bina", bina);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param tipoVoz
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, String tipoVoz) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("tipo_voz", tipoVoz);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia TTS
     * @param numero
     * @param mensagem
     * @param tipoVoz
     * @param bina
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, String tipoVoz, String bina) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("tipo_voz", tipoVoz);
        data.put("bina", bina);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     *
     * @param numero
     * @param mensagem
     * @param bina
     * @param velocidade
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, String bina, int velocidade) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("bina", bina);
        data.put("velocidade", velocidade);

        Path path = new Path();
        path.add(ROTA_TTS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Busca um TTS pelo seu ID
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject buscar(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_TTS);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Relatório de mensagens de Sms
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
        path.add(ROTA_TTS);
        path.add("relatorio");

        QueryString query = new QueryString();
        query.add("data_inicio", dataInicial);
        query.add("data_fim", dataFinal);

        request.setPath(path);
        request.setQuery(query);

        return client.get(request);
    }
}
