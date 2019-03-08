import java.util.EmptyStackException;

public class MyStack<E> implements StackInterface<E>
{
	public class Node<E>
	{
		private Node<E> next;
		private E data;

		public Node(E entry)
		{
			data = entry;
			next = null;
		}

		public Node(E entry, Node<E> nextNode)
		{
			data = entry;
			next = nextNode;
		}

		public Node<E> getNextNode()
		{
			return next;
		}

		public void setNextNode(Node<E> node)
		{
			next = node;
		}

		public E getData()
		{
			return data;
		}

		public void setData(E value)
		{
			data = value;
		}
	}

	Node<E> topOfStack;

	@Override
	public void push(E newEntry) 
	{
		Node<E> newNode = new Node<E>(newEntry);
		newNode.setNextNode(topOfStack);
		topOfStack = newNode;
	}

	@Override
	public E pop() 
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}

		E value = topOfStack.getData();
		topOfStack = topOfStack.getNextNode();
		return value;
	}

	@Override
	public E peek() 
	{
		if(isEmpty())
		{
			throw new EmptyStackException(); 
		}

		return topOfStack.getData();
	}

	@Override
	public boolean isEmpty() 
	{
		if(topOfStack.getData() == null)
		{
			return true;
		}

		return false;
	}

	@Override
	public void clear() 
	{
		topOfStack = null;
	}

}
