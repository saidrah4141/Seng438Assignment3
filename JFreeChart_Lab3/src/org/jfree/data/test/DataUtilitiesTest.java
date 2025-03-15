package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities{

    private Mockery mockingContext;
    private Values2D values2D;
    private KeyedValues keyedValues;
    private KeyedValues resultValue;
    @Before
    public void setUp() throws Exception {
        mockingContext = new Mockery();
        values2D = mockingContext.mock(Values2D.class);
        keyedValues = mockingContext.mock(KeyedValues.class);
    }

   

    @Test
    public void testCalculateColumnTotal_ValidDataWithNonNullValues() {
        mockingContext.checking(new Expectations() {{
            one(values2D).getRowCount(); will(returnValue(2));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
            one(values2D).getValue(1, 0); will(returnValue(2.5));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals(10.0, result, 0.000000001d);
    }

    @Test
    public void testCalculateColumnTotal_ValidDataWithNullValues() {
        mockingContext.checking(new Expectations() {{
            one(values2D).getRowCount(); will(returnValue(2));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
            one(values2D).getValue(1, 0); will(returnValue(null));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals(7.5, result, 0.000000001d);
    }

    @Test
    public void testCalculateColumnTotal_EmptyData() {
        mockingContext.checking(new Expectations() {{
            one(values2D).getRowCount(); will(returnValue(0));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals(0.0, result, 0.000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateColumnTotal_NullData() {
        DataUtilities.calculateColumnTotal(null, 0);
    }

  

    @Test
    public void testCalculateColumnTotal_NullValuesInValidRows() {
        mockingContext.checking(new Expectations() {{
            allowing(values2D).getRowCount(); will(returnValue(3));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
            one(values2D).getValue(1, 0); will(returnValue(null));
            one(values2D).getValue(2, 0); will(returnValue(5.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0, new int[] {0, 1, 2});
        assertEquals(12.5, result, 0.000000001d);
    }

    @Test
    public void testCalculateColumnTotal_InvalidRows() {
        mockingContext.checking(new Expectations() {{
            allowing(values2D).getRowCount(); will(returnValue(2));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0, new int[] {0, 2});
        assertEquals(7.5, result, 0.000000001d);
    }

    @Test
    public void testCalculateColumnTotal_EmptyValidRowsArray() {
        mockingContext.checking(new Expectations() {{
            allowing(values2D).getRowCount(); will(returnValue(2));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 0, new int[] {});
        assertEquals(0.0, result, 0.000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateColumnTotal_NullDataWithValidRows() {
        DataUtilities.calculateColumnTotal(null, 0, new int[] {0, 1});
    }

   
    @Test
    public void testCalculateRowTotal_ValidDataWithNonNullValues() {
        mockingContext.checking(new Expectations() {{
            one(values2D).getColumnCount(); will(returnValue(2));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
            one(values2D).getValue(0, 1); will(returnValue(2.5));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0);
        assertEquals(10.0, result, 0.000000001d);
    }

    @Test
    public void testCalculateRowTotal_ValidDataWithNullValues() {
        mockingContext.checking(new Expectations() {{
            one(values2D).getColumnCount(); will(returnValue(2));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
            one(values2D).getValue(0, 1); will(returnValue(null));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0);
        assertEquals(7.5, result, 0.000000001d);
    }

    @Test
    public void testCalculateRowTotal_EmptyData() {
        mockingContext.checking(new Expectations() {{
            one(values2D).getColumnCount(); will(returnValue(0));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0);
        assertEquals(0.0, result, 0.000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRowTotal_NullData() {
        DataUtilities.calculateRowTotal(null, 0);
    }

    

    @Test
    public void testCalculateRowTotal_ValidCols() {
        mockingContext.checking(new Expectations() {{
            allowing(values2D).getColumnCount(); will(returnValue(3));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
            one(values2D).getValue(0, 2); will(returnValue(5.0));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0, new int[] {0, 2});
        assertEquals(12.5, result, 0.000000001d);
    }

    @Test
    public void testCalculateRowTotal_NullValuesInValidCols() {
        mockingContext.checking(new Expectations() {{
            allowing(values2D).getColumnCount(); will(returnValue(3));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
            one(values2D).getValue(0, 1); will(returnValue(null));
            one(values2D).getValue(0, 2); will(returnValue(5.0));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0, new int[] {0, 1, 2});
        assertEquals(12.5, result, 0.000000001d);
    }

    @Test
    public void testCalculateRowTotal_InvalidCols() {
        mockingContext.checking(new Expectations() {{
            allowing(values2D).getColumnCount(); will(returnValue(2));
            one(values2D).getValue(0, 0); will(returnValue(7.5));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0, new int[] {0, 2});
        assertEquals(7.5, result, 0.000000001d);
    }

    @Test
    public void testCalculateRowTotal_EmptyValidColsArray() {
        mockingContext.checking(new Expectations() {{
            allowing(values2D).getColumnCount(); will(returnValue(2));
        }});

        double result = DataUtilities.calculateRowTotal(values2D, 0, new int[] {});
        assertEquals(0.0, result, 0.000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRowTotal_NullDataWithValidCols() {
        DataUtilities.calculateRowTotal(null, 0, new int[] {0, 1});
    }

   

    @Test
    public void testCreateNumberArray_ValidData() {
        double[] data = {1.0, 2.0, 3.0};
        Number[] result = DataUtilities.createNumberArray(data);
        assertArrayEquals(new Number[] {1.0, 2.0, 3.0}, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray_NullData() {
        DataUtilities.createNumberArray(null);
    }

    

    @Test
    public void testCreateNumberArray2D_ValidData() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);
        assertArrayEquals(new Number[][] {{1.0, 2.0}, {3.0, 4.0}}, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray2D_NullData() {
        DataUtilities.createNumberArray2D(null);
    }

  

    @Test
    public void testGetCumulativePercentages_ValidData() {
        mockingContext.checking(new Expectations() {{
            allowing(keyedValues).getItemCount(); will(returnValue(3));
            allowing(keyedValues).getKey(0); will(returnValue("A"));
            allowing(keyedValues).getKey(1); will(returnValue("B"));
            allowing(keyedValues).getKey(2); will(returnValue("C"));
            one(keyedValues).getValue(0); will(returnValue(5));
            one(keyedValues).getValue(1); will(returnValue(9));
            one(keyedValues).getValue(2); will(returnValue(2));
        }});

        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals(0.3125, result.getValue("A").doubleValue(), 0.000000001d);
        assertEquals(0.875, result.getValue("B").doubleValue(), 0.000000001d);
        assertEquals(1.0, result.getValue("C").doubleValue(), 0.000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCumulativePercentages_NullData() {
        DataUtilities.getCumulativePercentages(null);
    }

    

    @Test
    public void testEqual_BothArraysNull() {
        assertTrue(DataUtilities.equal(null, null));
    }

    @Test
    public void testEqual_OneArrayNull() {
        assertFalse(DataUtilities.equal(null, new double[][] {{1.0, 2.0}}));
    }

    @Test
    public void testEqual_ArraysDifferentLengths() {
        assertFalse(DataUtilities.equal(new double[][] {{1.0, 2.0}}, new double[][] {{1.0, 2.0}, {3.0, 4.0}}));
    }

    @Test
    public void testEqual_ArraysSameLengthDifferentContents() {
        assertFalse(DataUtilities.equal(new double[][] {{1.0, 2.0}}, new double[][] {{1.0, 3.0}}));
    }

    @Test
    public void testEqual_ArraysSameLengthAndContents() {
        assertTrue(DataUtilities.equal(new double[][] {{1.0, 2.0}}, new double[][] {{1.0, 2.0}}));
    }

 

    @Test
    public void testClone_Valid2DArray() {
        double[][] source = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] result = DataUtilities.clone(source);
        assertNotSame(source, result);
        assertArrayEquals(source, result);
    }

    @Test
    public void testClone_NullRowsInSourceArray() {
        double[][] source = {{1.0, 2.0}, null, {3.0, 4.0}};
        double[][] result = DataUtilities.clone(source);
        assertNotSame(source, result);
        assertNull(result[1]);
        assertArrayEquals(source[0], result[0], 0.000000001d);
        assertArrayEquals(source[2], result[2], 0.000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClone_NullInput() {
        DataUtilities.clone(null);
    }
    

	 /* New Test Cases */
	 /* Calculate column total Start (With valid Rows) */
	 @Test
	 public void testCalculateColumnTotal_ValidRows() {
	     mockingContext.checking(new Expectations() {
	         {
	             one(mockingContext.mock(Values2D.class)).getRowCount();
	             will(returnValue(5));  
	             one(mockingContext.mock(Values2D.class)).getValue(1, 0);
	             will(returnValue(10.0));
	             one(mockingContext.mock(Values2D.class)).getValue(3, 0);
	             will(returnValue(20.0));
	         }
	     });

	     int[] validRows = {1, 3}; // Only these rows are valid
	     double result = DataUtilities.calculateColumnTotal(values, 0, validRows);

	     assertEquals("Total should sum 10.0 + 20.0", 30.0, result, .000000001d);
	 }
	 
	 /* Calculate column total End */
	
	 
	 
	 /* Calculate Row Total Start (With Valid Columns) */
	 @Test
	 public void testCalculateRowTotal_ValidColumns() {
	     mockingContext.checking(new Expectations() {
	         {
	             one(mockingContext.mock(Values2D.class)).getColumnCount();
	             will(returnValue(5)); 
	             one(mockingContext.mock(Values2D.class)).getValue(0, 1);
	             will(returnValue(10.0));
	             one(mockingContext.mock(Values2D.class)).getValue(0, 3);
	             will(returnValue(20.0));
	         }
	     });

	     int[] validCols = {1, 3}; // Only these columns are valid
	     double result = DataUtilities.calculateRowTotal(mockingContext.mock(Values2D.class), 0, validCols);

	     assertEquals("Total should sum 10.0 + 20.0", 30.0, result, 1e-9);
	 }
	 
	 @Test
	 public void testCalculateRowTotal_ColumnCountNegative() {
	     mockingContext.checking(new Expectations() {
	         {
	             one(mockingContext.mock(Values2D.class)).getColumnCount();
	             will(returnValue(-1)); // Force colCount to be negative
	         }
	     });

	     int[] validCols = {0, 1}; // Even with valid columns, total should remain 0
	     double result = DataUtilities.calculateRowTotal(mockingContext.mock(Values2D.class), 0, validCols);

	     // Since colCount < 0, the total should be 0.0
	     assertEquals("Total should be 0.0 when colCount is negative", 0.0, result, 1e-9);
	 }
	 
	 @Test
	 public void testCalculateRowTotal_NullValueIgnored() {
	     mockingContext.checking(new Expectations() {
	         {
	             one(mockingContext.mock(Values2D.class)).getColumnCount();
	             will(returnValue(3)); 
	             one(mockingContext.mock(Values2D.class)).getValue(0, 0);
	             will(returnValue(10.0)); //  valid
	             one(mockingContext.mock(Values2D.class)).getValue(0, 1);
	             will(returnValue(null)); //  should be ignored
	             one(mockingContext.mock(Values2D.class)).getValue(0, 2);
	             will(returnValue(20.0)); //  valid
	         }
	     });

	     int[] validCols = {0, 1, 2}; 
	     double result = DataUtilities.calculateRowTotal(mockingContext.mock(Values2D.class), 0, validCols);

	     assertEquals("Total should sum only non-null values: 10.0 + 20.0", 30.0, result, 1e-9);
	 }

	 /* Calculate Row total End */
	 
	 /* New Test Cases End */
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	 @Test
	 public void calculateColumnTotalForTwoValues() {

	     mockingContext.checking(new Expectations() {
	         {
	             one(mockingContext.mock(Values2D.class)).getRowCount();
	             will(returnValue(2));
	             one(mockingContext.mock(Values2D.class)).getValue(0, 0);
	             will(returnValue(7.5));
	             one(mockingContext.mock(Values2D.class)).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(mockingContext.mock(Values2D.class), 0);
	     // verify
	     assertEquals(10.0, result, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 @Test
	 public void calculateColumnTotalForNullValues() {

	     mockingContext.checking(new Expectations() {
	         {
	             one(mockingContext.mock(Values2D.class)).getRowCount();
	             will(returnValue(0));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(mockingContext.mock(Values2D.class), 0);
	     // verify
	     assertEquals(0, result, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 @Test
	 public void calculateRowTotalForTwoValues() {
	     mockingContext.checking(new Expectations() {
	         {
	             one(mockingContext.mock(Values2D.class)).getColumnCount();
	             will(returnValue(2));
	             one(mockingContext.mock(Values2D.class)).getValue(1, 0);
	             will(returnValue(8.5));
	             one(mockingContext.mock(Values2D.class)).getValue(1, 1);
	             will(returnValue(1.5));
	         }
	     });
	     double result2 = DataUtilities.calculateRowTotal(mockingContext.mock(Values2D.class), 1);
	     // verify
	     assertEquals(10.0, result2, .000000001d);    
	     // tear-down: NONE in this test method
	 }
	 
	 @Test
	 public void calculateRowTotalForNullValues() {
	     mockingContext.checking(new Expectations() {
	         {
	             one(mockingContext.mock(Values2D.class)).getColumnCount();
	             will(returnValue(0));
	         }
	     });
	     double result2 = DataUtilities.calculateRowTotal(mockingContext.mock(Values2D.class), 1);
	     // verify
	     assertEquals(0, result2, .000000001d);    
	     // tear-down: NONE in this test method
	 }
	 
	 @Test
	 public void getCumulativePercentagesForThreeValues() {
		 mockingContext.checking(new Expectations() {
			 {
				 one(mockingContext.mock(KeyedValues.class)).getItemCount();
				 will(returnValue(3));
				 one(mockingContext.mock(KeyedValues.class)).getValue(0);
				 will(returnValue(5));
				 one(mockingContext.mock(KeyedValues.class)).getValue(1);
				 will(returnValue(9));
				 one(mockingContext.mock(KeyedValues.class)).getValue(2);
				 will(returnValue(2));
			 }	 
		 });
		 
		 resultValue = DataUtilities.getCumulativePercentages(mockingContext.mock(KeyedValues.class));
		 
		 
		 assertEquals(0.3125, resultValue.getValue(0).doubleValue(), .000000001d);
		 assertEquals(0.875, resultValue.getValue(1).doubleValue(), .000000001d);
	     assertEquals(1.0, resultValue.getValue(2).doubleValue(), .000000001d);
	 }
	 
	 @Test
	 public void createNumberArrayWithMultipleValues() {
		 double[] array = {10,20,30};
		 
		 Number[] resultArray = DataUtilities.createNumberArray(array);
		 
		 assertEquals(array[0], resultArray[0]);
		 assertEquals(array[1], resultArray[1]);
		 assertEquals(array[2], resultArray[2]); 
	 }
	 
	 @Test
	 public void createNumberArrayWithOneValuee() {
		 double[] array = {10};
		 
		 Number[] resultArray = DataUtilities.createNumberArray(array);
		 
		 assertEquals(array[0], resultArray[0]);
	 }
	 
	 @Test
	 public void createNumberArrayWithNoValues() {
		 double[] array = {};
		 
		 Number[] resultArray = DataUtilities.createNumberArray(array);
		 
		 assertEquals(array[0], resultArray[0]);

	 }
	 
	 @Test
	 public void createNumberArray2DWithTwoArrays() {
		 double[][] array2D = {{10,20}, {11,22}};
		 
		 Number[][] resultArray2D = DataUtilities.createNumberArray2D(array2D);
		 
		 assertEquals(array2D[0][0], resultArray2D[0][0]);
		 assertEquals(array2D[0][1], resultArray2D[0][1]);
		 assertEquals(array2D[1][0], resultArray2D[1][0]);
		 assertEquals(array2D[1][1], resultArray2D[1][1]);
	 }
	 
	 @Test
	 public void createNumberArray2DWithEmptyArrays() {
		 double[][] array2D = {{}, {}};
		 
		 Number[][] resultArray2D = DataUtilities.createNumberArray2D(array2D);
		 
		 assertEquals(array2D[0][0], resultArray2D[0][0]);

	 }
}