/*
 * Nicolas Perez
 * SearchRomania.java
 * */
public class SearchRomania {
	
	public static void main(String [] args) 
	{
        // create nodes needed for searches.
        Node arad = new Node("arad");
		Node bucharest = new Node("bucharest");
		Node craiova = new Node("craiova");
		Node dobreta = new Node("dobreta");
		Node eforie = new Node("eforie");
		Node fagaras = new Node("fagaras");
		Node giurgiu = new Node("giurgiu");
		Node hirsova = new Node("hirsova");
		Node iasi = new Node("iasi");
		Node lugoj = new Node("lugoj");
		Node mehadia = new Node("mehadia");
		Node neamt = new Node("neamt");
		Node oradea = new Node("oradea");
		Node pitesti = new Node("pitesti");
		Node rimnicu_vilcea = new Node("rimnicu_vilcea");
		Node sibiu = new Node("sibiu");
		Node timisoara = new Node("timisoara");
		Node urziceni = new Node("urziceni");
		Node vaslui = new Node("vaslui");
		Node zerind = new Node("zerind");
		
		// create graph for Romanian road map
		Graph romaGraph = new Graph();
			
		// add nodes to graph
		romaGraph.addNode(arad);
		romaGraph.addNode(bucharest);
		romaGraph.addNode(craiova);
		romaGraph.addNode(dobreta);
		romaGraph.addNode(eforie);
		romaGraph.addNode(fagaras);
		romaGraph.addNode(giurgiu);
		romaGraph.addNode(hirsova);
		romaGraph.addNode(iasi);
		romaGraph.addNode(lugoj);
		romaGraph.addNode(mehadia);
		romaGraph.addNode(neamt);
		romaGraph.addNode(oradea);
		romaGraph.addNode(pitesti);
		romaGraph.addNode(rimnicu_vilcea);
		romaGraph.addNode(sibiu);
		romaGraph.addNode(timisoara);
		romaGraph.addNode(urziceni);
		romaGraph.addNode(vaslui);
		romaGraph.addNode(zerind);
			
		// connect nodes in graph
		romaGraph.setEdge(oradea,zerind);
		romaGraph.setEdge(oradea,sibiu);
		romaGraph.setEdge(zerind,oradea);
		romaGraph.setEdge(zerind,arad);
		romaGraph.setEdge(arad,zerind);
		romaGraph.setEdge(arad,timisoara);
		romaGraph.setEdge(arad,sibiu);
		romaGraph.setEdge(timisoara,arad);
		romaGraph.setEdge(timisoara,lugoj);
		romaGraph.setEdge(lugoj,timisoara);
		romaGraph.setEdge(lugoj,mehadia);
		romaGraph.setEdge(mehadia,lugoj);
		romaGraph.setEdge(mehadia,dobreta);
		romaGraph.setEdge(dobreta,mehadia);
		romaGraph.setEdge(dobreta,craiova);
		romaGraph.setEdge(sibiu,oradea);
		romaGraph.setEdge(sibiu,arad);
		romaGraph.setEdge(sibiu,rimnicu_vilcea);
		romaGraph.setEdge(sibiu,fagaras);
		romaGraph.setEdge(rimnicu_vilcea,sibiu);
		romaGraph.setEdge(rimnicu_vilcea,craiova);
		romaGraph.setEdge(rimnicu_vilcea,pitesti);
		romaGraph.setEdge(craiova,dobreta);
		romaGraph.setEdge(craiova,rimnicu_vilcea);
		romaGraph.setEdge(craiova,pitesti);
		romaGraph.setEdge(fagaras,sibiu);
		romaGraph.setEdge(fagaras,bucharest);
		romaGraph.setEdge(pitesti,rimnicu_vilcea);
		romaGraph.setEdge(pitesti,craiova);
		romaGraph.setEdge(pitesti,bucharest);
		romaGraph.setEdge(bucharest,fagaras);
		romaGraph.setEdge(bucharest,pitesti);
		romaGraph.setEdge(bucharest,giurgiu);
		romaGraph.setEdge(bucharest,urziceni);
		romaGraph.setEdge(giurgiu,bucharest);
		romaGraph.setEdge(neamt,iasi);
		romaGraph.setEdge(iasi,neamt);
		romaGraph.setEdge(iasi,vaslui);
		romaGraph.setEdge(vaslui,iasi);
		romaGraph.setEdge(vaslui,urziceni);
		romaGraph.setEdge(urziceni,bucharest);
		romaGraph.setEdge(urziceni,vaslui);
		romaGraph.setEdge(urziceni,hirsova);
		romaGraph.setEdge(hirsova,urziceni);
		romaGraph.setEdge(hirsova,eforie);
		romaGraph.setEdge(eforie,hirsova);
        
        for (int i = 0; i < romaGraph.getVertexListSize();i++)
        {       
            // Set root vertex
            if (romaGraph.vertices.get(i).getLabel().equals(args[1]))
            {
                romaGraph.setRoot((Node)romaGraph.vertices.get(i));
            }
            // set goal vertex
            if (romaGraph.vertices.get(i).getLabel().equals(args[2]))
            {
                romaGraph.setGoal((Node)romaGraph.vertices.get(i));
            }
        }
        
        // run specified search
        if (args[0].toLowerCase().equals("bfs"))
        {
            System.out.println("Running Breadth-First Search");
            romaGraph.breadthFirstSearch();
        }
        else
        {
            System.out.println("Running Depth-First Search");
            romaGraph.depthFirstSearch();
        }
    }
}
