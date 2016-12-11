package io.swagger.api;

import io.swagger.model.Inscription;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-05T21:52:39.785Z")
public abstract class SigninApiService {
    public abstract Response signinPost(Inscription inscription,SecurityContext securityContext) throws NotFoundException;
}
