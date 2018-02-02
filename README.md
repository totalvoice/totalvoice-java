# totalvoice-java
Client em Java para utilização da API da TotalVoice

> ### Funcionalidades

- [X] Gerenciamento das chamadas
- [X] Consulta e envio de SMS
- [X] Consulta e envio de TTS
- [X] Consulta e envio de Audio
- [X] Gerenciamento da Conta
- [X] Gerenciamento da Central

> ### Utilização

Para utilizar esta biblioteca, primeiramente você deverá realizar um cadastro no site da [Total Voice](http://www.totalvoice.com.br).
Após a criação do cadastro será disponibilizado um AccessToken para acesso a API.

Com o AccessToken em mãos será possível realizar as consultas/cadastros conforme documentação da [API](https://api.totalvoice.com.br/doc/#/)

Os métodos da API que poderão ser invocados:
- audio
- central
- chamada
- composto
- conferencia
- conta
- perfil
- sms
- tts

A seguir um pequeno exemplo de como pode ser utilizada esta biblioteca.

> ##### Realiza uma chamada telefônica entre dois números: A e B

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Chamada;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("{{access-token}}");
            Chamada chamada = new Chamada(client);

            JSONObject result = chamada.ligar("NUMEROA", "NUMEROB");
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```