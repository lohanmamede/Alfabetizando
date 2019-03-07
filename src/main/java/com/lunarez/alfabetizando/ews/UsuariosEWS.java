package com.lunarez.alfabetizando.ews;

import com.lunarez.alfabetizando.ews.request.AtualizarUsuarioRequestModel;
import com.lunarez.alfabetizando.ews.request.CriarUsuarioRequestModel;
import com.lunarez.alfabetizando.ews.request.ObterUsuarioRequestModel;
import com.lunarez.alfabetizando.ews.response.UsuarioResponseModel;
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
public class UsuariosEWS {
    
    /**
     * Este método...
     * 
     * @param dadosDaRequisicao
     * @return 
     */
    public String criarUsuario(CriarUsuarioRequestModel dadosDaRequisicao) 
            throws HttpStatusCodeException {
        
        /* Definição da url do serviço de criação de usuário do webservice */
        String url = "http://localhost:8080/eludika-webservice/api/usuarios/";
        
        /* Criação do objeto que lida com requisições REST */
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
       
        /* Criação e configuração do cabeçalho */
        HttpHeaders cabecalho = new HttpHeaders();
        cabecalho.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity requisicao = new HttpEntity<>(dadosDaRequisicao, cabecalho);
        
        String resposta = restTemplate.postForObject(url, requisicao, String.class);
        
        out.println("Resultado da criação: " + resposta);
        
        return resposta;
    }
    
    /**
     * Este método...
     * 
     * @param idExterno
     * @param token
     * @param imagemPerfil
     * @param textFieldNomeCompleto
     * @param textFieldBiografia
     * @param textFieldCidade
     * @param textFieldEstado
     * @param textFieldEmail
     * @return 
     */
    public UsuarioResponseModel atualizarUsuario(String idExterno, String token, String imagemPerfil,
            String textFieldNomeCompleto, String textFieldBiografia, String textFieldCidade,
            String textFieldEstado, String textFieldEmail) 
            throws HttpStatusCodeException {
       
        AtualizarUsuarioRequestModel dadosDaRequisicao = new AtualizarUsuarioRequestModel();
        
        dadosDaRequisicao.setIdExterno(idExterno);
        dadosDaRequisicao.setToken(token);
        dadosDaRequisicao.setImagemPerfil(imagemPerfil);
        dadosDaRequisicao.setNomeCompleto(textFieldNomeCompleto);
        dadosDaRequisicao.setBiografia(textFieldBiografia);
        dadosDaRequisicao.setCidade(textFieldCidade);
        dadosDaRequisicao.setEstado(textFieldEstado);
        dadosDaRequisicao.setEmail(textFieldEmail);

        /* Definição da url do serviço de atualização de usuário do webservice */
        String url = "http://localhost:8080/eludika-webservice/api/usuarios/" 
                + dadosDaRequisicao.getIdExterno();
        
        /* Criação do objeto que lida com requisições REST */
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
       
        /* Criação e configuração do cabeçalho */
        HttpHeaders cabecalho = new HttpHeaders();
        cabecalho.setContentType(MediaType.APPLICATION_JSON);
        cabecalho.add("Authorization", "Portador " + dadosDaRequisicao.getToken());

        HttpEntity requisicao = new HttpEntity<>(dadosDaRequisicao, cabecalho);
        
        ResponseEntity<UsuarioResponseModel> resposta = restTemplate.exchange(url, 
                HttpMethod.PUT, requisicao, UsuarioResponseModel.class);
        
        out.println("Resultado da criação: " + resposta.getBody().getImagemPerfil());
        
        return resposta.getBody();
    }
    
    /**
     * Este método...
     * 
     * @param dadosDaRequisicao
     * @return 
     */
    public UsuarioResponseModel atualizarUsuario(AtualizarUsuarioRequestModel dadosDaRequisicao) 
            throws HttpStatusCodeException {

        /* Definição da url do serviço de atualização de usuário do webservice */
        String url = "http://localhost:8080/eludika-webservice/api/usuarios/" 
                + dadosDaRequisicao.getIdExterno();
        
        /* Criação do objeto que lida com requisições REST */
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
       
        /* Criação e configuração do cabeçalho */
        HttpHeaders cabecalho = new HttpHeaders();
        cabecalho.setContentType(MediaType.APPLICATION_JSON);
        cabecalho.add("Authorization", "Portador " + dadosDaRequisicao.getToken());

        HttpEntity requisicao = new HttpEntity<>(dadosDaRequisicao, cabecalho);
        
        ResponseEntity<UsuarioResponseModel> resposta = restTemplate.exchange(url, 
                HttpMethod.PUT, requisicao, UsuarioResponseModel.class);
        
        out.println("Resultado da criação: " + resposta.getBody().getImagemPerfil());
        
        return resposta.getBody();
    }
    
    /**
     * Este método...
     * 
     * @param idExterno
     * @param token
     * @return 
     */
    public UsuarioResponseModel obterUsuario(String idExterno, String token) 
            throws HttpStatusCodeException {
        
        ObterUsuarioRequestModel dadosDaRequisicao = new ObterUsuarioRequestModel();
        
        dadosDaRequisicao.setIdExterno(idExterno);
        dadosDaRequisicao.setToken(token);
        
        String url = "http://localhost:8080/eludika-webservice/api/usuarios/" 
                + dadosDaRequisicao.getIdExterno();
        
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders cabecalho = new HttpHeaders();
        cabecalho.setContentType(MediaType.APPLICATION_JSON);
        cabecalho.add("Authorization", "Portador " + dadosDaRequisicao.getToken());

        HttpEntity<ObterUsuarioRequestModel> requisicao = new HttpEntity<>(cabecalho);
        
        ResponseEntity<UsuarioResponseModel> resposta = restTemplate.exchange(url, 
                HttpMethod.GET, requisicao, UsuarioResponseModel.class);
        
        out.println("Conteúdo da conta: " + resposta.getBody().getNomeCompleto());
        
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
    public List<UsuarioResponseModel> obterUsuarios(String nome, int inicio, int limite) 
            throws HttpStatusCodeException {
        
        String url = "http://localhost:8080/eludika-webservice/api/usuarios/" 
                + "?nome=" + nome + "&inicio=" + inicio + "&limite=" + limite;

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        
        ResponseEntity<List<UsuarioResponseModel>> resposta = restTemplate.exchange(url, 
                HttpMethod.GET, null, new ParameterizedTypeReference<List<UsuarioResponseModel>>(){});
                
        List<UsuarioResponseModel> usuarios = resposta.getBody();
        
        return usuarios;
    }
}

/**
 * Url dos serviços do usuário (AWS)
 * http://ec2-18-228-5-45.sa-east-1.compute.amazonaws.com:8080/eludika-webservice/api/usuarios/
 * 
 * Url dos serviços do usuário (AWS)
 * http://localhost:8080/eludika-webservice/api/usuarios/
 * 
 * Conversão de um objeto em JSON
 * JSONObject json = new JSONObject();
 * json.put("email", objeto.getEmail());
 * json.put("senha", objeto.getSenha());
 */

