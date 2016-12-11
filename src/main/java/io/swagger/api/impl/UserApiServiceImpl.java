package io.swagger.api.impl;

import io.swagger.api.Constants;
import io.swagger.api.NotFoundException;
import io.swagger.api.UserApiService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-10T21:26:55.970Z")
public class UserApiServiceImpl extends UserApiService {

    private static final Logger logger = LogManager.getLogger(MemeApiServiceImpl.class);

    @Override
    public Response userLoginMemeGet(String login, SecurityContext securityContext) throws NotFoundException {
        logger.info("Appel du service : " + "MEME");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(pathMemeUserByLogin(login));
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
            else if (response.getStatusLine().getStatusCode() == Constants.NO_CONTENT){
                return Response.status(Constants.NO_CONTENT).build();
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
    public Response userGet(SecurityContext securityContext) {
        logger.info("Appel du service : " + "User");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_USER_GET_USER);
        logger.info("URL : " + builder.toString() );

        String token = Base64.encodeAsString(Constants.API_LOGIN2+":"+Constants.API_PASSWORD);
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
            else if (response.getStatusLine().getStatusCode() == Constants.NO_CONTENT){
                return Response.status(Constants.NO_CONTENT).build();
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
    public Response userIdGet(String login, SecurityContext securityContext) {
        logger.info("Appel du service : " + "User");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(pathUserByLogin(login));
        logger.info("URL : " + builder.toString() );

        String token = Base64.encodeAsString(Constants.API_LOGIN2+":"+Constants.API_PASSWORD);
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
            else if (response.getStatusLine().getStatusCode() == Constants.NO_CONTENT){
                return Response.status(Constants.NO_CONTENT).build();
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
    private String pathMemeUserByLogin(String login){
        return Constants.SERVICE_MEME_GET_USER_BYID+"/"+login+"/meme";
    }

    private String pathUserByLogin(String login){
        return Constants.SERVICE_USER_GET_USER+"/"+login;
    }
}
