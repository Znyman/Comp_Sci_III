package ZacheryNyman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class UnionFindForest<E> implements GroupPartition<E>
{
	private HashMap<E, Node<E>> hashMap;
	private HashMap<E, ArrayList<E>> groupsMap = new HashMap<>();
	
	public UnionFindForest()
	{
		 hashMap = new HashMap<>();
	}
	
	@Override
	public void createGroup(E key)
	{
		hashMap.put(key, new Node<E>(key));
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
			representativeBNode.parent = representativeANode;
			representativeANode.rank++;
		}
	}
	
	@Override
	public E find(E key)
	{
		Node<E> node = findRepresentative((Node<E>) hashMap.get((E)key));
		return node.value;
	}
	
	private Node<E> findRepresentative(Node<E> n)
	{
		if(n.parent.equals(n))
		{
			return (Node<E>) n;
		}
		else
		{
			n.parent = findRepresentative(n.parent);
			return (Node<E>) n.parent;
		}
	}
	
	public int getNumberOfGroups()
	{
		return getRepresentatives(hashMap.values()).size();
	}
	
	public ArrayList<E> getGroupLeaders()
	{
		return getRepresentatives(hashMap.values());
	}
	
	private ArrayList<E> getRepresentatives(Collection<Node<E>> values)
	{
		Iterator<Node<E>> it = values.iterator();
		ArrayList<E> listRepresentatives = new ArrayList<>();
		while(it.hasNext())
		{
			Node<E> node = it.next();
			Node<E> representative = findRepresentative(node);
			if(!(listRepresentatives.contains(representative.value)))
			{
				listRepresentatives.add(representative.value);
			}
		}
		return listRepresentatives;
	}
	
	private Node<E> getNode(E key)
	{
		return findRepresentative((Node<E>) hashMap.get(key));
	}
	
	public int getSize()
	{
		return hashMap.size();
	}
	
	public int getMembersSize()
	{
		return groupsMap.size();
	}
	
	public HashMap<E, ArrayList<E>> getMembers()
	{
		for(Node<E> node : hashMap.values())
		{
			if(node.parent.equals(node))
			{
				groupsMap.put(node.value, new ArrayList<E>());
			}
		}
		for(Node<E> node : hashMap.values())
		{
			if(groupsMap.containsKey(node.parent.value))
			{
				groupsMap.get(node.parent.value).add(node.value);
			}
		}
		return groupsMap;
	}
	
	public String toString()
	{
		return hashMap.toString();
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
