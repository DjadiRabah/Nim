package model.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree 
{
	protected int parent;
	protected List<Tree> children;

	public Tree(int parent) 
	{
		this.parent = parent;
		this.children = new ArrayList<>();
	}
	
	public void addChild(Tree newChild)
	{
		children.add(newChild);
	}
	
	/**
	 * @return the parent
	 */
	public int getParent() {
		return parent;
	}

	/**
	 * @return the children
	 */
	public List<Tree> getChildren() {
		return children;
	}
	
	protected String toStringBrother(List<Tree> brothers)
	{
		if(brothers.isEmpty())
		{
			return "";
		}
		
		String str = "";
		List<Tree> nextGeneration = new ArrayList<>();
		for(Tree child : brothers)
		{
			str = str + child.getParent() + " ";
			nextGeneration.addAll(child.getChildren());
		}
		str = str + "\n";
		str = str + toStringBrother(nextGeneration);
		
		return str;
	}
	
	@Override
	public String toString()
	{
		return String.format("%d\n", getParent()) + toStringBrother(getChildren());
	}
}
