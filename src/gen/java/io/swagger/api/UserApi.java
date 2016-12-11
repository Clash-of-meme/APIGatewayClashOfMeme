package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.UserApiServiceFactory;
import io.swagger.model.Meme;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/user")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
@io.swagger.annotations.Api(description = "the user API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-10T21:26:55.970Z")
public class UserApi  {
   private final UserApiService delegate = UserApiServiceFactory.getUserApi();

 @GET

 @Consumes({ "application/json", "application/xml" })
 @Produces({ "application/json", "application/xml" })
 @io.swagger.annotations.ApiOperation(value = "", notes = "On récupère les memes d'un utilisateur avec son ID.", response = Meme.class, responseContainer = "List", authorizations = {
         @io.swagger.annotations.Authorization(value = "API key")
 }, tags={  })
 @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 204, message = "L'utilisateur n'a pas de meme.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 400, message = "Pas d'utilisateur.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez êtes identifier pour accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'avez pas l'autorisation d'accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 503, message = "La base de données n'est pas disponible.", response = Meme.class, responseContainer = "List") })
 public Response userGet(@Context SecurityContext securityContext)
         throws NotFoundException {
  return delegate.userGet(securityContext);
 }

 @GET
 @Path("/{login}")
 @Consumes({ "application/json", "application/xml" })
 @Produces({ "application/json", "application/xml" })
 @io.swagger.annotations.ApiOperation(value = "", notes = "On récupère les memes d'un utilisateur avec son ID.", response = Meme.class, responseContainer = "List", authorizations = {
         @io.swagger.annotations.Authorization(value = "API key")
 }, tags={  })
 @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 204, message = "L'utilisateur n'a pas de meme.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 400, message = "Pas d'utilisateur.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez êtes identifier pour accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'avez pas l'autorisation d'accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 503, message = "La base de données n'est pas disponible.", response = Meme.class, responseContainer = "List") })
 public Response userIdGet(@ApiParam(value = "Le login d'un utilisateur",required=true) @PathParam("login") String login
         ,@Context SecurityContext securityContext)
         throws NotFoundException {
  return delegate.userIdGet(login,securityContext);
 }


    @GET
    @Path("/{login}/meme")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "On récupère les memes d'un utilisateur avec son ID.", response = Meme.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "API key")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "L'utilisateur n'a pas de meme.", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Pas d'utilisateur.", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez êtes identifier pour accéder à cette ressource.", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'avez pas l'autorisation d'accéder à cette ressource.", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 503, message = "La base de données n'est pas disponible.", response = Meme.class, responseContainer = "List") })
    public Response userLoginMemeGet(@ApiParam(value = "Le login d'un utilisateur",required=true) @PathParam("login") String login
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.userLoginMemeGet(login,securityContext);
    }

    @GET
    @Path("/{login}/duel")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "On récupère les memes d'un utilisateur avec son ID.", response = Meme.class, responseContainer = "List", authorizations = {
            @io.swagger.annotations.Authorization(value = "API key")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 204, message = "L'utilisateur n'a pas de meme.", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Pas d'utilisateur.", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez êtes identifier pour accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'avez pas l'autorisation d'accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 503, message = "La base de données n'est pas disponible.", response = Meme.class, responseContainer = "List") })
    public Response userLoginDuelGet(@ApiParam(value = "Le login d'un utilisateur",required=true) @PathParam("login") String login
            ,@Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.userLoginDuelGet(login,securityContext);
    }
}
