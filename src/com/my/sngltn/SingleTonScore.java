package com.my.sngltn;

import java.util.Date;

public class SingleTonScore {
	static{System.out.println("SIB :: SingleTonScore");}
	{System.out.println("IIB ::: SingleTonScore" );}
	private static SingleTonScore singleTonScore;
	public long timestamp;
	
	private SingleTonScore() throws Exception {
		//throw new Exception();//singleton
		//this.timestamp = new Date().getTime();
	}
	private SingleTonScore(Date date) throws Exception {
		this.timestamp = date.getTime();
		if (singleTonScore != null)
			throw new Exception("ALREADY HAS ..");
	}
	
	public static SingleTonScore getSingleTonScore(Date date) throws Exception {
		if (singleTonScore == null) singleTonScore = new SingleTonScore(date);
		return singleTonScore;
	}
	
	@Override
	public String toString() {
		System.out.println(":::::"  + timestamp);
		return "" + timestamp;
	}

	
}
