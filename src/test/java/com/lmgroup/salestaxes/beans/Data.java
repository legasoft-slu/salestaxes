/**
 * 
 */
package com.lmgroup.salestaxes.beans;

import java.io.Serializable;

/**
 * @author Rafael León Gómez
 *
 */
public class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470315664382951501L;
	
	/**
	 * The text 1 of Data
	 */
	private String text1;
	
	/**
	 * The text 2 of Data
	 */
	private String text2;
	
	/**
	 * The text 3 of Data
	 */
	private String text3;

	/**
	 * @return the text1
	 */
	public String getText1() {
		return text1;
	}

	/**
	 * @param text1 the text1 to set
	 */
	public void setText1(final String text1) {
		this.text1 = text1;
	}

	/**
	 * @return the text2
	 */
	public String getText2() {
		return text2;
	}

	/**
	 * @param text2 the text2 to set
	 */
	public void setText2(final String text2) {
		this.text2 = text2;
	}

	/**
	 * @return the text3
	 */
	public String getText3() {
		return text3;
	}

	/**
	 * @param text3 the text3 to set
	 */
	public final void setText3(String text3) {
		this.text3 = text3;
	}

}
