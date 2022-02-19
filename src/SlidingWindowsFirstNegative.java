import java.util.*;

public class SlidingWindowsFirstNegative {
    public static void main(String[] args) {
        List output = findFirstNegative(new int[]{2,-1,12,-7,-4,2,5,-23,-13,2,3,-8},3);
        //List output = findFirstNegative(new int[]{-2,-1,12,-7,-4,2,5,-23,-13,2,3,-8},3);
        System.out.println(Arrays.toString(output.toArray()));
    }

    public static List<Integer> findFirstNegative(int[]ar, int windowSize ){
        int i= 0;
        int j=0;
        List<Integer> list = new ArrayList();
        Queue<Integer> qu = new LinkedList();
        while(j<ar.length){
            if(ar[j]<0){
                qu.add(ar[j]);
            }
            if(j-i+1 < windowSize){
                j++;
            }else if(j-i+1== windowSize){
                if(qu.isEmpty()){
                    list.add(0);
                }else{
                    list.add(qu.peek());
                    if(ar[i] == qu.peek()){
                        qu.poll();
                    }
                    i++;
                    j++;
                }
            }
        }
        return list;
    }


    public static List<Integer> findFirstNeg(int[]ar,int w){
        int i=0;
        int j=0;
        Queue<Integer> qu = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        while(j<ar.length){
            if(ar[j]<0){
                qu.add(ar[j]);
            }
            if(j-i+1<w){
                j++;
            }else if(j-i+1==w) {
                if(qu.isEmpty()){
                    list.add(0);
                }else{
                    if(ar[i]==qu.peek()){
                        qu.poll();
                    }
                    j++;
                    i++;
                }
            }
        }
        return list;
    }
}
