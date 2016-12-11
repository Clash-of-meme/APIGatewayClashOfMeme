package io.swagger.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-10T21:26:55.970Z")
public abstract class UserApiService {
    public abstract Response userLoginMemeGet(String login,SecurityContext securityContext) throws NotFoundException;

    public abstract Response userGet(SecurityContext securityContext);

    public abstract Response userIdGet(String login, SecurityContext securityContext);
}
