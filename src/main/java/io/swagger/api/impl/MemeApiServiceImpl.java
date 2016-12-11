package io.swagger.api.impl;

import io.swagger.api.Constants;
import io.swagger.api.MemeApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.MemePattern;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-10T21:26:55.970Z")
public class MemeApiServiceImpl extends MemeApiService {

    private static final Logger logger = LogManager.getLogger(MemeApiServiceImpl.class);

    @Override
    public Response memeGet(SecurityContext securityContext) throws NotFoundException {
        logger.info("Appel du service : " + "MEME");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_MEME_GETMEME);
        logger.info("URL : " + builder.toString() );

        String token = Base64.encodeAsString(Constants.API_LOGIN+":"+Constants.API_PASSWORD);
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
    public Response memeIdDelete(Integer id, SecurityContext securityContext) throws NotFoundException {
        logger.info("Appel du service : " + "MEME");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_MEME_GETMEME+"/"+id);
        logger.info("URL : " + builder.toString() );

        String token = Base64.encodeAsString(Constants.API_LOGIN+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+token);

        HttpDelete request = new HttpDelete(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+token));

        logger.info(request.getAllHeaders());
        logger.info(request.getURI());
        try {
            HttpResponse response = client.execute(request);
            logger.info("Le code retour du service est : " + response.getStatusLine().getStatusCode());
            if(response.getStatusLine().getStatusCode() == Constants.DELETE) {
                return Response.status(Constants.DELETE).build();
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
    public Response memeIdGet(Integer id, SecurityContext securityContext) throws NotFoundException {
        logger.info("Appel du service : " + "MEME");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_MEME_GETMEME+"/"+id);
        logger.info("URL : " + builder.toString() );

        String token = Base64.encodeAsString(Constants.API_LOGIN+":"+Constants.API_PASSWORD);
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
    public Response memePictureGet(SecurityContext securityContext) throws NotFoundException {
        logger.info("Appel du service : " + "MEME");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_MEME_GETPICTURE);
        logger.info("URL : " + builder.toString() );

        String token = Base64.encodeAsString(Constants.API_LOGIN+":"+Constants.API_PASSWORD);
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
    public Response memePost(MemePattern memeToBuild, SecurityContext securityContext) throws NotFoundException {
        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_MEME_POSTMEME);
        logger.info("URL : " + builder.toString() );

        String tokenAPI = Base64.encodeAsString(Constants.API_LOGIN+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+tokenAPI);

        HttpPost request = new HttpPost(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+tokenAPI));



        StringEntity se = new StringEntity(memeToBuild.toString(), HTTP.UTF_8);
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

    private void Service_Error(IOException e){
        logger.info("Le service : "+Constants.SERVICE_MEME_GETMEME + " n'est pas disponible");
        logger.info("Error : " + e);
    }
}
