package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.api.factories.MeApiServiceFactory;
import io.swagger.model.Duel;
import io.swagger.model.Meme;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/me")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
@io.swagger.annotations.Api(description = "the me API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-10T21:26:55.970Z")
public class MeApi  {
   private final MeApiService delegate = MeApiServiceFactory.getMeApi();


 @GET
 @Path("/{token}")
 @Consumes({ "application/json", "application/xml" })
 @Produces({ "application/json", "application/xml" })
 @io.swagger.annotations.ApiOperation(value = "", notes = "On récupère les memes d'un utilisateur avec son token.", response = Meme.class, responseContainer = "List", authorizations = {
         @io.swagger.annotations.Authorization(value = "API key")
 }, tags={  })
 @io.swagger.annotations.ApiResponses(value = {
         @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 204, message = "L'utilisateur n'a pas de meme.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 400, message = "Pas d'utilisateur.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez êtes identifier pour accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'avez pas l'autorisation d'accéder à cette ressource.", response = Meme.class, responseContainer = "List"),

         @io.swagger.annotations.ApiResponse(code = 503, message = "La base de donnée n'a pas répondu.", response = Meme.class, responseContainer = "List") })
 public Response meTokenGet(@ApiParam(value = "token d'un utilisateur",required=true) @PathParam("token") String token
         ,@Context SecurityContext securityContext)
         throws NotFoundException {
  return delegate.meMemeGet(token,securityContext);
 }
    @GET
    @Path("/{token}/meme")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "On récupère les memes d'un utilisateur avec son token.", response = Meme.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "API key")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "L'utilisateur n'a pas de meme.", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Pas d'utilisateur.", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez êtes identifier pour accéder à cette ressource.", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'avez pas l'autorisation d'accéder à cette ressource.", response = Meme.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 503, message = "La base de donnée n'a pas répondu.", response = Meme.class, responseContainer = "List") })
    public Response meTokenMemeGet(@ApiParam(value = "token d'un utilisateur",required=true) @PathParam("token") String token
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.meTokenMemeGet(token,securityContext);
    }

    @GET
    @Path("/{token}/duel")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "On récupère les memes d'un utilisateur avec son token.", response = Duel.class, responseContainer = "List", authorizations = {
            @io.swagger.annotations.Authorization(value = "API key")
    }, tags={  })
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = Duel.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 204, message = "L'utilisateur n'a pas de meme.", response = Duel.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Pas d'utilisateur.", response = Duel.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez êtes identifier pour accéder à cette ressource.", response = Duel.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'avez pas l'autorisation d'accéder à cette ressource.", response = Duel.class, responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 503, message = "La base de donnée n'a pas répondu.", response = Duel.class, responseContainer = "List") })
    public Response meTokenDuelGet(@ApiParam(value = "token d'un utilisateur",required=true) @PathParam("token") String token
            ,@Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.meTokenDuelGet(token,securityContext);
    }
}
