package Experiment;

public class B_InitialScienSpotSystem {
	private static B_ScienSpotSystem scienSpotSystem;
	
	public B_ScienSpotSystem getScienSpotSystem() {
		if(scienSpotSystem==null) {
			scienSpotSystem=new B_ScienSpotSystem("ScenicSpot.txt","Relationship.txt");
		}
		return scienSpotSystem;
	}
}
