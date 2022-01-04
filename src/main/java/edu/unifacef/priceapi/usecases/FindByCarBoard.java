package edu.unifacef.priceapi.usecases;

import org.springframework.stereotype.Component;
import static edu.unifacef.priceapi.exceptions.MessageKey.PRICE_NOT_FOUND;
import edu.unifacef.priceapi.domains.Price;

import edu.unifacef.priceapi.exceptions.NotFoundException;
import edu.unifacef.priceapi.gateways.outputs.PriceDataGateway;
import edu.unifacef.priceapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByCarBoard {
	
	private final PriceDataGateway priceDataGateway;
	private final MessageUtils messageUtils;
	
	public Price execute (final String carBoard) {
		log.info("Find price. Car board: {}", carBoard);
		return priceDataGateway.findByBoard(carBoard).orElseThrow(
			() -> new NotFoundException(messageUtils.getMessage(PRICE_NOT_FOUND, carBoard)));		
	}
}
