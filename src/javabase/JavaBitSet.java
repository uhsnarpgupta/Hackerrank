package javabase;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args){
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        BitSet setA = new BitSet(N);
        BitSet setB = new BitSet(M);
        while(scanner.hasNext()){
            String operation = scanner.next();
            int inpSet1 = scanner.nextInt();
            int inpSet2 = scanner.nextInt();

            BitSet operandSet = new BitSet();
            operandSet = inpSet1 == 1 ? setA : setB;

            BitSet operatorSet = new BitSet();
            operatorSet = inpSet2 == 2 ? setB : setA;

            switch(operation){
                case "AND":
                    operandSet.and(operatorSet);
                    break;
                case "OR":
                    operandSet.or(operatorSet);
                    break;
                case "XOR":
                    operandSet.xor(operatorSet);
                    break;
                case "SET":
                    operandSet.set(inpSet2);
                    break;
                case "FLIP":
                    operandSet.flip(inpSet2);
                    break;
                default:
                    break;
            }
            System.out.println(setA.cardinality()+" "+setB.cardinality());
        }
        scanner.close();
    }
}
