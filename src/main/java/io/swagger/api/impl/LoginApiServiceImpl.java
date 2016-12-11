package io.swagger.api.impl;

import io.swagger.api.Constants;
import io.swagger.api.LoginApiService;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-04T16:40:19.632Z")
public class LoginApiServiceImpl extends LoginApiService {

    private static final Logger logger = LogManager.getLogger(io.swagger.api.impl.LoginApiServiceImpl.class);

    @Override
    public Response LoginGet(String login, String password, SecurityContext securityContext) {

            HttpClient client = new DefaultHttpClient();
            URIBuilder builder = new URIBuilder();
            builder.setScheme(Constants.PROTOCOLE).setHost(Constants.HOST).setPort(Constants.PORT).setPath(Constants.SERVICE_USER_GETLOGIN);
            builder.setParameter("login",login);
            builder.setParameter("password",password);
            logger.info("URL : " + builder.toString());

            String token = Base64.encodeAsString(Constants.SERVICE_USER+":"+Constants.API_PASSWORD);
            logger.info("Token d'authentification : "+token);
            HttpGet request = new HttpGet(builder.toString());
            request.setHeader(Constants.AUTH,token);

            try {
                HttpResponse response = client.execute(request);
                logger.info("Le code retour du service est : " + response.getStatusLine().getStatusCode());
                String essai = EntityUtils.toString(response.getEntity());
                return Response.status(200).entity(essai).build();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Response.status(Constants.ERROR).build();
    }
}
