import java.util.Collections;
import java.util.List;

public class Solution {

    private final List<Integer> data;

    public Solution(List<Integer> data) {
        this.data = data;
    }

    public Integer process() {
        if (data == null || data.isEmpty())
            return 0;
        Collections.sort(data);
        Integer firstPositif = findFirstPositif(data);
        if (firstPositif == null)
            return Integer.valueOf(data.get(data.size() - 1));
        else {
            Integer lastNegatif = findLastNegatif(firstPositif, data);
            if (lastNegatif == null || (Math.abs(lastNegatif) >= firstPositif))
                return Integer.valueOf(firstPositif);
            else
                return Integer.valueOf(lastNegatif);
        }
    }

    private Integer findLastNegatif(Integer firstPositif, List<Integer> data) {
        int i = data.indexOf(firstPositif);
        if (i == 0)
            return null;
        return data.get(i - 1);
    }

    private Integer findFirstPositif(List<Integer> data) {
        for (Integer v : data) {
            if (v >= 0)
                return v;
        }
        return null;
    }
}
