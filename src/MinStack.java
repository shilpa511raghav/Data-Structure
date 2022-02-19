import java.util.Stack;

public class MinStack {
    static Stack<Integer> stack = new Stack<Integer>();
    static Stack<Integer> supportingStack = new Stack<Integer>();

    public static void main(String[] args) {
        pushInStack(-2);
        pushInStack(3);
        pushInStack(-3);
        pushInStack(15);
        pushInStack(29);
        pushInStack(-2);

        int poppedEle= popFromStack();
        int minEle = getMinElementFromStack();
        System.out.println("poped 1st time ===  "+poppedEle);
        System.out.println("minelement1 === "+minEle);


        System.out.println("======================");

        int poppedEle2= popFromStack();
        int minEle2 = getMinElementFromStack();
        System.out.println("poped second time "+poppedEle2);
        System.out.println("min second time "+minEle2);


        System.out.println("======================/n");

        int poppedEle3= popFromStack();
        int minEle3 = getMinElementFromStack();
        System.out.println("poped third time "+poppedEle3);
        System.out.println("min third time "+minEle3);

        System.out.println("======================/n");

        int poppedEle4= popFromStack();
        int minEle4 = getMinElementFromStack();
        System.out.println("poped 4th time "+poppedEle4);
        System.out.println("min 4th time "+minEle4);


        System.out.println("======================/n");

        int poppedEle5= popFromStack();
        int minEle5 = getMinElementFromStack();
        System.out.println("poped 4th time "+poppedEle5);
        System.out.println("min 4th time "+minEle5);

    }

    static void pushInStack(int element) {
        stack.push(element);
        if(supportingStack.isEmpty() || element<= supportingStack.peek()){
            supportingStack.push(element);
            System.out.println(element);
        }


    }

    static int popFromStack(){
        if(stack.isEmpty() && supportingStack.isEmpty()){
            return -1;
        }
        int poped = stack.pop();
        if(poped == supportingStack.peek()){
            supportingStack.pop();
        }
        return poped;
    }

    static int getMinElementFromStack(){
        if(supportingStack.isEmpty()){
            return -1;
        }
        return supportingStack.peek();
    }
}
