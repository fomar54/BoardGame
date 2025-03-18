package BoardGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class BoardGame {
	static ArrayList<ArrayList<String>> csv = readCsv("GameCollection.csv");
	 ArrayList <String> names = getColumn(csv,0);
	public void intro() {
		//INPUT USER INPUT
		int scanner;
		// while loop continues until user inserts int value that also is between 1-4
		while(true) {
		System.out.println("what would you like to do ; \n [1] print games Alphabetically \n[2] pint games based on Difficulty \n [3] print games based on year of release   ");
		// intvaildtor takes return value has user input 
		scanner = intVaildtor() ;
		// if scanner input is 1 OR 2 Or 3 or 4 WHILE LOOP BREAKS 
		if (scanner == 1 || scanner == 2 ||scanner == 3 || scanner == 4)  { 
			break ;
			// else is not print error statement 
		}else {
			
		System.out.println("Invaild input ");
		}
		
	}
		// compare user input to each option then direct to method being used 
		// PROCESS
	if (scanner == 1 ) {
		alphabetically();
	}
	if (scanner == 2) {
		difficulty();
	}
		if (scanner == 3) {
			releaseYear();	
		}	
	}
	
	public static void insertionSortSt(ArrayList<String> list) {
		// PROCESS 
		// start with second item in arraylist
		for (int i = 1; i < list.size(); i++) {
			// set key value as arraylist value of i placement
	        String key = list.get(i);
	        // shifting to other item
	        int j = i - 1;
	        // while  j is greater or equal to 0 AND arraylist item j placement compared to key anothe item in arraylist is greater than 0 
	        while (j >= 0 && list.get(j).compareToIgnoreCase(key) > 0) {
	        	// shift placements 
	            list.set(j + 1, list.get(j));
	            j--;
	        }
	        // shift placements if it is less than 0 
	        list.set(j + 1, key);
	    }	
	}
	
	public static void insertionSortInt( ArrayList<Integer> list ) {
		//PROCESS 
		int key;
		int j;
	// starts at second item then continues until end of arralist 
		for (int i =1; i<list.size(); i++) {
			// key is arraylist item i placement
			key= list.get(i);
			j= i-1;
			// while j is greater than equal to 0 AND arraylist item is greater than key that is anothe item in arraylist 
			while(j>=0 && list.get(j) < key) {
				// set order 
				list.set(j+ 1 , list.get(j) );
				j = j-1;
			}
			// set order if key is less then list.get(j)
			list.set(j + 1, key);
		}
		
	}
	public void difficulty() {
		//PROCESS
		// getting column from csv 
	    ArrayList<String> column3 = getColumn(csv, 2);  
	    // unsorted arraylist 
	    ArrayList<Float> difficultyListUnsorted = new ArrayList<Float>();
	    // creating float arraylist 
	    ArrayList<Float> difficultyList = new ArrayList<>();
	    
	    
	    	// going through each item in colum3 arraylist until end        
	    for (int i = 1; i < column3.size(); i++) {
	        // Parse each string in column2 to float and add to difficultyList
	        difficultyList.add(Float.parseFloat(column3.get(i)));
	    }
	    for (int i = 0; i < difficultyList.size(); i++) {
	    	difficultyListUnsorted.add(difficultyList.get(i));
	    }

	    // Now difficultyList contains the parsed floats from column 3 of csv
	    
	  // putting difficulty list  into insertion method for floats 
	    insertionSortFloats(difficultyList);
	   
	    // going through each value until i is greator than the amount of items in arraylist 
	    for (int i = 1 ; i < difficultyList.size() ; i ++) {
	    // OUTPUT PRINTING NEW SORTED DIFFICULTYLIST ARRAYLIST WITH CORRESPONDING NAME 
	    	// Print the element in 'names' list at the position of the corresponding item in 'difficultyListUnsorted' plus 1 ignoring first item 
	    	System.out.print(names.get(difficultyListUnsorted.indexOf(difficultyList.get(i)) + 1));
	    	// Print a separator "||" followed by the corresponding item from 'difficultyList'
	    	System.out.println("||" + difficultyList.get(i));
	    	
	    }
	    // return back to intro menu to repeat 
	    //OUTPUT
	  intro();  
	    
	}
	 public void alphabetically() {
		// using names arraylist as parameter in insertion sort for strings 
		 //PROCESS 
		 insertionSortSt(names);
		 // print each item in araylist  // OUTPUT //
		 for(int i= 0 ; i< names.size();i++){
			 System.out.println(names.get(i));
		 } 
		 ///print statement explaining order  then returning to intro menu to repeat 
		 System.out.println("names ordered A-Z");
		 intro();
	 }
	
	 public void releaseYear() {
		 
		 ArrayList<String> column5= getColumn(csv,5);
		 ArrayList<Integer> year = new ArrayList<Integer>();
		 ArrayList<Integer> yearUnsorted = new ArrayList<Integer>();
		 
		     
	    for (int i = 1; i < column5.size(); i++) {
	        // Parse each string in column2 to float and add to difficultyList
	        year.add(Integer.parseInt(column5.get(i)));
	    }
	    for (int i = 0; i < year.size(); i++) {
	    	yearUnsorted.add(year.get(i));
	    }

		 
		 insertionSortInt(year);
		
		 for (int i = 0; i < year.size(); i++) {
			 int minYear = Integer.MAX_VALUE;
			 int minIndex = -1;
			 // Find minimum year
			 for (int j = 0; j < year.size(); j++) {
			 if (year.get(j) < minYear) {
			 minYear = year.get(j);
			 minIndex = j;
			 }
			 }
			 // Print the minimum year and remove it from the list
			 System.out.println(names.get(minIndex) + " || " + minYear);
			 year.remove(minIndex);
			 names.remove(minIndex); // Make sure to adjust names list accordingly if necessary
			 }
		 System.out.println("years oldest to most recent");
		 intro();
	    
	 }
	 public static void insertionSortFloats(ArrayList<Float> list) {
		    float key; // Declare a variable to hold the current key value
		    int j; // Declare a variable to keep track of the index while shifting elements
		    
		    // Iterate through the list starting from the second element
		    for (int i = 1; i < list.size(); i++) {
		        key = list.get(i); // Set the current item as the key to be inserted
		        j = i - 1; // Initialize j to the index of the previous item
		        
		        // Iterate backwards to find the correct position for the key element
		        while (j >= 0 && list.get(j) < key) { // Keep moving elements greater than the key to the right
		            list.set(j + 1, list.get(j)); // Shift the item to the right
		            j = j - 1; // Move to the previous index
		        }
		        
		        list.set(j + 1, key); // Place the key element at its correct position
		    }
		}


	 /* Quinn made this super amazing and omega brain level code
	  */
	 public static ArrayList<ArrayList<String>> readCsv(String filename) {
		    try {
		        // Create a File object representing the file specified by the filename
		        File f = new File(filename);
		        // Create a Scanner object to read from the file
		        Scanner r = new Scanner(f);
		        // Create an ArrayList to hold the rows of the CSV file
		        ArrayList<ArrayList<String>> s = new ArrayList<ArrayList<String>>();

		        // Read each line from the file
		        while (r.hasNextLine()) {
		            // Split the line by commas and convert it to an ArrayList of strings
		            // Then add the ArrayList to the ArrayList s
		            s.add(new ArrayList<String>(Arrays.asList(r.nextLine().split(","))));
		        }
		        // Return the ArrayList containing the CSV data
		        return s;

		    } catch (FileNotFoundException e) {
		        // Handle the case where the file is not found
		        System.out.println("FILE AIN'T FOUND, BROTHER");
		        return null; // Return null if csv fails 
		    }
		}
	
	/* Quinn made this ultra advanced and beautiful algorithmic masterpiece
	 */
	public static ArrayList<String> getColumn(ArrayList<ArrayList<String>> a, int column) {
	    // Create a new ArrayList to store the values of the specified column
	    ArrayList<String> res = new ArrayList<String>();
	    
	    // runs through arraylist 
	    for (int i = 0; i < a.size(); i++) {
	        // Add the element at the specified column index to the result ArrayList
	        res.add(a.get(i).get(column));
	    }
	    
	    // Return the result ArrayList containing values of the specified column
	    return res;
	}
	
	
	public static int intVaildtor() {
		//PROCESS takes user input 
		// scanner input if the input has a int value then break while loop by turning boolean on 
		Scanner input = new Scanner(System.in);
		 boolean numberEntered = false ; 

		// while loop
		while(numberEntered == false ) {
			System.out.println(" Enter option selected");
			if(input.hasNextInt()) {
				numberEntered = true;
			}else {// if input is string 
				System.out.println("Invaild Input. Enter number ");
				input.nextLine();
			}
			
		}
		//OUTPUT number user puts 
		// returns number 
		int num = input.nextInt();
		return num;
		
	}	
	
	public static void main(String[] args) {
		BoardGame game = new BoardGame();
		game.intro();
		ArrayList<String> s = getColumn(csv, 1);
		

		

	}
	
}

