package Karson_Hyland_HW6;

public class Hyland_Karson_A6 {

	public static void main(String[] args) {
		int numVertices = 20;
		
		//graph vetrex ("city name", x, position, y position);
        Graph graph = new Graph(numVertices);
        
        graph.addVertex("Dampier", 19, 12);
        graph.addVertex("Geraldton", 13, 28);
        graph.addVertex("Kalgoorlie", 23, 32);
        graph.addVertex("Perth", 28, 42);
        graph.addVertex("Broken Hill", 28, 42);
        
        graph.addVertex("Adelaide", 19, 12);
        graph.addVertex("Albany", 13, 28);
        graph.addVertex("Brisbane", 23, 32);
        graph.addVertex("Cairns", 28, 42);
        graph.addVertex("Canberra", 28, 42);
        
        graph.addVertex("Daly Waters", 19, 12);
        graph.addVertex("Derby", 13, 28);
        graph.addVertex("Esperance", 23, 32);
        graph.addVertex("Hobart", 28, 42);
        graph.addVertex("Melbourne", 28, 42);
        
        graph.addVertex("Alice Springs", 19, 12);
        graph.addVertex("Rockhampton", 13, 28);
        graph.addVertex("Sydney", 23, 32);
        graph.addVertex("Townsville", 28, 42);
        graph.addVertex("Wyndham", 28, 42);
        
        graph.addEgde(graph.getVertex("Dampier"), graph.getVertex("Geraldton"), 576);
        graph.addEgde(graph.getVertex("Dampier"), graph.getVertex("Kalgoorlie"), 757);
        graph.addEgde(graph.getVertex("Geraldton"), graph.getVertex("Kalgoorlie"), 434);
        graph.addEgde(graph.getVertex("Geraldton"), graph.getVertex("Perth"), 232);
        graph.addEgde(graph.getVertex("Kalgoorlie"), graph.getVertex("Perth"), 342);
        graph.addEgde(graph.getVertex("Kalgoorlie"), graph.getVertex("Broken Hill"), 1181);
        
        graph.addEgde(graph.getVertex("Kalgoorlie"), graph.getVertex("Albany"), 361);
        graph.addEgde(graph.getVertex("Perth"), graph.getVertex("Esperance"), 370);
        graph.addEgde(graph.getVertex("Esperance"), graph.getVertex("Melbourne"), 1321);
        graph.addEgde(graph.getVertex("Melbourne"), graph.getVertex("Alice Springs"), 1174);
        graph.addEgde(graph.getVertex("Melbourne"), graph.getVertex("Sydney"), 443);
        graph.addEgde(graph.getVertex("Alice Springs"), graph.getVertex("Broken Hill"), 734);
        
        graph.addEgde(graph.getVertex("Alice Springs"), graph.getVertex("Sydney"), 1260);
        graph.addEgde(graph.getVertex("Alice Springs"), graph.getVertex("Dampier"), 1118);
        graph.addEgde(graph.getVertex("Alice Springs"), graph.getVertex("Derby"), 797);
        graph.addEgde(graph.getVertex("Derby"), graph.getVertex("Wyndham"), 322);
        graph.addEgde(graph.getVertex("Wyndham"), graph.getVertex("Daly Waters"), 354);
        graph.addEgde(graph.getVertex("Daly Waters"), graph.getVertex("Cairns"), 822);

        graph.addEgde(graph.getVertex("Cairns"), graph.getVertex("Townsville"), 175);
        graph.addEgde(graph.getVertex("Cairns"), graph.getVertex("Sydney"), 1219);
        graph.addEgde(graph.getVertex("Townsville"), graph.getVertex("Rockhampton"), 371);
        graph.addEgde(graph.getVertex("Rockhampton"), graph.getVertex("Broken Hill"), 810);
        graph.addEgde(graph.getVertex("Rockhampton"), graph.getVertex("Brisbane"), 323);
        graph.addEgde(graph.getVertex("Brisbane"), graph.getVertex("Sydney"), 455);
        
        graph.addEgde(graph.getVertex("Sydney"), graph.getVertex("Hobart"), 657);
        graph.addEgde(graph.getVertex("Sydney"), graph.getVertex("Broken Hill"), 580);
        graph.addEgde(graph.getVertex("Sydney"), graph.getVertex("Canberra"), 153);
        graph.addEgde(graph.getVertex("Sydney"), graph.getVertex("Adelaide"), 722);
        graph.addEgde(graph.getVertex("Adelaide"), graph.getVertex("Albany"), 1171);
        
        graph.printVertices();
        graph.printAdjacencyList();
        graph.printAdjacencyMatrix();
        graph.BFS(graph.getVertex("Melbourne"));
        graph.BFS(graph.getVertex("Esperance"));
        graph.printBFS();
        graph.DFS(graph.getVertex("Sydney"));
  
        graph.printDFS();
	}

}
