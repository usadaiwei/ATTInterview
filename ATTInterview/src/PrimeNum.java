import java.util.ArrayList;
import java.util.List;

public class PrimeNum {

    public static List<Integer> sumOfPrimes(int number){
        List<Integer> primes = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] check = new boolean[number / 2 + 100];
        for (int i = 1; i <= (Math.sqrt(number) - 1) / 2; i++)
            for (int j = (i * (i + 1)) << 1; j <= number / 2; j = j + 2 * i + 1)
                check[j] = true;
            primes.add(2);

        for (int i = 1; i <= number / 2; i++)
            if (check[i] == false)
                primes.add(2 * i + 1);

        if (number <= 2 || number % 2 != 0)
            return null;

        for (int i = 0 ; primes.get(i) <= number / 2; i++) {
            int diff = number - primes.get(i);
            if (primes.contains(diff)) {
                ans.add(primes.get(i));
                ans.add(diff);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(sumOfPrimes(9));
    }
}
