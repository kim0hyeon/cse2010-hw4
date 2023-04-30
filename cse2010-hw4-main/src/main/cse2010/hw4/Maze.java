package cse2010.hw4;
/*
 * CSE2010 Homework #4: Maze.java
 *
 * Complete the code below.
 */

import java.util.Arrays;

public class Maze {
	private final int numRows; // number of rows
	private final int numCols; // number of columns

	private int[][] maze; // maze itself
	private boolean[][] visited; // true if cell was visited before

	private final Location entry; // Entry Location
	private final Location exit;  // Exit Location
	
	private final ArrayStack<Location> stack = new ArrayStack<>(100);

	/**
	 * Initialize this maze with a given maze and entry/exit locations.
	 * @param maze	2D array representing a maze
	 * @param entry	entry location
	 * @param exit	exit location
	 */
	public Maze(int[][] maze, Location entry, Location exit) {
		this.maze = maze;
		numRows = maze.length;
		numCols = maze[0].length;

		visited = new boolean[numRows][numRows];
		for (int i = 0; i < numRows; i++) {
			Arrays.fill(visited[i], false);
		}

		this.entry = entry;
		this.exit = exit;
	}

	// For testing purpose
	public void printMaze() {
		System.out.println("Maze[" + numRows + "][" + numCols + "]");
		System.out.println("Entry index = (" + entry.row + ", " + entry.col + ")");
		System.out.println("Exit index = (" + exit.row + ", " + exit.col + ")" + "\n");

		for (int i = 0; i < numRows; i++) {
			System.out.println(Arrays.toString(maze[i]));
		}
		System.out.println();
	}
	
	public boolean findPath() {
		return moveTo(entry.row, entry.col);
	}

	// tail recursion을 만든다.
	private boolean moveTo(int row, int col) {
		//	현재 row 와 col 이 탈출구 row 와 col 이라면 true 를 출력 한다.
		if (row == exit.row && col == exit.col) {
			stack.push(new Location(row, col));
			return true;
		}
		// 현재 row 와 col 이 시작 row 와 col 이고 주변에 움직일 곳이 없다면 false 를 출력 한다.
		if (row == entry.row && col == entry.col && !checkSide(row, col)) return false;

		// 가고자 하는 경로가 0이고 방문한 적이 없는 경우
		if (checkPath(row, col+1) && !visited[row][col+1]){
			Location loc = new Location(row, col);
			stack.push(loc);
			visited[row][col] = true;
			col++;
		}
		else if (checkPath(row, col-1) && !visited[row][col-1]){
			Location loc = new Location(row, col);
			stack.push(loc);
			visited[row][col] = true;
			col--;
		}
		else if (checkPath(row+1, col) && !visited[row+1][col]){
			Location loc = new Location(row, col); // 현재 위치 Location 생성자 만들기
			stack.push(loc); // 스택에 push 하기
			visited[row][col] = true; // 현재 위치를 이미 지나간 곳 이라고 표식 남기기
			row++;
		}
		else if (checkPath(row-1, col) && !visited[row-1][col]){
			Location loc = new Location(row, col);
			stack.push(loc);
			visited[row][col] = true;
			row--;
		}
		// 위의 4개중 아무것도 하지 못했을 때
		else{
			maze[row][col] = 1; // 더이상 나아갈 수 없으니까 해당 위치를 1로 바꾼다.
			Location loc = stack.pop();
			row = loc.row;
			col = loc.col;
		}
		return moveTo(row, col);
	}

	// 선택한 위치가 0이면 true를 리턴하고 1이거나 범위를 벗어났으면 false를 리턴한다.
	private boolean checkPath(int row, int col){
		if (row < 0 || row >= numRows)
			return false;
		if (col < 0 || col >= numCols)
			return false;
		if (maze[row][col] == 0)
			return true;
		else
			return false;
	}

	// 주변에 하나라도 움직일 곳이 있다면 true를 리턴한다. 주변에 하나도 움직일 곳이 없다면 false를 리턴한다.
	private boolean checkSide(int row, int col){
		if (checkPath(row+1, col))
			return true;
		else if (checkPath(row-1, col))
			return true;
		else if (checkPath(row, col+1))
			return true;
		else if (checkPath(row, col-1))
			return true;
		else return false;
	}

	public String showPath() {
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop() + " <-- ");
		}
		builder.append("Start");
		return builder.toString();
	}
	
}