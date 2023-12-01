
public class Pair<E, T>//accepts two different types
{
	private E value1;
	private T value2;
	
	public Pair(E v1, T v2)
	{
		value1 = v1;
		value2= v2;
	}

	public E getValue1() {
		return value1;
	}

	public void setValue1(E value1) {
		this.value1 = value1;
	}

	public T getValue2() {
		return value2;
	}

	public void setValue2(T value2) {
		this.value2 = value2;
	}
	
	public String toString()
	{
		return value1.toString() + " " + value2.toString();
	}
}
