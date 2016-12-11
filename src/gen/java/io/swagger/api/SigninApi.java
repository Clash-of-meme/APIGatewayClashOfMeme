package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.SigninApiServiceFactory;
import io.swagger.model.Inscription;
import io.swagger.model.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/signin")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
@io.swagger.annotations.Api(description = "the signin API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-05T21:52:39.785Z")
public class SigninApi  {
   private final SigninApiService delegate = SigninApiServiceFactory.getSigninApi();

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Inscription", notes = "Endpoint d'inscription sur le site. ", response = User.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "API key")
    }, tags={ "Inscription", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Le token de l'utilisateur", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request. Le nom d'utilisateur est déjà utilisé.", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez être identifié.", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'êtes pas autorisé à utiliser cette ressource.", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 503, message = "Erreur de connexion à la base de donnée", response = User.class) })
    public Response signinPost(@ApiParam(value = "Les informations nécessaires à une inscription." ,required=true) Inscription inscription
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.signinPost(inscription,securityContext);
    }
}
