package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Request;
import br.com.totalvoice.RequestInterface;

public class Sms extends Api {

    public static final String ROTA_SMS   = "sms";

    public Sms(ClientInterface client) {
        super(client);
    }

    public Sms(ClientInterface client, RequestInterface request) {
        super(client, request);
    }


}
