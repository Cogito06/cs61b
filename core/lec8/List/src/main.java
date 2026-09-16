public class main {
    public String longest(List<String> strList){
        int longestIndex = 0;
        String currMax = strList.get(0);
        for(int i = 0; i < strList.size(); i ++){
            String cur = strList.get(i);
            if(cur.length() > currMax.length()){
                longestIndex = i;
                currMax = cur;
            }
        }
        return strList.get(longestIndex);
    }

    static void main(String[] args) {

    }
}
