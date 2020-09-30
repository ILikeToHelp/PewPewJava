package game.map;


public class Map {
	public Map(){
		/* #TODO
			Implement Map from text file
		*/
	}


	public void moveSoldier(int i0, int j0, int i1, int j1, Soldier s){
		map[i0][j0].removeSoldier();
		setSoldier(i1, j1, s);
}

public void setSoldier(int i, int j, Soldier s){
  map[i][j].setSoldier(s);
}
public void removeSoldier(int i, int j){
  map[i][j].removeSoldier();
}
public Soldier getSoldier(int i, int j){
  return map[i][j].getSoldier();
}
public boolean hasSoldier(int i, int j){
  return map[i][j].hasSoldier();
}
	public static FieldType[][] getMap(){
		return map;
	}

}
