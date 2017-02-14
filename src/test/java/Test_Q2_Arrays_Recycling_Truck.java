import org.junit.Test;
import java.util.ArrayList;

import java.io.ByteArrayInputStream;


import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class Test_Q2_Arrays_Recycling_Truck {

    @Test
    public  void testGetRecyclingPerHouse() {


        int[] crateInput = {4, 3, 6, 2};

        String input = "";
        for (Integer i : crateInput) {
            input += i + "\n";
        }

        //input = elements of array separated by \n e.g. {4, 3, 6} becomes  "4\n3\n\6\n"

        //Where does the user input come from?
        //Can replace the System.in input stream with an input stream of our creation
        //credit to this Stack Overflow http://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[] recycling = Q2_Arrays_Recycling_Truck.getRecyclingPerHouse(crateInput.length);
        assertArrayEquals(crateInput, recycling);

        //And reset the System.in input stream when done
        System.setIn(System.in);

    }

    @Test
    public void testCalculateTotal() {

        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Totals 12
        assertEquals(12, Q2_Arrays_Recycling_Truck.calculateTotal(testHouseCrates));

    }

    @Test
    public void testCalculateMax() {

        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Max is 5
        assertEquals(5, Q2_Arrays_Recycling_Truck.calculateMax(testHouseCrates));

        int[] testHouseCrates2 = { 4, 6, 0, 1, 6 } ;  // Joint equal max
        assertEquals(6, Q2_Arrays_Recycling_Truck.calculateMax(testHouseCrates2));

        int[] testHouseCrates3 = { 0, 0, 0, 0, 0 } ;  // All zeros
        assertEquals(0, Q2_Arrays_Recycling_Truck.calculateMax(testHouseCrates3));

    }

    @Test
    public void testCalculateMin() {

        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // Min is 0
        assertEquals(0, Q2_Arrays_Recycling_Truck.calculateMin(testHouseCrates));

        int[] testHouseCrates2 = { 4, 6, 2, 3, 2 } ;  // Joint equal min
        assertEquals(2, Q2_Arrays_Recycling_Truck.calculateMin(testHouseCrates2));

        int[] testHouseCrates3 = { 0, 0, 0, 0, 0 } ;  // All zeros
        assertEquals(0, Q2_Arrays_Recycling_Truck.calculateMin(testHouseCrates3));

    }


    @Test
    public void testCalculateHouseWithMostRecycling() {

        int[] testHouseCrates = { 4, 2, 0, 1, 5} ;  // House with max is house 4
        int max = 5;
        assertEquals(4, Q2_Arrays_Recycling_Truck.calculateHouseWithMostRecycling(testHouseCrates, max));

        int[] testHouseCrates2 = { 4, 2, 10, 1, 5} ;  // House with max is house 2
        max = 10;
        assertEquals(2, Q2_Arrays_Recycling_Truck.calculateHouseWithMostRecycling(testHouseCrates2, max));

//        int[] testHouseCrates3 = { 4, 7, 0, 7, 5} ;  // 1 and 3 are both max, can pick either
//        max = 7;
//        ListArray<Integer> calcMaxHouse = Q2_Arrays_Recycling_Truck.calculateHouseWithMostRecycling(testHouseCrates3, max);
//
//        assertTrue(calcMaxHouse.get(0) == 1 || calcMaxHouse.get(0) == 3);


    }
}
