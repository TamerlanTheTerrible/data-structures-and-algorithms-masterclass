package exercises;

/**
 * Created by Temurbek Ismoilov on 17/01/23.
 */

public class RecursionExercises {
    public RecursionExercises() {
    }

    public static int sumOfDigits(int number) {
        if (number < 0) {
            return -1;
        } else {
            return number == 0 ? 0 : sumOfDigits(number / 10) + number % 10;
        }
    }

    public static long powerOfNumber(int number, int power) {
        if (number < 0) {
            return -1L;
        } else {
            return power == 0 ? 1L : (long)number * powerOfNumber(number, power - 1);
        }
    }

    public static int greatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber >= 0 && secondNumber >= 0) {
            return secondNumber == 0 ? firstNumber : greatestCommonDivisor(secondNumber, firstNumber % secondNumber);
        } else {
            return -1;
        }
    }

    public static int decimalToBinary(int decimal) {
        if (decimal < 0) {
            return -1;
        } else {
            int quotient = decimal / 2;
            int remainder = decimal % 2;
            return quotient == 0 ? remainder : decimalToBinary(quotient) * 10 + remainder;
        }
    }

    public static int productofArray(int[] A, int N) {
        if (N < 0) {
            return -1;
        } else if (N == 0) {
            return A[0];
        } else {
            --N;
            return A[N] * productofArray(A, N);
        }
    }

    public static int factorial(int num) {
        System.out.println(num);
        return num == 0 ? 1 : num * factorial(num - 1);
    }

    public static int recursiveRange(int num) {
        return num == 0 ? num : num + recursiveRange(num - 1);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n == 1 ? 1 : fib(n - 1) + fib(n - 2);
        }
    }

    public static String reverse(String str) {
        if (str.length() == 0) {
            return "";
        } else {
            String res = str.substring(str.length() - 1);
            return res + reverse(str.substring(0, str.length() - 1));
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() != 0 && s.length() != 1) {
            boolean result = s.substring(0, 1).equals(s.substring(s.length() - 1));
            return result && isPalindrome(s.substring(1, s.length() - 1));
        } else {
            return true;
        }
    }

    static char first(String str) {
        return Character.isUpperCase(str.charAt(0)) ? str.charAt(0) : first(str.substring(1));
    }

    public static String capitalizeWord(String str) {
        if (str.length() == 0) {
            return "";
        } else {
            char var10000;
            if (Character.isSpaceChar(str.charAt(0))) {
                var10000 = Character.toUpperCase(str.charAt(1));
                return " " + var10000 + capitalizeWord(str.substring(2));
            } else {
                var10000 = str.charAt(0);
                return "" + var10000 + capitalizeWord(str.substring(1));
            }
        }
    }

    public static String maxProduct(int[] intArray) {
        int max = Integer.MIN_VALUE;
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;

        for(int i = 0; i < intArray.length - 1; ++i) {
            for(int j = i + 1; j < intArray.length; ++j) {
                if (intArray[i] * intArray[j] > max) {
                    max = intArray[i] * intArray[j];
                    num1 = intArray[i];
                    num2 = intArray[j];
                }
            }
        }

        return num1 + "," + num2;
    }

    public static boolean isUnique(int[] intArray) {
        for(int i = 0; i < intArray.length - 1; ++i) {
            for(int j = i + 1; j < intArray.length; ++j) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean permutation(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        } else {
            int sum1 = 0;
            int sum2 = 0;
            int product1 = 1;
            int product2 = 1;

            for(int i = 0; i < array1.length; ++i) {
                sum1 += array1[i];
                product1 *= array1[i];
                sum2 += array2[i];
                product2 *= array2[i];
            }

            return sum1 == sum2 && product1 == product2;
        }
    }

    public static boolean rotateMatrix(int[][] matrix) {
        int[][] rotated = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = matrix.length - 1; j > -1; --j) {
                rotated[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }

        return true;
    }

    static int[] middle(int[] arr) {
        int[] middle = new int[arr.length - 2];

        for(int i = 0; i < middle.length; ++i) {
            middle[i] = arr[i + 1];
        }

        return middle;
    }

    static void drawMatrix(int[][] array) {
        int[][] var1 = array;
        int var2 = array.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            int[] ints = var1[var3];

            for(int j = 0; j < array.length; ++j) {
                String blank = ints[j] > 9 ? " " : "  ";
                System.out.print(ints[j] + blank);
            }

            System.out.println();
        }

    }

    static int sumDiagonal(int[][] a) {
        int sum = 0;

        for(int i = 0; i < a.length; ++i) {
            sum += a[i][i];
        }

        return sum;
    }

    static String firstSecond(Integer[] myArray) {
        String result = "";
        Integer max = Integer.MIN_VALUE;
        Integer max2 = Integer.MIN_VALUE;

        for(int i = 0; i < myArray.length - 1; ++i) {
            if (myArray[i] > max) {
                max2 = max;
                max = myArray[i];
            }
        }

        result = max + " " + max2;
        return result;
    }

    public static void main(String[] args) {
        int[][] var10000 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        var10000 = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Integer[] myArray = new Integer[]{84, 85, 86, 87, 85, 90, 85, 83, 23, 45, 84, 1, 2, 0};
        System.out.println(firstSecond(myArray));
    }
}
