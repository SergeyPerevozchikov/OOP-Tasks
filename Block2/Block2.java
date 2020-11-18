
public class Block2
{
	public static void main(String[] args)
	{
		//первый аргумент - номер задачи в блоке от 1 до 10
		if(args[0].equals("1"))
		{
			//2 аргумент - строка, 3 - целое число повторений
			System.out.println(repeat(args[1], Integer.parseInt(args[2])));
			//вывод - новая строка
		}
		if(args[0].equals("2"))
		{
			//2 и последующие аргументы - элементы массива целых чисел
			int[] arr = new int[args.length-1];
			for(int i = 0; i < args.length-1; i++)
			{
				arr[i] = Integer.parseInt(args[i+1]);
			}
			System.out.println(differenceMaxMin(arr));
			//вывод - разница максимального и минимального элемента
		}
		if(args[0].equals("3"))
		{
			//2 и последующие аргументы - элементы массива целых чисел
			int[] arr = new int[args.length-1];
			for(int i = 0; i < args.length-1; i++)
			{
				arr[i] = Integer.parseInt(args[i+1]);
			}
			System.out.println(isAvgWhole(arr));
			//вывод - цельность среднего арифметического элементов массива
		}
		if(args[0].equals("4"))
		{
			//2 и последующие аргументы - элементы массива целых чисел
			int[] arr = new int[args.length-1];
			for(int i = 0; i < args.length-1; i++)
			{
				arr[i] = Integer.parseInt(args[i+1]);
			}
			arr = cumulativeSum(arr);
			for(int i : arr)
			{
				System.out.print(i);
				System.out.print(" ");
			}
			//вывод - новый массив 
		}
		if(args[0].equals("5"))
		{
			//2 аргумент - число
			System.out.println(getDecimalPlaces(args[1]));
			//вывод - длина дробной части в переданной записи числа
		}
		if(args[0].equals("6"))
		{
			//2 аргумент - целое неотрицательное число
			System.out.println(Fibonacci(Integer.parseInt(args[1])));
			//вывод - число Фибоначчи
		}
		if(args[0].equals("7"))
		{
			//2 и последующие аргументы - строка
			String s = "";
			for(int i = 1; i < args.length; i++)
			{
				s += args[i];
				if(i != args.length-1)
				{
					s += " ";
				}
			}
			System.out.println(isValid(s));
			//вывод - является ли переданная строка правильным индексом
		}
		if(args[0].equals("8"))
		{
			//2 и 3 аргументы - 2 слова
			if(args.length >= 3)
			{
				System.out.println(isStrangePair(args[1], args[2]));
			}
			else
			{
				System.out.println(isStrangePair("", ""));
			}
			//вывод - являются ли они сранной парой
		}
		if(args[0].equals("9p"))
		{
			//2 и 3 аргументы - слово и префикс
			System.out.println(isPrefix(args[1], args[2]));
			//вывод - вхождение префикса в слово
		}
		if(args[0].equals("9s"))
		{
			//2 и 3 аргументы - слово и суффикс
			System.out.println(isSuffix(args[1], args[2]));
			//вывод - вхождение суффикса в слово
		}
		if(args[0].equals("0"))
		{
			//2 аргумент - целое не отрицательное число (номер шага)
			System.out.println(boxSeq(Integer.parseInt(args[1])));
			//вывод - количество полей на данном шаге
		}
	}
	
	//1 - Вывод новой строки, в которой каждый символ исходной повторяется count раз
	public static String repeat(String s1, int count)
	{
		String s2 = "";
		for(int i = 0; i < s1.length(); i++)
		{
			for(int j = 0; j < count; j++)
			{
				s2 += s1.charAt(i);
			}
		}
		return s2;
	}
	
	//2 - Нахождение разницы между максимальным и минимальным числом в массиве
	public static int differenceMaxMin(int[] arr)
	{
		if(arr.length != 0)
		{
			int min = arr[0], max = arr[0];
			for(int i = 1; i < arr.length; i++)
			{
				if(arr[i] > max)
				{
					max = arr[i];
				}
				if(arr[i] < min)
				{
					min = arr[i];
				}
			}
			return max - min;
		}
		return 0;
	}
	
	//3 - Проверка среднего арифметического чисел в массиве, является ли оно целым
	public static boolean isAvgWhole(int[] arr)
	{
		int res = 0;
		for(int i : arr)
		{
			res += i;
		}
		return Math.abs(res) % arr.length == 0;
	}
	
	//4 - Получение нового массива, состоящего из сумм элементов исходного массива на предыдущих индексах
	public static int[] cumulativeSum(int[] arr)
	{
		int[] newArr = new int[arr.length];
		for(int i : newArr)
		{
			i = 0;
		}
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i; j < arr.length; j++)
			{
				newArr[j] += arr[i];
			}
		}
		return newArr;
	}
	
	//5 - получение длины дробной части числа, переданного в виде строки
	public static int getDecimalPlaces(String number)
	{
		int count = 0;
		if(number.indexOf('.') >= 0)
		{
			count = number.length() - 1 - number.indexOf('.');
		}
		return count;
	}
	
	//6 - нахождение n-го числа Фибоначчи
	public static int Fibonacci(int n)
	{
		if(n == 1 || n == 0)
		{
			return 1;
		}
		return Fibonacci(n-1) + Fibonacci(n-2);
	}
	
	//7 - Является ли строка почтовым индексом (состоит только из 5 цифр без пробелов)
	public static boolean isValid(String ind)
	{
		if(ind.length() != 5)
		{
			return false;
		}
		if(ind.indexOf(' ') >= 0)
		{
			return false;
		}
		for(int i = 0; i < ind.length(); i++)
		{
			
			if(!Character.isDigit(ind.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	//8 - являются ли 2 строки странной парой (первый символ первой - последний второй строки и наоборот)
	public static boolean isStrangePair(String s1, String s2)
	{
		if(s1.length() != 0 && s2.length() != 0)
		{
			if(s1.charAt(0) == s2.charAt(s2.length()-1) && s1.charAt(s1.length()-1) == s2.charAt(0))
			{
				return true;
			}
			return false;
		}
		return true;
	}
	
	//9 - проверка, является ли подстрока префиксом или суффиксом строки
	public static boolean isPrefix(String word, String prefix)
	{
		return word.startsWith(prefix.substring(0, prefix.length()-1));
	}
	
	public static boolean isSuffix(String word, String suffix)
	{
		return word.endsWith(suffix.substring(1));
	}
	
	//10 - подсчет полей на шаге (0 - 0, 1 - +3, 2 - -1, 3 - +3...)
	public static int boxSeq(int step)
	{
		int fields = 0;
		for(int i = 1; i <= step; i += 2)
		{
			fields += 3;
		}
		for(int i = 2; i <= step; i += 2)
		{
			fields--;
		}
		return fields;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}