package objects_classes;

/******************************************************************************
 *  Compilation:  javac RationalPrinceton.java
 *  Execution:    java RationalPrinceton
 *
 *  ADT for nonnegative Rational numbers. Bare-bones implementation.
 *  Cancel common factors, but does not stave off overflow. Does not
 *  support negative fractions.
 *
 *  Invariant: all Rational objects are in reduced form (except
 *  possibly while modifying).
 *
 *  Remarks
 *  --------
 *    - See https://introcs.cs.princeton.edu/java/92symbolic/BigRational.java.html
 *      for a version that supports negative fractions and arbitrary
 *      precision numerators and denominators.
 *
 *  % java RationalPrinceton
 *  5/6
 *  1
 *  28/51
 *  17/899
 *  0
 *
 ******************************************************************************/

public class RationalPrinceton {
    private int num;   // the numerator
    private int den;   // the denominator
    
    // getters of num and den
    public int getNum() {
    	return num;
    }
    public int getDen() {
    	return den;
    }
    

    // create and initialize a new Rational object
    public RationalPrinceton(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Denominator is zero");
        }
        int g = gcd(numerator, denominator);
        num = numerator   / g;
        den = denominator / g;

    }

    // return string representation of (this)
    public String toString() {
        if (den == 1) return num + "";
        else          return num + "/" + den;
    }

    // return double representation of (this)
    public double toDouble() {
        return ((double) num) / ((double) den);
    }
    
    // return (this * b)
    public RationalPrinceton times(RationalPrinceton b) {
        return new RationalPrinceton(this.num * b.num, this.den * b.den);
    }


    // return (this + b)
    public RationalPrinceton plus(RationalPrinceton b) {
        int numerator   = (this.num * b.den) + (this.den * b.num);
        int denominator = this.den * b.den;
        return new RationalPrinceton(numerator, denominator);
    }
    
    // return (this - b)
    public RationalPrinceton minus(RationalPrinceton b) {
        int numerator   = (this.num * b.den) - (this.den * b.num);
        int denominator = this.den * b.den;
        return new RationalPrinceton(numerator, denominator);
    }

    // return (1 / this)
    public RationalPrinceton reciprocal() { return new RationalPrinceton(den, num);  }

    // return (this / b)
    public RationalPrinceton divides(RationalPrinceton b) {
        return this.times(b.reciprocal());
    }


   /***************************************************************************
    *  Helper functions
    ***************************************************************************/

    // return gcd(m, n)
    private static int gcd(int m, int n) {
        if (0 == n) return m;
        else return gcd(n, m % n);
    }


   /***************************************************************************
    *  Test client
    ***************************************************************************/
    
    public static void main(String[] args) {
        RationalPrinceton x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new RationalPrinceton(1, 2);
        y = new RationalPrinceton(1, 3);
        z = x.plus(y);
        System.out.println(z);

        // 8/9 + 1/9 = 1
        x = new RationalPrinceton(8, 9);
        y = new RationalPrinceton(1, 9);
        z = x.plus(y);
        System.out.println(z);

        //  4/17 * 7/3 = 28/51
        x = new RationalPrinceton(4, 17);
        y = new RationalPrinceton(7,  3);
        z = x.times(y);
        System.out.println(z);

        // 203/16957 * 9299/5887 = 17/899
        x = new RationalPrinceton(203, 16957);
        y = new RationalPrinceton(9299, 5887);
        z = x.times(y);
        System.out.println(z);

        // 0/6 = 0
        x = new RationalPrinceton(0, 6);
        System.out.println(x);

    }

}