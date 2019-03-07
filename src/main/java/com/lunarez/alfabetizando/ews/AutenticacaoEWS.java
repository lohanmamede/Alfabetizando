package com.lunarez.alfabetizando.ews;

import com.lunarez.alfabetizando.ews.request.LoginRequestModel;
import com.lunarez.alfabetizando.ews.response.AutenticacaoResponseModel;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * Esta classe...
 * 
 * @author eres
 */
public class AutenticacaoEWS {
    
    /**
     * Este método...
     * 
     * @param dadosDaRequisicao
     * @return
     * @throws HttpStatusCodeException
     */
    public void autenticar(String email, String senha) 
            throws HttpStatusCodeException {
        
            LoginRequestModel dadosDaRequisicao = new LoginRequestModel();
            
            dadosDaRequisicao.setEmail(email);
            dadosDaRequisicao.setSenha(senha);
        
            /* Definição da url do serviço de login do webservice */
            String url = "http://localhost:8080/eludika-webservice/api/autenticacao";
           
            /* Criação do objeto que lida com requisições REST */
            RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
            
            /* Criação e configuração do cabeçalho */
            HttpHeaders cabecalho = new HttpHeaders();
            cabecalho.setContentType(MediaType.APPLICATION_JSON);
            
            /* Montagem da requisição com o cabeçalho e o corpo */
            HttpEntity requisicao = new HttpEntity<>(dadosDaRequisicao, cabecalho);
            
            /* Envio da requisição e obtenção da resposta */
            String resposta = restTemplate.postForObject(url, requisicao, String.class);
            
            /* Conversão da string de resposta em um objeto JSONObject para manipulação
            dos dados */
            JSONObject json = new JSONObject(resposta);
            
            /* Atribuição dos dados de sessão se a requisição for bem sucedida */
            AutenticacaoResponseModel.getSessao().setIdExterno(json.getString("idExterno"));
            AutenticacaoResponseModel.getSessao().setToken(json.getString("token"));
            AutenticacaoResponseModel.getSessao().setCodinome(json.getString("codinome"));
            AutenticacaoResponseModel.getSessao().setImagemPerfil(json.getString("imagemPerfil"));
    }
}

/**
 * Url de autenticação (AWS)
 * http://ec2-18-228-5-45.sa-east-1.compute.amazonaws.com:8080/eludika-webservice/api/autenticacao/
 * 
 * Url de autenticação (local)
 * http://localhost:8080/eludika-webservice/api/autenticacao
 */

