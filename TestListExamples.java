import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.*;

public class TestListExamples {

  class myChecker implements StringChecker {
    
    public boolean checkString(String s) {
        return s.contains("a");
    }
  }

  //test merge 
  @Test(timeout = 100)
  public void testBasicMerge() {

    List<String> listOne = new ArrayList<>();
    listOne.add("itemA");
    listOne.add("itemB");

    List<String> listTwo = new ArrayList<>();
    listTwo.add("itemC");
    listTwo.add("itemD");

    List<String> expected = new ArrayList<>();
    expected.add("itemA");
    expected.add("itemB");
    expected.add("itemC");
    expected.add("itemD");

    List<String> realOutput = ListExamples.merge(listOne, listTwo);
    assertArrayEquals(expected.toArray(), realOutput.toArray());
  }
  
  //test merge 
  @Test(timeout=100)
  public void testMergeArray() {

    List<String> arr1 = new ArrayList<String>(Arrays.asList("berrie", "milk"));
    List<String> arr2 = new ArrayList<String>(Arrays.asList("salt", "chocolate"));
    List<String> mergedArr = new ArrayList<String>(Arrays.asList("berrie", "milk", "salt", "chocolate"));
    
    assertEquals(mergedArr, ListExamples.merge(arr1, arr2));
  }
  
  //test merge 
  @Test(timeout = 100)
	public void testMergeEmptyInputs() {
  
		ArrayList<String> emptyArrOne = new ArrayList<>();
		ArrayList<String> emptyArrTwo = new ArrayList<>();
		String[] expected = {};

		assertArrayEquals(expected, ListExamples.merge(emptyArrOne, emptyArrTwo).toArray());
	}

  //test filter
  @Test(timeout = 100)
  public void testFilter() {

    StringChecker sc = new myChecker();

    List<String> strList = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    String[] inputArr = {"apple", "acron", "excluded"};
    String[] filtered = {"apple", "acron"};
    
    for(String s: inputArr) { 
      strList.add(s); 
    }
    for(String s: filtered) { 
      expected.add(s); 
    }

    assertEquals(expected, ListExamples.filter(strList, sc));
  }
}
