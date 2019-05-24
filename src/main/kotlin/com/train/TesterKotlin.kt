package com.train

import java.util.*

fun main(args: Array<String>) {
    val machine = TicketVendingMachine_KT()
    machine.start()
}

class TicketVendingMachine_KT{
    var from: String = ""
    var to: String = ""
    var totalTicket: Int = 0
    var totalRoundTripTicket: Int = 0

    fun start(){
        var isContinue = true
        while (isContinue) {
            inputFrom()
            inputTo()
            inputTotalTicket()
            inputTotalRoundTripTicket()
            printSummary()
            isContinue = isContinueToOrderTicket()
        }
    }

    fun inputFrom() {
        var isValidate:Boolean = false;
        var scanner = Scanner(System.`in`);

        while (!isValidate) {
            print("Please input from place: ")
            from = scanner.next()

            if (!from.isEmpty()) {
                isValidate = true
            }
        }
    }

    fun inputTo() {
        var isValidate:Boolean = false;
        var scanner = Scanner(System.`in`);

        while (!isValidate) {
            print("Please input to place: ")
            to = scanner.next()

            if (!to.isEmpty()) {
                isValidate = true
            }
        }

    }

    fun inputTotalTicket() {
        var isValidate:Boolean = false;
        var scanner = Scanner(System.`in`);

        while (!isValidate) {
            print("Please enter number of tickets: ")
            totalTicket = scanner.nextInt()

            if (totalTicket > 0) {
                isValidate = true
            } else {
                println("The number of total ticket must be more than 0 ...")
            }
        }
    }

    fun inputTotalRoundTripTicket() {
        var isValidate:Boolean = false;
        var scanner = Scanner(System.`in`);

        while (!isValidate) {
            print("How many round-trip tickets: ")
            totalRoundTripTicket = scanner.nextInt()

            if (totalRoundTripTicket > 0) {

                if (totalRoundTripTicket > totalTicket) {
                    println("The number of round-trip ticket can't be more than total ticket...")
                } else {
                    isValidate = true
                }

            } else {
                println("The number of round-trip tickets must be more than 0...")
            }
        }

    }

    fun isContinueToOrderTicket():Boolean {
        var isValidate: Boolean = false
        var isContinue:Boolean = true
        val scanner = Scanner(System.`in`)

        while (!isValidate) {
            print("Do you want to continue to order the ticket? (Y or N): ")
            var answer = scanner.next()
            if (!answer.toUpperCase().equals("Y") && !answer.toUpperCase().equals("N")) {
                println("Please enter Y or N.")
            } else {
                if (answer.toUpperCase().equals("N")) {
                    isContinue = false
                }
                isValidate=true
            }

        }

        return isContinue
    }

    fun getTotalPrice(): Double {
        var summary:Double = 0.0
        var normalTicket:Int = totalTicket - totalRoundTripTicket

        summary = normalTicket * 1000 + totalRoundTripTicket * 2000 * 0.9

        return summary
    }

    fun printSummary(){
        println("\n/* ##### Summary (Kotlin) ##### */")
        println("From: " + from + "\n" +
                "To: " + to)
        println("Total tickets: " + totalTicket)
        println("Round-trip: " + totalRoundTripTicket)
        println("Total: " + getTotalPrice())
    }
}