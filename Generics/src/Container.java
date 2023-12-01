
public class Container<E>//Can be any capital letter you want
{
	private E value;
	
	public Container(E v)
	{
		value = v;
	}
	
	public E getValue()
	{
		return value;
	}
	
	public void setValue(E newValue)
	{
		value = newValue;
	}
	
	public String toString()
	{
		return value.toString();
	}
	
}
