import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] params = {"1", "2", "3","4"};
        List<String[]> result = pailiezuhe(params);
        System.out.println("总共有：" + result.size());
        for (String[] strings : result) {
            System.out.println(Arrays.toString(strings));
        }
    }

    /*
        param = 1,2,3

        0 a
        1，2，3

        1 a
        1,2,a
        1,a,3
        a,2,3

        2 a
        1,a,a
        a,2,a
        a,a,3

        3 a
        a,a,a
     */
    private static List<String[]> pailiezuhe(String[] params) {
        if (params.length == 1) {
            List<String[]> result = new ArrayList<>();
            result.add(new String[]{"a"});
            result.add(new String[]{params[0]});
            return result;
        }
        List<String[]> nResult = pailiezuhe(Arrays.copyOf(params, params.length - 1));
        List<String[]> aResult = new ArrayList<>();
        for (String[] strings : nResult) {
            String[] sNew = Arrays.copyOf(strings, strings.length + 1);
            sNew[sNew.length - 1] = "a";
            aResult.add(sNew);
        }
        List<String[]> realResult = new ArrayList<>();
        for (String[] strings : nResult) {
            String[] sNew = Arrays.copyOf(strings, strings.length + 1);
            sNew[sNew.length - 1] = params[params.length - 1];
            realResult.add(sNew);
        }
        realResult.addAll(aResult);
        return realResult;
    }
}
