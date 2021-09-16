import java.util.*;
public class p61 {

	public static void main(String[] args) {
		Vector<Integer> Inputs = new Vector<Integer>();
		Vector<Integer> outputs = new Vector<Integer>();

		Inputs.add(9);
		outputs.add(45228);


		Test(Inputs,outputs);
		System.out.println("The answer is:" + p32(9,9999,999));

	}

	public static long p32(int BOUND,int multi_a_bound,int multi_b_bound)
	{
		TreeSet<Long> ts = new TreeSet<Long>();
		long sum = 0;
		boolean pandigital[] = new boolean[9];
		for (int y = 0; y < pandigital.length; y++) {
			pandigital[y] = false;
		}

		for (long multiplier_a = 2; multiplier_a < multi_a_bound; multiplier_a++) {
			for (long multiplier_b = 1; multiplier_b < multi_b_bound; multiplier_b++) {
				boolean db = false;
				long res = multiplier_a*multiplier_b;
				db = Check_Single_section(multiplier_a,pandigital,db);
				db = Check_Single_section(multiplier_b,pandigital,db);
				db = Check_Single_section(res,pandigital,db);
				if(all_array_unanimous(pandigital,BOUND) && !ts.contains(res) && !db ) {
					sum += res;
					ts.add(res);
				}
			}
		}
		return sum;
	}

	public static boolean Check_Single_section(long temp_multiplier,boolean pandigital[],boolean db)
	{
		while((double)temp_multiplier / 10 >= 1)
		{
			long num = (int)temp_multiplier % 10;
			temp_multiplier /= 10;
			if(num-1 < 1) {
				db = true;
				continue;
			}
			if(!pandigital[(int) (num-1)])
				pandigital[(int) (num-1)] = true;
			else
				db = true;
		}
		if(temp_multiplier-1 >= 0)
		{
			if(!pandigital[(int) (temp_multiplier-1)])
				pandigital[(int) (temp_multiplier-1)] = true;
			else
				db = true;
		}
		return db;
	}

	public static boolean all_array_unanimous(boolean array[],int BOUND)
	{
		boolean return_value = true;
		for (int c = 0; c < BOUND ; c++) {
			if(array[c] == true)
				continue;
			return_value = false;
		}
		
		for (int i = 0; i < array.length; i++) {
			array[i] = false;
		}
		
		return return_value;

	}
	public static void Test(Vector<Integer> Inputs,Vector<Integer> Excpected_Outputs)
	{
		int i = 1;
		for (Integer num : Inputs) {
			System.out.print("Test number " + i +":");
			if(p32(num,9999,999) == Excpected_Outputs.elementAt(i-1))
				System.out.println("Passed");
			else
				System.out.println("Failed");
			i++;
		}
	}

}
