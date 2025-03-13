import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map[] map = readMap("Test5");
		System.out.println(map[1]);
	}
	
	
	
	public static Map[] readMap(String filename) {
		
		File mapFile = new File(filename);
		try {
			Scanner scan = new Scanner(mapFile);
			
			int numRows = scan.nextInt();
			int numCols = scan.nextInt();
			int numRooms = scan.nextInt();
			
			int currRoom = 0;
//			Tile[][][] map = new Tile[numRooms][numRows][numCols];
			Map[] fullMap = new Map[numRooms];
			
			//process the map!
			
			while(currRoom < numRooms) {
				
				int rowIndex = 0;
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
				
				Map map = new Map(currMap, currRoom);
				fullMap[currRoom] = map;
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

}
