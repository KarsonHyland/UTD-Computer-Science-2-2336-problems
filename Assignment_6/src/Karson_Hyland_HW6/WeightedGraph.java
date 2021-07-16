package Karson_Hyland_HW6;

public class WeightedGraph {
	static class Edge {
        Vertex destination;
        int weight;
        Vertex startingCity;

        public Edge(Vertex v, Vertex destination, int weight) {
            this.destination = destination;
            this.weight = weight;
            this.startingCity = v;
        }
        
        public String getStartingCity() {
        	return startingCity.getName();
        }
        public String getDestination() {
        	return destination.getName();
        }
        public int getWeight() {
        	return weight;
        }
	}
	
	static class Vertex{
		String name;
		int x;
		int y;
		
		public Vertex(String cityName, int xPosition, int yPosition) {
			this.name = cityName;
			this.x = xPosition;
			this.y = yPosition;
		}
		
		public String getName() {
        	return name;
        }
        public int getXPosition() {
        	return x;
        }
        public int getYPosition() {
        	return y;
        }
	}
}


