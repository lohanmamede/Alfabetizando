package com.lunarez.alfabetizando.ews;

import com.lunarez.alfabetizando.ews.response.JogoResponseModel;
import static java.lang.System.out;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * Esta classe...
 * 
 * @author eres
 */
public class JogosEWS {
    
    /**
     * Este método...
     * 
     * @param idExterno
     * @return 
     */
    public JogoResponseModel obterJogo(String idExterno) 
            throws HttpStatusCodeException {

        String url = "http://localhost:8080/eludika-webservice/api/jogos/" + idExterno;
        
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders cabecalho = new HttpHeaders();
        cabecalho.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity requisicao = new HttpEntity(cabecalho);
        
        ResponseEntity<JogoResponseModel> resposta = restTemplate.exchange(url, 
                HttpMethod.GET, requisicao, JogoResponseModel.class);
        
        out.println("Conteúdo da conta: " + resposta.getBody().getNome());
        
        return resposta.getBody();
    }
    
    /**
     * Este método...
     * 
     * @param nome
     * @param inicio
     * @param limite
     * @return 
     */
    public List<JogoResponseModel> obterJogos(String nome, int inicio, int limite) 
            throws HttpStatusCodeException {
        
        String url = "http://localhost:8080/eludika-webservice/api/jogos/" 
                + "?nome=" + nome + "&inicio=" + inicio + "&limite=" + limite;

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        
        ResponseEntity<List<JogoResponseModel>> resposta = restTemplate.exchange(url, 
                HttpMethod.GET, null, new ParameterizedTypeReference<List<JogoResponseModel>>(){});
                
        List<JogoResponseModel> usuarios = resposta.getBody();
        
        return usuarios;
    }
}
