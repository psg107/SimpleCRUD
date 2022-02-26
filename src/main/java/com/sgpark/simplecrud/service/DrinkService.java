package com.sgpark.simplecrud.service;

import com.netflix.discovery.EurekaClient;
import com.sgpark.simplecrud.define.EurekaVirtualHostNames;
import com.sgpark.simplecrud.model.common.service.NoDataRequest;
import com.sgpark.simplecrud.model.common.Pagination;
import com.sgpark.simplecrud.model.drink.common.AddDrink;
import com.sgpark.simplecrud.model.drink.common.Drink;
import com.sgpark.simplecrud.model.drink.common.UpdateDrink;
import com.sgpark.simplecrud.model.drink.service.add.AddDrinkRequest;
import com.sgpark.simplecrud.model.drink.service.add.AddDrinkResponse;
import com.sgpark.simplecrud.model.drink.service.detail.GetDrinkDetailResponse;
import com.sgpark.simplecrud.model.drink.service.get.GetDrinkRequest;
import com.sgpark.simplecrud.model.drink.service.get.GetDrinkResponse;
import com.sgpark.simplecrud.model.drink.service.update.UpdateDrinkRequest;
import com.sgpark.simplecrud.model.drink.service.update.UpdateDrinkResponse;
import com.sgpark.simplecrud.service.base.IDrinkService;
import com.sgpark.simplecrud.util.RestServiceClient;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Qualifier("DrinkServiceMybatis")
public class DrinkService implements IDrinkService {

    private final EurekaClient eurekaClient;

    @Autowired
    public DrinkService(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @Override
    public Pagination<Drink> getDrinks(int pageNumber) {

        var instanceInfo = eurekaClient.getNextServerFromEureka(EurekaVirtualHostNames.SIMPLE_CRUD_PRODUCT, false);

        //url
        var serviceHost = instanceInfo.getHomePageUrl();
        var endpoint = "api/drink";
        var query = "?page=" + pageNumber;
        var url = serviceHost + endpoint + query;

        //request
        var serviceResponse = new RestServiceClient<GetDrinkRequest>()
                .setUrl(url)
                .setHttpMethod(HttpMethod.GET)
                .request(GetDrinkResponse.class);

        //response
        var drinks = serviceResponse.getData();

        return drinks;
    }

    @Override
    public Drink getDrink(int drinkId) {

        var instanceInfo = eurekaClient.getNextServerFromEureka(EurekaVirtualHostNames.SIMPLE_CRUD_PRODUCT, false);

        //url
        var serviceHost = instanceInfo.getHomePageUrl();
        var endpoint = "api/drink/info";
        var query = "?drinkId=" + drinkId;
        var url = serviceHost + endpoint + query;

        //request
        var serviceResponse = new RestServiceClient<NoDataRequest>()
                .setUrl(url)
                .setHttpMethod(HttpMethod.GET)
                .request(GetDrinkDetailResponse.class);

        //response
        var drink = serviceResponse.getData();

        return drink;
    }

    @Override
    public boolean addDrink(AddDrink addDrink) {

        var instanceInfo = eurekaClient.getNextServerFromEureka(EurekaVirtualHostNames.SIMPLE_CRUD_PRODUCT, false);

        //url
        var serviceHost = instanceInfo.getHomePageUrl();
        var endpoint = "api/drink/add";
        var url = serviceHost + endpoint;

        //data
        var requestData = new DozerBeanMapper().map(addDrink, AddDrinkRequest.class);

        //request
        var serviceResponse = new RestServiceClient<AddDrinkRequest>()
                .setUrl(url)
                .setData(requestData)
                .setHttpMethod(HttpMethod.POST)
                .request(AddDrinkResponse.class);

        //response
        var httpStatus = serviceResponse.getCode();
        var added = httpStatus == HttpStatus.CREATED.value();

        return added;
    }

    @Override
    public boolean updateDrink(UpdateDrink updateDrink) {

        var instanceInfo = eurekaClient.getNextServerFromEureka(EurekaVirtualHostNames.SIMPLE_CRUD_PRODUCT, false);

        //url
        var serviceHost = instanceInfo.getHomePageUrl();
        var endpoint = "api/drink/update";
        var url = serviceHost + endpoint;

        //data
        var requestData = new DozerBeanMapper().map(updateDrink, UpdateDrinkRequest.class);

        //request
        var serviceResponse = new RestServiceClient<UpdateDrinkRequest>()
                .setUrl(url)
                .setData(requestData)
                .setHttpMethod(HttpMethod.POST)
                .request(UpdateDrinkResponse.class);

        //response
        var httpStatus = serviceResponse.getCode();
        var updated = httpStatus == HttpStatus.OK.value();

        return updated;
    }

    @Override
    public boolean deleteDrink(int drinkId) {

        var instanceInfo = eurekaClient.getNextServerFromEureka(EurekaVirtualHostNames.SIMPLE_CRUD_PRODUCT, false);

        //url
        var serviceHost = instanceInfo.getHomePageUrl();
        var endpoint = "api/drink/delete/";
        var query = "?drinkId=" + drinkId;
        var url = serviceHost + endpoint + query;

        //request
        var serviceResponse = new RestServiceClient<NoDataRequest>()
                .setUrl(url)
                .setHttpMethod(HttpMethod.DELETE)
                .request(UpdateDrinkResponse.class);

        //response
        var httpStatus = serviceResponse.getCode();
        var deleted = httpStatus == HttpStatus.OK.value();

        return deleted;
    }
}
