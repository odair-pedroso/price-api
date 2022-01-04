package edu.unifacef.priceapi.gateways.outputs;

import java.util.Optional;

import edu.unifacef.priceapi.domains.Price;


public interface PriceDataGateway {
	
	Price save(Price price);
	
	Optional<Price> findByBoard (String board);

}
