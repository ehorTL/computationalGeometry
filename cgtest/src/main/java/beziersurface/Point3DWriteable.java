package beziersurface;

import javafx.geometry.Point3D;

import java.io.*;

public class Point3DWriteable implements Serializable {

    private double x, y, z;

    public Point3DWriteable(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3DWriteable(Point3D p){
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
    }

    public void writeInFile(FileOutputStream fos) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
    }

    public static Point3DWriteable readFromFile(FileInputStream fin) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(fin);
        return (Point3DWriteable) ois.readObject();
    }

    @Override
    public String toString() {
        return "( " + x + "; " + y + "; " + z + " )";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
