package br.com.totalvoice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TotalVoiceClient implements ClientInterface {

    /**
     * Access Token
     * @var String
     */
    private String token;

    /**
     * Base URL
     * @var String
     */
    private String baseUrl;

    /**
     * @var HttpClient
     */
    private HttpClient client;

    /**
     * @param token
     */
    public TotalVoiceClient(String token) {
        this.token = token;
        this.baseUrl = BASE_URL;
        this.client = HttpClients.createDefault();
    }

    /**
     * @param token
     * @param baseUrl
     */
    public TotalVoiceClient(String token, String baseUrl) {
        this.token = token;
        this.baseUrl = baseUrl;
        this.client = HttpClients.createDefault();
    }

    @Override
    public JSONObject get(String path, String data) throws IOException {

        HttpGet request = new HttpGet(baseUrl + path);
        return execute(request);
    }

    @Override
    public String post() {
        return null;
    }

    @Override
    public String put() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }

    public JSONObject execute(HttpUriRequest request) throws IOException {

        request.addHeader("Access-Token", token);
        request.addHeader("Content-Type", "application/json");

        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };

        String responseBody = client.execute(request, responseHandler);
        return new JSONObject(responseBody);
        //return result.toString();
    }
}
