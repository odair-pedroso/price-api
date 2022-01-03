package edu.unifacef.priceapi.gateways.outputs.mongodb;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

import edu.unifacef.priceapi.domains.Price;
import edu.unifacef.priceapi.domains.TypeCar;
import edu.unifacef.priceapi.gateways.outputs.PriceDataGateway;
import edu.unifacef.priceapi.gateways.outputs.mongodb.documents.PriceDocument;
import edu.unifacef.priceapi.gateways.outputs.mongodb.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceDataGatewayMongoImpl implements PriceDataGateway {
	
	private final PriceRepository priceRepository;

	@Override
	public Price save(final Price price) {
		if(Objects.isNull(price.getCreatedDate())) {
			price.setCreatedDate(LocalDateTime.now());
		}		
		return priceRepository.save(new PriceDocument(price)).toDomain();
	}

	@Override
	public Optional<Price> findByType(final TypeCar typeCar) {		
		return priceRepository.findById(type).map(PriceDocument::toDomain);
	}

}
