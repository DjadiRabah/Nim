package model.player;

import model.minmax.MinMax;
import model.tree.Tree;

public class IA implements Player 
{
	protected int max;
	protected Tree tree;
	
	public IA(int depth, int max) 
	{
		this.max = max;
		tree = createTree(depth, max);
	}
	
	protected Tree createTree(int currentDepth, int currentMatches)
	{
		if ((currentDepth == 0) || (currentMatches == 0))
		{
			return new Tree(currentMatches);
		}
		
		Tree tree =  new Tree(currentMatches);
		for(int i = 1; i <= 3; i++)
		{
			if (currentMatches - i >= 0)
			{
				tree.addChild(createTree(currentDepth - 1, currentMatches - i));
			}
			else
			{
				return tree;
			}
		}
		return tree;
	}
	
	public void addDepth()
	{
		addDepth(tree);
	}
	
	protected void addDepth(Tree tree)
	{
		if (tree.getChildren().isEmpty())
		{
			for(int i = 1; i <= 3; i++)
			{
				if (tree.getParent() - i >= 0)
				{
					tree.addChild(new Tree(tree.getParent() - i));
				}
				else
				{
					return;
				}
			}
		}
		else
		{
			for(Tree child : tree.getChildren())
			{
				addDepth(child);
			}	
		}
	}
	
	public void removeTrees(int matchRemoved)
	{
		for(Tree child : tree.getChildren())
		{
			if (tree.getParent() - matchRemoved == child.getParent())
			{
				tree = child;
				return;
			}
		}
	}
	
	public String getTree() {
		return tree.toString();
	}

	@Override
	public int play() 
	{
		MinMax m = new MinMax(max);
		return tree.getParent() - m.getBestChild(tree).getParent();
	}
}
