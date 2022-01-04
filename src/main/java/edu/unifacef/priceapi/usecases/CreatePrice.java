package edu.unifacef.priceapi.usecases;

import org.ff4j.FF4j;
import org.springframework.stereotype.Component;



import static edu.unifacef.priceapi.exceptions.MessageKey.PRICE_ALREADY_EXISTS;

import edu.unifacef.priceapi.configurations.ff4j.Features;
import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.gateways.outputs.RentalGateway;
import edu.unifacef.priceapi.gateways.outputs.PriceDataGateway;
import edu.unifacef.priceapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreatePrice {
	
	private final PriceDataGateway priceDataGateway;
	private final MessageUtils messageUtils;
	private final RentalGateway rentalGateway;
	private final FF4j ff4j;
	
	
	public Price execute(final Price price) {
		log.info("Create price. Car board: {}", price.getCarBoard());
		if(priceDataGateway.findByBoard(price.getCarBoard()).isPresent()) {
			throw new IllegalArgumentException(
				messageUtils.getMessage(PRICE_ALREADY_EXISTS, price.getCarBoard()));
			
		}
		
		Price saved = priceDataGateway.save(price);
		if(ff4j.check(Features.SEND_TO_RENTAL.getKey())) {
			rentalGateway.send(saved);
		}
		return saved;		
		
	}

}
