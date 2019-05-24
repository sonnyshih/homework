package com.train;

import java.util.Scanner;

public class TicketVendingMachine {
    private String from = "";
    private String to = "";
    private int totalTicket;
    private int totalRoundTripTicket;

    public void start(){

        boolean isContinue = true;

        while (isContinue) {
            inputFrom();
            inputTo();
            inputTotalTicket();
            inputTotalRoundTripTicket();
            printSummary();

            isContinue = isContinueToOrderTicket();
        }
    }

    public void inputFrom(){
        boolean isValidate = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("Please input from place: ");
            this.from = scanner.next();

            if (this.from != null && !this.from.isEmpty()) {
                isValidate = true;
            }
        }
    }

    public void inputTo(){
        boolean isValidate = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("Please input to place: ");
            this.to = scanner.next();

            if (this.to != null && !this.to.isEmpty()) {
                isValidate = true;
            }
        }

    }

    public void inputTotalTicket() {
        boolean isValidate = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("Please enter number of tickets: ");
            totalTicket = scanner.nextInt();

            if (totalTicket > 0) {
                isValidate = true;
            } else {
                System.out.println("The number of total ticket must be more than 0 ...");
            }
        }

    }

    public void inputTotalRoundTripTicket() {
        boolean isValidate = false;
        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("How many round-trip tickets: ");
            totalRoundTripTicket = scanner.nextInt();

            if (totalRoundTripTicket > 0 ) {

                if (totalRoundTripTicket > totalTicket) {
                    System.out.println("The number of round-trip ticket can't be more than total ticket...");
                } else {
                    isValidate = true;
                }

            } else {
                System.out.println("The number of round-trip tickets must be more than 0...");
            }
        }

    }

    public boolean isContinueToOrderTicket() {
        boolean isValidate = false;

        boolean isContinue = true;

        Scanner scanner = new Scanner(System.in);

        while (!isValidate) {
            System.out.print("Do you want to continue to order the ticket? (Y or N): ");
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

    public double getTotalPrice(){
        double summary = 0;
        int normalTicket = totalTicket - totalRoundTripTicket;

        summary = normalTicket * 1000 + totalRoundTripTicket * 2000 * 0.9;

        return summary;
    }

    public void printSummary(){
        System.out.println("\n/* ##### Summary (Java) ##### */");
        System.out.println("From: " + from + "\n" +
                           "To: " + to);

        System.out.println("Total tickets: " + totalTicket);
        System.out.println("Round-trip: " + totalRoundTripTicket);
        System.out.println("Total: " + getTotalPrice());
    }
}
