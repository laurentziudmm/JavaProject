package Day1;

public class SumAndAverage {

    public static void main(String[] args) {

        int sum=0, number=100;

        int i = 1;
        if (i <= number) {
            do {
                sum += i;
                i++;
            } while (i <= number);
        }
        System.out.println("Sum:"+sum);
        double avg = (double)sum / (double)number;
        System.out.println("Avg:"+ avg);
    }
}
