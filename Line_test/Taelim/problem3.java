package kakao1803;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Comparator;
//import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
//		final class Node{
//			int x;
//			int y;
//			Node(int x, int y){
//				this.x = x;
//				this.y = y;
//			}
//		}
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		HashMap<Integer, Boolean> visit = new HashMap<Integer, Boolean>();
		HashMap<Integer, ArrayList<Integer>> edgeList = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0;i < N;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int j = 0;j < 2;j++){
				int k, l;
				if(j ==0){
					k = a;
					l = b;
				}
				else{
					k = b;
					l = a;
				}
				if(!edgeList.containsKey(k)){
					ArrayList<Integer>vertexList = new ArrayList<Integer>();
					vertexList.add(l);
					edgeList.put(k, vertexList);
					visit.put(k, false);
				}
				else{
					edgeList.get(k).add(l);
				}
			}
		}
		
//		System.out.println(edgeList.keySet());
		
		int count = 0;
		for(int key : edgeList.keySet()){
			if(visit.get(key) == false){
				count++;
				dfs(key, visit, edgeList);
			}
		}
		System.out.println(count);
	
//		List<List<Node>> node_arr = new ArrayList<List<Node>>();
//		List<Node> insert_arr = new ArrayList<Node>();
//		
//		for(int i = 0;i < N;i++){
//			insert_arr.add(new Node(sc.nextInt(), sc.nextInt()));
//			
//		}
//		insert_arr.sort(new Comparator<Node>(){
//			
//			@Override
//			public int compare(Node n1, Node n2){
//				if(n1.x > n2.x){
//					return 1;
//					
//				}
//				else if(n1.x < n2.x){
//					return -1;
//					
//				}
//				else{
//					if(n1.y > n2.y){
//						return 1;
//						
//					}
//					else if(n1.y < n2.y){
//						return -1;
//					}
//					else{
//						return 0;
//					}
//				}
//			}
//			
//			
//		});

//		List<Node> graph_arr = new ArrayList<Node>();
//		graph_arr.add(insert_arr.remove(0));
//		node_arr.add(graph_arr);
//
//		while(!insert_arr.isEmpty()){
//			while(node_arr.forEach()){
//				
//			}
//		}
		
		sc.close();
	}
	static void dfs(int x, HashMap<Integer, Boolean> visit, HashMap<Integer, ArrayList<Integer>> edgeList){
		visit.put(x, true);
		for(int i = 0;i < edgeList.get(x).size();i++){
			int y = edgeList.get(x).get(i);
			if(visit.get(y) == false){
				dfs(y, visit, edgeList);
			}
		}
	}

}
