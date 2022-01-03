package edu.unifacef.priceapi.usecases;

import org.springframework.stereotype.Component;
import static edu.unifacef.priceapi.exceptions.MessageKey.PRICE_NOT_FOUND;
import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.domains.TypeCar;
import edu.unifacef.priceapi.exceptions.NotFoundException;
import edu.unifacef.priceapi.gateways.outputs.PriceDataGateway;
import edu.unifacef.priceapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByTypeCar {
	
	private final PriceDataGateway priceDataGateway;
	private final MessageUtils messageUtils;
	
	public Price execute (final TypeCar typeCar) {
		log.info("Find price. Type car: {}", typeCar);
		return priceDataGateway.findByType(typeCar).orElseThrow(
			() -> new NotFoundException(messageUtils.getMessage(PRICE_NOT_FOUND, typeCar)));		
	}
}
