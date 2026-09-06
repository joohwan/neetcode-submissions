class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append(":");
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> original = new ArrayList<>();
        int start = 0, pos = 0;
        while ((pos = str.indexOf(":", start)) != -1) {
            int length = Integer.valueOf(str.substring(start, pos));
            original.add(str.substring(pos+1, pos+1+length));
            start = pos+1+length;
        }
        return original;
    }
}
