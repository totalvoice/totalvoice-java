package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.RequestInterface;
import br.com.totalvoice.Constants;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chamada extends Api {

    public static final String ROTA_CHAMADA = "chamada";

    /**
     * @param client
     */
    public Chamada(ClientInterface client) {
        super(client);
    }

    /**
     * @param client
     * @param request
     */
    public Chamada(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Cria uma chamada
     * @param numeroOrigem
     * @param numeroDestino
     * @return
     * @throws Exception
     */
    public JSONObject ligar(String numeroOrigem, String numeroDestino) throws Exception {

        JSONObject data = new JSONObject();
        data.put("numero_origem", numeroOrigem);
        data.put("numero_destino", numeroDestino);

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Cria uma chamada com opcoes adicionais
     * @param numeroOrigem
     * @param numeroDestino
     * @param opcoes
     * @return
     * @throws Exception
     */
    public JSONObject ligar(String numeroOrigem, String numeroDestino, JSONObject opcoes) throws Exception {

        opcoes.put("numero_origem", numeroOrigem);
        opcoes.put("numero_destino", numeroDestino);

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        request.setPath(path);

        return client.post(request, opcoes);
    }

    /**
     * busca os dados da chamada
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject buscar(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Encerrar chamada ativa
     * @return
     * @throws Exception
     */
    public JSONObject encerrar(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);

        request.setPath(path);

        return client.delete(request);
    }

    /**
     * URL para download do audio
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject downloadGravacao(int id) throws Exception {

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);
        path.add("gravacao");

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Relatório de chamadas
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
        path.add(ROTA_CHAMADA);
        path.add("relatorio");

        QueryString query = new QueryString();
        query.add("data_inicio", dataInicial);
        query.add("data_fim", dataFinal);

        request.setPath(path);
        request.setQuery(query);

        return client.get(request);
    }

    /**
     * (Beta) Escuta uma chamada ativa
     * @param id
     * @param numero
     * @param modo
     * @return
     * @throws Exception
     */
    public JSONObject escutar(int id, String numero, int modo) throws Exception {

        JSONObject data = new JSONObject();
        data.put("numero", numero);
        data.put("modo", modo);

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);
        path.add("escuta");

        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * (Beta) Faz uma transferência da chamada atual
     * @param id
     * @param numero
     * @param perna
     * @return
     * @throws Exception
     */
    public JSONObject transferir(int id, String numero, String perna) throws Exception {

        JSONObject data = new JSONObject();
        data.put("numero", numero);
        data.put("perna", perna);

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);
        path.add("transfer");

        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Avalia uma Chamada com nota de 1 a 5
     * @param id
     * @param nota
     * @return
     * @throws Exception
     */
    public JSONObject avaliar(int id, String nota) throws Exception {

        JSONObject data = new JSONObject();
        data.put("nota", nota);

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);
        path.add("avaliar");

        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Avalia uma Chamada com comentario com nota de 1 a 5
     * @param id
     * @param nota
     * @param comentario
     * @return
     * @throws Exception
     */
    public JSONObject avaliar(int id, String nota, String comentario) throws Exception {

        JSONObject data = new JSONObject();
        data.put("nota", nota);
        data.put("comentario", comentario);

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);
        path.add("avaliar");

        request.setPath(path);

        return client.post(request, data);
    }
}
