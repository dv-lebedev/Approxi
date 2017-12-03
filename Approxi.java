/*
MIT License
Copyright (c) 2017 Denis Lebedev
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package org.dvlebedev;

import java.awt.geom.Point2D;

interface Method {
    double calc(double value);
}

public final class Approxi {
    
    private Approxi(){
    }

    public static Point2D GetApproximated(Point2D left, Point2D right, double x) {
        return GetApproximated(left, right, x, i -> i);
    }

    public static Point2D GetApproximatedLog(Point2D left, Point2D right, double x) {
        return GetApproximated(left, right, x, Math::log10);
    }

    private static Point2D GetApproximated(Point2D left, Point2D right, double x, Method m) {
        double value = left.getY() +
                ((m.calc(x) - m.calc(left.getX())) / (m.calc(right.getX()) - m.calc(left.getX()))) *
                        ((right.getY() - left.getY()) / 1.0);

        return new Point2D.Double(x, value);
    }
}
