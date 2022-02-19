import java.util.Stack;

public class MinStackOptimal {

    static Stack<Integer> stk = new Stack<Integer>();
    static Integer minElement = 0;

    public static void main(String[] args) {
        pushEle(4);
        pushEle(9);
        pushEle(3);
        pushEle(2);
        pushEle(1);
        popEle();
        int mn  = getMin();
        System.out.println(mn);
/*
        pushEle(2);
        pushEle(1);*/
        int mn2= getMin();
        System.out.println(mn2);
    }

    public static void pushEle(int el) {
        if (stk.isEmpty() ) {
            stk.push(el);
            minElement = el;
        }else if(el<minElement){
            stk.push(2 * el - minElement);
            minElement = el;
        }else{
            stk.push(el);
        }

        //System.out.println(el);

    }


    public static int popEle() {
        if (stk.isEmpty()) {
            return -1;
        } else if (stk.peek() < minElement) {
            int poped = stk.pop();
            minElement = 2 * minElement - poped;
            return poped;
        } else {
            return stk.pop();
        }
    }

    public static int getMin() {
        if (stk.isEmpty()) {
            return -1;
        } else {
            return minElement;
        }
    }

}




