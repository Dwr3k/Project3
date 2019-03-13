import java.util.EmptyStackException;

public class MyStack<E> implements StackInterface<E>
{

	public class Node<E>
	{
		E data;
		Node<E> next;
		
		public Node(E value)
		{
			data = value;
		}
		
		public Node(E value, Node<E> nextNode)
		{
			data = value;
			next = nextNode;
		}
		
		public E getData()
		{
			return data;
		}
		
		public void setData(E value)
		{
			data = value;
		}
		
		public Node<E> getNextNode()
		{
			return next;
		}
		
		public void setNextNode(Node<E> node)
		{
			next = node;
		}
	}
	
	Node<E> topStack;
	
	@Override
	public void push(E newEntry) 
	{
		Node<E> newNode = new Node<E>(newEntry);
		newNode.setNextNode(topStack);
		topStack = newNode;
	}

	@Override
	public E pop() 
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		E target = topStack.getData();
		topStack = topStack.getNextNode();
		return target;
	}

	@Override
	public E peek() 
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return topStack.getData();
	}

	@Override
	public boolean isEmpty() 
	{
		if(topStack == null)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public void clear() 
	{
		topStack = null;
	}
	
	public String toString()
	{
		String statement = "Top: ";
		
		Node<E> stackNode = topStack;
		
		while(stackNode != null)
		{
			statement = statement.concat(stackNode.getData() + " | ");
			stackNode = stackNode.getNextNode();
		}
		
		return statement;
	}
	
	public static void main(String[] args)
	{
//		MyStack<Integer> test = new MyStack<>();
//		
//		int test1 = 1;
//		int test2 = 2;
//		int test3 = 3;
//		
//		test.push(test1);
//		test.push(test2);
//		test.push(test3);
//		
//		System.out.println(test.toString());
		
		char operand = '+';
		char operand2 = '*';
		
		
	}
}
