import java.io.*;

public class HW5 {
	public static int precLvl (char op){
		 int lvl;
		 switch(op){
		 	case '-':
			case '+':
				lvl=0;
				break;
			case '*':
			case '/':
				lvl=2;
				break;
			case '^':
				lvl=3;
				break;
			default:
				lvl= -1;
		 }
		 return lvl;
	}
	
	public static void main(String[] args) throws Exception{
		if (args[0]=="2"){
			//if (input=="2"){
			PrintWriter writer = new PrintWriter(args[2]);
			//PrintWriter writer = new PrintWriter("DoesItWork.txt");
			Stack<Character> st = new Stack<Character>();
			String str= args[1];
			//String str= "2-3*4+5/6";
			for (int i=0; i<str.length(); i++){
				char temp= str.charAt(i);
				
				if (Character.isLetterOrDigit(temp)){
					writer.write(temp);
				}
				
				else if (temp == '(')
					st.add(temp);
				
				else if(temp == ')'){ 
					while (!st.isEmpty() && st.top().equals(')')){
						writer.write(st.pop());
					}
					if(!st.isEmpty() && st.top().equals('('))
						st.pop();
				}
				else{
					while (!st.isEmpty() && precLvl(temp)<= precLvl(st.top())){
						writer.write(st.pop());
					}
					st.add(temp);
				}
			}
			while(!st.isEmpty()){
				writer.write(st.pop());
			}
			writer.close();
		}
		else if (args[0]=="3"){
			PrintWriter writer = new PrintWriter(args[2]);
			Stack<Double> st = new Stack<Double>();
			String str= args[1];
			try{
			for (int i=0; i<str.length(); i++){
				char temp = str.charAt(i);
				double a, b, c, num;
				
				if (Character.isLetterOrDigit(temp)){
					num=Character.getNumericValue(temp);
					st.add(num);
				}
				else if (temp=='-'){
					a= st.pop();
					b= st.pop();
					c= b-a;
					st.add(c);
				}
				else if (temp=='+'){
					a= st.pop();
					b= st.pop();
					c= a+b;
					st.add(c);
				}
				else if (temp=='*'){
					a= st.pop();
					b= st.pop();
					c= a*b;
					st.add(c);
				}
				else if (temp=='/'){
					a= (Double)st.pop();
					b= (Double)st.pop();
					c= b/a;
					st.add(c);
				}
				else if (temp=='^'){
					a= (Double)st.pop();
					b=(Double)st.pop();
					c= Math.pow(b, a);
					st.add(c);
				}
			}
			writer.write(String.valueOf(st.pop()));
			}catch (Exception e){
				writer.write("nv");
			}
			writer.close();
		}
		
	}
}
