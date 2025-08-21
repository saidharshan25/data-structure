class PolyNode{
	int coefficient;
	int exponent;
	PolyNode(){}
	PolyNode(int c,int e){
		coefficient=c;
		exponent=e;
	}
}
public class PolynomialAddition{
	public PolyNode addPolynomial(PloyNode poly1,PolyNode poly2){
		PolyNode dummy=new PolyNode(0,0);
		while(poly1!=null&&poly2!=null){
			if(poly1.exponent>poly2.exponent){
				current.next=new PolyNode(poly1.coefficient,poly1.exponent);
				poly1=poly1.next;
			}
			else if(poly1.exponent<poly2.exponent){
				current.next=new PolyNode(poly2.coefficient,poly2.exponent);
				poly2=poly2.next;
			}else {
				int sum=poly1.coefficient+poly2.coefficient;
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
			current.next=new PolyNode(poly1.coefficient,poly1.exponent);
			poly1=poly1.next;
			current=current.next;
		}
		while(poly2!=null)
		{
			current.next=new PolyNode(poly2.coefficient,poly2.exponent);
			poly2=poly2.next;
			current=current.next;
		}
		return dummy.next;
	}
	public void printPolynomial(PolyNode head){
		while(head!=null){
			System.out.println("+");
			head=head.next;
		}
		System.out.println();
	}
	public static void main(String[] args){
		PolynomialAddition pa=new PolynomialAddition();
		PolyNode poly1=new PolyNode(5,3);
		poly1.next=new PolyNode(4,2);
		poly1.next.next=new PolyNode(2,0);
		PolyNode poly2=new PolyNode(5,1);
		poly2.next=new PolyNode(5,0);
		System.out.println("Poly 1:");
		pa.printPolynomial(poly1);
		System.out.println("Poly 2:");
		pa.printPolynomial(poly2);
		PolyNode result=pa.addPolynomial(poly1,poly2);
		System.out.println("Result:");
		pa.printPolynomial(result);
	}
}

		
