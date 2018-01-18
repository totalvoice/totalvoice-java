package br.com.totalvoice.api;

import br.com.totalvoice.ClientInterface;

public class Sms {

    private ClientInterface client;

    public Sms(ClientInterface client) {
        this.client = client;
    }
}
