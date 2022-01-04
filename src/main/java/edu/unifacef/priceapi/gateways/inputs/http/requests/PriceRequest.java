package edu.unifacef.priceapi.gateways.inputs.http.requests;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import edu.unifacef.priceapi.domains.Price;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PriceRequest implements Serializable {
	
	private static final long serialVersionUID = 5153509276122327498L;
	
	
	@ApiModelProperty(position = 0)
	@NotNull(message = "{required.field}")
	private Double from;
	
	
	@ApiModelProperty(position = 1)
	@NotNull(message = "{required.field}")
	private Double to;
	
	
	public Price toDomain(final String carBoard) {
		return Price.builder()
			.carBoard(carBoard)
			.from(this.from)
			.to(this.to)
			.build();		
	}

}
