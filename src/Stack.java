import java.util.ArrayList;
public class Stack <E>{
    private ArrayList<E> stack = new ArrayList<>();

    public void push(E e){
        stack.add(e);
    }
    public E pop(){
        if (stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.size()-1);
    }
    public E peek(){
        if (stack.isEmpty()){
            return null;
        }
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }


}