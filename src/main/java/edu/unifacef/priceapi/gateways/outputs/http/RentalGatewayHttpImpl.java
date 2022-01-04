package edu.unifacef.priceapi.gateways.outputs.http;

import org.springframework.stereotype.Component;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.gateways.outputs.RentalGateway;
import edu.unifacef.priceapi.gateways.outputs.http.resources.PriceResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class RentalGatewayHttpImpl implements RentalGateway {
	
	private final RentalFeignIntegration rentalFeignIntegration;

	@Override
	public void send(Price price) {
		log.info("Sending price to Rental. Car board: {}",price.getCarBoard());
		PriceResource priceResource = new PriceResource(price);
		rentalFeignIntegration.send(price.getCarBoard(), priceResource);
		
	}

}
