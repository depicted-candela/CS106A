/**
 * 
 */
package objects_classes;

/**
 * @author nicalcoca
 *
 */

import acm.util.*;
import java.math.*;

public class Rational {
	
	/**
	* Creates a new Rational initialized to zero.
	*/
	public Rational() {
		this(0);
	}
	/**
	* Creates a new Rational from the integer argument.
	* @param n The initial value
	*/
	public Rational(int n) {
		this(n, 1);
	}
	/**
	* Creates a new Rational with the value x / y.
	* @param x The numerator of the rational number
	* @param y The denominator of the rational number
	*/
	public Rational(int x, int y) {
		if (y == 0) throw new ErrorException("Division by 0");
		BigInteger xb = new BigInteger(String.valueOf(Math.abs(x)));
		BigInteger yb = new BigInteger(String.valueOf(Math.abs(y)));
		BigInteger gb = gcd(xb, yb);
		int gi = gb.intValueExact();
		num = x / gi;
		den = Math.abs(y) / gi;
		if (y < 0) num = -num;
	}
	/**
	* Adds the rational number r to this one and returns the sum.
	* @param r The rational number to be added
	* @return The sum of the current number and r
	*/
	public Rational add(Rational r) {
		return new Rational(this.num * r.den + r.num * this.den, this.den * r.den);
	}
	/**
	* Subtracts the rational number r from this one.
	* @param r The rational number to be subtracted
	* @return The result of subtracting r from the current number
	*/
	public Rational subtract(Rational r) {
		return new Rational(this.num * r.den - r.num * this.den, this.den * r.den);
	}

	/**
	* Multiplies this number by the rational number r.
	* @param r The rational number used as a multiplier
	* @return The result of multiplying the current number by r
	*/
	public Rational multiply(Rational r) {
		return new Rational(this.num * r.num, this.den * r.den);
	}
	/**
	* Divides this number by the rational number r.
	* @param r The rational number used as a divisor
	* @return The result of dividing the current number by r
	*/
	public Rational divide(Rational r) {
		return new Rational(this.num * r.den, this.den * r.num);
	}
	/**
	* Creates a string representation of this rational number.
	* @return The string representation of this rational number
	*/
	public String toString() {
		if (den == 1) {
			return "" + num;
		} else {
			return num + "/" + den;
		}
	}
	
	/**
	* Creates a double representation of this rational number.
	* @return The double representation of this rational number
	*/
	public double toDouble() {
		System.out.println("Num");
		System.out.println((double) num);
		System.out.println("Den");
		System.out.println((double) den);
		return ((double) num) / ((double) den);
	}
	
	/**
	* Calculates the greatest common divisor using Euclid's algorithm.
	* @param x First integer
	* @param y Second integer
	* @return The greatest common divisor of x and y
	*/
	private BigInteger gcd(BigInteger x, BigInteger y) {
		BigInteger r = x.mod(y);
		while (r.compareTo(BigInteger.ZERO) == 0) {
			System.out.println('B');
//			r = x.gcd(y);
//			r = x;
			x = y;
			y = r;
			r = x.mod(y);
//			r = r.gcd(x);
		}
		return y;
	}
	/* Private instance variables */
	private int num;
	private int den;
}
