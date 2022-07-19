package com.nimsoc.lambdas;

import com.nimsoc.objects.LongOperation;

interface ITradable<Trade>{
	boolean check(Trade t);
}

public class Tradables {
	public static void main(String[] args) {
		Tradables client = new Tradables();
		
		ITradable<LongOperation> bigTrade = ( LongOperation t ) -> t.getQuantity() > 1000000? true:false;
		
		ITradable<LongOperation> openTrade = (trade) -> trade.getStatus().equals("OPEN")? true:false;
	}
}
