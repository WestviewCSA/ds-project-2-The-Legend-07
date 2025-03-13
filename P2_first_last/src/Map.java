import java.util.Arrays;

public class Map {
	
	private Tile[][] map;
	private int roomNum;
	
	public Map (Tile[][] map, int roomNum) {
		this.map = map;
		this.roomNum = roomNum;
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





	public String toString() {
		return Arrays.deepToString(map);
	}
	
}
