package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.Request;
import br.com.totalvoice.RequestInterface;
import org.json.JSONObject;

import java.io.IOException;

public class Conta extends Api {

    public static final String ROTA_SALDO = "saldo";

    private ClientInterface client;

    /**
     * @param client
     */
    public Conta(ClientInterface client) {
        super(client);
    }

    /**
     * @param client
     * @param request
     */
    public Conta(ClientInterface client, RequestInterface request) {
        super(client, request);
    }

    public JSONObject consultaSaldo() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_SALDO);

        Request r = new Request();
        r.setPath(path);

        return client.get(r);
    }
}
