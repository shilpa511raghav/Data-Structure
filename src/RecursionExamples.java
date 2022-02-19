public class RecursionExamples {

    public static void main(String[] args) {
        //printDecreasing(5);
        //printIncreasing(10);
        //printDecreasingIncreasing(5);
       /* int fact = factorial(5);
        System.out.println(fact);*/

        int po = powerOfn(3, 4);
        System.out.println(po);
    }

    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasing(n - 1);
    }

    static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n - 1);   // when a call goes stack got full everytime function invoked
        System.out.println(n);
    }

    static void printDecreasingIncreasing(int n) {

        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasingIncreasing(n - 1);
        System.out.println(n);
    }

    static int factorial(int n) {

        if (n == 1) {
            return 1;
        }

        int fnm1 = factorial(n - 1);
        int fn = n * fnm1;
        return fn;
    }


    //Slowest (time complexity more)calculate power of x ^n
    static int powerOfn(int x, int n) {

        if (n == 0) {
            return 1;
        }

        int xnm1 = powerOfn(x, n - 1);
        int xn = x * xnm1;
        return xn;
    }


    //Fastest(Time complexity less) calculate power of x^n using formula
    // For even numbers x^n = x^n/2 * x^n/2  i.e x^4 = x^4/2 * x^4/2  which means x^2* x^2 = x^4 proved
    // for odd number x^n = x^n/2 * x^n/2 *x; i.e x^3 = x^3/2 * x3/2 *x which means x^1 *x^1 *x  = x^3

    static int powerOfnFastWay(int x, int n) {

        if(n==0){
            return 1;
        }
        int xnb2 = powerOfnFastWay(x, n / 2);
        int xn;
        if (n % 2 == 0) {
            xn = xnb2 * xnb2;
        } else {
            xn = xnb2 * xnb2 * x;
        }
        return xn;
    }


}
