import hermite.HermiteSpline;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static final int VIEW_SCALE = 55;
    private static final ArrayList<Point2D> controlPoints = new ArrayList<Point2D>(Arrays.asList(new Point2D.Double[]{
            new Point2D.Double(1, 1), new Point2D.Double(2, 2), new Point2D.Double(4, 4),
            new Point2D.Double(5, 3), new Point2D.Double(6, 1), new Point2D.Double(7, 2),
            new Point2D.Double(8, 4), new Point2D.Double(9, 4), new Point2D.Double(10, 3)
    }));

    private static final ArrayList<Point2D> derivativesTestInput = new ArrayList<Point2D>(Arrays.asList(new Point2D.Double[]{
            new Point2D.Double(-1.07, 3), new Point2D.Double(6.4, -2.96), new Point2D.Double(4, 4),
            new Point2D.Double(5, 3), new Point2D.Double(6, 1), new Point2D.Double(7, 2),
            new Point2D.Double(8, 4), new Point2D.Double(9, 4), new Point2D.Double(10, 3)
    }));


    public static void main(String[] args) throws Exception {
//        HermiteSpline hermiteSpline = new HermiteSpline(controlPoints, null, false);

        HermiteSpline hermiteSpline = new HermiteSpline(controlPoints, derivativesTestInput, true);

        hermiteSpline.generatePoints();
        ArrayList<Point2D> curvePoints = hermiteSpline.getCurvePoints();

        scalePoints(VIEW_SCALE, curvePoints);
        scalePoints(VIEW_SCALE, controlPoints);

        Drawer drawer = new Drawer("Hermite Spline", curvePoints, controlPoints, true);
    }

    public static void scalePoints(int coef, ArrayList<Point2D> points){
        points.forEach(p -> {
            p.setLocation(p.getX() * coef, p.getY() * coef);
        });
    }
}
