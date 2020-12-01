
import java.util.ArrayList;

public class Block4
{
	public static void main(String[] args)
	{
		//первый аргумент - номер задачи в блоке от 1 до 10
		if(args[0].equals("1"))
		{
			//2 аргумент - целое количество слов в эссе, 3 аргумент - ограничение по символам в строке, 4 и следующие - строка
			String str1 = "";
			for(int i = 3; i < 3 + Integer.parseInt(args[1]); i++)
			{
				str1 += args[i];
				if(i != 2 + Integer.parseInt(args[1]))
				{
					str1 += " ";
				}
			}
			System.out.println(BessieEssay(Integer.parseInt(args[1]), Integer.parseInt(args[2]), str1));
			//вывод - отформатированное эссе
		}
		if(args[0].equals("2"))
		{
			//2 аргумент - строка из скобок
			System.out.println(split(args[1]));
			//вывод - кластер скобок
		}
		if(args[0].equals("3a"))
		{
			//2 аргумент - строка формата snake case
			System.out.println(toCamelCase(args[1]));
			
			//вывод - строка формата camel case
		}
		if(args[0].equals("3b"))
		{
			//2 аргумент - строка формата camel case
			System.out.println(toSnakeCase(args[1]));
			
			//вывод - строка формата snake case
		}
		if(args[0].equals("4"))
		{
			//2, 3, 4 и 5 аргументы - начало рабочего дня, конец, почасовая оплата, коэффициент оплаты переработок
			String[] data = {args[1], args[2], args[3], args[4]};
			System.out.println(overTime(data));
			//вывод - оплата труда
		}
		if(args[0].equals("5"))
		{
			//2 и 3 аргументы - масса, 4 и 5 аргументы - рост
			System.out.println(BMI(args[1] + " " + args[2], args[3] + " " + args[4]));
			//вывод - индекс массы тела
		}
		if(args[0].equals("6"))
		{
			//2 аргумент - число
			System.out.println(bugger(Integer.parseInt(args[1])));
			//вывод - количество итераций перемножений всех разрядов числа, пока оно не станет однозначным
		}
		if(args[0].equals("7"))
		{
			//2 аргумент - строка
			if(args.length > 1)
			{
				System.out.println(toStarShorthand(args[1]));
			}
			else
			{
				System.out.println(toStarShorthand(""));
			}
			//вывод - звездная стенография
		}
		if(args[0].equals("8"))
		{
			//2 и 3 аргументы - строчки (ввод через "")
			System.out.println(doesRhyme(args[1], args[2]));
			//вывод - проверка, рифмуются ли 2 строки (в последнем слове все гласные совпадают)
		}
		if(args[0].equals("9"))
		{
			//2 и 3 аргументы - целые числа
			System.out.println(trouble(Long.parseLong(args[1]), Long.parseLong(args[2])));
			//вывод - повторяется ли какая-то цифра 3 раза подряд в первом числе и 2 раза во втором
		}
		if(args[0].equals("0"))
		{
			//2 аргумент - строка символов, 3 аргумент - открывающий и закрывающий книгу символ
			System.out.println(countUniqueBooks(args[1], args[2]));
			//вывод - количество уникальных символов в книгах
		}
	}
	
	
	//1 - форматирование эссе
	public static String BessieEssay(int N, int K, String essay)
	{
		String newEssay = "";
		int counter = 0;
		for(int numOfWord = 0; numOfWord < N; numOfWord++)
		{
			String word = "";
			for(int i = 0; i < essay.length(); i++)
			{
				if(essay.charAt(i) != ' ')
				{
					word += essay.charAt(i);
				}
				else
				{
					break;
				}
			}
			if(counter + word.length() <= K)
			{
				counter += word.length();
				newEssay += word + " ";
			}
			else
			{
				counter = word.length();
				newEssay += "\n" + word + " ";
				
			}
			essay = essay.substring(word.length());
			essay = essay.trim();
		}
		return newEssay;
	}
	
	//2 - группировка скобок
	public static String split(String str)
	{
		ArrayList<String> claster = new ArrayList<>();
		int open = 0;
		String element = "";
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == '(')
			{
				open++;
				element += "(";
			}
			if(str.charAt(i) == ')' && open != 0)
			{
				open--;
				element += ")";
			}
			if(open == 0 && element != "")
			{
				claster.add(new String(element));
				element = "";
			}
		}
		element = "[";
		for(int i = 0; i < claster.size(); i++)
		{
			element += claster.get(i);
			if(i != claster.size() - 1)
			{
				element += ",";
			}
		}
		element += "]";
		return element;
	}
	
	//3а - преобразование snake_case to CamelCase, 3b - преобразование CamelCase to snake_case
	public static String toCamelCase(String str)
	{
		String newStr = "";
		for(int i = 0; i < str.length(); i++)
		{
			if(i != 0)
			{
				if(str.charAt(i-1) == '_' && str.charAt(i) != '_')
				{
					newStr += Character.toUpperCase(str.charAt(i));
					continue;
				}
				if(str.charAt(i) != '_')
				{
					newStr += Character.toLowerCase(str.charAt(i));
				}
			}
			else
			{
				if(str.charAt(i) != '_')
				{
					newStr += Character.toLowerCase(str.charAt(i));
				}
			}
		}
		return newStr;
	}
	
	public static String toSnakeCase(String str)
	{
		String newStr = "";
		for(int i = 0; i < str.length(); i++)
		{
			if(Character.isUpperCase(str.charAt(i)))
			{
				newStr += "_" + Character.toLowerCase(str.charAt(i));
			}
			else
			{
				newStr += str.charAt(i);
			}
		}
		return newStr;
	}
	
	//4 - вычисление сверхурочной оплаты
	public static String overTime(String[] data)
	{
			double salary = 0;
			double start = Double.parseDouble(data[0]), end = Double.parseDouble(data[1]), payment = Double.parseDouble(data[2]), multiplier = Double.parseDouble(data[3]);
			if(start < 17 && end <= 17 && end > 9)
			{
				salary += (end - start) * payment;
			}
			if(start < 17 && (end > 17 || end <= 9) )
			{
				salary += (17 - start) * payment;
			}
			if(end <= 24 && end > 17)
			{
				salary += (end - 17) * payment * multiplier;
			}
			if(end <= 9)
			{
				salary += (7 + end) * payment * multiplier;
			}
			return String.format("$%.2f", salary);
	}
	
	//5 - индекс массы тела
	public static String BMI(String weight, String height)
	{
		double w = Double.parseDouble(weight.substring(0, weight.indexOf(" "))), h = Double.parseDouble(height.substring(0, height.indexOf(" "))), BMI;
		String result = "";
		if(weight.contains("pounds"))
		{
			w = w * 0.4536;
		}
		if(height.contains("inches"))
		{
			h = h * 0.0254;
		}
		BMI = w / (h * h);
		if(BMI < 18.45)
		{
			result = String.format("%.1f Underweight", BMI);
		}
		if(BMI >= 18.45 && BMI < 24.95)
		{
			result = String.format("%.1f Normal weight", BMI);
		}
		if(BMI > 24.95)
		{
			result = String.format("%.1f Overweight", BMI);
		}
		return result;
	}
	
	//6 число перемножений цифр в числе, пока оно не станет цифрой
	public static int bugger(int number)
	{
		int iterations = 0;
		while(number / 10 != 0)
		{
			iterations++;
			int newNumber = 1;
			while(number != 0)
			{
				newNumber = newNumber * (number % 10);
				number = number / 10;
			}				
			number = newNumber;
		}
		return iterations;
		
	}
	
	//7
	public static String toStarShorthand(String expression)
	{
		String star = "";
		char symbol = ' ';
		int count = 0;
		for(int i = 0; i < expression.length(); i++)
		{
			if(symbol != expression.charAt(i))
			{
				if(count > 1)
				{
					star += "*" + Integer.toString(count);
					
				}
				if(count == 0)
				{
					star += expression.charAt(i);
				}
				else
				{
					star += expression.charAt(i);
				}
				symbol = expression.charAt(i);
				count = 1;
				continue;
			}
			if(symbol == expression.charAt(i))
			{
				count++;
			}
			if(i == expression.length()-1 && count != 1)
			{
				star += "*" + Integer.toString(count);
			}
		}
		return star;
	}
	
	//8 рифмуются ли строки?
	public static boolean doesRhyme(String first, String second)
	{
		String word1 = "";
		String vowels1 = "";
		if(first.lastIndexOf(" ") != -1)
		{
			word1 = first.substring(first.lastIndexOf(" "));
		}
		else
		{
			word1 += first;
		}
		word1 = word1.toLowerCase();
		String word2 = "";
		String vowels2 = "";
		if(second.lastIndexOf(" ") != -1)
		{
			word2 = second.substring(second.lastIndexOf(" "));
		}
		else
		{
			word2 += second;
		}
		word2 = word2.toLowerCase();
		for(int i = 0; i < word1.length(); i++)
		{
			if(word1.charAt(i) == 'a' || word1.charAt(i) == 'e' || word1.charAt(i) == 'i' || word1.charAt(i) == 'o' || word1.charAt(i) == 'u' || word1.charAt(i) == 'y')
			{
				vowels1 += word1.charAt(i);
			}
		}
		for(int i = 0; i < word2.length(); i++)
		{
			if(word2.charAt(i) == 'a' || word2.charAt(i) == 'e' || word2.charAt(i) == 'i' || word2.charAt(i) == 'o' || word2.charAt(i) == 'u' || word2.charAt(i) == 'y')
			{
				vowels2 += word2.charAt(i);
			}
		}
		
		return vowels1.equals(vowels2);
	}
	
	//9
	public static boolean trouble(long a, long b)
	{
		String num1 = Long.toString(a);
		String num2 = Long.toString(b);
		boolean containSequence = false;
		for(int i = 0; i < 10; i++)
		{
			if(num1.contains(Integer.toString(i) + Integer.toString(i) + Integer.toString(i)) && num2.contains(Integer.toString(i) + Integer.toString(i)))
			{
				containSequence = true;
			}
		}
		return containSequence;
	}
	
	//10 - количество уникальных символов между "концами книги"
	public static int countUniqueBooks(String sequence, String bookEnd)
	{
		ArrayList<Character> symbols = new ArrayList<>();
		boolean opened = false;
		
		for(int i = 0; i < sequence.length(); i++)
		{
			if(sequence.charAt(i) == bookEnd.charAt(0))
			{
				if(i == sequence.lastIndexOf(bookEnd))
				{
					break;
				}
				opened = !opened;
				continue;
			}
			if(opened)
			{
				if(!symbols.contains(sequence.charAt(i)))
				{
					symbols.add(sequence.charAt(i));
				}
			}
		}
		return symbols.size();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}