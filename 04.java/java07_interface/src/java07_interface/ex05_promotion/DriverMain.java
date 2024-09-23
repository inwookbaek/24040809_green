package java07_interface.ex05_promotion;

public class DriverMain {

	public static void main(String[] args) {
		
		Driver hong = new Driver();
		hong.drive(new Taxi());
		hong.drive(new Bus());
		hong.drive(new 자전거());
		hong.drive(new 오토바이());
		hong.drive(new 비행기());
	}

}

class 오토바이 implements Vehicle {

	@Override
	public void run() {
		System.out.println("오토바이를 탑니다!!");
	}
}

class 자전거 implements Vehicle {

	@Override
	public void run() {
		System.out.println("자전거를 탑니다!!");	
	}
}
class 비행기 implements Vehicle {

	@Override
	public void run() {
		System.out.println("비행기를 조정합니다!!");	}
	
}
