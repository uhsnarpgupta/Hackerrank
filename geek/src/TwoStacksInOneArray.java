package src;

public class TwoStacksInOneArray {
    private static int top1 = -1;
    private static int top2 = -1;
    private static int size;
    private static int[] arr;

    public TwoStacksInOneArray(int size) {
        arr = new int[size];
        this.size = size;
        top1 = 0;
        top2 = size - 1;
    }

    void push1(int a) {
        if (top2 - top1 >= 0) {
            arr[top1] = a;
            top1++;
        } else {
            new RuntimeException("Overflow Exception");
        }
    }

    void push2(int a) {
        if (top2 - top1 >= 0) {
            arr[top2] = a;
            top2--;
        } else {
            new RuntimeException("Overflow Exception");
        }
    }

    int pop1() {
        if (top1 != -1) {
            int temp = arr[top1];
            arr[top1] = 0;
            top1--;
            return temp;
        }
        return -1;
    }

    int pop2() {
        if (top2 != -1 && top2 < size) {
            int temp = arr[top2];
            arr[top2] = 0;
            top2++;
            return temp;
        }
        return -1;
    }

    void printStack() {
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}

class CheckDoubleSidedStack {
    public static void main(String[] args) {
        TwoStacksInOneArray tStack = new TwoStacksInOneArray(5);

        tStack.push1(3);
        tStack.push1(4);
        tStack.push1(5);

        tStack.push2(9);
        tStack.push2(8);
        System.out.println("After Pushing: ");
        tStack.printStack();


        tStack.pop2();

        System.out.println("After Popping: ");
        tStack.printStack();

        tStack.pop2();
        tStack.pop2();
        tStack.pop2();

    }
}