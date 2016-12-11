package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.LoginApiServiceFactory;
import io.swagger.api.factories.MeApiServiceFactory;
import io.swagger.model.Meme;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/login")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
@io.swagger.annotations.Api(description = "the me API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-10T21:26:55.970Z")
public class LoginApi  {

    private final LoginApiService delegate = LoginApiServiceFactory.getLoginApi();

    @GET

    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "On récupère les infos d'un utilisateur avec ses identifiants.", response = Meme.class, responseContainer = "List", authorizations = {
            @io.swagger.annotations.Authorization(value = "API key")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Pas d'utilisateur.", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez êtes identifier pour accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'avez pas l'autorisation d'accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 503, message = "La base de donnée n'a pas répondu.", response = Meme.class, responseContainer = "List") })
    public Response meTokenMemeGet(@ApiParam(value = "login d'un utilisateur", required = true) @QueryParam("login") String login,
                                   @ApiParam(value = "password d'un utilisateur", required = true) @QueryParam("password") String password
            ,@Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.LoginGet(login, password,securityContext);
    }
}
