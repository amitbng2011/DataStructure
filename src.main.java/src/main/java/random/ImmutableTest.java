package src.main.java.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Class final so no can extend it
 * Don't provide setter
 * Initialize all the fields via constructor
 *
 */
public final class ImmutableTest {
	private final String name;
	private final int regNo;
	private final Map<String, String> metadata;

	public ImmutableTest(String name, int regNo, Map<String, String> metadata){
		this.name = name;
		this.regNo = regNo;
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.metadata = tempMap;
	}

	public String getName() {
		return name; 
	}

	public int getRegNo() {
		return regNo; 
	}

	public Map<String, String> getMetadata(){
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry :
			this.metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}
}

// Driver class
class Test {
	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<>();
		map.put("1", "first");
		map.put("2", "second");
		ImmutableTest s = new ImmutableTest("ABC", 101, map);
		System.out.println(s.getName());
		System.out.println(s.getRegNo());
		System.out.println(s.getMetadata());

		// Uncommenting below line causes error
		// s.regNo = 102;

		map.put("3", "third");
		System.out.println(s.getMetadata()); // Remains unchanged due to deep copy in constructor

		s.getMetadata().put("4", "fourth");
		System.out.println(s.getMetadata()); // Remains unchanged due to deep copy in getter
	}
}
