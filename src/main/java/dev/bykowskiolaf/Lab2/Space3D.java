package dev.bykowskiolaf.Lab2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Space3D extends Space2D {

    private Double z;

    public Space3D(Double x, Double y, Double z) {
        super(x, y);
        this.z = z;
    }

    public void print() {
        System.out.println(STR."x: \{getX()}, y: \{getY()}, z: \{z}");
    }

    public Double distance(Space3D other) {
        return Math.sqrt(
                Math.pow(getX() - other.getX(), 2) + Math.pow(getY() - other.getY(), 2) + Math.pow(z - other.z, 2)
        );
    }

    @Override
    public Double distanceFromOrigin() {
        // calculate distance from origin using Pythagorean theorem
        return Math.sqrt(
                Math.pow(getX(), 2) + Math.pow(getY(), 2) + Math.pow(z, 2)
        );
    }

    public Double triangleCircumference(Space3D other1, Space3D other2) {
        // calculate distances between points
        Double a = distance(other1);
        Double b = distance(other2);
        Double c = other1.distance(other2);

        // return sum of distances
        return a + b + c;
    }

    public Double triangleArea(Space3D other1, Space3D other2) {
        // calculate distances between points
        Double a = distance(other1);
        Double b = distance(other2);
        Double c = other1.distance(other2);

        //half of the perimeter
        Double p = (a + b + c) / 2;

        // calculate area using Heron's formula
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
