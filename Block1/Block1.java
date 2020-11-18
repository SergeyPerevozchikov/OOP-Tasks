
public class Block1
{
	public static void main(String[] args)
	{
		//первый аргумент - номер задачи в блоке от 1 до 10
		if(args[0].equals("1"))
		{
			//2 и 3 аргументы - 2 целых числа 
			System.out.println(remainder(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
			//вывод - остаток от деления 
		}
		if(args[0].equals("2"))
		{
			//2 и 3 аргументы - 2 целых числа
			System.out.println(triArea(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
			//вывод - площадь треугольника по высоте и стороне
		}
		if(args[0].equals("3"))
		{
			//2, 3 и 4 аргументы - 3 целых числа
			System.out.println(animals(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
			//вывод число ног у куриц, свиней и коров
		}
		if(args[0].equals("4"))
		{
			//2, 3 и 4 аргументы - 3 числа
			System.out.println(profitableGamble(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3])));
			//вывод - true, если произведение первых двух больше третьего
		}
		if(args[0].equals("5"))
		{
			//2, 3 и 4 аргументы - 3 целых числа
			System.out.println(operation(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
			//вывод - операция, которой получается первое число из второго и третьего
		}
		if(args[0].equals("6"))
		{
			//2 аргумент - символ
			System.out.println(ctoa(args[1].charAt(0)));
			//вывод - код ASCII символа
		}
		if(args[0].equals("7"))
		{
			//2 аргумент - натуральное число
			System.out.println(addUpTo(Integer.parseInt(args[1])));
			//вывод - сумма натуральных чисел до него
		}
		if(args[0].equals("8"))
		{
			//2 и 3 аргументы - натуральные числа
			System.out.println(nextEdge(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
			//вывод - максимальная по длине третья сторона треугольника, если первые 2 - аргументы
		}
		if(args[0].equals("9"))
		{
			//2 и последующие аргументы - элементы массива целых чисел
			int[] arr = new int[args.length-1];
			for(int i = 0; i < args.length-1; i++)
			{
				arr[i] = Integer.parseInt(args[i+1]);
			}
			System.out.println(sumOfCubes(arr));
			//вывод - сумма кубов элементов введенного массива
		}
		if(args[0].equals("10"))
		{
			//2, 3 и 4 аргументы - целые числа
			System.out.println(abcmath(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
			//вывод - делимость a*2^b на c
		}
	}
	
	//1 - Возврат значения остатка от деления
	public static int remainder(int a, int b)
	{
		return a % b;
	}
	
	//2 - Нахождение площади треугольника
	public static int triArea(int h, int ab)
	{
		return h*ab/2;
	}
	
	//3 - Подсчет числа ног у куриц (ch), свиней (pig) и коров (cow)
	public static int animals(int ch, int pig, int cow)
	{
		return ch*2 + pig*4 + cow*4;
	}
	
	//4 - Программа возвращает true, если произведение prob и prize больше pay
	public static boolean profitableGamble(double prob, double prize, double pay)
	{
		return prob*prize > pay;
	}
	
	//5 - Что нужно сделать с числами a и b, чтобы получить N
	public static String operation(int N, int a, int b)
	{
		if(a + b == N)
		{
			return "added";
		}
		if(a - b == N)
		{
			return "substructed";
		}
		if(a * b == N)
		{
			return "multipled";
		}
		if(a / b == N)
		{
			return "splitted";
		}
		return "none";
	}
	
	//6 - Возврат значения ASCII символа
	public static int ctoa(char ch)
	{
		return (int) ch;
	}
	
	//7 - сумма натуральных чисел до введенного, включая само число
	public static int addUpTo(int num)
	{
		int res = 0;
		for(int i = 1; i <= num; i++)
		{
			res += i;
		}
		return res;
	}
	
	//8 - Нахождение максимальной по длине третьей стороны треугольника с целыми длинами сторон
	public static int nextEdge(int a, int b)
	{
		if(a > 0 && b > 0)
		{
			return a + b - 1;
		}
		return 0;
	}
	
	//9 - Сумма кубов чисел массива
	public static int sumOfCubes(int[] arr)
	{
		int res = 0;
		if(arr.length != 0)
		{
			for(int i = 0; i < arr.length; i++)
			{
				res += Math.pow(arr[i], 3);
			}
		}
		return res;
	}
	
	//10 - a суммируется с самим собой b раз, выводится true, если результат делится нацело на c
	public static boolean abcmath(int a, int b, int c)
	{
		if(a > 0 && b > 0 && c > 0)
		{
			while(b > 0)
			{
				a = a + a;
				b--;
			}
			return a % c == 0;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}