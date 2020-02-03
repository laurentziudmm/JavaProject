package objectOrientedProgramming.OOP.graphicshape;

/**
 * Developer: Viorelt
 * <p>
 * Copyright (c) 2018 Teamnet International. All Rights Reserved.
 * <p>
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet International.
 **/

public class Point {
    private int xPos, yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        // check if the dynamic type of 'other' is Point
        // if 'other' is of any other type than 'Point', the two objects cannot be
        // equal if 'other' is of type Point (or one of its derived classes), then
        // downcast the object to Point type and then compare members for equality
        Point point = (Point) o;
        return xPos == point.xPos &&
                yPos == point.yPos;
    }


}
