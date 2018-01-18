package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import org.json.JSONObject;

import java.io.IOException;

public class Conta {

    public static final String ROTA_SALDO = "/saldo";

    private ClientInterface client;

    public Conta(ClientInterface client) {
        this.client = client;
    }

    public JSONObject consultaSaldo()  throws IOException
    {
        return client.get(ROTA_SALDO, "");
    }
}
