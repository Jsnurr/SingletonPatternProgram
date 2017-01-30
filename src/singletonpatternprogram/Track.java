package singletonpatternprogram;

import java.util.*; // Import the java utility package

/**
 * Singleton Pattern Program (Week 1)
 * John D. Snurr
 * PRG/421
 * November 29, 2016
 * Roland Morales
 */

public class Track
{
    private static final Track SINGLETON_TRACK = new Track(); // Declare and instantiate encapsulated reference to track
    private final String[] firstNameArray = new String[8]; // Declare and initialize an encapsulated 8 index array for first names
    private final String[] lastNameArray = new String[8]; //  Declare and initialize an encapsulated 8 index array for last names
    
    @SuppressWarnings("FieldMayBeFinal") // Suppress Final warning indicators
    private Set<Integer> availableLanes; // Declare encapsulated set for availableLanes
    
    public static Track getTrack() // Access for Track reference
    {
        return SINGLETON_TRACK; // Return SINGLETON_TRACK to caller
    }
    
    public String getFirstName(int position) // Accessor for index data in firstNameArray
    {
        return firstNameArray[position]; // Return String at position to caller
    }
    
    public String getLastName(int position) // Accessor for index data in lastNameArray
    {
        return lastNameArray[position]; // Return String at position to caller
    }
    
    private Track() // Private Track contructor
    {
        availableLanes = new HashSet<>(); // Intialize availableLanes
        
        for (int i = 1; i < 9; i++) // Loob through availableLanes...
        {
            availableLanes.add(i); // Creating and adding each lane
        }
    }
    
    public void addRunner(Integer lane, String firstName, String lastName) // Method for removing lane from availableLanes and adding
    {                                                                         // first and last name to their respective arrays
        if (availableLanes.remove(lane)) // If the lane can be removed...
        {
            firstNameArray[lane - 1] =  firstName; // Add the firstName to the firstNameArray
            lastNameArray[lane - 1] = lastName; // Add the lastName to the lastNameArray
            
            System.out.println(firstNameArray[lane - 1] + " " + lastNameArray[lane - 1] + " has been assigned to lane " + lane); // Output that the runner assignment has been accepted
        }
        else // Else if the lane can NOT be removed...
        {
            ValidateInput validation = new ValidateInput(); // Declare and instantiate new reference to ValidateInput
            
            System.out.print("Lane " + lane + " is already filled by " + firstNameArray[lane - 1] + " " + // Output that the lane already has a runner
                    lastNameArray[lane - 1] + ". Please enter a new lane to fill: ");                     // assigned and prompt for a new lane
            lane = validation.validateInt(false); // Validate and assign user input to lane integer
            
            Track track = Track.getTrack(); // Declare and instantiate reference to SINGLETON_TRACK
            track.addRunner(lane, firstName, lastName); // Call addRunner() with the new lane assignment
        }
    }
}

/**
 * John D. Snurr
 * November 29, 2016
 */

