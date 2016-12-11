package io.swagger.api.impl;

import io.swagger.api.Constants;
import io.swagger.api.NotFoundException;
import io.swagger.api.SigninApiService;
import io.swagger.model.Inscription;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-27T09:59:00.389Z")
public class SigninApiServiceImpl extends SigninApiService {

    private static final Logger logger = LogManager.getLogger(SigninApiService.class);

    @Override
    public Response signinPost(Inscription inscription, SecurityContext securityContext) throws NotFoundException {

        logger.info("Procédure d'inscription");
        HttpClient client = new DefaultHttpClient();
        URIBuilder builder = new URIBuilder();
        builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_USER_SIGNIN);
        logger.info("URL : " + builder.toString() );

        String tokenAPI = Base64.encodeAsString(Constants.API_LOGIN2+":"+Constants.API_PASSWORD);
        logger.info("Token d'authentification : "+tokenAPI);

        HttpPost request = new HttpPost(builder.toString());
        request.addHeader(Constants.AUTH,(Constants.BASIC_AUTH+tokenAPI));



        StringEntity se = new StringEntity(inscription.toString(), HTTP.UTF_8);
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
