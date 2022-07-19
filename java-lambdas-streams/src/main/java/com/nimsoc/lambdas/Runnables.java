package com.nimsoc.lambdas;
import com.nimsoc.objects.LongOperation;
import java.util.concurrent.Callable;

//Example Lambdas
public class Runnables {

	public void methodAcceptingRunnable(Runnable r){
		
	}
	
	public void methodAcceptingCallable(Callable c){
		
	}
	
	public static void main(String[] args) {
		Runnable runnable = ( ) -> System.out.println("Hello, Lambda");
		
		new Runnables().methodAcceptingRunnable(runnable);
		
		new Runnables().methodAcceptingRunnable(() ->{
			System.out.println("Complex lambda");
			persist();
			email();
		});
		
		Callable callable = () -> "Hello, Callable";
		
		new Runnables().methodAcceptingCallable(( ) -> {
			return "Hello!";
		}); 
		
	}

	private static void email() {
		// TODO Auto-generated method stub
		
	}

	private static void persist() {
		// TODO Auto-generated method stub
		
	}

	
	interface Tradable<Trade>{
		boolean check(Trade t);
	};
	
	Tradable<LongOperation> bigTradeLambda = (trade) -> trade.isLongOperation();
	
	Tradable<LongOperation> ibmTradeLambda = (trade ) -> trade.getName().equals("IBM");
}
