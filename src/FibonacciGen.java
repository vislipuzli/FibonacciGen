package MyArrayList;



import java.util.ArrayList;
import java.util.Scanner;

class MyInputClass {
    public static void main(String[] args) {
        System.out.print("Enter the quantity of Fibonacci numbers: ");
        Scanner input = new Scanner(System.in);
        int inputSize = input.nextInt();
        System.out.println("The number of cell in array: " + MyArrayBuild(inputSize));


    }

    private static int MyArrayBuild(int inputSize) {
        long[] myArray = new long[5];

        for(int pointer = 0; pointer < inputSize; pointer++) {
            myArray[pointer] = InputClass(myArray, pointer);

            if(pointer == myArray.length - 1) {
                int arraySize = myArray.length;
                arraySize *= 2;
                long[] myArrayTemp = new long[arraySize];
                System.arraycopy(myArray,0, myArrayTemp,0, arraySize / 2);
                myArray = new long[arraySize];
                System.arraycopy(myArrayTemp,0, myArray,0, arraySize);
            }
        }
        System.out.print("The quatity of cell in array now is: " + myArray.length + ". ");

        System.out.print("Enter number of Fibbonaci: ");
        Scanner input = new Scanner(System.in);
        int fibNumber = input.nextInt();

        System.out.print("The " + fibNumber + " number of Fibbonaci is " + FibNumberInArray(fibNumber, myArray) + "! ");
        System.out.print("Enter the number of Fibonacci is you want to delete: ");
        Scanner input1 = new Scanner(System.in);
        int pointToDelete = input1.nextInt();

        System.out.print("How many numbers you want to delete from " + pointToDelete + ": ");
        Scanner input2 = new Scanner(System.in);
        int numbersToDelete = input2.nextInt();

        int arraySize = myArray.length;
        System.out.println("Now the number of " + pointToDelete + " is " + DeleteOfArray(pointToDelete, myArray, arraySize, inputSize, numbersToDelete));

        System.out.println("The quantity of Febonacci numbers in array now is: " + (inputSize - numbersToDelete) );

        if(myArray.length - (inputSize - numbersToDelete) >= 10 ){
            long[] myArrayTemp = new long[(inputSize - numbersToDelete) + 5];
            System.arraycopy(myArray, 0, myArrayTemp, 0, inputSize - numbersToDelete);
            myArray = myArrayTemp;
        }
        return myArray.length;
    }

    //    F_{n}=F_{n-2}+F_{n-1}.
    public static long InputClass(long[] myArray, int pointer){
        long input = myArray[pointer];
        if(pointer > 1) {
            long a = myArray[pointer - 1];
            long b = myArray[pointer - 2];
            input = a + b;
            return input;
        }
        else {
            return pointer;
        }
    }

    public static long FibNumberInArray(int fbn, long[] myArray) {
        long fibOnArray = myArray[fbn];
        return fibOnArray;
    }

    public static long DeleteOfArray(int pointToDelete, long[] myArray, int arraySize, int inputSize, int numbersToDelete){
        long[] myArrayTemp = new long[arraySize];   //[0]0 [1]1 [2]1 [3]2 [4]3 [5]5 [6]8 [7]13 [8]21 [9]34
        System.arraycopy(myArray,0, myArrayTemp,0, pointToDelete);
        System.arraycopy(myArray,(pointToDelete + numbersToDelete), myArrayTemp, pointToDelete, (inputSize - numbersToDelete));

        myArray = myArrayTemp;

        return myArray[pointToDelete];
    }
}






