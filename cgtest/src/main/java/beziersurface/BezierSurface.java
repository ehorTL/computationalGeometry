package beziersurface;

import beziersurface.drawer.Point;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;


/**
 * 8 control points = (n + 1)*(m + 1) ---> {n = 1, m = 3}
 */
public class BezierSurface {
    public static final String pointsGeneratedFileName = "surfacePoints.dat";
    public final int n = 1;
    public final int m = 3;
    public static final double STEP = 0.005;

    public static Point3D[][] controlPoints = new Point3D[][]
    {
        {
            new Point3D(1, 5, 1), new Point3D(2, 3, 0), new Point3D(3, 2, 2), new Point3D(4, 4, 1)
        },
        {
            new Point3D(5, 1, 2), new Point3D(6, 2, 0), new Point3D(7, 3, 3), new Point3D(10, 2, 3)
        },
    };


    public BezierSurface() {
    }

    public ArrayList<Point3D> generateSurfacePoints() throws IOException {
        ArrayList<Point3D> returnArray = new ArrayList<>();

        double u = STEP;
        while (u < 1.0){
            double v = STEP;
            while (v < 1.0){
                returnArray.add(p(u, v));
                v += STEP;
            }
            u += STEP;
        }

        return returnArray;
    }

    /**
     * u, v lies within (0, 1);
     */
    private Point3D p(double u, double v) {
        Point3D pComputed = new Point3D(0, 0, 0);

        for (int i = 0; i < this.n + 1; i++) {
            for (int j = 0; j < this.m +1; j++) {
                pComputed = pComputed.add(controlPoints[i][j].multiply(bernsteinPolynomial(i, this.n, u) * bernsteinPolynomial(j, this.m, v)));
            }
        }

        return pComputed;
    }

    private double bernsteinPolynomial(int i, int n, double u) {
        return (factorial(n) * Math.pow(u, i) * Math.pow((1.0 - u), n - i)) / (factorial(i) * factorial(n - i));
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public Point3D[][] getControlPoints() {
        return controlPoints;
    }
}
