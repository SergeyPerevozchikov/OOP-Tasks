
import java.util.ArrayList;
import java.util.Arrays;

public class Block3
{
	public static void main(String[] args)
	{
		//первый аргумент - номер задачи в блоке от 1 до 10
		if(args[0].equals("1"))
		{
			//2, 3 и 4 аргументы - целые коэффициенты квадратного уравнения
			System.out.println(solutions(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
			//вывод - количество решений квадратного уравнения
		}
		if(args[0].equals("2"))
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
			System.out.println(findZip(s));
			//вывод - индекс второго вхождения в строку слова zip (-1, если его нет)
		}
		if(args[0].equals("3"))
		{
			//2 аргумент - натуральное число
			System.out.println(checkPerfect(Integer.parseInt(args[1])));
			//вывод - является ли число совершенным (суммой его множителей, кроме него самого)
		}
		if(args[0].equals("4"))
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
			System.out.println(flipEndChars(s));
			//вывод - новая строка или сообщение
		}
		if(args[0].equals("5"))
		{
			//2 аргумент - строка
			System.out.println(isValidHexCode(args[1]));
			//вывод - является ли строка допустимым шестнадцатеричным кодом
		}
		if(args[0].equals("6"))
		{
			//2 и 3 аргументы - размеры первого и второго массивов, последующие аргументы - целочисленные элементы массивов
			int i;
			int[] arr1 = new int[Integer.parseInt(args[1])];
			int[] arr2 = new int[Integer.parseInt(args[2])];
			for(i = 3; i < arr1.length+3; i++)
			{
				arr1[i-3] = Integer.parseInt(args[i]);
				
			}
			for(int j = i; j < i + arr2.length; j++)
			{
				arr2[j-i] = Integer.parseInt(args[j]);
			}
			System.out.println(same(arr1, arr2));
			//вывод - равное ли у массивов число уникальных элементов
		}
		if(args[0].equals("7"))
		{
			//2 аргумент - целое число
			System.out.println(isKaprekar(Integer.parseInt(args[1])));
			//вывод - является ли оно числом Капрекара
		}
		if(args[0].equals("8"))
		{
			//2 аргумент - последовательность нулей и единиц
			System.out.println(longestZero(args[1]));
			//вывод - самая длинная непрерывная последовательность нулей 
		}
		if(args[0].equals("9"))
		{
			//2 аргумент - натуральное число
			System.out.println(nextPrime(Integer.parseInt(args[1])));
			//вывод - следующее простое число (или введенное число, если оно является простым)
		}
		if(args[0].equals("0"))
		{
			//2, 3 и 4 аргументы - целые числа (длины сторон треугольника)
			System.out.println(rightTriangle(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
			//вывод - является ли треугольник прямоугольным
		}
	}
	
	//1 - Нахождение количества решений квадратного уравнения
	public static String solutions(int a, int b, int c)
	{
		if(a == 0 && b != 0)
		{
			return "1";
		}
		if(a == 0 && b == 0 && c != 0)
		{
			return "0";
		}
		if(a == 0 && b == 0 && c == 0)
		{
			return "inf";
		}
		if(b*b - 4*a*c < 0)
		{
			return "0";
		}
		if(b*b - 4*a*c == 0)
		{
			return "1";
		}
		if(b*b - 4*a*c > 0)
		{
			return "2";
		}
		return "";
	}
	
	//2 - Нахождение индекса второго вхождения слова zip
	public static int findZip(String s1)
	{
		if(s1.indexOf("zip") >= 0)
		{
			s1 = s1.substring(0, s1.indexOf("zip")) + "_" + s1.substring(s1.indexOf("zip") + 1);
			if(s1.indexOf("zip") >= 0)
			{
				return s1.indexOf("zip");
			}
		}
		return -1;
	}
	
	//3 - Проверка, является ли число совершенным (равно сумме его множителей, кроме самого себя)
	public static boolean checkPerfect(int number)
	{
		ArrayList<Integer> multipliers = new ArrayList<>();
		for(int i = 1; i < number; i++)
		{
			if(number%i == 0)
			{
				multipliers.add(i);
			}
		}
		if(multipliers.size() > 0)
		{
			int summ = 0;
			for(int i : multipliers)
			{
				summ += i;
			}
			if(summ == number)
			{
				return true;
			}
		}
		return false;
	}
	
	//4 - Возврат строки с заменой последного символа на первый и наоборот, если длина строки больше 1, если первый и последний символы равны, вернуть "Two's a pair."
	public static String flipEndChars(String s1)
	{
		if(s1.length() >= 2)
		{
			if(s1.charAt(0) == s1.charAt(s1.length()-1))
			{
				return "Two's a pair.";
			}
			return s1.charAt(s1.length()-1) + s1.substring(1, s1.length()-1) + s1.charAt(0);
		}
		return "Incompatible";
	}
	
	//5 - Проверка, является ли строка допустимым шестнадцатеричным кодом (начинается с #, состоит из 6 цифр или букв в диапазоне A-F)
	public static boolean isValidHexCode(String code)
	{
		if(code.length() == 7)
		{
			if(code.charAt(0) == '#')
			{
				for(int i = 1; i < code.length(); i++)
				{
					if(!Character.isDigit(code.charAt(i)))
					{
						char symbol = code.charAt(i);
						if(!Character.isLetter(symbol))
						{
							return false;
						}
						symbol = Character.toUpperCase(symbol);
						if(symbol != 'A' && symbol != 'B' && symbol != 'C' && symbol != 'D' && symbol != 'E' && symbol != 'F')
						{
							return false;
						}
					}
				}
				return true;
			}
		}
		return false;
	}
	
	//6 - Проверка, имеют ли 2 массива одинаковое количество уникальных элементов
	public static boolean same(int[] arr1, int[] arr2)
	{
		ArrayList<Integer> unique1 = new ArrayList<>();
		ArrayList<Integer> unique2 = new ArrayList<>();
		for(int i : arr1)
		{
			if(!unique1.contains(i))
			{
				unique1.add(i);
			}
		}
		for(int i : arr2)
		{
			if(!unique2.contains(i))
			{
				unique2.add(i);
			}
		}
		return unique1.size() == unique2.size();
	}
	
	//7 - Проверка, является ли число числом Капрекара 
	public static boolean isKaprekar(int number)
	{
		int left = 0, right = 0;
		if(number*number/10 == 0)
		{
			return number == number*number;
		}
		int sq = number*number, len = 0;
		while(sq > 0)
		{
			sq = sq/10;
			len++;
		}
		left = number*number/(int)Math.pow(10, len - len/2);
		right = number*number % (int)Math.pow(10, len - len/2);
		
		return number == left + right;
	}
	
	//8 - Возврат самой длинной последовательности нулей из строки нулей и единиц
	public static String longestZero(String seq)
	{
		String zeros = ""; 
		String max = "";
		for(int i = 0; i < seq.length(); i++)
		{
			if(seq.charAt(i) == '0')
			{
				zeros += "0";
			}
			if(seq.charAt(i) == '1')
			{
				if(zeros.length() > max.length())
				{
					max = zeros.substring(0);
				}
				zeros = "";
			}
		}
		if(zeros.length() > max.length())
		{
			max = zeros.substring(0);
		}
		return max;
	}
	
	//9 - Нахождение следующего простого числа или вывод полученного числа, если оно простое 
	public static int nextPrime(int number)
	{
		while(true)
		{
			boolean notPrime = false;
			for(int i = 2; i < number; i++)
			{
				if(number % i == 0)
				{
					notPrime = true;
				}
			}
			if(!notPrime)
			{
				break;
			}
			number++;
		}
		return number;
	}
	
	//10 - Проверка, является ли треугольник со сторонами x, y, z - прямоугольным
	public static boolean rightTriangle(int x, int y, int z)
	{
		return (x*x + y*y == z*z) || (x*x + z*z == y*y) || (y*y + z*z == x*x);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}