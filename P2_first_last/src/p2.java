import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		readMap("Test1");
		
	}
	
	
	
	public static void readMap(String filename) {
		
		File map = new File(filename);
		try {
			Scanner scan = new Scanner(map);
			
			int numRows = scan.nextInt();
			int numCols = scan.nextInt();
			int numRooms = scan.nextInt();
			
			int rowIndex = 0;
			
			//process the map!
			while (scan.hasNextLine()) {
				//grab a line (one row of the map)
				String row = scan.nextLine();
				if (row.length()>0) {
					for (int i = 0; i < numCols && i < row.length(); i++) {
						char el = row.charAt(i);
						Tile obj = new Tile(rowIndex, i, el);
					}
				}
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
