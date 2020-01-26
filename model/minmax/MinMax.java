package model.minmax;

import model.tree.Tree;

public class MinMax
{
	protected int maxMatches;
	
	public MinMax(int maxMatches) 
	{
		this.maxMatches = maxMatches;
	}
	
	public float heuristique(boolean maximizingPlayer, int value)
	{
		if (maximizingPlayer)
		{
			if(value == 0)
			{
				return Float.POSITIVE_INFINITY;
			}
			else if (value == 1)
			{
				return Float.NEGATIVE_INFINITY;
			}
			else
				return maxMatches - value;
		}
		else
		{
			if(value == 0)
			{
				return Float.NEGATIVE_INFINITY;
			}
			else if (value == 1)
			{
				return Float.POSITIVE_INFINITY;
			}
			else
				return maxMatches - value;
		}
	}
	
	protected float minMax(Tree tree, boolean maximizingPlayer)
	{
		if (tree.getChildren().isEmpty())
		{
			return heuristique(maximizingPlayer, tree.getParent());
		}
		if (maximizingPlayer)
		{
			float value = Float.NEGATIVE_INFINITY;
			for (Tree child : tree.getChildren())
			{
				value = Math.max(value, minMax(child, !maximizingPlayer));
			}
			return value;
		}
		else
		{
			float value = Float.POSITIVE_INFINITY;
			for (Tree child : tree.getChildren())
			{
				value = Math.min(value, minMax(child, !maximizingPlayer));
			}
			return value;
		}
	}
	
	public Tree getBestChild(Tree tree)
	{
		Tree bestChild = tree.getChildren().get(0);	
		float minmax = minMax(bestChild, false);
				
		for(int i = 1; i < tree.getChildren().size(); i++)
		{
			Tree child = tree.getChildren().get(i);
			float currentMinMax = minMax(child, false);
			if (currentMinMax > minmax)
			{
				minmax = currentMinMax;
				bestChild = child;
			}
		}
		
		return bestChild;
	}
}
