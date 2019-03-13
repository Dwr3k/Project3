
public class InfixExpressionEvaluator 
{
	public static double evaluateInfix(String infix, int[] values)
	{
		MyStack<String> operatorStack = new MyStack<>();
		MyStack<String> valueStack = new MyStack<>();
		
		String[] expression = infix.split("\\s+");
		char[] charExpression = new char[expression.length];
		
		int i = 0;
		
		for(i = 0; i < expression.length; ++i)
		{
			charExpression[i] = expression[i].charAt(0);
			//System.out.println(charExpression[i]);
		}
		
		i = 0;
		
		while(i != charExpression.length)
		{
			char nextCharacter = charExpression[i];
			
			if(Character.isLetter(nextCharacter))
			{
				
			}
			if(nextCharacter == '^')
			{
				System.out.println("Found " + nextCharacter);
			}
			if(nextCharacter == '+' || nextCharacter == '-' || nextCharacter == '*' || nextCharacter == '/' && (hasPrecedence()))
			{
				
			}
			if(nextCharacter == '(')
			{
				
			}
			if(nextCharacter == ')')
			{
				
			}
			
			++i;
		}
		
		return 0;
	}
	
	public double doOperation(char sign, int a, int b)
	{
		double result = 0;
		
		if(sign == '+')
		{
			result = a + b;
		}
		if(sign == '-')
		{
			result = a - b;
		}
		if(sign == '*')
		{
			result = a * b;
		}
		if(sign == '/')
		{
			if(b != 0)
			{
				result = a / b;
			}
		}
		return result;
	}
	
	
	public boolean hasPrecedence(char firstSign, char secondSign)
	{
		if(secondSign == '(' || secondSign == ')')
		{
			return false;
		}
		
		if((firstSign == '*' || firstSign == '/') && (secondSign == '+' || secondSign == '-'))
		{
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{	
		int[] values = {2,4,6};
		String infix = "a * b + c";
		
		evaluateInfix(infix, values);
		
		
		
		
		
		
		
		
		
		
	}
}
