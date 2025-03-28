import java.util.Arrays;

public class Map {
	
	private Tile[][] map;
	private int roomNum;
	
	public Map (Tile[][] map, int roomNum) {
		this.map = map;
		this.roomNum = roomNum;
	}
	
	
	public char getTile(int row, int col) {
	    return map[row][col].getType();
	}
	
	
	
	public Tile[][] getMap() {
		return map;
	}





	public void setMap(Tile[][] map) {
		this.map = map;
	}





	public int getRoomNum() {
		return roomNum;
	}





	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}


	public int getRows() {
		return map.length;
	}
	
	public int getCols() {
		return map[0].length;
	}


	public String toString() {
		return Arrays.deepToString(map);
	}
	

}
