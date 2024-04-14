package dev.bykowskiolaf.Lab4.Zad4;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Watek extends Thread {
    public double min = 0, max = 0;
    public int start = 0, end = 0;
    public double[] rand_array;

    public Watek(int start, int end, double[] rand_array) {
        this.start = start;
        this.end = end;
        this.rand_array = rand_array;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (rand_array[i] > max) {
                max = rand_array[i];
            }
            if (rand_array[i] < min) {
                min = rand_array[i];
            }
        }
    }
}
