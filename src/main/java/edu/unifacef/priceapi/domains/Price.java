package edu.unifacef.priceapi.domains;

import lombok.Data;

import java.time.LocalDateTime;

import lombok.Builder;

@Data
@Builder
public class Price {
	
	private String carBoard;
	private Double from;
	private Double to;
	private LocalDateTime createdDate;
	private LocalDateTime lastModifiedDate;

}
