package designpatterns;

enum TransportType {
	BUS, TRUCK, TRAIN
}

interface Transport {
	String dispatch(String goods);
}

class Truck implements Transport {

	@Override
	public String dispatch(String goods) {
		return goods + ", Dispatch in  truck";
	}

}

class Train implements Transport {

	@Override
	public String dispatch(String goods) {
		return goods + ", Dispatch in Train";
	}

}

class Bus implements Transport {

	@Override
	public String dispatch(String goods) {
		return goods + ", Dispatch in Bus ";
	}

}

class TransportFactory {
	public static Transport getTransportVehicle(TransportType type) {
		if (type == null)
			throw new IllegalArgumentException("Transport type can't be null");
		switch (type) {
		case TRUCK:
			return new Truck();
		case TRAIN:
			return new Train();
		case BUS:
			return new Bus();
		default:
			throw new IllegalArgumentException("Invalid Transport Type");
		}
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		Transport transportVehicle = TransportFactory.getTransportVehicle(TransportType.TRUCK);
		System.out.println(transportVehicle.dispatch("Books"));
	}
}
