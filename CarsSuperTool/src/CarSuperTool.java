import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * created by Gothbag <josemariacagigalso@gmail.com
 * this does a few things involving cars
 */

public class CarSuperTool {
	
	public static void main(String[] args){
		//declarations
		SortedMap<String, Car> carMap = new TreeMap<String, Car>();
		//we add elements to the set
		carMap.put("1234 AAA", new Car("Alfa Romeo", "Giulia", 2900, 6));
		carMap.put("2321 BBB", new Car("Seat", "Ibiza", 1200, 3));
		carMap.put("8232 FFF", new Car("Ford", "Focus", 2000, 4));
		carMap.put("3311 FFF", new Car("Ford", "Mondeo", 2200, 4));
		carMap.put("9381 LLL", new Car("Seat", "Leon", 1600, 4));
		Car hyundi = new Car("Hyundai", "Atos", 1500, 3);
		carMap.put("B 9011 XC", hyundi);
		carMap.put("9234 BHG", new Car("Hyundai", "Santa Fe", 3000, 6));
		carMap.put("9216 CKK", new Car("Hyundai", "Accent", 2000, 4));
		
		ArrayList<Car> carsByMake = CarSuperToolCore.carsGroupedByMake(carMap);
		System.out.println("CARS SORTED BY MAKE");
		for (Car c : carsByMake) {
			System.out.println(c);	
		}
		
		System.out.println("CARS WITH AN ENGINE DISPLACEMENT GREATER THAN 2000");
		ArrayList<Car> cars2000cc = CarSuperToolCore.carsOverEngineDisplacement(carMap, 2000);
		for (Car c : cars2000cc) {
			System.out.println(c);	
		}
		
		System.out.println("CARS SORTED BY MAKE, AGAIN");
		TreeMap<String, ArrayList<Car>> carsSortedByMake = CarSuperToolCore.carsGroupedByMakeTrue(carMap);
		
		for(Iterator<Map.Entry<String, ArrayList<Car>>> it = carsSortedByMake.entrySet().iterator(); it.hasNext(); ) {
			Map.Entry<String, ArrayList<Car>> entry = it.next();
			for (Car c : entry.getValue()) {
				System.out.println(c);
			}
	    	//System.out.println(entry.getKey() + " " + entry.getValue().toString());
	    }
		
		System.out.println("WE REMOVE ALL CARS WITH AN ENGINE DISPLACEMENT GREATER THAN 2500");
		CarSuperToolCore.deleteCarsGT2500cc(carMap);
		for(Iterator<Map.Entry<String, Car>> it = carMap.entrySet().iterator(); it.hasNext(); ) {
	    	Map.Entry<String, Car> entry = it.next();
	    	System.out.println(entry.getKey() + " " + entry.getValue().toString());
	    }
		
	}
	
	
	static public class CarSuperToolCore{
		//1
		//given a Map, removes all cars in a map with an engine displacement of over 2500
		public static void deleteCarsGT2500cc(Map<String, Car> pCarMap) {
			//declarations
			ArrayList<String> keysDelete = new ArrayList<String>();
			//We go over the map and obtain the keys we need to delete
		    for(Iterator<Map.Entry<String, Car>> it = pCarMap.entrySet().iterator(); it.hasNext(); ) {
		    	Map.Entry<String, Car> entry = it.next();
		    	if (entry.getValue().getEngineDisplacement() > 2500) {
		    		keysDelete.add(entry.getKey());
		    	}
		    }
		    //we iterate over the keys to be removed and we remove them from the map
		    for (String ke : keysDelete) {
		    	pCarMap.remove(ke);
		    }
			
		}
		
		//2
		//given a Map, retrieves all cars with an engine displacement greater than the number we pass as an argument
		public static ArrayList<Car> carsOverEngineDisplacement(Map<String, Car> pCarMap, int pEngineDisplacement) {
			//declarations
			ArrayList<Car> retCars = new ArrayList<Car>();
			for(Map.Entry<String,Car> entry : pCarMap.entrySet()) {
				if (entry.getValue().getEngineDisplacement() > pEngineDisplacement) {
					retCars.add(entry.getValue());
				}
			}
			return retCars;
		}
		
		//3
		//given a car Map returns all its elements grouped by make
		public static ArrayList<Car> carsGroupedByMake(Map<String, Car> pCarMap) {
			//declarations
			ArrayList<Car> groupedCars = new ArrayList<Car>();
			//we copy the cars to the return list
			for(Map.Entry<String,Car> entry : pCarMap.entrySet()) {
				groupedCars.add(entry.getValue());
			}
			//we sort the list
			Collections.sort(groupedCars, new Comparator<Car>() {
		        @Override
		        public int compare(Car  car1, Car  car2)
		        {

		            return  car1.getMake().compareTo(car2.getMake());
		        }
		    });
			return groupedCars;
			
		}
		
		public static TreeMap<String,ArrayList<Car>> carsGroupedByMakeTrue(Map<String, Car> pCarMap) {
			//declarations
			TreeMap<String,ArrayList<Car>> groupedCars = new TreeMap<String,ArrayList<Car>>();
			//we iterate over the map
			for(Map.Entry<String,Car> entry : pCarMap.entrySet()) {
				//if the map of cars sorted by make doesn't contain a make, we add it 
				if ( !groupedCars.containsKey(entry.getValue().getMake()) ) {
					groupedCars.put(entry.getValue().getMake(), new ArrayList<Car>());
					
				}
				//groupedCars.
				for (Map.Entry<String, ArrayList<Car>> entryMakes : groupedCars.entrySet()) {
					if ( entryMakes.getKey().equals(entry.getValue().getMake()) ) {
						entryMakes.getValue().add(entry.getValue());
					}
			    }
			}
			return groupedCars;
		}
		
		//Indeed, maps look very appropriate for indexing our allergens
	
		//TreeMap Classifieds <String, TreeSet<Car>>
	}

}
