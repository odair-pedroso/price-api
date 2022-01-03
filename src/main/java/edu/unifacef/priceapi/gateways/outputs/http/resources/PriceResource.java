package edu.unifacef.priceapi.gateways.outputs.http.resources;

import java.io.Serializable;
import edu.unifacef.priceapi.domains.Price;
import lombok.Data;

@Data
public class PriceResource implements Serializable {
	
	
	private static final long serialVersionUID = 4346706890197509855L;
	
	private Double from;
	private Double to;
	
	
	public PriceResource (final Price price) {
		this.from = price.getFrom();
		this.to = price.getTo();
	}

}
