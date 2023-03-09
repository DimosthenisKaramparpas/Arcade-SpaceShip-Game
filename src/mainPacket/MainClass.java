package mainPacket;
import gui.*;
import sounds.GameAudioPlayer;

public class MainClass {
	static int CosmosWidth=800;
	static int CosmosHeight=600;
	public static void main(String[] args) {
		SpaceFrame F1=new SpaceFrame(800,600);
		GameAudioPlayer Sound = new GameAudioPlayer();
	}
	public static int getCosmosWidth(){
		return CosmosWidth;
	}
	public static int getCosmosHeight(){
		return CosmosHeight;
	}
}
