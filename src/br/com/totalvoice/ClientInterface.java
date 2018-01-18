package br.com.totalvoice;

import org.json.JSONObject;
import java.io.IOException;

public interface ClientInterface {

    /**
     * @var String
     */
    public static final String BASE_URL = "https://api2.totalvoice.com.br";

    /**
     * GET method
     * @return String
     */
    public JSONObject get(String path, String data) throws IOException;

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
