class PolyNode{
	int values;
	int exponent;
	PolyNode next;
	PolyNode(){}
	PolyNode(int v,int e){
		values=v;
		exponent=e;
	}
}
public class PolynomialAddition{
	public PolyNode addPolynomial(PolyNode poly1,PolyNode poly2){
		PolyNode dummy=new PolyNode(0,0);
		PolyNode current=dummy;
		while(poly1!=null&&poly2!=null){
			if(poly1.exponent>poly2.exponent){
				current.next=new PolyNode(poly1.values,poly1.exponent);
				poly1=poly1.next;
			}
			else if(poly1.exponent<poly2.exponent){
				current.next=new PolyNode(poly2.values,poly2.exponent);
				poly2=poly2.next;
			}else {
				int sum=poly1.values+poly2.values;
				if(sum!=0){
					current.next=new PolyNode(sum,poly1.exponent);
				}
				poly1=poly1.next;
				poly2=poly2.next;
			}
			if(current.next!=null)
				current=current.next;
		}
		while(poly1!=null){
			current.next=new PolyNode(poly1.values,poly1.exponent);
			poly1=poly1.next;
			current=current.next;
		}
		while(poly2!=null)
		{
			current.next=new PolyNode(poly2.values,poly2.exponent);
			poly2=poly2.next;
			current=current.next;
		}
		return dummy.next;
	}
	public void printPolynomial(PolyNode head){
		while(head!=null){
			System.out.print(head.values+"x"+head.exponent);
			if(head.next!=null)
				System.out.print("+");
			head=head.next;
		}
		System.out.println();
	}
	public static void main(String[] args){
		PolynomialAddition pa=new PolynomialAddition();
		PolyNode poly1=new PolyNode(6,2);
		poly1.next=new PolyNode(3,3);
		poly1.next.next=new PolyNode(3,0);
		PolyNode poly2=new PolyNode(4,1);
		poly2.next=new PolyNode(4,0);
		System.out.print("Poly 1:");
		pa.printPolynomial(poly1);
		System.out.print("Poly 2:");
		pa.printPolynomial(poly2);
		PolyNode result=pa.addPolynomial(poly1,poly2);
		System.out.print("Result:");
		pa.printPolynomial(result);
	}
}

Output:
Poly 1:6x^2+3x^3+3x^0
Poly 2:4x^1+4x^0
Result:6x^2+3x^3+4x^1+7x^0

		

