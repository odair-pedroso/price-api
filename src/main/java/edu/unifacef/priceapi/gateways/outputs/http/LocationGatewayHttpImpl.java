package edu.unifacef.priceapi.gateways.outputs.http;

import org.springframework.stereotype.Component;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.gateways.outputs.LocationGateway;
import edu.unifacef.priceapi.gateways.outputs.http.resources.PriceResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class LocationGatewayHttpImpl implements LocationGateway {
	
	private final LocationFeignIntegration locationFeignIntegration;

	@Override
	public void send(Price price) {
		log.info("Sending price to Location. Type car: {}",price.getTypeCar());
		PriceResource priceResource = new PriceResource(price);
		locationFeignIntegration.send(price.getTypeCar(), priceResource);
		
	}

}
