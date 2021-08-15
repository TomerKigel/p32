import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class p32 {
		public static void main(String[] args) {
			TreeSet<Long> ts = new TreeSet<Long>();
			long sum = 0;
			int digits = 9;
			boolean pandigital[] = new boolean[9];
			for (long i = 2; i < 99999; i++) {
				for (long j = 1; j < 999; j++) {
					boolean db = false;
					if(i == 39 && j == 186)
						System.out.println();
					for (int y = 0; y < pandigital.length; y++) {
						pandigital[y] = false;
					}
					long a = i,b = j;
					long res = i*j;
					while((double)a / 10 >= 1)
					{
						int num = (int)a % 10;
						a /= 10;
						if(num-1 < 1) {
							db = true;
							continue;
						}
						if(!pandigital[(int) (num-1)])
							pandigital[(int) (num-1)] = true;
						else
							db = true;
					}
					if(a-1 >= 0)
					{
						if(!pandigital[(int) (a-1)])
							pandigital[(int) (a-1)] = true;
						else
							db = true;
					}
					while((double)b / 10 >= 1)
					{
						int num = (int)b % 10;
						b /= 10;
						if(num-1 < 1) {
							db = true;
							continue;
						}
						if(!pandigital[(int) (num-1)])
							pandigital[(int) (num-1)] = true;
						else
							db = true;
					}
					if(b-1 >= 0) {
						if(!pandigital[(int) (b-1)])
							pandigital[(int) (b-1)] = true;
						else
							db = true;
					}
					long num = 0;
					long result = res;
					while((double)result / 10 >= 1)
					{
						num = (int)result % 10;
						result /= 10;
						if(num-1 < 1) {
							db = true;
							continue;
						}
						if(!pandigital[(int) (num-1)])
							pandigital[(int) (num-1)] = true;
						else
							db = true;
					}
					if(num-1 >= 0) {
						if(!pandigital[(int) (result-1)])
							pandigital[(int) (result-1)] = true;
						else
							db = true;
					}
					for (boolean c : pandigital) {
						if(c == true)
							continue;
						pandigital[0] = false;
					}
					if(pandigital[0] && !ts.contains(res) && db == false) {
						sum += res;
						ts.add(res);
						System.out.println(res + " " + i + " " + j);
					}
				}
			}
		 System.out.println(sum);
	}
}
