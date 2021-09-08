package br.com.totalvoice;

import org.json.JSONObject;

public interface ClientInterface {

    /**
     *
     */
    public static final String BASE_URL = "https://voice-api.zenvia.com";

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    public JSONObject get(RequestInterface request) throws Exception;

    /**
     *
     * @param request
     * @param data
     * @return
     * @throws Exception
     */
    public JSONObject post(RequestInterface request, JSONObject data) throws Exception;

    /**
     *
     * @param request
     * @param data
     * @return
     * @throws Exception
     */
    public JSONObject put(RequestInterface request, JSONObject data) throws Exception;

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    public JSONObject delete(RequestInterface request) throws Exception;
}
