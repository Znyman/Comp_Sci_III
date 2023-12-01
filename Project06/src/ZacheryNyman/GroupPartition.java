package ZacheryNyman;

public interface GroupPartition<E>
{
	public void createGroup(E key);
	public E find(E key);
	public void combineGroup(E key1, E key2);
}
