import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: abderrazak
 * Date: 9/19/13
 * Time: 3:01 PM
 */
public class TemperaturesTest {

    @Test
    public void solutionTestCase1() {
        Scanner in = new Scanner(System.in);
        List<Integer> data = loadData("in1.txt");
        Solution solution = new Solution(data);
        Assert.assertEquals(Integer.decode("1"), solution.process());
    }

    @Test
    public void solutionTestCase2() {
        List<Integer> data = loadData("in2.txt");
        Solution solution = new Solution(data);
        Assert.assertEquals(Integer.decode("0"), solution.process());
    }

    @Test
    public void solutionTestCase3() {
        List<Integer> data = loadData("in3.txt");
        Solution solution = new Solution(data);
        Assert.assertEquals(Integer.decode("2"), solution.process());
    }

    @Test
    public void solutionTestCase4() {
        List<Integer> data = loadData("in4.txt");
        Solution solution = new Solution(data);
        Assert.assertEquals(Integer.decode("-7"), solution.process());
    }

    private List<Integer> loadData(String s) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(s);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String stringLine;
            while ((stringLine = bufferedReader.readLine()) != null) {
                if (Integer.decode(stringLine) > 0) {
                    // read next line
                    stringLine = bufferedReader.readLine();
                    String[] split = stringLine.split(" ");
                    List<Integer> result = new ArrayList<Integer>();
                    for (int i = 0; i < split.length; i++) {
                        result.add(Integer.decode(split[i]));
                    }
                    return result;
                } else
                    return new ArrayList<Integer>();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
