package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Duel;
import io.swagger.model.DemandePattern;

import java.io.IOException;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.util.Base64;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-27T10:57:43.054Z")
public class DuelApiServiceImpl extends DuelApiService {

    private static final Logger logger = LogManager.getLogger(io.swagger.api.impl.LoginApiServiceImpl.class);

    @Override
    public Response duelDemandePost(DemandePattern demande, SecurityContext securityContext) throws NotFoundException {
        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_DUEL_POST_DUEL);
        logger.info("URL : " + builder.toString() );

        String tokenAPI = Base64.encodeAsString(Constants.API_LOGIN3+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+tokenAPI);

        HttpPost request = new HttpPost(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+tokenAPI));
        logger.info("Demande envoyée : " + demande.toString());
        StringEntity se = new StringEntity(demande.toString(), HTTP.UTF_8);
        request.setEntity(se);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        try {
            HttpResponse response = client.execute(request);
            logger.info("Le code retour du service est : " + response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() == Constants.CREATED) {
                logger.info("Le meme a bien été créé");
                String result = EntityUtils.toString(response.getEntity());
                logger.info("Le resultat est : "+result);
                return Response.status(Constants.OK).entity(result).build();
            }
            else if (response.getStatusLine().getStatusCode() == Constants.BAD_REQUEST)
            {
                return Response.status(Constants.BAD_REQUEST).build();
            }

        } catch (IOException e) {
            Service_Error(e);
        }
        return Response.status(Constants.ERROR).build();
    }
    @Override
    public Response duelGet(SecurityContext securityContext) throws NotFoundException {
        logger.info("Appel du service : " + "Duel");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_DUEL_GET_DUEL);
        logger.info("URL : " + builder.toString() );

        String token = Base64.encodeAsString(Constants.API_LOGIN3+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+token);

        HttpGet request = new HttpGet(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+token));

        logger.info(request.getAllHeaders());
        logger.info(request.getURI());
        try {
            HttpResponse response = client.execute(request);
            logger.info("Le code retour du service est : " + response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() == Constants.OK) {
                logger.info(response.getEntity().getContentType());
                String result = EntityUtils.toString(response.getEntity());
                logger.info(result);
                return Response.status(Constants.OK).entity(result).build();
            }
        } catch (IOException e) {
            Service_Error(e);
        }
        return Response.status(Constants.ERROR).build();
    }
    @Override
    public Response duelIdGet(Integer id, SecurityContext securityContext) throws NotFoundException {
        logger.info("Appel du service : " + "Duel");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_DUEL_GET_DUEL+"/"+id);
        logger.info("URL : " + builder.toString() );

        String token = Base64.encodeAsString(Constants.API_LOGIN3+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+token);

        HttpGet request = new HttpGet(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+token));

        logger.info(request.getAllHeaders());
        logger.info(request.getURI());
        try {
            HttpResponse response = client.execute(request);
            logger.info("Le code retour du service est : " + response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() == Constants.OK) {
                logger.info(response.getEntity().getContentType());
                String result = EntityUtils.toString(response.getEntity());
                logger.info(result);
                return Response.status(Constants.OK).entity(result).build();
            }
            else if (response.getStatusLine().getStatusCode() == Constants.BAD_REQUEST){
                return Response.status(Constants.BAD_REQUEST).build();
            }
        } catch (IOException e) {
            Service_Error(e);
        }
        return Response.status(Constants.ERROR).build();
    }
    @Override
    public Response duelIdVotePost(Integer id, Integer idMeme, SecurityContext securityContext) throws NotFoundException {
        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(getPathPostDuel(id));
        builder.setParameter("id_meme",idMeme.toString());
        logger.info("URL : " + builder.toString() );

        String tokenAPI = Base64.encodeAsString(Constants.API_LOGIN3+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+tokenAPI);

        HttpPost request = new HttpPost(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+tokenAPI));

        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        try {
            HttpResponse response = client.execute(request);
            logger.info("Le code retour du service est : " + response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() == Constants.CREATED) {
                logger.info("Le vote a bien été pris en compte");
                return Response.status(Constants.CREATED).build();
            }
            else if (response.getStatusLine().getStatusCode() == Constants.BAD_REQUEST)
            {
                return Response.status(Constants.BAD_REQUEST).build();
            }

        } catch (IOException e) {
            Service_Error(e);
        }
        return Response.status(Constants.ERROR).build();
    }

    private String getPathPostDuel(Integer id) {
        return Constants.SERVICE_DUEL_GET_DUEL+"/"+id+"/vote";
    }

    private void Service_Error(IOException e){
        logger.info("Le service : "+Constants.SERVICE_MEME_GETMEME + " n'est pas disponible");
        logger.info("Error : " + e);
    }
}
