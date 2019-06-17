package buuretraum;

import frames.SpriteObject;

public class FarmClass extends SpriteObject{

	private int idFarm;
	private int Player_idPLayer;
	private String name;
	
	public FarmClass(int idFarm, int Player_idPLayer, String name) {
		// TODO Auto-generated constructor stub
		this.idFarm = idFarm;
		this.Player_idPLayer = Player_idPLayer;
		this.name = name;
	}

	public int getIdFarm() {
		return idFarm;
	}

	public void setIdFarm(int idFarm) {
		this.idFarm = idFarm;
	}

	public int getPlayer_idPLayer() {
		return Player_idPLayer;
	}

	public void setPlayer_idPLayer(int player_idPLayer) {
		Player_idPLayer = player_idPLayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
