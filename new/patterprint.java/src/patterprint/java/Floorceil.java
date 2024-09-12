package patterprint.java;

public class Floorceil {
	static int floor=-1;
	static int ceil=-1;
	public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 8, 10, 12, 14};
        int value = -1;

        findFloorAndCeil(array, value);
        System.out.println("Floor of " + value + " is: " +floor);
        System.out.println("Ceil of " + value + " is: " + ceil);
    }

    static void Result(int f,int c) {
            floor = f;
            ceil = c;
    }

    public static void findFloorAndCeil(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE; 
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == value) {
            	floor=ceil=array[mid];
            	break;
            } else if (array[mid] < value) {
                floor = array[mid];
                left = mid + 1;
            } else {
                ceil = array[mid];
                right = mid - 1;
            }
        }
    }

}
