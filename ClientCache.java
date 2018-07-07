//Student: Marius Popescu
//Instructor: Fatma Serce
//CS 401: Algorithms
//05.21.2018
package Cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ClientCache {
	public static void main(String[] args) throws IOException {
		Scanner inp = new Scanner(System.in);
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		String answ;
		String key;
		Object object;
		File file = new File("file1.txt");
		Source s = new FileSource();
		CacheMemory cm = new CacheMemory(2, s);
		System.out.println("Please enter: 1 - to get an object from the cash;  2 - to clear the cash; 3 - to display the miss ratio;  "
+ "\n 4 - to display the hit ratio; 5 - to find if a element is in the cache; 6  - to exit");
		answer = inp.nextInt();
		do {
		if(answer == 1) {
			System.out.println("Enter the key for the object you are looking for: ");
			key = input.readLine();
			System.out.println("The object at the value " + key + " is: "+cm.getObject(key));
			}
		else if (answer == 2) {
			cm.clearCash();
			}
		else if (answer == 3) {
			System.out.println("The miss ratio is: " + cm.displayMissRatio());
		}
		else if (answer == 4) {
			System.out.println("The hit ratio is: " + cm.displayHitRatio());
		}
		else if (answer == 5) {
			System.out.println("Enter the key for the element you want to find if is in the cash: ");
			answ = input.readLine();
			if(cm.contain(answ)) 
				System.out.println("The element is in the cache");
			else
				System.out.println("The element is not in the cache");
		}
		System.out.println("Please enter: 1 - to get an object from the cash;  2 - to clear the cash; 3 - to display the miss ratio;  "
+ "\n 4 - to display the hit ratio; 5 - to find if a element is in the cache; 6  - to exit");
						answer = inp.nextInt();
	}while (answer != 6);
	}
}

