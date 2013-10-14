/*
 * Nicolas Perez
 * Node.java
 * */
class Node
{
	public boolean visited = false;
	public String label;
	
    /***
     * Node() is the constructor for a Node object. It creates a Node and sets
     * the label to the String passed in.
     * @param name The name of the Node to set as the label.
     * @return n/a
     * */
	public Node(String name)
	{
		this.label = name;
	}
    
    /***
     * getLabel() returns the label of the calling Node object.
     * 
     * @param void
     * @return a string representing the label of the calling Node object.
     * */        
    public String getLabel()
    {
        return label;
    }
    
    /***
     * isEqual() compares two Node objects by their labels.
     * @param n the Node whos label needs to be compared to the calling object.
     * @return the result of the comparison.
     * */ 
    public boolean isEqual(Node n)
    {
        boolean result = false;
        if (this.label.equals(n.label))
        {
            result = true;
        }
        return result;
    }
}
