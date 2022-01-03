package edu.unifacef.priceapi.gateways.outputs.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.unifacef.priceapi.domains.TypeCar;
import edu.unifacef.priceapi.gateways.outputs.http.resources.PriceResource;

@FeignClient(name = "location", url = "${integration.location.url}")
public interface LocationFeignIntegration {
	
	@PostMapping(path = "/api/v1/cars/{typeCar}/prices", produces = APPLICATION_JSON_VALUE)
	void send(@PathVariable("typeCar") final TypeCar typeCar, final PriceResource priceResource);
}
