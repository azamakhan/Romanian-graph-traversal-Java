/*
 * Nicolas Perez
 * Graph.java
 * */
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class can represent a simple network graph represented by an
 * adjacency matrix.  It also has helper functions to help manipulate data 
 * related to the current graph object.
 * */
class Graph
{
    public Node rootVertex;
    public Node goalVertex;
    public ArrayList<Node>vertices = new ArrayList<Node>();
    public int[][] adjacencyMatrix;
    int size;
	
    /***
     * viewAdjMatrix prints out the adjacency matrix for the current graph
     * object.
     * 
     * @param void
     * @return void
     * */
    public void  viewAdjMatrix()
    {
        for (int i = 0; i < adjacencyMatrix.length;i++)
        {
            for (int j = 0; j < adjacencyMatrix.length; j++)
            {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    
    /***
     * 
     * getVertexListSize() returns the size of the list of vertices created when
     * node data is added to a graph object.
     * @param void
     * @return the size of the vertice array for a graph object as an integer.
     * */
    public int getVertexListSize()
    {
        return vertices.size();
    }
    
    /***
     * getNodeByIndex() uses a passed in index to return a node to the calling 
     * function
     * 
     * @param index The index of the desired Node object as an integer
     * @return the Node object specified by the passed in index.
     * */
    public Node getNodeByIndex(int index)
    {
        return (Node)vertices.get(index);
    }
    
    /**
     * setGoal() records the destination Node where the searches terminate.
     * 
     * @param vertex The vertex that represents the goal of the search.
     * @return void
     * 
     * */
    public void setGoal(Node vertex)
    {
        this.goalVertex = vertex;
    }
    
    /***
     * setRoot() records the source Node object where the searches begin.
     * 
     * @param vertex The Node object where the search is starting.
     * @return void
     * 
     * */
	public void setRoot(Node vertex)
	{
		this.rootVertex = vertex;
	}
	
    /***
     * getRoot() returns the Node object representing the root Node of the
     * current graph object.
     * 
     * @param void
     * @return Node object representing the root of the search tree.
     * */
	public Node getRoot()
	{
        return this.rootVertex;
	}
    
    /*** 
     * getGoal() returns the Node object representing the goal of the search.
     * 
     * @param void
     * @return the Node object representing the specified goal of the search.
     * 
     * */
    public Node getGoal()
    {
        return this.goalVertex;
    }
    
    /***
     * getRootLabel() returns a string representing the label of the root Node
     * object.
     * 
     * @param void
     * @return a string representing the label of the root Node object.
     * */
    public String getRootLabel()
    {
        return this.rootVertex.getLabel();
    }
    
    /***
     * getGoalLabel() returns a string representing the label of the goal Node
     * object.
     * 
     * @param void
     * @return a string representing the label of the goal Node object.
     * */
	public String getGoalLabel()
    {
        return this.goalVertex.getLabel();
    }
    
    /***
     * addNode() adds the passed in Node object to the current graph object'sj
     * vertices list.
     * 
     * @param vertex The Node object to be added to the graph's vertices list.
     * @return void
     * */
	public void addNode(Node vertex)
	{
	    vertices.add(vertex);
	}
	
    /***
     * setEdge()  creates an entry in the graph object's adjacency matrix
     * representing a one way link between two passed in vertices.
     * 
     * @param startVertex the initial Node to which the edge is connected.
     * @param endVertex the final Node to which the edge is connected.
     * @return void
     * */ 
	public void setEdge(Node startVertex, Node endVertex)
	{
		// if no entries, create
		if (adjacencyMatrix == null)
		{
		    size = vertices.size();
			adjacencyMatrix = new int[size][size];
		}
		
		int beginIndex = vertices.indexOf(startVertex);
		int endIndex = vertices.indexOf(endVertex);
		
		adjacencyMatrix[beginIndex][endIndex] = 1;
		adjacencyMatrix[endIndex][beginIndex] = 1;
	}
    
    /***
     * breadthFirstSearch() implements the bfs algorithm on the current graph
     * object.
     * @param void
     * @return void
     * */
	public void breadthFirstSearch()
	{
		Queue<Node> bfsQueue = new LinkedList<Node>();
        bfsQueue.add(this.rootVertex);
		
        printNode(this.rootVertex);
		this.rootVertex.visited = true;
        
        boolean pathFound = false;
		while (!bfsQueue.isEmpty() && !pathFound)
		{
			Node vertex = (Node)bfsQueue.remove();
            Node child = null;
			while ((child = getUnvisitedChild(vertex))!=null)
            {
                child.visited = true;
				printNode(child);
				bfsQueue.add(child);
                if (this.goalVertex.isEqual(child))
                {
                    pathFound = true;
                }
            }
        }
        System.out.println("\nbfsQueue contents:\n"); // REMOVE
        /*
         * REMOVE  BELOW FOR LOOP
         * */
        for (Node n : bfsQueue)
        {
                System.out.println("Saved path: "+ n.getLabel());
        }
		clearNodes();
    }
	
    /***
     * depthFirstSearch() implements the dfs algorithm on the current graph
     * object.
     * 
     * @param void
     * @return void
     * */
	public void depthFirstSearch()
	{
        // initialize stack
		Stack<Node> dfsStack = new Stack<Node>();
        boolean pathFound = false;
		
        rootVertex.visited = true;
		printNode(rootVertex);
        dfsStack.push(this.rootVertex);
        
		while (!dfsStack.isEmpty() && !pathFound)
		{
            Node vertex = (Node)dfsStack.peek();
            Node child = getUnvisitedChild(vertex);
           
            if (child !=null)
            {
                child.visited = true;
                printNode(child);
                dfsStack.push(child);
                if (this.goalVertex.isEqual(child))
                {
                    pathFound = true;
                }
            }
            else
            {
                dfsStack.pop();
            }
        }
        clearNodes();
	} 
	
    /***
     * clearNodes resets the visited flag on all stored Node objects to false.
     * 
     * @param void
     * @return void
     * */
	public void clearNodes()
	{
		int count = 0;
		while (count < size)
		{
			Node vertex = (Node)vertices.get(count);
			vertex.visited = false;
			count++;
		}
	}
	
    /***
     * getUnvisitedChild() returns the next connected and unvisited child to 
     * the passed in Node object, else returns null.
     * 
     * @param vertex The vertex for which we would like to search for children.
     * @return The node representing an unvisited child of the passed in vertex,
     * or null if none were found.
     * */
	public Node getUnvisitedChild(Node vertex)
	{
		int index = vertices.indexOf(vertex);
		int count = 0;
		while (count < size)
		{
			if (adjacencyMatrix[index][count] == 1 && 
			((Node)vertices.get(count)).visited == false)
			{
				return (Node)vertices.get(count);
			}
			count++;
		}
		return null;
	}
	
	public void printNode(Node vertex)
	{
		System.out.println(vertex.getLabel() + " ");
	}
} 
