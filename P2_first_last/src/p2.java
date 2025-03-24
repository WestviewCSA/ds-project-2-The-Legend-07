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
		
		readMapCoor("TestC2");
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
						System.out.println(Arrays.deepToString(currMap));
						rowIndex++;
					}
				}
				
				//storing current map as map object
				Map map = new Map(currMap, currRoom);
				//adding the current map to array of map objects
				fullMap[currRoom] = map;
				//going to next room
				currRoom++;
			}
			
			System.out.println(Arrays.deepToString(fullMap));
			
			return fullMap;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	
	

	public static void readMapCoor(String filename) {
		
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
				
//	//	//	//	//as of now this doesn't account for multiple rooms - need to change this
				if (temp != null) {
					currMap[temp.getRow()][temp.getCol()] = temp;
					temp = null;
				}

				while (scan.hasNextLine()) {
					char el = scan.next().charAt(0);
					int row = scan.nextInt();
					int col = scan.nextInt();
					room = scan.nextInt();
					System.out.println(room + "  " + currRoom);
					if (room != currRoom) {
						temp = new Tile(el, row, col);
						break;
					}
					Tile obj = new Tile(el, row, col);
					currMap[row][col] = obj;
				}
				
				
				
				//storing current map as map object
				Map map = new Map(currMap, currRoom);
				//adding the current map to array of map objects
				fullMap[currRoom] = map;
				currRoom++;
				
				System.out.println(Arrays.deepToString(fullMap));

				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
