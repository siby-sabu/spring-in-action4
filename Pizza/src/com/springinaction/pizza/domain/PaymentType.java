package com.springinaction.pizza.domain;

import java.util.Arrays;
import java.util.List;
import static org.apache.commons.text.WordUtils.*;

public enum PaymentType {
	CARD, CASH, CREDIT_CARD;
	
	public static List<PaymentType> asList(){
		PaymentType[] all = PaymentType.values();
		return Arrays.asList(all);
 	}
	
	@Override
	public String toString() {
		return capitalizeFully(name().replaceAll("_", " "));
	}

}
