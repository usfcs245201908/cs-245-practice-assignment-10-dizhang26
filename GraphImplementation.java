import java.util.List;
import java.util.ArrayList;

public class GraphImplementation implements Graph
{
	private int[][] matrix;
	private int ver;

	public GraphImplementation(int ver)//constructor
	{
		this.ver = ver;
		matrix = new int[ver][ver];
	}
	private int findZero(int [] a)
	{
		for (int i=0; i<a.length; i++)
		{
			if (a[i]==0)
				return i;
		}
		return -1;
	}
	public void addEdge(int v1, int v2) throws Exception//add connection between two vertices
	{
		if ((v1 < 0 || v1 >= ver) || (v2 < 0 || v2 >= ver))
			throw new Exception();
		matrix[v1][v2] = 1;
	}
	public List<Integer> neighbors(int vertex) throws Exception//find the the vertices that are directly linked to the vertex
	{
		if (vertex < 0 || vertex >= ver)
			throw new Exception();

		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<ver; i++)
		{
			if (matrix[vertex][i] == 1)
				list.add(i);
		}
		return list;
	}
	public List<Integer> topologicalSort()//sorting algorithm
	{
		List<Integer> list = new ArrayList<Integer>();
		int [] sum = new int[ver];

		for (int i=0; i < ver; i++)
		{
			for (int j=0; j < ver; j++)
				sum[i]+=matrix[j][i];
		}
		for (int i=0; i < ver; i++)
		{
			int next=findZero(sum);
			if (next == -1)
			{
				System.out.println("Impossible Order");
				return list;
			}
			list.add(next);
			System.out.println(next);
			sum[next]=-1;
			for (int j=0; j<ver; j++)
				sum[j]-=matrix[next][j];
		}
		System.out.println();
		return list;
	}


}