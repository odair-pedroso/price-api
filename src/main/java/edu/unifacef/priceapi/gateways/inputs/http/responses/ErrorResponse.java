package edu.unifacef.priceapi.gateways.inputs.http.responses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ErrorResponse implements Serializable {
	
	private static final long serialVersionUID = -5803837526028241382L;
	private List<String> errors = new ArrayList();
	

}
