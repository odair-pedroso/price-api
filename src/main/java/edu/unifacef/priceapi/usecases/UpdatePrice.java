package edu.unifacef.priceapi.usecases;

import org.ff4j.FF4j;
import org.springframework.stereotype.Component;

import edu.unifacef.priceapi.gateways.outputs.LocationGateway;
import edu.unifacef.priceapi.gateways.outputs.PriceDataGateway;
import edu.unifacef.priceapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdatePrice {
	
	private final PriceDataGateway priceDataGateway;
	private final LocationGateway locationGateway;
	private final MessageUtils messageUtils;
	private final FF4j ff4j;
	
	
	  
	  
	  
	
	

}
