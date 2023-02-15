package org.develop;

import java.util.InputMismatchException;
import java.util.Scanner;

    public class Input {

        static Scanner setInput = new Scanner(System.in);

        public static byte scanningForByte(String message) {
            byte inputByte = 0;
            boolean correct = false;
            do {
                System.out.println(message);
                try {
                    inputByte = setInput.nextByte();
                    correct = true;
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR. Input type mismatch\n");
                }
                setInput.nextLine();
            } while (!correct);
            return inputByte;
        }

        public static int scanningForInt(String message) {
            int inputInt = 0;
            boolean correct = false;
            do {
                System.out.println(message);
                try {
                    inputInt = setInput.nextInt();
                    correct = true;
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR. Input type mismatch\n");
                }
                setInput.nextLine();
            } while (!correct);
            return inputInt;
        }

        public static float scanningForFloat(String message) {
            float inputFloat = 0f;
            boolean correct = false;
            do {
                System.out.println(message);
                try {
                    inputFloat = setInput.nextFloat();
                    correct = true;
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR. Input type mismatch\n");
                }
                setInput.nextLine();
            } while (!correct);
            return inputFloat;
        }

        public static double scanningForDouble(String message) {
            double inputDouble = 0.0;
            boolean correct = false;
            do {
                System.out.println(message);
                try {
                    inputDouble = setInput.nextDouble();
                    correct = true;
                } catch (InputMismatchException ex) {
                    System.out.println("ERROR. Input type mismatch\n");
                }
                setInput.nextLine();
            } while (!correct);
            return inputDouble;
        }

        public static char scanningForChar(String message) {
            String input = "";
            boolean correct = false;
            do {
                System.out.println(message);
                try {
                    input = setInput.nextLine();
                    if (input.length() > 1) {
                        correct = false;
                        throw new Exception();
                    } else {
                        correct = true;
                    }
                } catch (Exception ex) {
                    System.out.println("ERROR. Input type requires length 1\n");
                }
            } while (!correct);
            char inputChar = input.charAt(0);
            return inputChar;
        }

        public static String scanningForString(String message) {
            String input = "";
            boolean correct = false;
            do {
                System.out.println(message);
                try {
                    input = setInput.nextLine();
                    if (input.length() < 2) {
                        throw new Exception();
                    } else {
                        correct = true;
                    }
                } catch (Exception ex) {
                    System.out.println("ERROR. Input type requires length > 1\n");
                }
            } while (!correct);
            return input;
        }

        public static boolean scanningForYesNo(String message) {
            String input;
            boolean yesOrNo = false;
            boolean correct = false;
            do {
                System.out.println(message);
                try {
                    input = setInput.next();
                    if (input.equalsIgnoreCase("y")) {
                        yesOrNo = true;
                        correct = true;
                    } else if (input.equalsIgnoreCase("n")) {
                        yesOrNo = false;
                        correct = true;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    System.out.println("ERROR. Input type requires length 1\n");
                }
            } while (!correct);
            return yesOrNo;
        }
    }