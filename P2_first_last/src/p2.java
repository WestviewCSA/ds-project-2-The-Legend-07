import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map[] map = readMap("Test5");
//		System.out.println(map[1]);
//		char temp = map[1].getTile(1, 1);
//		System.out.println(temp);
		
//		Map[] mapC = readMapCoor("TestC2");
//		System.out.println(mapC[0]);

		printMap(map);

	}
	
	
	
	
	public static void printMap(Map[] map) {
		for (int room = 0; room < map.length; room++) {
			Map obj = map[room];
			for (int row = 0; row < obj.getRows(); row++) {
				for (int col = 0; col < obj.getCols(); col++) {
					System.out.print( obj.getTile(row, col) );
				}
				System.out.println();
			}
		}
	}
	
	
	
	public static Map[] readMap(String filename) {
		
		File mapFile = new File(filename);
		try {
			Scanner scan = new Scanner(mapFile);
			
			//getting input for rows, cols, rooms
			int numRows = scan.nextInt();
			int numCols = scan.nextInt();
			int numRooms = scan.nextInt();
			
			//setting initial room = 0
			int currRoom = 0;
//			Tile[][][] map = new Tile[numRooms][numRows][numCols];
			
			
			
			//creating an array of map objects - each map has 2d array of tiles, basically each map of the current room
			Map[] fullMap = new Map[numRooms];
			
			//process the map!
			while(currRoom < numRooms) {
				
				int rowIndex = 0;
				//2d array of tiles - making current map from input
				Tile[][] currMap = new Tile[numRows][numCols];

				while (rowIndex < numRows) {
										
					//grab a line (one row of the map)
					String row = scan.nextLine();
					if (row.length()>0) {
						for (int i = 0; i < numCols && i < row.length(); i++) {
							char el = row.charAt(i);
							Tile obj = new Tile(rowIndex, i, el);
	//						System.out.println(obj.getType());
							currMap[rowIndex][i] = obj;
						}
//						System.out.println(Arrays.deepToString(currMap));
						rowIndex++;
					}
				}
				
				//storing current map as map object
				Map map = new Map(currMap, currRoom);
				//adding the current map to array of map objects
				fullMap[currRoom] = map;
				//going to next room
				currRoom++;
				
//				for (int row = 0; row < currMap.length; row++) {
//					for (int col = 0; col < currMap[row].length; col++) {
//						System.out.print(currMap[row][col]);
//					}
//					System.out.println();
//				}
			}
			
			System.out.println(Arrays.deepToString(fullMap));
			
			return fullMap;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	
	

	public static Map[] readMapCoor(String filename) {
		
		//for the coor map input files they don't give you ".", insert where empty
		File mapFile = new File(filename);
		try {
			Scanner scan = new Scanner(mapFile);
			
			//getting input for rows, cols, rooms
			int numRows = scan.nextInt();
			int numCols = scan.nextInt();
			int numRooms = scan.nextInt();
			
			//setting initial room = 0
			int currRoom = 0;
			
			//creating an array of map objects - each map has 2d array of tiles, basically each map of the current room
			Map[] fullMap = new Map[numRooms];
			Tile temp = null;
			
			while (currRoom < numRooms) {
				
				//2d array of tiles - making current map from input
				Tile[][] currMap = new Tile[numRows][numCols];
				
				int room = 0;
				
				//if value stored in temp from loop cutting off @ next room, then insert first
				if (temp != null) {
					currMap[temp.getRow()][temp.getCol()] = temp;
					temp = null;
				}

				while (scan.hasNextLine()) {
					char el = scan.next().charAt(0);
					int row = scan.nextInt();
					int col = scan.nextInt();
					room = scan.nextInt();
					if (room != currRoom) {
						temp = new Tile(el, row, col);
						break;
					}
					Tile obj = new Tile(el, row, col);
					currMap[row][col] = obj;
				}
				
//				System.out.println(Arrays.deepToString(currMap));
				
				//storing current map as map object
				Map map = new Map(currMap, currRoom);
				//adding the current map to array of map objects
				fullMap[currRoom] = map;
				currRoom++;

			}
			
			System.out.println(Arrays.deepToString(fullMap));
			return fullMap;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

}
