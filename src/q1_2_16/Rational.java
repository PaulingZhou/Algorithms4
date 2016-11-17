package q1_2_16;

public class Rational {
	private final int numerator;
	private final int denominator;

	public Rational(int b1_Numerator, int b1_Denominator) throws DenominatorZeroException{
		if(b1_Numerator == 0) {
			this.numerator = 0;
			this.denominator = 1;
			return;
		}
		if(b1_Denominator == 0) throw new DenominatorZeroException("除数不能为0");
		int mod = getGCD(b1_Numerator, b1_Denominator);
		this.denominator = b1_Denominator / mod;
		this.numerator = b1_Numerator / mod;
//		assert numerator > Integer.MAX_VALUE || numerator < Integer.MIN_VALUE : "被除数超限";
//		assert denominator > Integer.MAX_VALUE || denominator < Integer.MIN_VALUE : "除数超限";
	}

	public int getDenominator() {
		return (int) denominator;
	}

	public int getNumerator() {
		return (int) numerator;
	}
	
	public Rational plus(Rational b) throws DenominatorZeroException {
		int b_Numerator = b.getNumerator();
		int b_Denominator = b.getDenominator();
		int b1_Denominator = denominator * b_Denominator;
		int b1_Numerator = numerator * b_Denominator + b_Numerator * denominator;
//		int gcd = getGCD(b1_Numerator, b1_Denominator);
//		b1_Numerator = b1_Numerator / gcd;
//		b1_Denominator = b1_Denominator / gcd;
		return new Rational(b1_Numerator, b1_Denominator);
	}
	
	public Rational minus(Rational b) throws DenominatorZeroException {
		int b_Numerator = -b.getNumerator();
		int b_Denominator = b.getDenominator();
		Rational b1 = new Rational(b_Numerator, b_Denominator);
		return this.plus(b1);	
	}
	
	public Rational times(Rational b) throws DenominatorZeroException {
		int b_Numerator = b.getNumerator() * numerator;
		int b_Denominator = b.getDenominator() * denominator;
//		int gcd = getGCD(b_Numerator, b_Denominator);
//		b_Numerator /= gcd;
//		b_Denominator /= gcd;
		return new Rational(b_Numerator, b_Denominator);
	}
	
	public Rational divides(Rational b) throws DenominatorZeroException {
		Rational b1 = new Rational(b.getDenominator(), b.getNumerator());
		return this.times(b1);
	}
	
	public boolean equals(Rational b) {
		return numerator == b.getNumerator() && denominator == b.getDenominator();
	}

	private int getGCD(int b1_Numerator, int b1_Denominator) {
		int maxNum = Math.max(Math.abs(b1_Numerator), Math.abs(b1_Denominator));
		int minNum = Math.min(Math.abs(b1_Numerator), Math.abs(b1_Denominator));
		int gcd = minNum;
		int mod = maxNum - minNum * (maxNum / minNum);
		if (mod == 0)
			return gcd;
		else {
			maxNum = mod;
			return (getGCD(mod, minNum));
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return numerator + "/" + denominator;
	}

}
