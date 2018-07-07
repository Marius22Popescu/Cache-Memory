//Student: Marius Popescu
//Instructor: Fatma Serce
//CS 401: Algorithms
//05.21.2018
package Cache;
import java.util.LinkedHashMap;
import java.util.Map;
@SuppressWarnings({ "serial", "rawtypes" })
public class CacheMemory extends LinkedHashMap {
	private static int maxSize;
	private Source s;		
	private static double hit;
	private static double miss;
	private int size;
//The constructor	
	public CacheMemory (int x, Source s) {     
		this.s = s;          
		maxSize = x;
		hit = 0;
		miss = 0;
	}
//This method will return the ratio of cache misses
	public double displayMissRatio() {
		double ratio = miss/(hit + miss);
		return ratio;
	}
//This method will return the ratio of cache hits
	public double displayHitRatio() {
			double ratio = hit/(hit + miss);
			return ratio;
		}
//This method will clear the cache
	public void clearCash() {
		clear();  
	}
//This method will insert a set (Key, Object) in the cash.
	private void putObject(String key, Object object) {
			put(key, object);		//insert the new set in cash
			size++;
	}
//This method will return the object based on the key provided
	public Object getObject(String k){
		Object obj = null;
		if(containsKey(k)) {
			obj = get(k);  	
			hit++;		//cache hit
		}
		else {			//if is not in the cache copy it from the file
			miss++;		//cache miss
			obj = s.readData(k);		
			putObject(k, obj);		//insert the new set in cash
			
		}		
		return obj;		
	}
//This method will return true if the element is in the cache
	public boolean contain (String key) {
		if(containsKey(key))
		return true;
		else
		return false;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size >= maxSize;
	}
}