import java.util.*;

public class Stack<E>{
	
	public ArrayList<E> arr= new ArrayList<E>();
	public E top () { 
		return arr.get(0);}
	public E pop() {
		E temp= arr.get(0);
		arr.remove(arr.get(0));
		return temp;
	}
	public void add(E c) {arr.add(0, c);}
	
	public boolean isEmpty(){
		if (arr.size()==0){
			return true;
		}
		return false;
	}
}