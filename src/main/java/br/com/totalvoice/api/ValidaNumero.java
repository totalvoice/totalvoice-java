package br.com.totalvoice.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Constants;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.RequestInterface;

public class ValidaNumero extends Api {

    public static final String ROTA_VALIDA_NUMERO = "valida_numero";

    public ValidaNumero(ClientInterface client) {
        super(client);
    }

    public ValidaNumero(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Cria um valida número
     * @param numero
     * @return
     * @throws Exception
     */
    public JSONObject enviar(String numero) throws Exception {

        JSONObject data = new JSONObject();
        data.put("numero_destino", numero);
        
        Path path = new Path();
        path.add(ROTA_VALIDA_NUMERO);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Retorna um valida número pelo id
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject buscar(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_VALIDA_NUMERO);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }
    
    /**
     * Retorna um valida número pelo id
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject realatorio(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_VALIDA_NUMERO);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }
    
    /**
     * Relatório de valida número
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
        path.add(ROTA_VALIDA_NUMERO);
        path.add("relatorio");

        QueryString query = new QueryString();
        query.add("data_inicio", dataInicial);
        query.add("data_fim", dataFinal);

        request.setPath(path);
        request.setQuery(query);

        return client.get(request);
    }


}