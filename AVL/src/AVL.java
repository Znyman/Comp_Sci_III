import java.util.ArrayList;
import java.util.Iterator;

public class AVL<E extends Comparable<E>> implements Set<E>
{	
	private Node<E> root;
	private int size;
	
	public AVL()
	{
		root = null;
		size = 0;
	}
	
	
	private void populateSnapShotInOrder(Node<E> r, ArrayList<E> snapShot)
	{
		if(r == null)
		{
			return;
		}
		populateSnapShotInOrder(r.left, snapShot);
		snapShot.add(r.value);
		populateSnapShotInOrder(r.right, snapShot);
	}
	
	
	public Iterator<E> iterator() 
	{
		ArrayList<E> snapShot = new ArrayList<>();
		populateSnapShotInOrder(root, snapShot);
		return snapShot.iterator();
	}

	/**
	 * 
	 * @param v : value to search for
	 * @param r is the root of the subtree we are searching in
	 * @return three cases: null if tree is empty, if the value is contained then return the node, or returns the parent node where the value
	 * would have been a child
	 */
	private Node<E> findNode(E v, Node<E> r)
	{
		if(r == null)
		{
			return null;
		}
		
		if(r.value.compareTo(v) == 0)
		{
			return r;
		}
		
		if(r.right != null && r.value.compareTo(v) < 0)
		{
			return findNode(v, r.right);
		}
		
		if(r.left != null && r.value.compareTo(v) > 0)
		{
			return findNode(v, r.left);
		}
		
		//We are at a leaf and the value is not there
		//Return the parent where the node would have been
		return r;

	}
	
	private int nodeHeight(Node<E> n)
	{
		if(n == null)
		{
			return -1;
		}
		return n.height;
	}
	
	/**
	 * 
	 * @param n node with the assumption that left and right subtrees have correct height
	 * @return correct height of n
	 */
	private int recalculateHeight(Node<E> n)
	{
		return 1 + Math.max(nodeHeight(n.left), nodeHeight(n.right));
	}
	
	/**
	 * 
	 * @param v value we are inserting
	 * @param r the root of the subtree where v is inserted
	 * @return the root of the subtree AFTER insert is complete 
	 * (Note that the root of the subtree may change after insert) 
	 */
	private Node<E> add(E v, Node<E> r)
	{
		if(r == null)
		{
			size++;
			return new Node<>(v);
		}
		if(v.equals(r.value))
		{
			return r;
		}
		if(v.compareTo(r.value) < 0)
		{
			r.left = add(v, r.left);
			r = rebalanceLeft(r);
			r.height = recalculateHeight(r);
		}
		else
		{
			r.right = add(v, r.right);
			r = rebalanceRight(r);
			r.height = recalculateHeight(r);
		}
		return r;
	}
	
	/*
	 *        a             b
	 *       / \           / \
	 *      b   t3  ===>  t1  a
	 *      /\                /\
	 *     t1 t2             t2 t3
	 */
	private Node<E> rotateRight(Node<E> a)
	{
		Node<E> b = a.left;
		Node<E> t2 = b.right;
		b.right = a;
		a.left = t2;
		
		//We MUST recacluate height for a before b
		a.height = recalculateHeight(a);
		b.height = recalculateHeight(b);
		
		return b;
	}

	/*
	 *        a             b
	 *       / \           / \
	 *      b   t3  <===  t1  a
	 *      /\                /\
	 *     t1 t2             t2 t3
	 */
	private Node<E> rotateLeft(Node<E> b)
	{
		Node<E> a = b.right;
		Node<E> t2 = a.left;
		a.left = b;
		b.right = t2;
		
		//We MUST recacluate height for b before a
		b.height = recalculateHeight(b);
		a.height = recalculateHeight(a);
		
		return a;
	}

	/**
	 * Rebalance the tree rooted at z assuming that left is the longer side if balance is needed
	 * @param z the root of the subtree
	 * @return the root of the subtree AFTER rebalance 
	 * (Note that root of the subtree may change after rebalance)
	 */
	private Node<E> rebalanceLeft(Node<E> z)
	{
		if(nodeHeight(z.left) - nodeHeight(z.right) > 1)
		{
			Node<E> y = z.left;
			//Case 1: x is left of y
			if(nodeHeight(y.left) > nodeHeight(y.right))
			{
				//left left
				z = rotateRight(z);
			}
			else
			{
				//left right
				y = rotateLeft(y);
				z = rotateRight(z);
			}
		}
		return z;
	}

	private Node<E> rebalanceRight(Node<E> z)
	{
		if(nodeHeight(z.right) - nodeHeight(z.left) > 1)
		{
			Node<E> y = z.right;
			//Case 1: x is right of y
			if(nodeHeight(y.right) > nodeHeight(y.left))
			{
				//right right
				z = rotateLeft(z);
			}
			else
			{
				//right left
				y = rotateRight(y);
				z = rotateLeft(z);
			}
		}
		return z;
	}

	public boolean add(E v) 
	{
		int oldSize = size;
		root = add(v, root);
		return oldSize < size;
	}

	@Override
	public boolean remove(E v) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(E v) 
	{
		Node<E> n = findNode(v, root);
		return n != null && n.value.equals(v);
	}

	public void addAll(Set<E> other)
	{
		Iterator<E> it = other.iterator();
		while(it.hasNext())
		{
			add(it.next());
		}
	}

	public void retainAll(Set<E> other) 
	{		
		Iterator<E> it = iterator();
		while(it.hasNext())
		{
			E temp = it.next();
			if(!other.contains(temp))
			{
				//CANNOT use the remove from Set because that would be unsafe
				//(removing from a set while iterating over its element)
				it.remove();
			}
		}
	}
	
	private void toString(StringBuilder sb, Node<E> r, int level)
	{
		if(r == null)
		{
			return;
		}
		for(int i=0; i < level; i++)
		{
			sb.append(" ");
		}
		sb.append("(" + r.height + ") " + r.value + "\n");
		toString(sb, r.left, level+2);
		toString(sb, r.right, level+2);
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		toString(sb, root, 0);
		return sb.toString();
	}

	public void removeAll(Set<E> other)
	{
		Iterator<E> it = other.iterator();
		while(it.hasNext())
		{
			E temp = it.next();
			if(contains(temp))
			{
				remove(temp);
			}
		}
	}
	private static class Node<T> implements Position<T>
	{
		private T value;
		private Node<T> left;
		private Node<T> right;
		private int height;
		
		public Node(T v)
		{
			value = v;
			left = null;
			right = null;
			height = 0;
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
