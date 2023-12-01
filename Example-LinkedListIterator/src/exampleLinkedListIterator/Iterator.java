package exampleLinkedListIterator;
public interface Iterator<E>
{
	//return true if there are more values to iterate over
	public boolean hasNext();
	
	//Get the next value
	public E next();
	
	//Remove the last element retrieved
	//Throws expcetion if no element has been retrieved
	public void remove();
	

}
