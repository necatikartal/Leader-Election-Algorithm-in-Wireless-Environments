package com.neco4j.graph;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main class to test
 * @author Necati Kartal
 */
public class Main {

	/**
	 * Main function to test
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);
		Operations op = new Operations();
		Graph gr = null;
		
		String ans="0";
		do{	
			System.out.println("Here are your options:");
			System.out.println("1. Build graph with given capacity and grow percent.");
			System.out.println("2. Build graph from given files.");
			System.out.println("3. Start Election Algorithm.");
			System.out.println("4. Quit.");
			
			ans = stdin.next();
			if (ans.compareTo("1") == 0) {
				System.out.println("1.1 Enter Capacity:");
				String capacity = stdin.next();
				System.out.println("1.2 Enter Grow Percent:");
				String grow = stdin.next();
				try {
					gr = op.buildGraph(Integer.parseInt(capacity),Integer.parseInt(grow));
					gr.printGraph();
				} catch (Exception e) {
					System.out.println("Invalid capacity or grow percent!");
				}
				try {
					System.out.println("Press enter!");
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (ans.compareTo("2") == 0) {
				gr = new Graph();
				try {
					System.out.println("2.1 Reading files:");
					gr = op.buildGraph("Resources\\vertices.txt", "Resources\\edges.txt");
					gr.printGraph();
					System.out.println("Press enter!");
					System.in.read();
				} catch (IOException e) {
					System.out.println("Reading file error!");
				}			
			} else if (ans.compareTo("3") == 0) {
				if(gr != null ){
					System.out.println("3.1 Enter Vertex Number:");
					String vertexVal = stdin.next();
					if(gr.findVertex(vertexVal)!=null) {
						System.out.println("Election start:");
						gr.electionCoordinator(vertexVal);
						try {
							System.out.println("Press enter!");
							System.in.read();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else
						System.out.println("Vertex didn't find!");	
				}
				else
					System.out.println("Please build graph by using 1th and 2nd options!");		
			} else if (ans.compareTo("4") == 0) {
					break;
			} else
				System.out.println("Invalid option!");
		} while(ans.compareTo("4") != 0);
	}
}