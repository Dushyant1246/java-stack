import java.util.*;

class CircularTour {
    // Function to find the starting petrol pump index using a queue
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>(); // Queue to track petrol pumps
        int surplus = 0; // Track available petrol
        int deficit = 0; // Track fuel shortage

        for (int i = 0; i < n; i++) {
            int netPetrol = petrol[i] - distance[i]; // Petrol left after traveling
            surplus += netPetrol;
            queue.add(i); // Add pump index to queue

            // If surplus becomes negative, we can't complete the tour from 'start'
            if (surplus < 0) {
                // Remove pumps from the queue since the journey failed
                while (!queue.isEmpty()) {
                    queue.poll();
                }
                deficit += surplus; // Store total fuel shortage
                surplus = 0; // Reset surplus petrol
            }
        }

        // If the total fuel (surplus + deficit) is non-negative, a solution exists
        return (surplus + deficit >= 0) && !queue.isEmpty() ? queue.peek() : -1;
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};  // Petrol available at each pump
        int[] distance = {6, 5, 3, 5}; // Distance to the next pump

        int startIndex = findStartingPoint(petrol, distance);

        if (startIndex == -1) {
            System.out.println("No possible starting point.");
        } else {
            System.out.println("Start at petrol pump index: " + startIndex);
        }
    }
}
