package br.com.totalvoice;

import org.json.JSONObject;
import java.io.IOException;

public interface ClientInterface {

    /**
     * @var String
     */
    public static final String BASE_URL = "https://diegodev.totalvoice.com.br";

    /**
     *
     * @param route
     * @param data
     * @return
     * @throws IOException
     */
    public JSONObject get(RequestInterface route, String data) throws IOException;

    /**
     * POST method
     * @return String
     */
    public String post();

    /**
     * PUT method
     * @return String
     */
    public String put();

    /**
     * DELETE method
     * @return String
     */
    public String delete();
}
