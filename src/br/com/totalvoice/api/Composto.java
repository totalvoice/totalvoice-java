package br.com.totalvoice.api;

import br.com.totalvoice.*;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Composto extends Api {

    public static final String ROTA_COMPOSTO = "composto";

    public Composto(ClientInterface client) {
        super(client);
    }

    public Composto(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Envia um composto para um número destino
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject enviar(JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_COMPOSTO);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Busca um composto pelo seu ID
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject buscar(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_COMPOSTO);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Relatório de mensagens de Composto
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
        path.add(ROTA_COMPOSTO);
        path.add("relatorio");

        QueryString query = new QueryString();
        query.add("data_inicio", dataInicial);
        query.add("data_fim", dataFinal);

        request.setPath(path);
        request.setQuery(query);

        return client.get(request);
    }
}
