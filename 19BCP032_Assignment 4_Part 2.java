package Graph;
import java.util.*;

class Graph
{
	private static LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public Graph(int v)
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
	public void BFS(int source, int destination)
	{
		boolean visited[] = new boolean[adj.length];
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		q.add(source);
		visited[source] = true;
		
		while(!q.isEmpty())
		{
			int top = q.peek();
			System.out.println("Visited : " + top);
			if(top==destination)
			{
				break;
			}
			q.poll();

			for(int adjacent: adj[top])
			{
				if(!visited[adjacent])
				{
					visited[adjacent] = true;
					q.add(adjacent);
				}
			}
		}
	}
}

public class BFS_Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int v,e;
		System.out.print("Enter the number of vertices : ");
		v = sc.nextInt();
		System.out.print("Enter the number of edges : ");
		e = sc.nextInt();
		
		Graph g = new Graph(v);
		
		System.out.println("Enter "+e+" edges :");
		
		for(int i=0;i<e;i++)
		{
			int source = sc.nextInt();
			int destination = sc.nextInt();
			g.addEdge(source, destination);
		}

		int source, destination;
		System.out.print("Enter the source for BFS Traversal : ");
		source = sc.nextInt();
		System.out.print("Enter the destination for BFS Traversal : ");
		destination = sc.nextInt();
		
		g.BFS(source, destination);
		
		sc.close();
	}
}
