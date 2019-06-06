package com.box;

import java.util.Scanner;

public abstract class BaseBox {
    protected float boxPrice;
    protected float boxLength;
    protected float boxWidth;
    protected float boxHeight;


    public boolean isValidate(float length, float width, float height) {

        boolean isMatchBoxLength = false;
        boolean isMatchBoxWidth = false;
        boolean isMatchBoxHeight = false;

        // Check length
        if (boxLength >= length) {
            isMatchBoxLength = true;
        } else if (boxWidth >= length) {
            isMatchBoxWidth = true;
        } else if (boxHeight >= length) {
            isMatchBoxHeight = true;
        }

        // Check width
        if (isMatchBoxLength) {
            if (boxWidth >= width) {
                isMatchBoxWidth = true;
            } else if (boxHeight >= width) {
                isMatchBoxHeight = true;
            }

        } else if (isMatchBoxWidth) {
            if (boxLength >= width) {
                isMatchBoxWidth = true;
            } else if (boxHeight >= width) {
                isMatchBoxHeight = true;
            }

        } else if (isMatchBoxHeight) {
            if (boxLength >= width) {
                isMatchBoxLength = true;
            } else if (boxWidth >= width) {
                isMatchBoxWidth = true;
            }
        }

        //Check height
        if (isMatchBoxLength && isMatchBoxWidth) {
            if (boxHeight >= height) {
                isMatchBoxHeight = true;
            }

        } else if (isMatchBoxWidth && isMatchBoxHeight) {
            if (boxLength >= height) {
                isMatchBoxLength = true;
            }

        } else if (isMatchBoxLength && isMatchBoxHeight) {
            if (boxWidth >= height) {
                isMatchBoxWidth = true;
            }
        }

        if (isMatchBoxLength && isMatchBoxWidth && isMatchBoxHeight) {
            return true;
        }


        return false;
    }

    public float getBoxPrice() {
        return boxPrice;
    }
}
