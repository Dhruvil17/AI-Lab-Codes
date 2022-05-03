package Graph;
import java.util.*;

class Graphs
{
	private static LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public Graphs(int v)
	{
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int source, int destination)
	{
		adj[source].add(destination);
		adj[destination].add(source);
	}
	public void DFSStack(int source, int destination)
	{
		boolean visited[] = new boolean[adj.length];
		
		visited[source] = true;
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(source);
		
		while(!s.isEmpty())
		{
			int current = s.peek();
			System.out.println("Visited : " + current);

			if(current==destination)
			{
				break;
			}

			s.pop();
			
			for(int adjacent: adj[current])
			{
				if(visited[adjacent]==false)
				{
					visited[adjacent] = true;
					s.push(adjacent);
				}
			}
		}
	}
}

public class DFS_Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int v,e;
		System.out.print("Enter the number of vertices : ");
		v = sc.nextInt();
		System.out.print("Enter the number of edges : ");
		e = sc.nextInt();
		
		Graphs graph = new Graphs(v);
		
		System.out.println("Enter "+e+" edges :");
		
		for(int i=0;i<e;i++)
		{
			int source = sc.nextInt();
			int destination = sc.nextInt();
			graph.addEdge(source, destination);
		}
		int source, destination;
		
		System.out.print("Enter the source for DFS Traversal : ");
		source = sc.nextInt();
		System.out.print("Enter the destination for DFS Traversal : ");
		destination = sc.nextInt();
		
		graph.DFSStack(source, destination);

		sc.close();	
	}
}
