package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;
import br.com.totalvoice.Request;
import br.com.totalvoice.RequestInterface;

public abstract class Api {

    protected ClientInterface client;
    protected RequestInterface request;

    public Api(ClientInterface client) {
        this.client = client;
        this.request = new Request();
    }

    public Api(ClientInterface client, RequestInterface request) {
        this.client = client;
        this.request = request;
    }
}
