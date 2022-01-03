package edu.unifacef.priceapi.gateways.inputs.http;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.domains.TypeCar;
import edu.unifacef.priceapi.gateways.inputs.http.requests.PriceRequest;
import edu.unifacef.priceapi.gateways.inputs.http.responses.PriceResponse;
import edu.unifacef.priceapi.usecases.CreatePrice;
import edu.unifacef.priceapi.usecases.FindByTypeCar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/cars/{typeCar}/prices")
public class PriceController {
	
	
	private final PriceValidator priceValidator;
	private final CreatePrice createPrice;
	private final FindByTypeCar findByTypeCar;
	private final UpdatePrice updatePrice;
	
	
	
	@PostMapping
	public PriceResponse create(@PathVariable final TypeCar typeCar,@RequestBody @Validated PriceRequest request) {
		priceValidator.validate(request);
		Price price = createPrice.execute(request.toDomain(typeCar));		
		return new PriceResponse(price);
	}

}
