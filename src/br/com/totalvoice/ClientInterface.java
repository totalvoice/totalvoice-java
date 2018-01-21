package br.com.totalvoice;

import org.json.JSONObject;
import java.io.IOException;

public interface ClientInterface {

    /**
     * @var String
     */
    public static final String BASE_URL = "https://api2.totalvoice.com.br";

    /**
     *
     * @param request
     * @return
     * @throws IOException
     */
    public JSONObject get(RequestInterface request) throws IOException;

    /**
     * POST method
     * @return String
     */
    public JSONObject post(RequestInterface request, JSONObject data) throws IOException;

    /**
     * PUT method
     * @return String
     */
    public JSONObject put(RequestInterface request, JSONObject data) throws IOException;

    /**
     * DELETE method
     * @return String
     */
    public JSONObject delete(RequestInterface request) throws IOException;
}
