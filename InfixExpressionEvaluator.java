
public class InfixExpressionEvaluator 
{
	public static double evaluateInfix(String infix, int[] values)
	{
		MyStack<String> operatorStack = new MyStack<>();
		MyStack<Integer> valueStack = new MyStack<>();

		for(int i = 0; i < values.length; ++i)
		{
			valueStack.push(values[i]);
		}

		String[] expression = infix.split("\\s+");

		for(int i = 0; i < expression.length; ++i)
		{
			String nextCharacter = expression[i];

			//			if(Character.isLetter(nextCharacter))
			//			{
			//				
			//			}
			if(nextCharacter.equals("^"))
			{
				operatorStack.push(nextCharacter);
			}
			if(nextCharacter.equals("+") || nextCharacter.equals("-") || nextCharacter.equals("*") || nextCharacter.equals("/"))
			{
				while(operatorStack.isEmpty() == false && hasPrecedence(expression[i], operatorStack.peek()))
				{
					String operator = operatorStack.pop();

					int firstNum = valueStack.pop();
					int secondNum = valueStack.pop();

					int newValue = doOperation(operator, firstNum, secondNum);

					valueStack.push(newValue);

					operatorStack.push(nextCharacter);
				}
			}
			if(nextCharacter.equals("("))
			{
				operatorStack.push(nextCharacter);
			}
			if(nextCharacter.equals(")"))
			{
				while(operatorStack.peek().equals("(") == false)
				{
					String operator = operatorStack.pop();

					int firstNum = valueStack.pop();
					int secondNum = valueStack.pop();

					int newValue = doOperation(operator, firstNum, secondNum);

					valueStack.push(newValue);

					operatorStack.pop();
				}
			}
		}
		int finalResult = valueStack.pop();
		
		return finalResult;
	}

	public static int doOperation(String sign, int a, int b)
	{
		int result = 0;

		if(sign.equals("+"))
		{
			result = a + b;
		}
		if(sign.equals("-"))
		{
			result = a - b;
		}
		if(sign.equals("*"))
		{
			result = a * b;
		}
		if(sign.equals("/"))
		{
			if(b != 0)
			{
				result = a / b;
			}
		}
		return result;
	}


	public static boolean hasPrecedence(String firstSign, String secondSign)
	{
		if(secondSign.equals("(") || secondSign.equals(")"))
		{
			return false;
		}

		if((firstSign.equals("*") || firstSign.equals("/")) && (secondSign.equals("+") || secondSign.equals("-")))
		{
			return false;
		}

		return true;
	}

	public static void main(String[] args)
	{	
		int[] values = {2,4,6};
		String infix = "10 + 2 * 6";

		System.out.println(evaluateInfix(infix, values));

	}
}
