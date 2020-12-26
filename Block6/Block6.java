
import java.util.ArrayList;
import java.util.Arrays;


public class Block6
{
	public static void main(String[] args)
	{
		//первый аргумент - номер задачи в блоке от 1 до 10
		if(args[0].equals("1"))
		{
			//2 аргумент - количество элементов множества
			System.out.println(bell(Integer.parseInt(args[1])));
			//вывод - число Белла для этого множества
		}
		if(args[0].equals("2a"))
		{
			//2 аргумент - слово
			System.out.println(translateWord(args[1]));
			//вывод - слово, переведенное на свино-латинский
		}
		if(args[0].equals("2b"))
		{
			//2 аргумент - предложение
			System.out.println(translateSentence(args[1]));
			//вывод - предложение, переведенное на свино-латинский
		}
		if(args[0].equals("3"))
		{
			//2 аргумент - цвет
			System.out.println(validColor(args[1]));
			//вывод - правильный ли формат
		}
		if(args[0].equals("4a"))
		{
			//2 аргумент - URL
			System.out.println(stripUrlParams(args[1]));
			//вывод - URL без повторений параметров запроса
		}
		if(args[0].equals("4b"))
		{
			//2 аргумент - URL, 3 и последующие - лишние параметры
			ArrayList<String> params = new ArrayList<>();
			for(int i = 2; i < args.length; i++)
			{
				params.add(args[i]);
			}
			System.out.println(stripUrlParams(args[1], params));
			//вывод - URL без повторений и лишних параметров запроса
		}
		if(args[0].equals("5"))
		{
			//2 аргумент - заголовок статьи
			System.out.println(Arrays.toString(getHashTags(args[1])));
			//вывод - хэштеги
		}
		if(args[0].equals("6"))
		{
			//2 аргумент - номер числа Улама
			System.out.println(ulam(Integer.parseInt(args[1])));
			//вывод - число Улама
		}
		if(args[0].equals("7"))
		{
			//2 аргумент - строка
			System.out.println(longestNonrepeatingSubstring(args[1]));
			//вывод - самая длинная последовательность уникальных символов
		}
		if(args[0].equals("8"))
		{
			//2 аргумент - число
			System.out.println(convertToRoman(Integer.parseInt(args[1])));
			//вывод - римская запись числа
		}
		if(args[0].equals("9"))
		{
			//2 аргумент - формула
			System.out.println(formula(args[1]));
			//вывод - правильная ли формула
		}
		if(args[0].equals("0"))
		{
			//2 аргумент - число
			System.out.println(palindromedescendant(Integer.parseInt(args[1])));
			//вывод - является ли палиндромом оно или его потомок
		}
	}
	
	//1 - возврат n-го числа Белла
	public static int bell(int n)
	{
		int bellNumber = 0;
		if(n == 0)
		{
			bellNumber = 1;
		}
		if(n > 0)
		{
			String sampleArr = "";
			String ossiblePartitions = "";
			int[][] bellTriangle = new int[n][n];
			bellTriangle[0][0] = 1;
			for(int i = 1; i < n; i++)
			{
				bellTriangle[i][0] = bellTriangle[i-1][i-1];
				for(int j = 1; j <= i; j++)
				{
					bellTriangle[i][j] = bellTriangle[i][j-1] + bellTriangle[i-1][j-1];
				}
			}
			
			bellNumber = bellTriangle[n-1][n-1];
		}
		
		return bellNumber;
	}
	
	//2 - перевод на свино-латинский
	public static String translateWord(String wordEng)
	{
		boolean upper = Character.isUpperCase(wordEng.charAt(0));
		String wordLat = "";
		wordEng = wordEng.toLowerCase();
		if(wordEng.charAt(0) == 'a' || wordEng.charAt(0) == 'e' || wordEng.charAt(0) == 'i' || 
		wordEng.charAt(0) == 'o' || wordEng.charAt(0) == 'u' || wordEng.charAt(0) == 'y')
		{
			if(upper)
			{
				wordLat += Character.toUpperCase(wordEng.charAt(0));
				if(wordEng.length() > 1)
				{
					wordLat += wordEng.substring(1);
				}
				wordLat += "yay";
			}
			else
			{
				wordLat += wordEng + "yay";
			}
		}
		else
		{
			int i = 0;
			String consonant = "";
			while(wordEng.charAt(i) != 'a' && wordEng.charAt(i) != 'e' && wordEng.charAt(i) != 'i' && 
			wordEng.charAt(i) != 'o' && wordEng.charAt(i) != 'u' && wordEng.charAt(i) != 'y')
			{
				consonant += wordEng.charAt(i);
				i++;
			}
			if(upper)
			{
				wordLat += Character.toUpperCase(wordEng.charAt(i));
				if(i != wordEng.length()-1)
				{
					wordLat += wordEng.substring(i+1);
				}
				wordLat += consonant + "ay";
			}
			else
			{
				wordLat += wordEng.substring(i) + consonant + "ay";
			}
		}
		
		return wordLat;
	}
	
	public static String translateSentence(String sentenceEng)
	{
		String sentenceLat = "";
		String word = "";
		for(int i = 0; i < sentenceEng.length(); i++)
		{
			if(Character.isLetter(sentenceEng.charAt(i)))
			{
				word += sentenceEng.charAt(i);
			}
			else
			{
				if(word != "")
				{
					sentenceLat += translateWord(word);
					word = "";
				}
				sentenceLat += sentenceEng.charAt(i);
			}
		}
		return sentenceLat;
	}
	
	//3 - правильность формата rgba
	public static boolean validColor(String color)
	{
		if(color.substring(0, color.indexOf("(")).equals("rgb"))
		{
			try
			{
				color = color.substring(color.indexOf("(") + 1, color.indexOf(")"));
				if(Double.parseDouble(color.substring(0, color.indexOf(","))) < 0 || Double.parseDouble(color.substring(0, color.indexOf(","))) > 255)
				{
					return false;
				}
				color = color.substring(color.indexOf(",")+1);
				if(Double.parseDouble(color.substring(0, color.indexOf(","))) < 0 || Double.parseDouble(color.substring(0, color.indexOf(","))) > 255)
				{
					return false;
				}
				color = color.substring(color.indexOf(",")+1);
				if(Double.parseDouble(color.substring(0)) < 0 || Double.parseDouble(color.substring(0)) > 255)
				{
					return false;
				}
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
		if(color.substring(0, color.indexOf("(")).equals("rgba"))
		{
			try
			{
				color = color.substring(color.indexOf("(") + 1, color.indexOf(")"));
				if(Double.parseDouble(color.substring(0, color.indexOf(","))) < 0 || Double.parseDouble(color.substring(0, color.indexOf(","))) > 255)
				{
					return false;
				}
				color = color.substring(color.indexOf(",")+1);
				if(Double.parseDouble(color.substring(0, color.indexOf(","))) < 0 || Double.parseDouble(color.substring(0, color.indexOf(","))) > 255)
				{
					return false;
				}
				color = color.substring(color.indexOf(",")+1);
				if(Double.parseDouble(color.substring(0, color.indexOf(","))) < 0 || Double.parseDouble(color.substring(0, color.indexOf(","))) > 255)
				{
					return false;
				}
				color = color.substring(color.indexOf(",")+1);
				if(Double.parseDouble(color.substring(0)) < 0 || Double.parseDouble(color.substring(0)) > 1)
				{
					return false;
				}
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
			
		}
		return false;
	}
	
	//4 - удаление повторяющихся параметров запроса и параметров, передаваемых функции (опционально)
	public static String stripUrlParams(String url, ArrayList<String> parametersExcept)
	{
		if(url.contains("?"))
		{
			String request = url.substring(url.indexOf("?")+1);
			ArrayList<String> keys = new ArrayList<>();
			ArrayList<String> values = new ArrayList<>();
			String key = "";
			boolean fullKey = false;
			String value = "";
			for(int i = 0; i < request.length();i++)
			{
				if(request.charAt(i) != '=' && request.charAt(i) != '&' && !fullKey)
				{
					key += request.charAt(i);
				}
				if(request.charAt(i) == '=')
				{
					fullKey = true;
				}
				if(request.charAt(i) != '=' && request.charAt(i) != '&' && fullKey)
				{
					value += request.charAt(i);
				}
				if(request.charAt(i) == '&' || i == request.length()-1)
				{
					if(!keys.contains(key))
					{
						keys.add(key);
						values.add(value);
					}
					else
					{
						values.set(keys.indexOf(key), value);
					}
					key = "";
					value = "";
					fullKey = false;
				}
			}
			url = url.substring(0, url.indexOf("?")+1);
			for(int i = 0; i < keys.size(); i++)
			{
				if(!parametersExcept.contains(keys.get(i)))
				{
					url += keys.get(i) + "=" + values.get(i);
					if(i != keys.size()-1)
					{
						url += "&";
					}
				}
				
			}
			if(url.charAt(url.length()-1) == '&' || url.charAt(url.length()-1) == '?')
			{
				url = url.substring(0, url.length()-1);
			}
		}
		return url;
	}
	
	public static String stripUrlParams(String url)
	{
		if(url.contains("?"))
		{
			String request = url.substring(url.indexOf("?")+1);
			ArrayList<String> keys = new ArrayList<>();
			ArrayList<String> values = new ArrayList<>();
			String key = "";
			boolean fullKey = false;
			String value = "";
			for(int i = 0; i < request.length();i++)
			{
				if(request.charAt(i) != '=' && request.charAt(i) != '&' && !fullKey)
				{
					key += request.charAt(i);
				}
				if(request.charAt(i) == '=')
				{
					fullKey = true;
				}
				if(request.charAt(i) != '=' && request.charAt(i) != '&' && fullKey)
				{
					value += request.charAt(i);
				}
				if(request.charAt(i) == '&' || i == request.length()-1)
				{
					if(!keys.contains(key))
					{
						keys.add(key);
						values.add(value);
					}
					else
					{
						values.set(keys.indexOf(key), value);
					}
					key = "";
					value = "";
					fullKey = false;
				}
			}
			url = url.substring(0, url.indexOf("?")+1);
			for(int i = 0; i < keys.size(); i++)
			{
				url += keys.get(i) + "=" + values.get(i);
				if(i != keys.size()-1)
				{
					url += "&";
				}
			}
		}
		return url;
	}
	
	//5 - 3 самые длинные слова - хэштеги
	public static String[] getHashTags(String title)
	{
		String[] tags = {"#","#","#"};
		for(int num = 0; num < 3; num++)
		{
			String word = "";
			String max = "";
			for(int i = 0; i < title.length(); i++)
			{
				if(Character.isLetter(title.charAt(i)))
				{
					word += title.charAt(i);
				}
				if(!Character.isLetter(title.charAt(i)) || i == title.length()-1)
				{
					if(max.length() < word.length())
					{
						max = word.substring(0);
					}
					word = "";
				}
			}
			tags[num] += max.toLowerCase();
			title = title.substring(0, title.indexOf(max)) + title.substring(title.indexOf(max) + max.length());
			max = "";
		}
		if(tags[0].equals("#"))
		{
			return null;
		}
		if(tags[1].equals("#"))
		{
			return new String[]{tags[0]};
		}
		if(tags[2].equals("#"))
		{
			return new String[]{tags[0], tags[1]};
		}
		return tags;
	}
	
	//6 - число Улама
	public static int ulam(int number)
	{
		int[] ulam = new int[number];
		if(number > 0)
		{
			ulam[0] = 1;
			if(number > 1)
			{
				ulam[1] = 2;
				for(int i = 2; i < number; i++)
				{
					int num = ulam[i-1] + 1;
					while(true)
					{
						int count = 0;
						for(int j = 0; j < i; j++)
						{
							for(int k = j; k < i; k++)
							{
								if(num == ulam[j] + ulam[k])
								{
									ulam[i] = num;
									if(j != k)
									{
										count++;
									}
								}
							}
						}
						if(count < 2 && ulam[i] != 0)
						{
							break;
						}
						else
						{
							ulam[i] = 0;
							num++;
						}
					}
				}
			}
			return ulam[number-1];
		}
		return 0;
	}
	
	//7 - самая длинная подстрока без повторений
	public static String longestNonrepeatingSubstring(String str)
	{
		String subStr = "";
		if(str.length() != 0)
		{
			
			String seq = "";
			for(int i = 0; i < str.length(); i++)
			{
				if(seq.indexOf(str.charAt(i)) == -1)
				{
					seq += str.charAt(i);
					if(seq.length() > subStr.length())
					{
						subStr = seq.substring(0);
					}
				}
				else
				{
					seq = "" + str.charAt(i);
				}
				
			}
			
		}
		return subStr;
	}
	
	//8 - перевод арабского числа в римское (до 3999)
	public static String convertToRoman(int number)
	{
		String romanNumber = "";
		if(number / 1000 > 0)
		{
			while(number >= 1000)
			{
				romanNumber += "M";
				number -= 1000;
			}
		}
		if(number % 1000 >= 900)
		{
			romanNumber += "CM";
			number -= 900;
		}
		if(number % 1000 >= 500)
		{
			romanNumber += "D";
			number -= 500;
		}
		if(number % 1000 >= 400)
		{
			romanNumber += "CD";
			number -= 400;
		}
		if(number / 100 > 0)
		{
			while(number >= 100)
			{
				romanNumber += "C";
				number -= 100;
			}
		}
		if(number % 100 >= 90)
		{
			romanNumber += "XC";
			number -= 90;
		}
		if(number % 100 >= 50)
		{
			romanNumber += "L";
			number -= 50;
		}
		if(number % 100 >= 40)
		{
			romanNumber += "XL";
			number -= 40;
		}
		if(number / 10 > 0)
		{
			while(number >= 10)
			{
				romanNumber += "X";
				number -= 10;
			}
		}
		if(number % 10 == 9)
		{
			romanNumber += "IX";
			number -= 9;
		}
		if(number % 10 >= 5)
		{
			romanNumber += "V";
			number -= 5;
		}
		if(number % 10 == 4)
		{
			romanNumber += "IV";
			number -= 4;
		}
		if(number > 0)
		{
			while(number > 0)
			{
				romanNumber += "I";
				number -= 1;
			}
		}
		return romanNumber;
	}		
	
	//9 - правильная ли формула
	public static boolean formula(String expression)
	{
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Character> operations = new ArrayList<>();
		String num = "";
		for(int i = 0; i < expression.length(); i++)
		{
			if(Character.isDigit(expression.charAt(i)))
			{
				num += expression.charAt(i);
				if(i == expression.length()-1)
				{
					numbers.add(Integer.parseInt(num));
				}
			}
			else
			{
				if(num.length() != 0)
				{	
					numbers.add(Integer.parseInt(num));
					num = "";
				}
				if(expression.charAt(i) != ' ')
				{
					operations.add(expression.charAt(i));
				}
			}
		}
		int recentSum = 0;
		boolean waitingForCompare = false;
		System.out.println(Arrays.toString(numbers.toArray()));
		System.out.println(Arrays.toString(operations.toArray()));
		for(int i = 0; i < numbers.size()-1; i++)
		{
			if(operations.get(i) == '+')
			{
				numbers.set(i+1, numbers.get(i)+numbers.get(i+1)); 
			}
			if(operations.get(i) == '-')
			{
				numbers.set(i+1, numbers.get(i)-numbers.get(i+1)); 
			}
			if(operations.get(i) == '*')
			{
				numbers.set(i+1, numbers.get(i)*numbers.get(i+1)); 
			}
			if(operations.get(i) == '/')
			{
				numbers.set(i+1, numbers.get(i)/numbers.get(i+1)); 
			}
			if(operations.get(i) == '=' && !waitingForCompare)
			{
				if(i == numbers.size()-2)
				{
					return numbers.get(i) == numbers.get(i+1);
				}
				else
				{
					recentSum = numbers.get(i);
					waitingForCompare = true;
					continue;
				}
			}
			if(operations.get(i) == '=' && waitingForCompare)
			{
				if(recentSum != numbers.get(i))
				{
					return false;
				}
			}
			if(waitingForCompare && i == numbers.size()-2)
			{
				return recentSum == numbers.get(i+1);
			}
		}
		return false;
	}
	
	//10 - является ли палиндромом число или один из его потомков 
	public static boolean palindromedescendant(int number)
	{
		String reverse = "";
		boolean isPalindrome = false;
		while(number >= 10)
		{
			for(int i = Integer.toString(number).length()-1; i >= 0; i--)
			{
				reverse += Integer.toString(number).charAt(i);
			}
			if(reverse.equals(Integer.toString(number)))
			{
				isPalindrome = true;
				break;
			}
			String newNum = "";
			for(int i = 0; 2*i < Integer.toString(number).length(); i++)
			{
				newNum += Integer.toString(Integer.parseInt(Integer.toString(number).substring(2*i, 2*i+1))+Integer.parseInt(Integer.toString(number).substring(2*i+1, 2*i+2)));
			}
			number = Integer.parseInt(newNum);
			reverse = "";
		}
		return isPalindrome;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}