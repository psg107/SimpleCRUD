package com.sgpark.simplecrud.util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceUrlBuilder {
    private String serviceHost;
    private String endpoint;
    private Map<String, String> queries;

    public ServiceUrlBuilder(){
        this.queries = new HashMap<String, String>();
    }

    public ServiceUrlBuilder setServiceHost(String serviceHost){
        this.serviceHost = serviceHost;
        return this;
    }

    public ServiceUrlBuilder setEndpoint(String endpoint){
        this.endpoint = endpoint;
        return this;
    }

    public ServiceUrlBuilder addQuery(String key, String value) {
        this.queries.put(key, value);
        return this;
    }

    public ServiceUrlBuilder addQuery(String key, int value) {
        var stringTypeValue = Integer.toString(value);

        this.queries.put(key, stringTypeValue);
        return this;
    }

    public String build(){
        if (this.serviceHost.isBlank()){
            //#warning throw?
        }
        if (this.endpoint.isBlank()) {
            //#warning throw?
        }

        var queryString = "";

        if (this.queries.size() > 0) {
            queryString += "?";
            queryString += this.queries.entrySet().stream().map(x -> {
                var key = x.getKey();
                var value = x.getValue();
                return key + "=" + value;
            }).collect(Collectors.joining("&"));
        }

        return this.serviceHost + this.endpoint + queryString;
    }
}
