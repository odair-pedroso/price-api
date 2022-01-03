package edu.unifacef.priceapi.gateways.outputs;

import edu.unifacef.priceapi.domains.Price;

public interface LocationGateway {
	
	void send(Price price);

}
