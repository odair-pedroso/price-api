package edu.unifacef.priceapi.gateways.inputs.http;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unifacef.priceapi.domains.Price;

import edu.unifacef.priceapi.gateways.inputs.http.requests.PriceRequest;
import edu.unifacef.priceapi.gateways.inputs.http.responses.PriceResponse;
import edu.unifacef.priceapi.usecases.CreatePrice;
import edu.unifacef.priceapi.usecases.FindByCarBoard;
import edu.unifacef.priceapi.usecases.UpdatePrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/cars/{carBoard}/prices")
public class PriceController {
	
	
	private final PriceValidator priceValidator;
	private final CreatePrice createPrice;
	private final FindByCarBoard findByCarBoard;
	private final UpdatePrice updatePrice;
	
	
	
	@GetMapping
	public PriceResponse find(@PathVariable final String carBoard) {
		Price price = findByCarBoard.execute(carBoard);
		return new PriceResponse(price) ;
		
	}
	
	
	@PostMapping
	public PriceResponse create(@PathVariable final String carBoard,@RequestBody @Validated PriceRequest request) {
		priceValidator.validate(request);
		Price price = createPrice.execute(request.toDomain(carBoard));		
		return new PriceResponse(price);
	}

}
