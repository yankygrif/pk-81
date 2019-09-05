public class Main {

    public static void main(String[] args) {

        int k = 8, m = 10;
        double sum = 0.0;
        float f = 0.0F;
        boolean hasInfinity = false;

        for (int i = -3; i < k; i++) {
            for (int j = 0; j < m; j++) {
                int zn = i * 5;
                if (zn == 0) {
                    hasInfinity = true;
                    System.out.println("continue");
                    continue;
                }
                sum += (double) (i + j) / zn;
                f += (double) (i + j) / zn;
            }
        }

        if (hasInfinity == false) {
            System.out.println(sum);
            System.out.println(f);
        } else {
            System.out.println("Infinity");
        }

    }


}
