package FundamentalsExercise4;

import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split("\\s+");

            if (command[0].equals("exchange")) {
                array = getNewArray(array, command[1]);
            } else if (command[0].equals("max")) {
                if (command[1].equals("even")) {
                    getMaxEven(array);
                } else {
                    getMaxOdd(array);
                }
            } else if (command[0].equals("min")) {
                if (command[1].equals("even")) {
                    getMinEven(array);
                } else {
                    getMinOdd(array);
                }
            } else if (command[0].equals("first")) {
                if (command[2].equals("even")) {
                    getFirstEven(array, command[1]);
                } else {
                    getFirstOdd(array, command[1]);
                }
            } else if (command[0].equals("last")) {
                if (command[2].equals("even")) {
                    getLastEven(array, command[1]);
                } else {
                    getLastOdd(array, command[1]);
                }
            }


            input = scanner.nextLine();
        }
        System.out.print("[");
        for (int i = 0; i <= array.length - 1; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println("]");


    }

    private static void getLastOdd(String[] array, String command) {
        int count = Integer.parseInt(command);
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            int countOdd = 0;
            for (int i = 0; i <= array.length - 1; i++) {
                if (Integer.parseInt(array[i]) % 2 != 0) {
                    countOdd++;
                }
            }
            int[] newArray = new int[Math.min(count, countOdd)];
            if (array.length > 0) {
                int index = 0;
                for (int i = array.length - 1; i >= 0; i--) {
                    if (Integer.parseInt(array[i]) % 2 != 0) {
                        newArray[index] = Integer.parseInt(array[i]);
                        index++;
                        if (index > newArray.length - 1) {
                            break;
                        }
                    }
                }
                int[] reversedArray = new int[newArray.length];
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    reversedArray[i] = newArray[newArray.length - (i + 1)];
                }
                System.out.print("[");
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    if (i == reversedArray.length - 1) {
                        System.out.print(reversedArray[i]);
                    } else {
                        System.out.print(reversedArray[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }

    private static void getLastEven(String[] array, String command) {
        int count = Integer.parseInt(command);
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            int countEven = 0;
            for (int i = 0; i <= array.length - 1; i++) {
                if (Integer.parseInt(array[i]) % 2 == 0) {
                    countEven++;
                }
            }
            int[] newArray = new int[Math.min(count, countEven)];
            if (array.length > 0) {
                int index = 0;
                for (int i = array.length - 1; i >= 0; i--) {
                    if (Integer.parseInt(array[i]) % 2 == 0) {
                        newArray[index] = Integer.parseInt(array[i]);
                        index++;
                        if (index > newArray.length - 1) {
                            break;
                        }
                    }
                }
                int[] reversedArray = new int[newArray.length];
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    reversedArray[i] = newArray[newArray.length - (i + 1)];
                }
                System.out.print("[");
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    if (i == reversedArray.length - 1) {
                        System.out.print(reversedArray[i]);
                    } else {
                        System.out.print(reversedArray[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }

    private static void getFirstOdd(String[] array, String command) {
        int count = Integer.parseInt(command);
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            int countOdd = 0;
            for (int i = 0; i <= array.length - 1; i++) {
                if (Integer.parseInt(array[i]) % 2 != 0) {
                    countOdd++;
                }
            }
            int[] newArray = new int[Math.min(count, countOdd)];
            if (array.length > 0) {
                int index = 0;
                for (int i = 0; i <= array.length - 1; i++) {
                    if (Integer.parseInt(array[i]) % 2 != 0) {
                        newArray[index] = Integer.parseInt(array[i]);
                        index++;
                        if (index > newArray.length - 1) {
                            break;
                        }
                    }
                }
                System.out.print("[");
                for (int i = 0; i <= newArray.length - 1; i++) {
                    if (i == newArray.length - 1) {
                        System.out.print(newArray[i]);
                    } else {
                        System.out.print(newArray[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }

    private static void getFirstEven(String[] array, String command) {
        int count = Integer.parseInt(command);
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            int countEven = 0;
            for (int i = 0; i <= array.length - 1; i++) {
                if (Integer.parseInt(array[i]) % 2 == 0) {
                    countEven++;
                }
            }
            int[] newArray = new int[Math.min(count, countEven)];
            if (array.length > 0) {
                int index = 0;
                for (int i = 0; i < array.length; i++) {
                    if (Integer.parseInt(array[i]) % 2 == 0) {
                        newArray[index] = Integer.parseInt(array[i]);
                        index++;
                        if (index > newArray.length - 1) {
                            break;
                        }
                    }
                }
                System.out.print("[");
                for (int i = 0; i < newArray.length; i++) {
                    if (i == newArray.length - 1) {
                        System.out.print(newArray[i]);
                    } else {
                        System.out.print(newArray[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }

    private static void getMinOdd(String[] array) {
        int minOdd = Integer.MAX_VALUE;
        int indexOfMaxElement = -1;
        for (int i = 0; i <= array.length - 1; i++) {
            if (Integer.parseInt(array[i]) % 2 != 0) {
                if (Integer.parseInt(array[i]) <= minOdd) {
                    minOdd = Integer.parseInt(array[i]);
                    indexOfMaxElement = i;
                }
            }

        }
        if (indexOfMaxElement > -1) {
            System.out.println(indexOfMaxElement);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getMinEven(String[] array) {
        int minEven = Integer.MAX_VALUE;
        int indexOfMaxElement = -1;
        for (int i = 0; i <= array.length - 1; i++) {
            if (Integer.parseInt(array[i]) % 2 == 0) {
                if (Integer.parseInt(array[i]) <= minEven) {
                    minEven = Integer.parseInt(array[i]);
                    indexOfMaxElement = i;
                }
            }

        }
        if (indexOfMaxElement > -1) {
            System.out.println(indexOfMaxElement);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getMaxOdd(String[] array) {
        int maxOdd = Integer.MIN_VALUE;
        int indexOfMaxElement = -1;
        for (int i = 0; i < array.length; i++) {
            if (Integer.parseInt(array[i]) % 2 != 0) {
                if (Integer.parseInt(array[i]) >= maxOdd) {
                    maxOdd = Integer.parseInt(array[i]);
                    indexOfMaxElement = i;
                }
            }

        }
        if (indexOfMaxElement > -1) {
            System.out.println(indexOfMaxElement);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getMaxEven(String[] array) {
        int maxEven = Integer.MIN_VALUE;
        int indexOfMaxElement = -1;
        for (int i = 0; i <= array.length - 1; i++) {
            if (Integer.parseInt(array[i]) % 2 == 0) {
                if (Integer.parseInt(array[i]) >= maxEven) {
                    maxEven = Integer.parseInt(array[i]);
                    indexOfMaxElement = i;
                }
            }

        }
        if (indexOfMaxElement > -1) {
            System.out.println(indexOfMaxElement);
        } else {
            System.out.println("No matches");
        }
    }

    private static String[] getNewArray(String[] array, String command) {
        int index = Integer.parseInt(command);
        String[] newArray = new String[array.length];
        if (index < 0 || index >= array.length) {
            System.out.println("Invalid index");
            return array;
        } else {
            int x = 0;
            for (int i = index + 1; i < array.length; i++) {
                newArray[x] = array[i];
                x++;
            }
            for (int i = 0; i <= index; i++) {
                newArray[x] = array[i];
                x++;
            }
        }
        return newArray;
    }


}
