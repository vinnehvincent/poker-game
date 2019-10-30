package model;

public enum Suit {
	CLUBS("\u2663"),
	HEARTS("\u2665"),
	SPADES("\u2660"),
	DIAMOND("\u2666");
	private String asciiCode;
	
	Suit(String code) {
		this.asciiCode = code;
	}
	public String code() {
		return asciiCode;
	}
}
