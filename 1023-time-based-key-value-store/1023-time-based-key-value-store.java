class TimeValue {
    int timestamp;
    String value;
    TimeValue(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    HashMap<String, List<TimeValue>> map;
    public TimeMap() {
        this.map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<TimeValue> valueTimePairs = map.get(key);
        
        //Binary Search on the valueTimePairs
        int l = 0;
        int r = valueTimePairs.size()-1;
        String result = "";
        while(l<=r){
            int mid = l+(r-l)/2;
            if(valueTimePairs.get(mid).timestamp == timestamp){
                return valueTimePairs.get(mid).value;
            }
            if(valueTimePairs.get(mid).timestamp < timestamp){
                result = valueTimePairs.get(mid).value;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */