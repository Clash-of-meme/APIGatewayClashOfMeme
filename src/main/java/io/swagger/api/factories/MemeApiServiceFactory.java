package io.swagger.api.factories;

import io.swagger.api.MemeApiService;
import io.swagger.api.impl.MemeApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-10T21:26:55.970Z")
public class MemeApiServiceFactory {
    private final static MemeApiService service = new MemeApiServiceImpl();

    public static MemeApiService getMemeApi() {
        return service;
    }
}
