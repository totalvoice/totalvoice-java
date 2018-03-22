package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.RequestInterface;
import br.com.totalvoice.Constants;
import org.json.JSONObject;

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
     * @throws Exception
     */
    public JSONObject enviar(JSONObject data) throws Exception {

        Path path = new Path();
        path.add(ROTA_COMPOSTO);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Busca um composto pelo seu ID
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject buscar(int id) throws Exception {

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
     * @throws Exception
     */
    public JSONObject relatorio(Date dataInicio, Date dataFim) throws Exception {

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
