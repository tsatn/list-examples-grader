import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.*;

public class TestListExamples {
  // @Test(timeout = 100)
  // public void testTimeout() {
  //   while(true) {}
  // }
  // Write your grading tests here!

  @Test(timeout = 100)
  public void testMerge() {
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
    List<String> output = ListExamples.merge(listOne, listTwo);
    assertArrayEquals(expected.toArray(), output.toArray());
  }

  class Checker implements StringChecker {
    public boolean checkString(String s) {
        return s.contains("a");
    }
  }

  @Test(timeout = 100)
  public void testFilter() {
    StringChecker sc = new Checker();

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
