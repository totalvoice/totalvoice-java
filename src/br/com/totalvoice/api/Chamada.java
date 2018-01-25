package br.com.totalvoice.api;

import br.com.totalvoice.*;
import org.json.JSONObject;

import java.io.IOException;
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
     * @throws IOException
     */
    public JSONObject ligar(String numeroOrigem, String numeroDestino) throws IOException
    {
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
     * @throws IOException
     */
    public JSONObject ligar(String numeroOrigem, String numeroDestino, JSONObject opcoes) throws IOException
    {
        opcoes.put("numero_origem", numeroOrigem);
        opcoes.put("numero_destino", numeroDestino);

        Path path = new Path();
        path.add(ROTA_CHAMADA);
        request.setPath(path);

        return client.post(request, opcoes);
    }

    /**
     * Leitura dos dados da Conta criada
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject buscar(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Encerrar chamada ativa
     * @return
     * @throws IOException
     */
    public JSONObject encerrar(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);

        request.setPath(path);

        return client.delete(request);
    }

    /**
     * Leitura dos dados da Conta criada
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject downloadGravacao(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_CHAMADA);
        path.add(id);
        path.add("gravacao");

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
     * @throws IOException
     */
    public JSONObject escutar(int id, String numero, int modo) throws IOException
    {
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
     * @throws IOException
     */
    public JSONObject transferir(int id, String numero, String perna) throws IOException
    {
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
     * @throws IOException
     */
    public JSONObject avaliar(int id, String nota) throws IOException
    {
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
     * @throws IOException
     */
    public JSONObject avaliar(int id, String nota, String comentario) throws IOException
    {
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
