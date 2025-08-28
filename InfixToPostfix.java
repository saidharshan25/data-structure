import java.util.Stack;
public class InfixToPostfix{
	private static int precedence(char ch){
		switch (ch){
			case'+':
			case'-':
			  return 1;
            case'*':
            case'/':
              return 2;
            case'^':
              return 3;
		}
    return-1;
	}
public static String infixToPostfix(String expression){
	StringBuilder result=new StringBuilder();
	Stack<Character>stack=new Stack<>();
	for (int i=0;i<expression.length();i++){
		char c=expression.charAt(i);
		if(Character.isLetterOrDigit(c)){
			result.append(c);
		}
		else if(c=='('){
			stack.push(c);
		}
		else if(c==')'){
			while(!stack.isEmpty()&&stack.peek()!='('){
				result.append(stack.pop());
			}
			stack.pop();
		}
		else{
			while(!stack.isEmpty()&&precedence(stack.peek())>=precedence(c)){
				result.append(stack.pop());
			}
			stack.push(c);
		}
	}
	while(!stack.isEmpty()){
		result.append(stack.pop());
	}
	return result.toString();
}
public static void main(String[] args){
	String infixExp="A+(B*C-(D/E^F)*G)*H";
	System.out.println("Infix Expression:"+infixExp);
	String postfixExp=infixToPostfix(infixExp);
	System.out.println("postfix Expression:"+postfixExp);
	}
}


Output:
Infix Expression:A+(B*C-(D/E^F)*G)*H
postfix Expression:ABC*DEF^/G*-H*+
         			

	
