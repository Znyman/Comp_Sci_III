import java.util.Iterator;

public class BinaryTree<E> implements Iterable<E>
{
	private Node<E> root;
	int size;

	public BinaryTree()
	{
		root = null;
		size = 0;
	}
	
	public Position<E> addRoot(E v)
	{
		if(root != null)
		{
			throw new IllegalStateException("Tree is not empty");
		}
		root = new Node<>(v, null);
		
		return root;
	}
	
	private void recursiveToString(Node<E> r, StringBuilder sb, int level)
	{
		if(r != null)
		{
			for(int i=0; i < level; i++)
			{
				sb.append(" ");
			}
			sb.append(r + "\n");
			recursiveToString(r.left, sb, level+2);
			recursiveToString(r.right, sb, level+2);
		}
	}
	
	private int recursiveHeight(Node<E> r)
	{
		if(r == null)
		{
			return -1;
		}
		return 1 + Math.max(recursiveHeight(r.left), recursiveHeight(r.right));
	}
	
	public int height()
	{
		return recursiveHeight(root);
	}
	
	public int depth(Position<E> p)
	{
		Node<E> n = validatePosition(p);
		int depth = 0;
		while(n != root)
		{
			depth++;
			n = n.parent;
		}
		return depth;
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		recursiveToString(root, sb, 0);
		return sb.toString();
	}
	private Node<E> validatePosition(Position<E> p)
	{
		if(p instanceof Node)
		{
			return (Node<E>) p;
		}
		throw new IllegalStateException("Position is invalid");
	}
	public Position<E> addLeft(E v, Position<E> p)
	{
		Node<E> n = validatePosition(p);
		if(n.left != null)
		{
			throw new IllegalStateException("Left already exists");
		}
		n.left = new Node<>(v, n);
		
		return n.left;
	}
	
	public Position<E> addRight(E v, Position<E> p)
	{
		Node<E> n = validatePosition(p);
		if(n.right != null)
		{
			throw new IllegalStateException("Right already exists");
		}
		n.right = new Node<>(v, n);
		
		return n.right;
	}
	
	public Position<E> left(Position<E> p)
	{
		Node<E> n = validatePosition(p);
		return n.left;
	}
	
	public Position<E> right(Position<E> p)
	{
		Node<E> n = validatePosition(p);
		return n.right;
	}
	
	public Position<E> parent(Position<E> p)
	{
		Node<E> n = validatePosition(p);
		return n.parent;
	}
	
	public Iterator<E> iterator() 
	{
		//Snapshot
		//Create an arraylist l 
		//Use a private recurive method to traverse the tree in a pre-order fashion
		//insert the values in the array in that order
		//return l.iterator();
		return new BinaryTreeIteratorPre();
	}

	
	private class BinaryTreeIteratorPre implements Iterator<E>
	{	
		private Node<E> cursor;
		
		public BinaryTreeIteratorPre()
		{
			cursor = root;
		}
		public boolean hasNext() 
		{
			return cursor != null;
		}

		public E next() 
		{
			E value = cursor.value;
			//Mover cursor to the next node in a preorder traversal
			if(cursor.left != null)
			{
				cursor = cursor.left;
			}
			else if(cursor.right != null)
			{
				cursor = cursor.right;
			}
			//it's a lfea
			//Search for an ancestor that has a right child that is not cursor
			else
			{
				while(cursor.parent != null && (cursor.parent.right == null || cursor.parent.right == cursor))
				{
					cursor = cursor.parent;
				}
				
				//check which case stopped the loop
				//If cursor.parent is null then I am done iterating
				if(cursor.parent == null)
				{
					cursor = null;
				}
				else
				{
					cursor = cursor.parent.right;
				}
			}
			return value;
		}	
	}
	
	private static class Node<T> implements Position<T>
	{
		private T value;
		private Node<T> parent;
		private Node<T> left;
		private Node<T> right;
		
		public Node(T v, Node<T> p)
		{
			value = v;
			parent = p;
			left = right = null;
		}
		
		public T getValue()
		{
			return value;
		}
		public String toString()
		{
			return value.toString();
		}
		
	}



}
