import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;


import java.util.Random;
import java.math.BigInteger;

public class HashMap<K, V> implements Map<K, V> 
{
	private ArrayList<LinkedList<MapEntry<K,V>>> map;
	private int N;
	private int size;
	
	private int p;
	private int a;
	private int b;

	public HashMap()
	{
		initTable(31);
		size = 0;
	}
	
	public String toString()
	{
		int maxBucketSize = 0;
		int numEmpty = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < map.size(); i++)
		{
			if(map.get(i).size() == 0)
			{
				numEmpty ++;
			}
			if(maxBucketSize < map.get(i).size())
			{
				maxBucketSize = map.get(i).size();
			}
			sb.append(i + ": [");
			for(MapEntry<K, V> entry : map.get(i))
			{
				sb.append(entry.toString() + " ");
			}
			sb.append("]\n");
		}
		return sb.toString() + "\nMax Bucket size: " + maxBucketSize + "\nOccupancy: " + ((double)map.size() - numEmpty)/(double)map.size();
	}
	
	private LinkedList<MapEntry<K, V>> bucket(K key)
	{
		 return map.get((Math.abs((a * key.hashCode() + b)) % p) % N);
	}
	
	private void initTable(int bucketCount)
	{
		N = ((new BigInteger(String.valueOf(bucketCount)).nextProbablePrime()).intValue());		
		p = ((new BigInteger(String.valueOf(N)).nextProbablePrime()).intValue());
		
		Random r = new Random();
		a = r.nextInt(p-1) + 1;
		b = r.nextInt(p);
		
		map = new ArrayList<>();
		
		for(int i =0; i < N; i++)
		{
			map.add(new LinkedList<>());
		}
	
	}
	private void	 expandIfNeeded()
	{
		if((double)size / N > 0.75)
		{
			Iterable<Entry<K, V>> snapShot = this.entrySet();
			initTable(N * 2);
			for(Entry<K, V> entry : snapShot)
			{
				this.put(entry.getKey(), entry.getValue());
			}
			
		}
	}

	public V put(K key, V value) 
	{
		LinkedList<MapEntry<K, V>> bucket = bucket(key);
		for(MapEntry<K, V> e : bucket)
		{
			if(e.key.equals(key))
			{
				V old = e.value;
				e.value = value;
				return old;
			}
		}
		
		MapEntry<K, V> newEntry = new MapEntry(key, value);
		bucket.add(newEntry);
		size++;
		expandIfNeeded();
		return null;
	}

	public V set(K key, V value) 
	{
		LinkedList<MapEntry<K, V>> bucket = bucket(key);
		for(MapEntry<K, V> entry : bucket)
		{
			if(entry.key.equals(key))
			{
				V old = entry.value;
				entry.value = value;
				return old;
			}
		}
		return null;
	}

	public V get(K key) 
	{
		LinkedList<MapEntry<K, V>> bucket = bucket(key);
		for(int i=0; i < bucket.size(); i++)
		{
			if(bucket.get(i).key.equals(key))
			{
				return bucket.get(i).value;
			}
		}
		return null;
	}

	public V remove(K key) 
	{
		LinkedList<MapEntry<K, V>> bucket = bucket(key);
		Iterator<MapEntry<K, V>> it = bucket.iterator();
		while(it.hasNext())
		{
			MapEntry<K, V> e = it.next();
			
			if(e.key.equals(key))
			{
				V valueToRemove = e.value;
				it.remove();
				size--;
				return valueToRemove;
			}
		}
		return null;
	}

	public int size() 
	{
		return size;
	}

	public boolean isEmpty() 
	{
		return size == 0;
	}

	public Iterable<K> keySet() 
	{
		ArrayList<K> snapShotOfKeys = new ArrayList<>(); 
		for(LinkedList<MapEntry<K, V>> bucket : map)
		{
			for(MapEntry<K, V> e : bucket)
			{
				snapShotOfKeys.add(e.key);
			}
		}
		return snapShotOfKeys;
	}

	public Iterable<V> valueSet() 
	{
		ArrayList<V> snapShotOfKeys = new ArrayList<>(); 
		for(LinkedList<MapEntry<K, V>> bucket : map)
		{
			for(MapEntry<K, V> e : bucket)
			{
				snapShotOfKeys.add(e.value);
			}
		}
		return snapShotOfKeys;
	}

	public Iterable<Entry<K, V>> entrySet() 
	{
		ArrayList<Entry<K, V>> snapShotOfKeys = new ArrayList<>(); 
		for(LinkedList<MapEntry<K, V>> bucket : map)
		{
			for(MapEntry<K, V> e : bucket)
			{
				snapShotOfKeys.add(e);
			}
		}
		return snapShotOfKeys;
	}
	
	private static class MapEntry<K, V> implements Entry<K, V>
	{
		private K key;
		private V value;
		
		public MapEntry(K k, V v)
		{
			key = k;
			value = v;
		}
		public K getKey() 
		{
			return key;
		}

		@Override
		public V getValue() 
		{
			return value;
		}

		public V setValue(V v) 
		{
			V old = value;
			value = v;
			return old;
		}	
		
		public String toString()
		{
			return "(" + key + ", " + value +")";
		}
	}

}
