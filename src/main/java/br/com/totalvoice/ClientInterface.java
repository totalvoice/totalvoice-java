package br.com.totalvoice;

import org.json.JSONObject;

public interface ClientInterface {

    /**
     * @var String
     */
    public static final String BASE_URL = "https://api2.totalvoice.com.br";

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    public JSONObject get(RequestInterface request) throws Exception;

    /**
     * POST method
     * @return String
     */
    public JSONObject post(RequestInterface request, JSONObject data) throws Exception;

    /**
     * PUT method
     * @return String
     */
    public JSONObject put(RequestInterface request, JSONObject data) throws Exception;

    /**
     * DELETE method
     * @return String
     */
    public JSONObject delete(RequestInterface request) throws Exception;
}
