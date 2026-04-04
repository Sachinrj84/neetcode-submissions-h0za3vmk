class TimeMap {
    HashMap<String, List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k-> new ArrayList<>()).add( new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values= keyStore.getOrDefault(key, new ArrayList<>());
        int l=0, r=values.size()-1;
        String result="";
        while(l<=r){
            int m= (l+r)/2;
            if(values.get(m).getKey()<=timestamp){
                result=values.get(m).getValue();
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return result;
    }
}
