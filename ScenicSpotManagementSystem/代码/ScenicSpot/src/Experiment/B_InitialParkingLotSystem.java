package Experiment;

public class B_InitialParkingLotSystem {
	private static B_ParkingLotSystem parkingLotSystem;
	
	public B_ParkingLotSystem getParkingLotSystem() {
		if(parkingLotSystem==null) {
			parkingLotSystem=new B_ParkingLotSystem();
		}
		return parkingLotSystem;
	}
}
