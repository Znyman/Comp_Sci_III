/**
 * Project 01
 * @author Zachery Nyman
 * 07 April 2017
 */
public class GameCharacter
{
	private String name;
	
	GameCharacter(String n)
	{
		name = n;
	}
	
	public String toString()
	{
		return name;
	}
	
	public boolean equals(Object otherObject)//overriding
	{
		if (otherObject == null)
		{
			return false;
		}
		else if (getClass() != otherObject.getClass())
		{
			return false;
		}
		else
		{
			GameCharacter otherCharacter = (GameCharacter)otherObject;
			return (sameName(otherCharacter));
		}
	}
	
	public boolean sameName(GameCharacter otherCharacter)
    {
        return name.equalsIgnoreCase(otherCharacter.name);
    }
	
}
