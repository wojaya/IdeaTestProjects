import java.util.Arrays;
import java.util.Scanner;

public class test {

    public static void main(String args[]) {


        Scanner inputN = new Scanner(System.in);
        Scanner inputCoin = new Scanner(System.in);

        System.out.print("输入银币个数：");

        int intInputN = inputN.nextInt();
        int[] CoinWeight = new int[intInputN];

        for (int i = 0; i < intInputN; i++) {
            System.out.print("请依次输入银币质量：");

            CoinWeight[i] = inputCoin.nextInt();
        }
        System.out.println(Arrays.toString(CoinWeight));

        int index = new test().findFalseCoin(CoinWeight, 0, intInputN - 1);
        System.out.println(index + 1);

    }

    public int findFalseCoin(int[] CoinWeight, int low, int high) {
        int sum1 = 0, sum2 = 0;
        int indexFalseCoin = -1;
        int len = high - low + 1;

        if (high - low == 2) {
            sum1 = CoinWeight[low];
            sum2 = CoinWeight[high - 1];
            if (sum1 == sum2) {
                indexFalseCoin = high;
                return indexFalseCoin;
            } else if (sum1 > sum2) {
                indexFalseCoin = high - 1;
                return indexFalseCoin;
            } else {
                indexFalseCoin = low;
                return indexFalseCoin;
            }
        }

        if (high - low == 1) {
            sum1 = CoinWeight[low];
            sum2 = CoinWeight[high];
            if (sum1 > sum2) {
                indexFalseCoin = high;
                return indexFalseCoin;
            } else if (sum1 < sum2) {
                indexFalseCoin = low;
                return indexFalseCoin;
            } else {
                return -1;
            }
        }

        if (high == low) {
            indexFalseCoin = low;
            return indexFalseCoin;
        }

        if ((len % 3) == 1) {

            int[] lowAndHigh = CalcTool(CoinWeight, low, high, 1);

            return findFalseCoin(CoinWeight, lowAndHigh[0], lowAndHigh[1]);

        } else if ((len % 3) == 2) {

            int[] lowAndHigh = CalcTool(CoinWeight, low, high, 2);

            return findFalseCoin(CoinWeight, lowAndHigh[0], lowAndHigh[1]);

        } else if ((len % 3) == 0) {

            int[] lowAndHigh = CalcTool(CoinWeight, low, high, 0);

            return findFalseCoin(CoinWeight, lowAndHigh[0], lowAndHigh[1]);

        } else {
        }

        return indexFalseCoin;
    }

    public int[] CalcTool(int[] CoinWeight, int low, int high, int mod) {
        int[] lowAndHigh = new int[2];
        int sum1 = 0, sum2 = 0;
        int len = high - low + 1;

        for (int i = low; i <= low + (len + mod) / 3 - 1; i++) {
            sum1 += CoinWeight[i];
        }
        for (int i = low + (len + mod) / 3; i <= low + 2 * (len + mod) / 3 - 1; i++) {
            sum2 += CoinWeight[i];
        }
        if (sum1 == sum2) {
            lowAndHigh = new int[]{low + 2 * (len + mod) / 3, high};
            return lowAndHigh;
        }

        if (sum1 > sum2) {
            lowAndHigh = new int[]{low + (len + mod) / 3, low + 2 * (len + mod) / 3 - 1};
            return lowAndHigh;
        }
        if (sum1 < sum2) {
            lowAndHigh = new int[]{low, low + (len + mod) / 3 - 1};
            return lowAndHigh;
        }

        return lowAndHigh;
    }


}