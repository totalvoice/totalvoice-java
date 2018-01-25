package br.com.totalvoice.api;

import br.com.totalvoice.*;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sms extends Api {

    public static final String ROTA_SMS = "sms";

    public Sms(ClientInterface client) {
        super(client);
    }

    public Sms(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Envia SMS
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
        path.add(ROTA_SMS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia SMS
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
        path.add(ROTA_SMS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Envia SMS
     * @param numero
     * @param mensagem
     * @param multiSMS
     * @return
     * @throws IOException
     */
    public JSONObject enviar(String numero, String mensagem, boolean respostaUsuario, boolean multiSMS) throws IOException
    {
        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        data.put("mensagem", mensagem);
        data.put("resposta_usuario", respostaUsuario);
        data.put("multi_sms", multiSMS);

        Path path = new Path();
        path.add(ROTA_SMS);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Busca um sms pelo seu ID
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject buscar(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_SMS);
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
        path.add(ROTA_SMS);
        path.add("relatorio");

        QueryString query = new QueryString();
        query.add("data_inicio", dataInicial);
        query.add("data_fim", dataFinal);

        request.setPath(path);
        request.setQuery(query);

        return client.get(request);
    }
}
