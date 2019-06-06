package com.box;

import java.util.Scanner;

public class BoxMachine {
    private float length = 0;
    private float width = 0;
    private float height = 0;

    public void start(){
        boolean isContinue = true;

        while (isContinue) {
            boolean isMatchBox3 = false;
            boolean isMatchBox5 = false;

            inputProductSpec();

            // Check box3
            Box3 box3 = new Box3();
            if (box3.isValidate(this.length, this.width, this.height)) {
                isMatchBox3 = true;
            }

            // Check box5
            Box5 box5 = new Box5();
            if (box5.isValidate(this.length, this.width, this.height)) {
                isMatchBox5 = true;
            }

            System.out.println("You can choose:");
            if (isMatchBox3) {
                System.out.println("Model: Box3, Price: " + box3.getBoxPrice());
            }

            if (isMatchBox5) {
                System.out.println("Model: Box5, Price: " + box5.getBoxPrice());
            }

            isContinue = isContinueToBuyBox();
        }

    }

    public boolean isContinueToBuyBox() {
        boolean isValidate = false;

        boolean isContinue = true;

        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("Do you want to continue to buy the box? (Y or N): ");
            String answer = scanner.next();

            if (!answer.toUpperCase().equals("Y") && !answer.toUpperCase().equals("N")) {
                System.out.println("Please enter Y or N.");

            } else {

                if (answer.toUpperCase().equals("N")) {
                    isContinue = false;
                }

                isValidate = true;
            }

        }

        return isContinue;
    }

    private void inputProductSpec() {
        this.length = inputLength();
        this.width = inputWidth();
        this.height = inputHeight();
    }

    private float inputLength() {
        float height = 0;
        boolean isValidate = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("Please enter object's length: ");
            height = scanner.nextInt();

            if (height > 0) {
                isValidate = true;
            } else {
                System.out.println("The number of length must be more than 0 ...");
            }
        }

        return height;
    }

    private float inputWidth() {
        float width = 0;
        boolean isValidate = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("Please enter object's width: ");
            width = scanner.nextInt();

            if (width > 0) {
                isValidate = true;
            } else {
                System.out.println("The number of width must be more than 0 ...");
            }
        }

        return width;
    }

    private float inputHeight() {
        float height = 0;
        boolean isValidate = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("Please enter object's height: ");
            height = scanner.nextInt();

            if (height > 0) {
                isValidate = true;
            } else {
                System.out.println("The number of height must be more than 0 ...");
            }
        }

        return height;
    }


}
