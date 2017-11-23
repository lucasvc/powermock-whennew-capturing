package com.github.lucasvc.powermock;

import java.math.BigInteger;
import java.util.Random;

public class MultiConstructor {

	private static final Random random = new Random();

	private static final String DEFAULT_FIRST = "1";
	private static final String DEFAULT_SECOND = "2";

	private String first;
	private String second;

	public MultiConstructor() {
		this(DEFAULT_FIRST, DEFAULT_SECOND);
	}

	public MultiConstructor(String first) {
		this(first, DEFAULT_SECOND);
	}

	public MultiConstructor(String first, String second) {
		this.first = first;
		this.second = second;
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}

	public static MultiConstructor factory() {
		return new MultiConstructor(generateRand(16), generateRand(32));
	}

	public static String generateRand(int length) {
		return new BigInteger(length * 5, random).toString(32);
	}

}
