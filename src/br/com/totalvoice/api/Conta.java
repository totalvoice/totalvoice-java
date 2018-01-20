package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.QueryString;
import br.com.totalvoice.Request;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Conta {

    public static final String ROTA_SALDO = "saldo";

    private ClientInterface client;

    public Conta(ClientInterface client) {
        this.client = client;
    }

    public JSONObject consultaSaldo() throws IOException
    {
        ArrayList path = new ArrayList();
        path.add(ROTA_SALDO);

        QueryString query = new QueryString();
        query.add("data_inicio", "2018-01-10");
        query.add("status",true);
        query.add("numero",123456);
        query.add("s", "Outro teste meu");

        Request r = new Request();
        r.setPath(path);
        r.setQuery(query);

        return client.get(r, "");
    }
}
