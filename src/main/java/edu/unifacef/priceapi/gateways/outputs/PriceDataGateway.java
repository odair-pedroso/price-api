package edu.unifacef.priceapi.gateways.outputs;

import java.util.Optional;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.domains.TypeCar;

public interface PriceDataGateway {
	
	Price save(Price price);
	
	Optional<Price> findByType (TypeCar type);

}
