package io.swagger.api.factories;

import io.swagger.api.DuelApiService;
import io.swagger.api.impl.DuelApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-27T10:57:43.054Z")
public class DuelApiServiceFactory {
    private final static DuelApiService service = new DuelApiServiceImpl();

    public static DuelApiService getDuelApi() {
        return service;
    }
}
