import java.util.Scanner;
/**
 * this class is used convert decimal to hexadecimal,
 * hexadecimal to decimal and doing arithmetic operations on 
 * hexadecimal number - Add, subtract, multiply and divide
 * @author yash.porwal_metacube
 *
 */
class HexCalc {
	public static String decToHexa(int value) {
		return Integer.toHexString(value);
	}

	
	/**
	 * it converts hexadecimal number to decimal number
	 * @param value in string is hexadecimal number
	 * @return decimal number in integer
	 */
	public static int hexaToDec(String value) {
		int val = Integer.parseInt(value, 16);
		return val;
	}

	/**
	 * it adds two hexadecimal number while converting it into decimal number
	 * @param a is the 1st hexadecimal number in the form of string
	 * @param b is the 2nd hexadecimal number in the form of string
	 */
	public static void add(String a, String b) {
		int ai = hexaToDec(a);
		int bi = hexaToDec(b);
		int ci = ai + bi;
		String cs = decToHexa(ci);
		System.out.println(cs);
	}

	/**
	 * it subtract two hexadecimal number while converting it into decimal number
	 * @param a is the 1st hexadecimal number in the form of string
	 * @param b is the 2nd hexadecimal number in the form of string
	 */
	public static void subtract(String a, String b) {
		int ai = hexaToDec(a);
		int bi = hexaToDec(b);
		int ci = ai - bi;
		String cs = decToHexa(ci);
		System.out.println(cs);
	}

	/**
	 *it multiply two hexadecimal number while converting it into decimal number
	 * @param a is the 1st hexadecimal number in the form of string
	 * @param b is the 2nd hexadecimal number in the form of string
	 */
	public static void multiply(String a, String b) {
		int ai = hexaToDec(a);
		int bi = hexaToDec(b);
		int ci = ai * bi;
		String cs = decToHexa(ci);
		System.out.println(cs);
	}

	/**
	 *it divide two hexadecimal number while converting it into decimal number
	 * @param a is the 1st hexadecimal number in the form of string
	 * @param b is the 2nd hexadecimal number in the form of string
	 */
	public static void divide(String a, String b) {
		int ai = hexaToDec(a);
		int bi = hexaToDec(b);
		int ci = ai / bi;
		String cs = decToHexa(ci);
		System.out.println(cs);
	}
}

/**
 * it is a hexaDecimal calculator
 * @author yash.porwal_metacube
 *
 */
public class HexaDecimalCalculator {
	static String a;
	static String b;
	static int ofChoice;

	public static void main(String[] args) {
		while (true) {
			firstPage();
		}
	}

	/**
	 * it takes input of two string from user
	 */
	public static void twoInputs() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a : ");
		a = sc.nextLine();
		System.out.print("Enter b : ");
		b = sc.nextLine();
	}

	/**
	 * it takes input of single integer value
	 */
	public static void aInput() {
		Scanner sc = new Scanner(System.in);
		ofChoice = sc.nextInt();
	}

	/**
	 * this is the driver code of the program 
	 * which is firstly represented in console(output) window 
	 */
	public static void firstPage() {
		System.out.println("1.Arithmetic \n2. Relational \n3. Conversion \n0. Exit");
		System.out.print("Enter your Choice: ");
		aInput();
		switch (ofChoice) {
		case 1:
			arithmeticPage();
			System.exit(0);

		case 2:
			relationPage();
			System.exit(0);

		case 3:
			conversionPage();
			System.exit(0);

		case 0:
			System.exit(0);
		default:
			System.out.println("Please enter the Correct Choice");
			break;
		}
	}

	/**
	 * this is the driver code of the program
	 * which is specifically code to give 
	 * what should be print in console(output) window 
	 * when the user doing arithmetic in hexadecimal number
	 */
	public static void arithmeticPage() {

		System.out.println("1. Add \n2. Subtract \n3. Multiply \n4. Divide \n5. Back \n0.Exit");
		System.out.print("Enter your Choice: ");
		aInput();
		switch (ofChoice) {
		case 1:
			twoInputs();
			HexCalc.add(a, b);
			break;

		case 2:
			twoInputs();
			HexCalc.subtract(a, b);
			break;

		case 3:
			twoInputs();
			HexCalc.multiply(a, b);
			break;

		case 4:
			twoInputs();
			HexCalc.divide(a, b);
			break;

		case 5:
			firstPage();

		case 0:
			System.exit(0);

		default:
			System.out.println("Enter correct Choice");
		}
	}

	/**
	 * this is the driver code of the program
	 * which is specifically code to give 
	 * what should be print in console(output) window 
	 * when the user finding relations between two hexadecimal number
	 */
	public static void relationPage() {
		System.out.println("1. == \n2. > \n3. < \n4. Back \n5. Exit");
		System.out.print("Enter your Choice: ");
		aInput();
		switch (ofChoice) {
		case 1:
			System.out.println(relations(1));
			break;

		case 2:
			System.out.println(relations(2));
			break;

		case 3:
			System.out.println(relations(3));
			break;

		case 4:
			firstPage();
		case 5:
			System.exit(0);
		default:
			System.out.println("Enter Correct Choice");

		}
	}
	
	/**
	 * it find the relation between two hexadecimal number
	 * that is the numbers equal or greater or less than
	 * @param caseValue what the user want (equality check or greater than check or less than check)
	 * @return boolean value true/false on the basis of what answer it get
	 */
	public static boolean relations(int caseValue) {
		twoInputs();
		int binary1 = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(a, 16)));
		int binary2 = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(b, 16)));

		if (caseValue == 1 && binary1 == binary2) {
			return true;
		} else if (caseValue == 2 && binary1 > binary2) {
			return true;
		} else if (caseValue == 3 && binary1 < binary2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * conversion form hexadecimal number to decimal or vice versa
	 * then this is used
	 */
	public static void conversionPage() {
		System.out.println("1. From HexaDecimal to Decimal \n2. From Decimal to HexaDecimal \n3. Back \n0. Exit");
		System.out.print("Enter your Choice: ");
		aInput();
		String hex;
		switch (ofChoice) {
		case 1:
			System.out.print("Enter a HexaDecimal No.: ");
			Scanner sc = new Scanner(System.in);
			hex = sc.nextLine();
			int dec = HexCalc.hexaToDec(hex);
			System.out.printf("Decimal Equivalent: %d", dec);
			break;

		case 2:
			System.out.print("Enter a Decimal No.: ");
			aInput();
			hex = HexCalc.decToHexa(ofChoice);
			System.out.println("Hexadecimal: " + hex);
			break;

		case 3:
			firstPage();

		case 0:
			System.exit(0);

		default:
			System.out.println("Enter correct Choice");

		}
	}
}
