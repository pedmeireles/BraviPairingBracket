import java.util.Scanner;
import java.util.Stack;

public class pairingBracket {
	
	
	public static boolean answeredYes(String question) {
		return question.toUpperCase().contains("Y") || question.toUpperCase().contains("S");

	}
	
	public static boolean answeredNo(String question) {
		return question.toUpperCase().contains("N");

	}
	public static boolean keepProgram() {
		System.out.println("Do you want to run the program?[y/n]");
		Scanner scan = new Scanner(System.in);
		String question = scan.nextLine();
		if(answeredYes(question) && answeredNo(question)) {
			return keepProgram();
		}
		else if(answeredYes(question)) {
			return true;
		}
		else if(answeredNo(question)) {
			return false;
		}
		else {
			return keepProgram();
		}
		
	}
	public static char previewClosedPair(char closed) {
		char open = ' ';
		if(closed == ')') {
			open = '(';			
		}
		else if(closed == ']')
			open = '[';
		else if(closed == '}')
			open = '{';
			
		return open;
	}
	
	public static boolean matchBracket(char open, char closed) {
		char previewClosed = previewClosedPair(closed);
		
		return(open == previewClosed);
		
	}
	public static boolean isOpenBracket(char open) {
		return (open == '(' || open == '{' || open == '[');
	}
	
	public static boolean isClosedBracket(char closed) {
		return (closed == ')' || closed == '}' || closed == ']');
	}
	
	public static boolean isNotBracket(char notBracket) {
		return !isOpenBracket(notBracket) && !isClosedBracket(notBracket);
	}
	public static boolean pairingBrackets(String bracket) {
		
		char[] chars = bracket.toCharArray();
		
		Stack<Character> stackBracket = new Stack<Character>();
		boolean somethingWentWrong = false;
		for(char ch : chars) {
			if(isOpenBracket(ch)) {
				stackBracket.push(ch);
			}
			else if(isClosedBracket(ch)) {
				if(!stackBracket.isEmpty()) {
					char openBracket = (char) stackBracket.pop();
					if(!matchBracket(openBracket, ch)) {
						somethingWentWrong = true;
						System.out.println("The last closed bracket verified didn't matched with the top of stack.");
						break;
					}
				} else {
					somethingWentWrong = true;
					System.out.println("The last closed bracket verified doesn't have an open element to pair with.");
					break;
				}
			} else {
				somethingWentWrong = true;
				System.out.println("The string contains invalid characters. ");
				break;
			}
		}
		if(!stackBracket.isEmpty()) {
			somethingWentWrong = true;
			System.out.println("The stack still has elements even after running through all the string. So an open bracket doesn't have a pair.");

		}
		return !somethingWentWrong;
	}
	public static void main(String[] args) {
		
		while(keepProgram()) {
			System.out.println("enter the bracket string that must be evaluate");
			Scanner scan = new Scanner(System.in);
			String bracketString = scan.nextLine();
			if(pairingBrackets(bracketString)) {
				System.out.println("The string is a valid string!");
			}
			else {
				System.out.println("The string is a invalid string!");
			}
		}
		System.out.println("Oks.. See you there!");
	}

}
