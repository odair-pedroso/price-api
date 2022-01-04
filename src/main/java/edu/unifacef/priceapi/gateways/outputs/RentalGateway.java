package edu.unifacef.priceapi.gateways.outputs;

import edu.unifacef.priceapi.domains.Price;

public interface RentalGateway {
	
	void send(Price price);

}
