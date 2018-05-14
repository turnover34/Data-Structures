package com.dvoinenko.datastructures.tasks.manymethod;

public class ManyMethod {

    public void print(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public void print(String[][] twoDimensionStringArray) {
        for (int i = 0; i < twoDimensionStringArray.length; i++) {
            for (int j = 0; j < twoDimensionStringArray[i].length; j++) {
                System.out.print(twoDimensionStringArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char[][] convert(int[][] intArray) {
        char[][] convertedCharArray = new char[intArray.length][];
        for (int i = 0; i < intArray.length; i++) {
            convertedCharArray[i] = new char[intArray[i].length];
            for (int j = 0; j <intArray[i].length ; j++) {
                convertedCharArray[i][j] = (char) intArray[i][j];
            }
        }
        return convertedCharArray;
    }

    public int[][] changeSign(int[][] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j <intArray[i].length ; j++) {
                intArray[i][j] = -intArray[i][j];
            }
        }
        return intArray;
    }

    public int maxOfTwo(int first, int second) {
        return (first < second)? second : first;
    }

    public int maxOfThree(int first, int second, int third) {
        return (maxOfTwo(first, second) < third)? third : maxOfTwo(first, second);
    }

    public int maxOfFive(int first, int second, int third, int forth, int fifth) {
        return (maxOfTwo(first, second) < maxOfThree(third, forth, fifth))? maxOfThree(third, forth, fifth) : maxOfTwo(first, second);
    }

    public String toString(char[] chars) {
        String resultString;
        return resultString = String.valueOf(chars);
    }

    public boolean subArrayCheck(char[] mainArray, char[] subArray) {
/*        int mainLength = mainArray.length;
        int subLength = subArray.length;
        String mainArrayString = String.valueOf(mainArray);
        String subArrayString = String.valueOf(subArray);
        for (int i = 0; i < mainLength - subLength; i++) {
            String curSubArray = mainArrayString.substring(i, subLength + i);
            if (curSubArray.equals(subArrayString)) {
                return true;
            }
        }
        return false;*/
        int mainLength = mainArray.length;
        int subLength = subArray.length;
        int i = 0;
        while (i < mainLength) {
            if (mainArray[i] == subArray[0]) {
                int j = 0;
                while (j < subLength) {
                    if (mainArray[i++] != subArray[j]) {
                        return false;
                    }
                    j++;
                }

            }
            i++;
        }
        return true;
    }

    public int searchFromBeginning(int[] incomeIntArray, int toSearch) {
        for (int i = 0; i < incomeIntArray.length; i++) {
            if (incomeIntArray[i] == toSearch) {
                return i;
            }
        }
        return -1;
    }

    public int searchFromEnding(int[] incomeIntArray, int toSearch) {
        for (int i = incomeIntArray.length - 1; i >= 0 ; i--) {
            if (incomeIntArray[i] == toSearch) {
                return i;
            }
        }
        return -1;
    }

    public int factorial(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * factorial(i - 1);
        }
    }

    public boolean isLeapYear( int Year) {
        return Year % 100 != 0 && (Year % 400 == 0 || Year % 4 == 0);
    }

    public void multiplicityCheck (int[] intArray, int toCheck) {
        for (int i : intArray) {
            if (i % toCheck == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public double round(double toRound) {
        toRound = toRound * 1000;
        int current = (int) Math.round(toRound);
        double result = (double) (current/1000);
        return result;
    }

    public int[] ascOrDescSort(int[] array, boolean order) {
        if (order) {
            descSort(array);
            return array;
        }
        acsSort(array);
        return array;
    }

    public int[] acsSort(int[] array) {
        for (int gap = array.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp ; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return array;
    }

    public int[] descSort(int[] array) {
        for (int gap = array.length/2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] < temp ; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return array;
    }

    public boolean check(byte[] array) {
        for (int i = 0; i < array.length; i++) {
            byte current = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (current == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] create(int[] first, int[] second) {
        int size = first.length;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
                array[i] = first[i] * second[i];
        }
        return array;
    }

    public int[] reverse(int[] incomeIntArray){
        int len = incomeIntArray.length;
        int[] reverseArray = new int[len];
        for (int i : incomeIntArray) {
            reverseArray[len - 1] = i;
            len--;
        }
        return reverseArray;
    }

    public int[] createRandomArray(int arrayLength, int maxInt) {
        return createRandomArray(arrayLength, 0, maxInt);
    }

    public int[] createRandomArray(int arrayLength, int minInt, int maxInt) {
        int[] randomIntArray = new int[arrayLength];
        int coef = maxInt - minInt + 1;
        for (int i = 0; i < arrayLength; i++) {
            randomIntArray[0] = (int) (Math.random()*coef + minInt);
        }
        return randomIntArray;
    }

    public boolean symbolsValidation(String incomeString) {
        char [] stringToCharArray = incomeString.toCharArray();
        int atCounter = 0;
        int pointCounter = 0;
        for (char c : stringToCharArray) {
            if (c == '@') {
                atCounter++;
            } else if (c == '.') {
                pointCounter++;
            }
        }
        if (atCounter == 1 && pointCounter >= 1) {
            return true;
        }
        return false;
    }

    public String reverse(String toReverse) {
        StringBuilder toReverseBuilder = new StringBuilder();
        toReverseBuilder.append(toReverse);
        toReverseBuilder = toReverseBuilder.reverse();
        String reversedString = toReverseBuilder.toString();
        return reversedString;
    }

    public int[] merge(int[] first, int[] second) {
        int[] resultArray = new int[first.length + second.length];
        System.arraycopy(first, 0, resultArray, 0, first.length);
        System.arraycopy(second, 0, resultArray, first.length, second.length);
        return resultArray;
    }

    public int maxElement(int[] intArray) {
        int max = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            }
        }
        return max;
    }
}
