package org.example;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.builder.ResponseBuilder;
import io.restassured.specification.FilterableResponseSpecification;

public class MyFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        Response originalResponse = ctx.next(requestSpec, responseSpec);
        Response modifiedResponse = new ResponseBuilder()
                .clone(originalResponse)
                .setBody("что то пришло")
                .build();

        return modifiedResponse;
    }
}
