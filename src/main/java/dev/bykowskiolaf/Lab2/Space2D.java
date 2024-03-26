package dev.bykowskiolaf.Lab2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Space2D {

    @NonNull
    private Double x;

    @NonNull
    private Double y;

    public void print() {
        System.out.println("x: " + x + ", y: " + y);
    }

    public Double distance(Space2D other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    public Double distanceFromOrigin() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Double triangleCircumference(Space2D other1, Space2D other2) {
        Double a = distance(other1);
        Double b = distance(other2);
        Double c = other1.distance(other2);

        return a + b + c;
    }

    public Double triangleArea(Space2D other1, Space2D other2) {
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
