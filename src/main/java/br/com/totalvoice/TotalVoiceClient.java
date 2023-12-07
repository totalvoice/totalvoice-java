package br.com.totalvoice;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TotalVoiceClient implements ClientInterface {

    private static final String VERSION = "1.4.13";

    private String token;

    private String baseUrl;

    private HttpClient client;

    /**
     *
     * @param token
     */
    public TotalVoiceClient(final String token) {
        this.token = token;
        this.baseUrl = BASE_URL;
        this.client = HttpClients.createDefault();
    }

    /**
     *
     * @param token
     * @param baseUrl
     */
    public TotalVoiceClient(final String token, final String baseUrl) {
        this.token = token;
        this.baseUrl = baseUrl;
        this.client = HttpClients.createDefault();
    }

    @Override
    public JSONObject get(RequestInterface request) throws Exception {
        HttpGet get = new HttpGet(baseUrl + request.getURL());
        return execute(get);
    }

    @Override
    public JSONObject post(RequestInterface request, JSONObject data) throws Exception {
        HttpPost post = new HttpPost(baseUrl + request.getURL());
        post.setEntity(new StringEntity(data.toString(), "UTF-8"));
        return execute(post);
    }

    @Override
    public JSONObject put(RequestInterface request, JSONObject data) throws Exception {
        HttpPut put = new HttpPut(baseUrl + request.getURL());
        put.setEntity(new StringEntity(data.toString(), "UTF-8"));
        return execute(put);
    }

    @Override
    public JSONObject delete(RequestInterface request) throws Exception {
        HttpDelete delete = new HttpDelete(baseUrl + request.getURL());
        return execute(delete);
    }

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    public JSONObject execute(HttpUriRequest request) throws Exception {

        request.addHeader("Access-Token", token);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("User-Agent", "lib-java/"+VERSION);

        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        };

        String responseBody = client.execute(request, responseHandler);
        return new JSONObject(responseBody);
    }
}
