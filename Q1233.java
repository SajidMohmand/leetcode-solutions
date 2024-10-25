import java.util.*;
public class Q1233 {
    public static List<String> removeSubfolders(String[] folder) {
        List<String> dir = Arrays.asList(folder);
        List<String> res = new ArrayList<>();
        Collections.sort(dir);
        res.add(dir.get(0));
        for (int i = 1; i < dir.size(); i++) {
            String curr = dir.get(i);
            String prev = res.get(res.size() - 1);
            int l = prev.length();
            if (!(curr.length() > l && curr.charAt(l) == '/' && prev.equals(curr.substring(0, l)))) {
                res.add(curr);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String[] folder = {"/a", "/a/j", "/c/d/e", "/c/d", "/b"};
        List<String> result = removeSubfolders(folder);
        System.out.println(result);
    }
}
