import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        PriorityQueue<Integer> min = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<Integer>();
        int a = in.nextInt();
        System.out.println(String.format("%.1f", (float) a));
        if (n == 1) return;
        int b = in.nextInt();


        min.add(Math.min(a, b));
        max.add(Math.max(a, b));
        System.out.println(String.format("%.1f", ((float) (max.peek() + min.peek())) / 2));

        for (int i = 2; i < n; i++) {
            int v = in.nextInt();
            if (v >= max.peek())
                max.add(v);
            else
                min.add(v);
            if (Math.abs(max.size() - min.size()) > 1) {
                if (min.size() > max.size()) {
                    max.add(min.poll());
                } else {
                    min.add(max.poll());
                }
            }

            if (max.size() == min.size())
                System.out.println(String.format("%.1f", ((float) (max.peek() + min.peek())) / 2));
            else if (max.size() > min.size())
                System.out.println(String.format("%.1f", (float) max.peek()));
            else
                System.out.println(String.format("%.1f", (float) min.peek()));
        }
    }
}
/*
This problem can be solved using two heaps.

Let's say we are taking input for the ith number. If somehow we had the previous (i-1) numbers sorted, then we can
easily add the ith number in O(n) time to the appropriate place in our list so that the list remains sorted and find the
median in O(1) time. But we cannot afford to add every number with O(n) complexity.

So let's say we had two sorted arrays. The first array holds the smaller half of the numbers in decreasing order. The
second array contains the larger half of the numbers in increasing order. Now, after taking input for the  number, we
can easily decide which half the ith number belongs to and add it there in the appropriate place. If any of the arrays
becomes much larger than the other array, we can remove the first element from that array and add it to the appropriate
place of the other array. We have reduced time complexity by some constant factor. But obviously, that is not enough.

Now let's look at the indices of the array where we need to access at any moment for getting the median. If the total
number of elements is odd, then we need the first element of the array with the higher number of elements. If the total
number of elements is even, then we need the average of the first elements of both the arrays. So the only indices we
need to access while getting the median and adding the elements are the first index of both of the arrays. So which
data structure can help in storing data in sorted order and accessing the top element efficiently? The answer is a heap.

We will use a max heap for storing data of the smaller half of the numbers and a min heap for storing data of the
larger half of the numbers. Now let's see how we will add the numbers and get the medians.

Adding the ith number:
While adding the ith number we will check the following conditions and add accordingly:

If the ith number is greater than or equal to the max element of the max heap then it surely belongs to the larger half
of the numbers i.e. the min heap. So we will add it there.

Otherwise, we will add it to the max heap.

Now it may happen that one of the heap becomes much larger than the other if we add the numbers in this way. So to stop
this situation from taking place, we need to check the size of the heaps after adding every number. If the difference
between the number of elements of the two heaps becomes more than one, then we need to pop the top element from the heap
with more elements and push that element to the other heap. If we work in this way, the difference can never be more
than one.

Getting the median:
To get the median after adding the ith number we will check if i is odd or even. If i is odd, then surely one of the
heap has one more element than the other. The median will be the top element of that heap then. If i is even, then the
two heaps must have the same number of elements. So the median will be the average of the top elements of the two heaps.
 */