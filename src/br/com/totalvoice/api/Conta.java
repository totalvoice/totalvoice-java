package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Path;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.Request;
import org.json.JSONObject;

import java.io.IOException;

public class Conta {

    public static final String ROTA_SALDO = "saldo";

    private ClientInterface client;

    public Conta(ClientInterface client) {
        this.client = client;
    }

    public JSONObject consultaSaldo() throws IOException
    {
        Path path = new Path();
        path.add(ROTA_SALDO);

        Request r = new Request();
        r.setPath(path);

        return client.get(r, "");
    }
}
