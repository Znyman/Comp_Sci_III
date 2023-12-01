/**
 * Project03
 * @author Zachery Nyman
 * 21 April 2017
 */

package project03;

import java.util.Random;

public class Forest<E>
{
	private int numRows, numColumns;
	private int[][] grid;
	float vegetationProbability, randomfloat;
	private Random randomNumber = new Random();
	
	public Forest(int height, int width, float vegProbability)
	{
		numRows = height;
		numColumns = width;
		grid = new int[numRows+2][numColumns+2];//+2 is for dummy rows
		vegetationProbability = vegProbability;
		
		for (int row = 1; row <= numRows; row++)
    	{
    		for (int col = 1; col <= numColumns; col++)
    		{
    			if (vegetationProbability == 1)
    			{
    				grid[row][col] = 1;//vegetation
    				
    			}
    			else if(vegetationProbability == 0)
    			{
    				grid[row][col] = 0;//dry land
    			}
    			else
    			{
    				randomfloat = randomNumber.nextFloat();
    				
    				if(randomfloat > vegetationProbability)
    				{
    					grid[row][col] = 0;//dry land
    				}
    				else if(randomfloat <= vegetationProbability)
    				{
    					grid[row][col] = 1;//vegetation
    				}
    			}
    		}
    	}
	}
	
	public int getHeight()
	{
		return numRows;
	}
	
	public int getWidth()
	{
		return numColumns;
	}
	
	public boolean DepthFirstSearch()
	{
		Stack<E> cellsToExplore = new LinkedListStack<>();
		
		stackCheckTopRow(grid, cellsToExplore);
		
		while(cellsToExplore.size() != 0)
		{
			Cell<E> currentCell = (Cell<E>) cellsToExplore.pop();
			grid[(int) currentCell.getX()][(int) currentCell.getY()] = 2;
			
			if((int)currentCell.getX() == getHeight())
			{
				return true;
			}
			if(checkAbove(currentCell))
			{
				cellsToExplore.push((E)new Cell((int)currentCell.getX(), (int)currentCell.getY()-1));
			}
			if(checkRight(currentCell))
			{
				cellsToExplore.push((E)new Cell((int)currentCell.getX()+1, (int)currentCell.getY()));
			}
			if(checkLeft(currentCell))
			{
				cellsToExplore.push((E)new Cell((int)currentCell.getX()-1, (int)currentCell.getY()));
			}
			if(checkBelow(currentCell))
			{
				cellsToExplore.push((E)new Cell((int)currentCell.getX(), (int)currentCell.getY()+1));
			}
		}
		return false;
	}
	
	public boolean BreadthFirstSearch()
	{
		Queue<E> cellsToExplore = new LinkedListQueue<>();
		
		queueCheckTopRow(grid, cellsToExplore);
		
		while(cellsToExplore.size() != 0)
		{
			Cell<E> currentCell = (Cell<E>) cellsToExplore.dequeue();
			grid[(int) currentCell.getX()][(int) currentCell.getY()] = 2;
			
			if((int)currentCell.getX() == getHeight())
			{
				return true;
			}
			if(checkAbove(currentCell))
			{
				cellsToExplore.enqueue((E)new Cell((int)currentCell.getX(), (int)currentCell.getY()-1));
			}
			if(checkRight(currentCell))
			{
				cellsToExplore.enqueue((E)new Cell((int)currentCell.getX()+1, (int)currentCell.getY()));
			}
			if(checkLeft(currentCell))
			{
				cellsToExplore.enqueue((E)new Cell((int)currentCell.getX()-1, (int)currentCell.getY()));
			}
			if(checkBelow(currentCell))
			{
				cellsToExplore.enqueue((E)new Cell((int)currentCell.getX(), (int)currentCell.getY()+1));
			}
		}
		return false;
	}
	
	private void stackCheckTopRow(int[][] theGrid, Stack<E> theStack)
	{
		for(int row = 1; row == 1; row++)
    	{
    		for(int col = 1; col <= numColumns; col++)
    		{
    			if(theGrid[row][col] == 1)
    			{
    				theStack.push((E) new Cell(row, col));
    			}
    		}
    	}
	}
	
	private void queueCheckTopRow(int[][] theGrid, Queue<E> theQueue)
	{
		for(int row = 1; row == 1; row++)
    	{
    		for(int col = 1; col <= numColumns; col++)
    		{
    			if(theGrid[row][col] == 1)
    			{
    				theQueue.enqueue((E) new Cell(row, col));
    			}
    		}
    	}
	}
	
	private boolean checkAbove(Cell<E> thisCell)
	{
		return grid[(int)thisCell.getX()][(int)thisCell.getY()-1] == 1 && grid[(int)thisCell.getX()][(int)thisCell.getY()-1] != 2;
	}
	
	private boolean checkRight(Cell<E> thisCell)
	{
		return grid[(int)thisCell.getX()+1][(int)thisCell.getY()] == 1 && grid[(int)thisCell.getX()+1][(int)thisCell.getY()] != 2;
	}
	
	private boolean checkLeft(Cell<E> thisCell)
	{
		return grid[(int)thisCell.getX()-1][(int)thisCell.getY()] == 1 && grid[(int)thisCell.getX()-1][(int)thisCell.getY()] != 2;
	}
	
	private boolean checkBelow(Cell<E> thisCell)
	{
		return grid[(int)thisCell.getX()][(int)thisCell.getY()+1] == 1 && grid[(int)thisCell.getX()][(int)thisCell.getY()+1] != 2;
	}
	
	public String toString()
	{
		
		StringBuilder sb = new StringBuilder();
		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[row].length; col++)
			{
				sb.append(grid[row][col] + ", ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private class Cell<E>
	{
		private E x, y;
		
		public Cell(E thisX, E thisY)
		{
			x = thisX;
			y = thisY;
		}
		
		public E getX()
		{
			return x;
		}
		
		public E getY()
		{
			return y;
		}
		
		public String toString()
		{
			return x + " " + y;
		}
	}
	
	private class LinkedListStack<E> implements Stack<E> 
	{
		private DLinkedList<E> theStack;
		
		public LinkedListStack()
		{
			theStack = new DLinkedList<>();
		}

		@Override
		public void push(E v) 
		{
			theStack.insertAtHead(v);
		}

		
		public E pop() 
		{
			return theStack.removeAtHead();
		}

		
		public E top() 
		{
			return theStack.getFirst();
		}

		@Override
		public int size()
		{
			return theStack.getSize();
		}
		
		public String toString()
		{
			return theStack.toString();
		}
	}
	
	private class LinkedListQueue<E> implements Queue<E> 
	{
		private DLinkedList<E> theQ;
		
		public LinkedListQueue()
		{
			theQ = new DLinkedList<>();
		}

		@Override
		public void enqueue(E v) 
		{			
			theQ.insertAtTail(v);	
		}

		@Override
		public E dequeue() 
		{
			if(theQ.getSize() == 0)
			{
				throw new IllegalStateException("q is empty");
			}
			return theQ.removeAtHead();
		}

		@Override
		public E front()
		{
			if(theQ.getSize() == 0)
			{
				throw new IllegalStateException("q is empty");
			}		
			return theQ.getFirst();
		}

		@Override
		public int size()
		{
			return theQ.getSize();
		}

	}

}


