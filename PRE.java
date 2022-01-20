import java.util.*;
public class PRE {
	public static void main(String[] args) {
		String S = "5 6 + -";
		Stack<Integer> s = new Stack();
		// Separates the operations out into terms divided by white space
		String[] operations = S.split("\\s+");
		// n = number of operations Time Complexity : O(n) Memory Complexity : O(n)
		for(int i = 0; i < operations.length; i++) {
			// Check for number by checking if first character is a digit and if so push the number on stack
			if(Character.isDigit(operations[i].charAt(0))) s.push(Integer.parseInt(operations[i]));
			// Check if operation is pop if so pop
			else if(operations[i].equals("POP")) {
				if(s.size() >= 1) s.pop();
				else System.out.print(-1);
			}
			// Check if operation is DUP if so push a duplicate of our top object
			else if(operations[i].equals("DUP")) {
				if(s.size() >= 1) s.push(s.peek());
				else System.out.print(-1);
			}
			// Check if operation is plus if so add top two terms
			else if(operations[i].equals("+")) { 
				// Check if we have more than two terms in stack
				if(s.size() >= 2) s.push(s.pop() + s.pop());
				else System.out.print(1);
			}
			// Do same thing with negative sign
			else if(operations[i].equals("-")) {
				if(s.size() >= 2) s.push(s.pop() - s.pop());
				else System.out.print(1);
			}
		}
		System.out.print(s.peek());
	}
}
