package model.player;

import java.util.ArrayList;
import java.util.List;

import model.minmax.MinMax;
import model.tree.Tree;

public class IA extends Player 
{
	protected int depth;
	protected Tree tree;
	
	public IA(int depth, int maxMatches) 
	{
		super(maxMatches);
		this.depth = depth;
		tree = createTree(depth, maxMatches);
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
	
	public String getTree() {
		return tree.toString();
	}

	@Override
	public int play() 
	{
		MinMax m = new MinMax(maxMatches);
		System.out.println(m.getBestChild(tree).getParent());
		return 0;
	}
}
