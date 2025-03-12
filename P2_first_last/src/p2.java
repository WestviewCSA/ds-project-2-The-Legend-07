import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		readMap("Test5");
		
		
	}
	
	
	
	public static void readMap(String filename) {
		
		File mapFile = new File(filename);
		try {
			Scanner scan = new Scanner(mapFile);
			
			int numRows = scan.nextInt();
			int numCols = scan.nextInt();
			int numRooms = scan.nextInt();
			
			int currRoom = 0;
			Tile[][][] map = new Tile[numRooms][numRows][numCols];
			
			//process the map!
			
			while(currRoom < numRooms) {
				
				int rowIndex = 0;

				while (rowIndex < numRows) {
					//grab a line (one row of the map)
					String row = scan.nextLine();
					if (row.length()>0) {
						for (int i = 0; i < numCols && i < row.length(); i++) {
							char el = row.charAt(i);
							Tile obj = new Tile(rowIndex, i, el);
	//						System.out.println(obj.getType());
							map[currRoom][rowIndex][i] = obj;
						}
						System.out.println(Arrays.deepToString(map));
						rowIndex++;
					}
				}
				currRoom++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
