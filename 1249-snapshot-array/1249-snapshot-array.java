class SnapMap{
    int snap_id;
    int value;
    SnapMap(int snap_id, int val){
        this.snap_id = snap_id;
        this.value = val;
    }
}
class SnapshotArray {
    HashMap<Integer, List<SnapMap>> map;
    int currSnapId = 0;
    public SnapshotArray(int length) {
        this.map = new HashMap();
        for(int i=0; i<length; i++){
            map.putIfAbsent(i, new ArrayList<>());
            map.get(i).add(new SnapMap(0, 0));
        }
    }
    
    public void set(int index, int val) {
        List<SnapMap> snapList = map.get(index);
        if (snapList.get(snapList.size() - 1).snap_id == currSnapId) {
            snapList.get(snapList.size() - 1).value = val; 
        } else {
            snapList.add(new SnapMap(currSnapId, val));
        }
    }
    
    public int snap() {
        return currSnapId++;

    }
    
    public int get(int index, int snap_id) {
        List<SnapMap> valueSnapPairs = map.get(index);
        
        //Binary Search on the valueTimePairs
        int l = 0;
        int r = valueSnapPairs.size()-1;
        int result = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(valueSnapPairs.get(mid).snap_id == snap_id){
                return valueSnapPairs.get(mid).value;
            }
            if(valueSnapPairs.get(mid).snap_id < snap_id){
                result = valueSnapPairs.get(mid).value;
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
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */