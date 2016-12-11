package io.swagger.api.impl;

import io.swagger.api.Constants;
import io.swagger.api.MeApiService;
import io.swagger.api.NotFoundException;
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
public class MeApiServiceImpl extends MeApiService {

    private static final Logger logger = LogManager.getLogger(MemeApiServiceImpl.class);

    @Override
    public Response meTokenMemeGet(String token, SecurityContext securityContext) throws NotFoundException {
        logger.info("Appel du service : " + "MEME");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(pathMemeUserByToken(token));
        logger.info("URL : " + builder.toString() );

        String token_API = Base64.encodeAsString(Constants.API_LOGIN+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+token_API);

        HttpGet request;
        request = new HttpGet(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+token_API));

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
    public Response meMemeGet(String token, SecurityContext securityContext) {
        logger.info("Appel du service : " + "User");

        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(pathMeByToken(token));
        logger.info("URL : " + builder.toString() );

        String token_API = Base64.encodeAsString(Constants.API_LOGIN2+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+token_API);

        HttpGet request;
        request = new HttpGet(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+token_API));

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

    private String pathMeByToken(String token) {return Constants.SERVICE_USER_GET_ME+"/"+token;
    }

    private String pathMemeUserByToken(String token) {
        return Constants.SERVICE_MEME_GET_ME+"/"+token+"/meme";
    }

    private void Service_Error(IOException e){
        logger.info("Le service : "+Constants.SERVICE_MEME_GETMEME + " n'est pas disponible");
        logger.info("Error : " + e);
    }

}
