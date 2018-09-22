# totalvoice-java
Client em Java para utilização da API da TotalVoice

> ### Funcionalidades

- [X] Gerenciamento das chamadas
- [X] Consulta e envio de SMS
- [X] Consulta e envio de TTS
- [X] Consulta e envio de Audio
- [X] Gerenciamento da Conta
- [X] Gerenciamento da Central
- [X] Gerenciamento da DID

> ### Utilização

Para utilizar esta biblioteca, primeiramente você deverá realizar um cadastro no site da [Total Voice](http://www.totalvoice.com.br).
Após a criação do cadastro será disponibilizado um AccessToken para acesso a API.

Com o AccessToken em mãos será possível realizar as consultas/cadastros conforme documentação da [API](https://api.totalvoice.com.br/doc/#/)

> #### Instalando com o Maven

Basta adicionar este trecho no pom.xml

```xml

    <dependencies>
        <dependency>
            <groupId>br.com.totalvoice</groupId>
            <artifactId>totalvoice-java</artifactId>
            <version>1.7.0</version>
        </dependency>
    </dependencies>

```

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
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Chamada chamada = new Chamada(client);

            JSONObject result = chamada.ligar("NUMEROA", "NUMEROB");
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Consulta de chamada pelo ID

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Chamada;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Chamada chamada = new Chamada(client);

            JSONObject result = chamada.buscar(123); // ID da chamada
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Encerrar chamada

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Chamada;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Chamada chamada = new Chamada(client);

            JSONObject result = chamada.encerrar(123); // ID da chamada
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Envio de SMS

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Sms;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Sms sms = new Sms(client);

            JSONObject result = sms.enviar("NUMERO", "SUA MENSAGEM");
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Envio de TTS

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Tts;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Tts tts = new Tts(client);

            JSONObject result = tts.enviar("NUMERO", "SUA MENSAGEM");
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Envio de Audio

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Audio;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Audio audio = new Audio(client);

            JSONObject result = audio.enviar("NUMERO", "http://foo.bar/audio.mp3");
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Configurações de central telefonica

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Central;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Central central = new Central(client);

            JSONObject result = central.buscarRamal(123); // ID do Ramal
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Gerenciamento dos dados da Conta

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Conta;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Conta conta = new Conta(client);

            JSONObject result = conta.buscarConta(123);
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Consulta saldo da minha Conta

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Perfil;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Perfil perfil = new Perfil(client);

            JSONObject result = perfil.consultaSaldo();
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Caso você necessite utilizar seu próprio endereço configurado na Total Voice

Basta informar o segundo parâmetro ao instânciar o Client

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Perfil;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token", "https://meuhost.com.br");
            Perfil perfil = new Perfil(client);

            JSONObject result = perfil.consultaSaldo();
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Listando DID's do Estoque

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Did;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Did did = new Did(client);

            JSONObject result = did.estoque();
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Adquirindo DID

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Did;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Did did = new Did(client);

            JSONObject result = did.adquirir(1); // ID do DID
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

> ##### Listando seus DID's

```java
package br.com.totalvoice;

import br.com.totalvoice.api.Did;
import org.json.JSONObject;

public class Main {
    
    public static void main(String args[]) {
        
        try {
            TotalVoiceClient client = new TotalVoiceClient("access-token");
            Did did = new Did(client);

            JSONObject result = did.listar();
            System.out.println(result);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

```

Mais informações sobre os métodos disponíveis podem ser encontrados na documentação da [API](https://api.totalvoice.com.br/doc/#/)

> ### Licença
Esta biblioteca segue os termos de uso da [MIT](https://github.com/totalvoice/totalvoice-java/blob/master/LICENSE)
