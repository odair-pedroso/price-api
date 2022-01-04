package edu.unifacef.priceapi.gateways.inputs.http.responses;

import java.io.Serializable;
import java.time.LocalDateTime;

import edu.unifacef.priceapi.domains.Price;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PriceResponse implements Serializable {
	
	private static final long serialVersionUID = 4655889080829497767L;
	
	
	@ApiModelProperty(position = 0)
	private String carBoard;
	@ApiModelProperty(position = 1)
	private Double from;
	@ApiModelProperty(position = 2)
	private Double to;
	@ApiModelProperty(position = 3)
	private LocalDateTime createdDate;
	@ApiModelProperty(position = 4)
	private LocalDateTime lastModifiedDate;
	
	public PriceResponse(final Price price) {
		this.carBoard = price.getCarBoard();
		this.from = price.getFrom();
		this.to = price.getTo();
		this.createdDate = price.getCreatedDate();
		this.lastModifiedDate = price.getLastModifiedDate();
	}

}
