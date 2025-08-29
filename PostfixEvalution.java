import java.util.Stack;
public class PostfixEvalution{
	public static int evalutionPostfix(String expression){
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<evalution.length();i++){
			char c=expression.charAt(i);
			if(c==''){
				continue;
			}
			if(character.isDigit(c)){
				stack.push(c-'0');
			}
			else{
				int val2=stack.pop();
				int val1=stack.pop();
				switch (c){
					case'+':
					  stack.push(val1+val2);
					  break;
					case'-':
                      stack.push(val1-val2);
                      break;
                    case'*':
                      stack.push(val1*val2);
                      break;
                    case'/':
                      stack.push(val1/val2);
                      break;
                    case'%':
                      stack.push(val1%val2);
                      break;
                    default:
                      System.out.println("Invalid Operator:"+c);
				}
            }
        } 
    retuen stack.pop();
    }
public static void main(Strin[] args){ 
    String postfixExp="231*+9-";
    System.out.println("postfix Expression":+postfixExp);
    int result=evalutePostfix(postfixExp);
    System.out.println("Result:"+result);
    }
}	
				