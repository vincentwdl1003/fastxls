package com.github.hiwepy.fastxls.core;


/**
 * ValidationType enum
 */
public final class ValidationType {
	private ValidationType() {
		// no instances of this class
	}

	/** 'Any value' type - value not restricted */
	public static final int ANY = 0x00;
	/** Integer ('Whole number') type */
	public static final int INTEGER = 0x01;
	/** Decimal type */
	public static final int DECIMAL = 0x02;
	/** List type ( combo box type ) */
	public static final int LIST = 0x03;
	/** Date type */
	public static final int DATE = 0x04;
	/** Time type */
	public static final int TIME = 0x05;
	/** String length type */
	public static final int TEXT_LENGTH = 0x06;
	/** Formula ( 'Custom' ) type */
	public static final int FORMULA = 0x07;
}
