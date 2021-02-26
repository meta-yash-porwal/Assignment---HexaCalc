import java.util.Scanner;

class HexCalc {
	public static String decToHexa(int value) {
		return Integer.toHexString(value);
	}

	public static int hexaToDec(String value) {
		int val = Integer.parseInt(value, 16);
		return val;
	}

	public static void add(String a, String b) {
		int ai = hexaToDec(a);
		int bi = hexaToDec(b);
		int ci = ai + bi;
		String cs = decToHexa(ci);
		System.out.println(cs);
	}

	public static void subtract(String a, String b) {
		int ai = hexaToDec(a);
		int bi = hexaToDec(b);
		int ci = ai - bi;
		String cs = decToHexa(ci);
		System.out.println(cs);
	}

	public static void multiply(String a, String b) {
		int ai = hexaToDec(a);
		int bi = hexaToDec(b);
		int ci = ai * bi;
		String cs = decToHexa(ci);
		System.out.println(cs);
	}

	public static void divide(String a, String b) {
		int ai = hexaToDec(a);
		int bi = hexaToDec(b);
		int ci = ai / bi;
		String cs = decToHexa(ci);
		System.out.println(cs);
	}
}

public class HexaDecimalCalculator {
	static String a;
	static String b;
	static int ofChoice;

	public static void main(String[] args) {
		while (true) {
			firstPage();
		}
	}

	public static void twoInputs() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a : ");
		a = sc.nextLine();
		System.out.print("Enter b : ");
		b = sc.nextLine();
	}

	public static void aInput() {
		Scanner sc = new Scanner(System.in);
		ofChoice = sc.nextInt();
	}

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

	public static void arithmeticPage() {

		System.out
				.println("1. Add \n2. Subtract \n3. Multiply \n4. Divide \n5. Back \n0.Exit");
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
	
	
	public static boolean relations(int caseValue) {
		twoInputs();
		int value = a.compareTo(b);

		if (caseValue == 1 && value == 0) {
			return true;
		} else if (caseValue == 2 && value>0) {
			return true;
		} else if (caseValue == 3 && value<0) {
			return true;
		} else {
			return false;
		}
	}

	public static void conversionPage() {
		System.out
				.println("1. From HexaDecimal to Decimal \n2. From Decimal to HexaDecimal \n3. Back \n0. Exit");
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
