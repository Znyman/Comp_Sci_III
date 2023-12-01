package ZacheryNyman;

import java.util.ArrayList;
import java.util.LinkedList;


public class ZachImplementation<E> implements GroupPartition<E>
{
	ArrayList<LinkedList<Node<E>>> dataStructure;
	ArrayList<LinkedList<Node<E>>> groupsList;
	int index = 0;
	
	public ZachImplementation()
	{
		dataStructure = new ArrayList<>();
	}
	
	@Override
	public void createGroup(E key)
	{
		dataStructure.add(new LinkedList());
		dataStructure.get(index).add(new Node<E>(key));
		index++;
	}

	@Override
	public E find(E key)
	{
		for(LinkedList<Node<E>> list : dataStructure)
		{
			for(Node<E> node : list)
			{
				if(node.value.equals(key))
				{
					Node<E> representative = findRepresentative(node);
					return representative.value;
				}
			}
		}
		return null;
	}

	@Override
	public void combineGroup(E key1, E key2)
	{
		E representativeA = find(key1);
		E representativeB = find(key2);
		
		Node<E> representativeANode = getNode(key1);
		Node<E> representativeBNode = getNode(key2);
		
		if(representativeA.equals(representativeB))
		{
			return;
		}
		if(representativeANode.rank < representativeBNode.rank)
		{
			representativeANode.parent = representativeBNode;
		}
		else if(representativeANode.rank > representativeBNode.rank)
		{
			representativeBNode.parent = representativeANode;
		}
		else if(representativeANode.rank == representativeBNode.rank)
		{
			representativeANode.parent = representativeBNode;
			representativeBNode.rank++;
		}
	}
	
	private Node<E> findRepresentative(Node<E> n)
	{
		Node<E> temp = n;
		while(!temp.parent.equals(temp))
		{
			temp = temp.parent;
		}
		return temp;
	}
	
	public Node<E> getNode(E key)
	{
		for(LinkedList<Node<E>> list : dataStructure)
		{
			for(Node<E> node : list)
			{
				if(node.value.equals(key))
				{
					Node<E> representative = findRepresentative(node);
					return representative;
				}
			}
		}
		return null;
	}
	
	public ArrayList<LinkedList<Node<E>>> getMembers()
	{
		index = 0;
		groupsList = new ArrayList<LinkedList<Node<E>>>();
		for(LinkedList<Node<E>> list : dataStructure)
		{
			for(Node<E> node : list)
			{
				if(node.parent.equals(node) && !groupsList.contains(node))
				{
					groupsList.add(new LinkedList<Node<E>>());
					groupsList.get(index).add(node);
					index++;
				}
				for(int i = 0; i < groupsList.size(); i++)
				{
					if(findRepresentative(node).equals(groupsList.get(i).element()) && !node.value.equals(find(node.value)))
					{
						groupsList.get(i).add(node);
					}
				}
				
			}
		}
		return groupsList;
	}
	
	public int getMembersSize()
	{
		return groupsList.size();
	}
	
	public int getSize()
	{
		return dataStructure.size();
	}
	
	public String toString()
	{
		return dataStructure.toString();
	}
	
	private class Node<T>
	{
		private E value;
		private int rank;
		private Node<T> parent;
		
		public Node(E v)
		{
			value = v;
			parent = this;
			rank = 0;
		}
		
		public String toString()
		{
			return value.toString();
		}
		
		public String getParent()
		{
			return parent.value.toString();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
