package com.boxkt

import java.util.*


fun main() {
    val machine = BoxMachine()
    machine.start()
}

class BoxMachine {
    var length = 0f
    var width:Float = 0f
    var height: Float = 0f

    fun start (){
        var isContinue = true

        while (isContinue) {
            var isMatchBox3: Boolean = false
            var isMatchBox5: Boolean = false
            inputOjectSpec()

            val box3 = Box3()
            if(box3.isValidate(length, width, height)){
                isMatchBox3 = true
            }

            val box5 = Box5()
            if (box5.isValidate(length, width, height)) {
                isMatchBox5 = true
            }

            println("You can choose:");
            if (isMatchBox3) {
                println("Model: Box3, Price: ${box3.boxPrice}")
            }

            if (isMatchBox5) {
                println("Model: Box5, Price: ${box5.boxPrice}")
            }

            isContinue = isContinueToOrderTicket()
        }


    }

    fun inputOjectSpec(){
        length = inputLength()
        width = inputWidth()
        height = inputHeight()
    }

    fun inputLength():Float {
        var length: Float = 0f
        var isValidate:Boolean = false
        var scanner = Scanner(System.`in`);

        while (!isValidate) {
            print("Please enter object's length: ")
            length = scanner.nextInt().toFloat()

            if (length > 0) {
                isValidate = true
            } else {
                println("The number of length must be more than 0 ...")
            }
        }

        return length;
    }

    fun inputWidth():Float {
        var width: Float = 0f
        var isValidate:Boolean = false
        var scanner = Scanner(System.`in`)

        while (!isValidate) {
            print("Please enter object's width: ")
            width = scanner.nextInt().toFloat()

            if (width > 0) {
                isValidate = true
            } else {
                println("The number of length must be more than 0 ...")
            }
        }

        return width
    }

    fun inputHeight():Float {
        var height: Float = 0f
        var isValidate:Boolean = false
        var scanner = Scanner(System.`in`)

        while (!isValidate) {
            print("Please enter object's height: ")
            height = scanner.nextInt().toFloat()

            if (height > 0) {
                isValidate = true
            } else {
                println("The number of length must be more than 0 ...")
            }
        }

        return height
    }

    fun isContinueToOrderTicket():Boolean {
        var isValidate: Boolean = false
        var isContinue:Boolean = true
        val scanner = Scanner(System.`in`)

        while (!isValidate) {
            print("Do you want to continue to buy the box? (Y or N): ")
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
}

class Box3: BaseBox (60f, 23f, 14f, 13f)
class Box5: BaseBox (100f, 39.5f, 27.5f, 23f)

open class BaseBox(var boxPrice: Float, var boxLength: Float, var boxWidth: Float, var boxHeight: Float) {

    fun isValidate(length: Float, width: Float, height: Float):Boolean {
        var isMatchBoxLength: Boolean = false
        var isMatchBoxWidth: Boolean = false
        var isMatchBoxHeight: Boolean = false

        // Check length
        if (boxLength >= length) {
            isMatchBoxLength = true
        } else if (boxWidth >= length) {
            isMatchBoxWidth = true
        } else if (boxHeight >= length) {
            isMatchBoxHeight = true
        }

        // Check width
        if (isMatchBoxLength) {
            if (boxWidth >= width) {
                isMatchBoxWidth = true
            } else if (boxHeight >= width) {
                isMatchBoxHeight = true
            }

        } else if (isMatchBoxWidth) {
            if (boxLength >= width) {
                isMatchBoxWidth = true
            } else if (boxHeight >= width) {
                isMatchBoxHeight = true
            }

        } else if (isMatchBoxHeight) {
            if (boxLength >= width) {
                isMatchBoxLength = true
            } else if (boxWidth >= width) {
                isMatchBoxWidth = true
            }
        }

        //Check height
        if (isMatchBoxLength && isMatchBoxWidth) {
            if (boxHeight >= height) {
                isMatchBoxHeight = true
            }

        } else if (isMatchBoxWidth && isMatchBoxHeight) {
            if (boxLength >= height) {
                isMatchBoxLength = true
            }

        } else if (isMatchBoxLength && isMatchBoxHeight) {
            if (boxWidth >= height) {
                isMatchBoxWidth = true
            }
        }

        if (isMatchBoxLength && isMatchBoxWidth && isMatchBoxHeight) {
            return true
        }

        return false
    }


}