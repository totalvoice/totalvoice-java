package br.com.totalvoice.api;

import br.com.totalvoice.*;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Central extends Api {

    public static final String ROTA_RAMAL = "ramal";
    public static final String ROTA_WEBPHONE = "webphone";
    public static final String ROTA_URA = "ura";

    /**
     * @param client
     */
    public Central(ClientInterface client) {
        super(client);
    }

    /**
     * @param client
     * @param request
     */
    public Central(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    /**
     * Cria um novo ramal
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject criarRamal(JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_RAMAL);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Atualiza um ramal
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject atualizarRamal(int id, JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_RAMAL);
        path.add(id);

        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Atualiza um ramal
     * @param data
     * @return
     * @throws Exception
     * @throws IOException
     */
    public JSONObject atualizarRamal(JSONObject data) throws Exception, IOException
    {
        Object id = data.get("id");
        if(id == null) {
            throw new Exception("Nao foi possivel recuperar o ID da Conta");
        }
        Path path = new Path();
        path.add(ROTA_RAMAL);
        path.add(id);

        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Excluir ramal
     * @return
     * @throws IOException
     */
    public JSONObject excluirRamal(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_RAMAL);
        path.add(id);

        request.setPath(path);

        return client.delete(request);
    }

    /**
     * Busca um ramal pelo seu ID
     * @param id
     * @return
     * @throws IOException
     */
    public JSONObject buscarRamal(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_RAMAL);
        path.add(id);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Relatório de ramais
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
        path.add(ROTA_RAMAL);
        path.add("relatorio");

        QueryString query = new QueryString();
        query.add("data_inicio", dataInicial);
        query.add("data_fim", dataFinal);

        request.setPath(path);
        request.setQuery(query);

        return client.get(request);
    }

    /**
     * Requisita a URL do webphone de um ramal
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject webphone(JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_WEBPHONE);

        QueryString query = new QueryString();
        for (Object key : data.keySet()) {
            //based on you key types
            query.add((String)key, data.get((String)key));
        }

        request.setPath(path);
        request.setQuery(query);

        return client.get(request);
    }

    /**
     * Requisita a URL do webphone de um ramal
     * @return
     * @throws IOException
     */
    public JSONObject webphone() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_WEBPHONE);

        request.setPath(path);

        return client.get(request);
    }

    /**
     * Criar URA
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject criarUra(JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_URA);
        request.setPath(path);

        return client.post(request, data);
    }

    /**
     * Excluir URA
     * @return
     * @throws IOException
     */
    public JSONObject excluirUra(int id) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_URA);
        path.add(id);

        request.setPath(path);

        return client.delete(request);
    }

    /**
     * Atualizar URA
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject atualizarUra(int id, JSONObject data) throws IOException
    {
        Path path = new Path();
        path.add(ROTA_URA);
        path.add(id);

        request.setPath(path);

        return client.put(request, data);
    }

    /**
     * Atualizar URA
     * @param data
     * @return
     * @throws Exception
     * @throws IOException
     */
    public JSONObject atualizarUra(JSONObject data) throws Exception, IOException
    {
        Object id = data.get("id");
        if(id == null) {
            throw new Exception("Nao foi possivel recuperar o ID da Conta");
        }
        Path path = new Path();
        path.add(ROTA_URA);
        path.add(id);

        request.setPath(path);

        return client.put(request, data);
    }
}
