package edu.unifacef.priceapi.gateways.outputs.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.unifacef.priceapi.gateways.outputs.mongodb.documents.PriceDocument;

public interface PriceRepository extends MongoRepository<PriceDocument, String> {

}
