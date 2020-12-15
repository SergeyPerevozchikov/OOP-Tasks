
import java.util.ArrayList;
import java.util.Arrays;
import java.security.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Block5
{
	public static void main(String[] args)
	{
		//первый аргумент - номер задачи в блоке от 1 до 10
		if(args[0].equals("1a"))
		{
			//2 аргумент - целое количество слов в эссе, 3 аргумент - ограничение по символам в строке, 4 и следующие - строка
			System.out.println(Arrays.toString(encrypt(args[1])));
			//вывод - отформатированное эссе
		}
		if(args[0].equals("1b"))
		{
			//2 аргумент - целое количество слов в эссе, 3 аргумент - ограничение по символам в строке, 4 и следующие - строка
			int[] arr = new int[args.length-1];
			for(int i = 1; i < args.length; i++)
			{
				arr[i-1] = Integer.parseInt(args[i]);
			}
			System.out.println(decrypt(arr));
			//вывод - отформатированное эссе
		}
		if(args[0].equals("2"))
		{
			//2 аргумент - строка из скобок
			System.out.println(canMove(args[1], args[2], args[3]));
			//вывод - кластер скобок
		}
		if(args[0].equals("3"))
		{
			//2 аргумент - строка формата snake case
			System.out.println(canComplete(args[1], args[2]));
			
			//вывод - строка формата camel case
		}
		if(args[0].equals("4"))
		{
			//2 аргумент - строка формата camel case
			int[] arr = new int[args.length-1];
			for(int i = 1; i < args.length; i++)
			{
				arr[i-1] = Integer.parseInt(args[i]);
			}
			System.out.println(sumDigProd(arr));
			
			//вывод - строка формата snake case
		}
		if(args[0].equals("5"))
		{
			//2 и 3 аргументы - масса, 4 и 5 аргументы - рост
			String[] arr = new String[args.length-1];
			for(int i = 1; i < args.length; i++)
			{
				arr[i-1] = args[i];
			}
			System.out.println(Arrays.toString(sameVowelGroup(arr)));
			//вывод - индекс массы тела
		}
		if(args[0].equals("6"))
		{
			//2 аргумент - число
			System.out.println(validateCard(Long.parseLong(args[1])));
			//вывод - количество итераций перемножений всех разрядов числа, пока оно не станет однозначным
		}
		if(args[0].equals("7"))
		{
			//2 аргумент - строка
			System.out.println(numToEng(Integer.parseInt(args[1])));
			//вывод - звездная стенография
		}
		if(args[0].equals("8"))
		{
			//2 и 3 аргументы - строчки (ввод через "")
			System.out.println(getSha256Hash(args[1]));
			//вывод - проверка, рифмуются ли 2 строки (в последнем слове все гласные совпадают)
		}
		if(args[0].equals("9"))
		{
			//2 и 3 аргументы - целые числа
			System.out.println(correctTitle(args[1]));
			//вывод - повторяется ли какая-то цифра 3 раза подряд в первом числе и 2 раза во втором
		}
		if(args[0].equals("0"))
		{
			//2 аргумент - строка символов, 3 аргумент - открывающий и закрывающий книгу символ
			System.out.println(hexLattice(Integer.parseInt(args[1])));
			//вывод - количество уникальных символов в книгах
		}
	}
	
	//1 - кодирование строки и декодирование массива
	public static int[] encrypt(String s)
	{
		int[] code = new int[s.length()];
		code[0] = (int)s.charAt(0);
		for(int i = 1; i < s.length(); i++)
		{
			code[i] = (int)s.charAt(i)-(int)s.charAt(i-1);
		}
		return code;
	}
	
	public static String decrypt(int[] code)
	{
		//System.out.println(Arrays.toString(code));
		String s = "";
		s += (char)code[0];
		for(int i = 1; i < code.length; i++)
		{
			//code[i] = (int)s.charAt(i)-(int)s.charAt(i-1);
			s += (char)((int)s.charAt(i-1) + code[i]);
		}
		return s;
	}
	
	//2 - шахматы
	public static boolean canMove(String name, String start, String step)
	{
		int Sx = (int)start.charAt(0), Sy = Integer.parseInt(start.substring(1)), Ex = (int)step.charAt(0), Ey = Integer.parseInt(step.substring(1));
		//System.out.println(Sx);
		//System.out.println(Sy);
		//System.out.println(Ex);
		//System.out.println(Ey);
		//System.out.println(name);
		if(name.equals("Pawn"))
		{
			//System.out.println(Math.abs(Ex - Sx));
			if(Math.abs(Ex - Sx) < 2 && Math.abs(Ey - Sy) == 1)
			{
				return true;
			}
		}
		if(name.equals("Rook"))
		{
			if(Math.abs(Ex - Sx) > 0 && Math.abs(Ey - Sy) == 0 || Math.abs(Ex - Sx) == 0 && Math.abs(Ey - Sy) > 0)
			{
				return true;
			}
		}
		if(name.equals("Bishop"))
		{
			if(Math.abs(Ex - Sx) > 0 && Math.abs(Ey - Sy) > 0 && Math.abs(Ex - Sx) == Math.abs(Ey - Sy))
			{
				return true;
			}
		}
		if(name.equals("Horse"))
		{
			if(Math.abs(Ex - Sx) == 1 && Math.abs(Ey - Sy) == 2 || Math.abs(Ex - Sx) == 2 && Math.abs(Ey - Sy) == 1)
			{
				return true;
			}
		}
		if(name.equals("Queen"))
		{
			if(Math.abs(Ex - Sx) > 0 && Math.abs(Ey - Sy) > 0 && Math.abs(Ex - Sx) == Math.abs(Ey - Sy) || 
			Math.abs(Ex - Sx) > 0 && Math.abs(Ey - Sy) == 0 || Math.abs(Ex - Sx) == 0 && Math.abs(Ey - Sy) > 0)
			{
				return true;
			}
		}
		if(name.equals("King"))
		{
			if(Math.abs(Ex - Sx) < 2 && Math.abs(Ey - Sy) < 2)
			{
				return true;
			}
		}
		
		
		return false;
	}
	
	//3 - можно ли закончить слово?
	public static boolean canComplete(String enter, String word)
	{
		for(int i = 0; i < word.length(); i++)
		{
			if(word.indexOf(enter.charAt(i)) == -1)
			{
				break;
			}
			if(i != enter.length()-1 || enter.charAt(i) == word.charAt(word.length()-1))
			{
				if(enter.charAt(i) != word.charAt(i))
				{	
					enter = enter.substring(0, i) + word.charAt(i) + enter.substring(i);
				}
			}
			else
			{
				enter += word.substring(i+1);
				break;
			}
			//System.out.println(enter);
		}
		//System.out.println(enter);
		return enter.equals(word);
	}
	
	//4 - минимальное произведение всех разрядов суммы элементов массива 
	public static int sumDigProd(int[] arr)
	{
		int sum = 0, prod = 1;
		for(int i: arr)
		{
			sum += i;
		}
		while(true)
		{
			prod *= sum % 10;
			sum = sum / 10;
			if(prod < 10 && sum == 0)
			{
				break;
			}
			if(prod>= 10 && sum == 0)
			{
				sum = prod;
				prod = 1;
			}
		}
		return prod;
	}
	
	//5 - возврат слов с такими же гласными, что у первого
	public static Object[] sameVowelGroup(String[] words)
	{
		ArrayList<Character> vowels1 = new ArrayList<>();
		ArrayList<String> same = new ArrayList<>();
		for(int i = 0; i < words[0].length(); i++)
		{
			if(words[0].charAt(i) == 'a' || words[0].charAt(i) == 'e' || words[0].charAt(i) == 'i' || 
			words[0].charAt(i) == 'o' || words[0].charAt(i) == 'u' || words[0].charAt(i) == 'y')
			{
				if(!vowels1.contains(words[0].charAt(i)))
				{
					vowels1.add(words[0].charAt(i));
				}
			}
		}
		same.add(words[0]);
		
		for(int i = 1; i < words.length; i++)
		{
			boolean contains = true;
			for(int j = 0; j < words[i].length(); j++)
			{
				if(words[i].charAt(j) == 'a' || words[i].charAt(j) == 'e' || words[i].charAt(j) == 'i' || 
				words[i].charAt(j) == 'o' || words[i].charAt(j) == 'u' || words[i].charAt(j) == 'y')
				{
					if(!vowels1.contains(words[i].charAt(j)))
					{
						contains = false;
						break;
					}
				}
			}
			if(contains)
			{
				same.add(words[i]);
			}
		}
		return same.toArray();
	}
	
	//6 - Проверка номера кредитной карты 
	public static boolean validateCard(long number)
	{
		if(number / Math.pow(10, 14) != 0)
		{
			long control = number % 10;
			number = number / 10;
			String n = Long.toString(number);
			String n1 = "";
			for(int i = n.length()-1; i >= 0; i--)
			{
				n1+= n.charAt(i);
			}
			//System.out.println(n1);
			number = 0;
			ArrayList<Integer> digits = new ArrayList<>();
			for(int i = 0; i < n1.length(); i++)
			{
				//System.out.println(n1.substring(i,i+1));
				if(i % 2 != 0)
				{
					digits.add(Integer.parseInt(n1.substring(i,i+1)));
				}
				else
				{
					int newDigit = Integer.parseInt(n1.substring(i,i+1)) * 2;
					if(newDigit / 10 == 0)
					{
						digits.add(newDigit);
					}
					else
					{
						digits.add(newDigit / 10 + newDigit % 10);
					}
				}
			}
			for(int i : digits)
			{
				number += i;
				//System.out.println(number);
			}
			
			return 10 - number%10 == control;
		}
		return false;
	}
	
	//7 - перевод чисел в слова
	public static String numToEng(int number)
	{
		String result = "";
		if(number / 100 > 0)
		{
			if(number / 100 == 1)
				result += "One";
			if(number / 100 == 2)
				result += "Two";
			if(number / 100 == 3)
				result += "Three";
			if(number / 100 == 4)
				result += "Four";
			if(number / 100 == 5)
				result += "Five";
			if(number / 100 == 6)
				result += "Six";
			if(number / 100 == 7)
				result += "Seven";
			if(number / 100 == 8)
				result += "Eight";
			if(number / 100 == 9)
				result += "Nine";
			result += " hundred ";
		}
		if(number % 100 > 20)
		{
			if(number % 100 >= 20 && number % 100 < 30)
				result += "Twenty ";
			if(number % 100 >= 30 && number % 100 < 40)
				result += "Thirty ";
			if(number % 100 >= 40 && number % 100 < 50)
				result += "Fourty ";
			if(number % 100 >= 50 && number % 100 < 60)
				result += "Fifty ";
			if(number % 100 >= 60 && number % 100 < 70)
				result += "Sixty ";
			if(number % 100 >= 70 && number % 100 < 80)
				result += "Seventy ";
			if(number % 100 >= 80 && number % 100 < 90)
				result += "Eighty ";
			if(number % 100 >= 90)
				result += "Ninety ";
		}
		if((number % 100 > 20 || number % 100 < 10) && number % 10 > 0)
		{
			if(number % 10 == 1)
				result += "One ";
			if(number % 10 == 2)
				result += "Two ";
			if(number % 10 == 3)
				result += "Three ";
			if(number % 10 == 4)
				result += "Four ";
			if(number % 10 == 5)
				result += "Five ";
			if(number % 10 == 6)
				result += "Six ";
			if(number % 10 == 7)
				result += "Seven ";
			if(number % 10 == 8)
				result += "Eight ";
			if(number % 10 == 9)
				result += "Nine ";
		}
		if(number % 100 < 20 && number % 100 >= 10)
		{
			if(number % 100 == 10)
				result += "Ten";
			if(number % 100 == 11)
				result += "Eleven";
			if(number % 100 == 12)
				result += "Twelve";
			if(number % 100 == 13)
				result += "Thirteen";
			if(number % 100 == 14)
				result += "Fourteen";
			if(number % 100 == 15)
				result += "Fifteen";
			if(number % 100 == 16)
				result += "Sixteen";
			if(number % 100 == 17)
				result += "Seventeen";
			if(number % 100 == 18)
				result += "Eighteen";
			if(number % 100 == 19)
				result += "Nineteen";
		}
		if(number == 0)
		{
			result = "zero";
		}
		return result;
	}
	
	//8 - возврат хеш SHA-256
	public static String getSha256Hash(String s)
	{
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(s.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} 
		catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	//9 - исправление регистра слов в строке (and, the, of и in в нижнем регистре, остальные с заглавной буквы)
	public static String correctTitle(String nonCorrect)
	{
		String correct = "";
		String word = "";
		for(int i = 0; i < nonCorrect.length(); i++)
		{
			if(nonCorrect.charAt(i) != ' ' && nonCorrect.charAt(i) != ',')
			{
				word += nonCorrect.charAt(i);
			}
			else
			{
				if(word.length() != 0)
				{
					word = word.toLowerCase();
					if(!word.equals("and") && !word.equals("the") && !word.equals("of") && !word.equals("in"))
					{
						word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
					}
					correct += word;
					word = "";
				}
				correct += nonCorrect.charAt(i);
			}
			if(i == nonCorrect.length()-1 && word.length() != 0)
			{
				word = word.toLowerCase();
				if(!word.equals("and") && !word.equals("the") && !word.equals("of") && !word.equals("in"))
				{
					word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
				}
				correct += word;
				word = "";
			}
		}
		return correct;
	}
	
	//10	

	public static String hexLattice(int n) 
	{
		int num = 1;
		int i = 1;
		String result = "";
		String str2 = "";

		while (n > num) 
		{
			i++;
			num = 3 * i * (i - 1) + 1;
		}

		int k = i;

		if (n != num)
			result = "invalid";
		else 
		{
			while (k < i * 2 - 1) 
			{

				for (int a = 0; a < i * 2 - 1 - k; a++)
					result += " ";

				for (int b = 0; b < k; b++)
					result += "o ";

				result += "\n";
				k++;
			}

			while (k >= i) {

				for (int a = 0; a < i * 2 - 1 - k; a++)
					result += " ";

				for (int b = k; b > 0; b--)
					result += "o ";

				result += "\n";
				k--;
			}
		}

	return result;
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}