/**
 * 
 */
package com.lmgroup.salestaxes.beans;

import java.io.Serializable;

/**
 * @author Rafael León Gómez
 *
 */
public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6051983892652572218L;

	/**
	 * The text A of Test
	 */
	private Data input;
	
	/**
	 * The text B of Test
	 */
	private Data output;

	/**
	 * @return the input
	 */
	public final Data getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public final void setInput(Data input) {
		this.input = input;
	}

	/**
	 * @return the output
	 */
	public final Data getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public final void setOutput(Data output) {
		this.output = output;
	}

}
