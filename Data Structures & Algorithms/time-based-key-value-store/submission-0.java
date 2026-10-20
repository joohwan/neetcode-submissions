class TimeMap {

    private Map<String, TreeMap<Integer, String>> timeMap;
    
    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> sortedMap = timeMap.get(key);    
        if (sortedMap == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = sortedMap.floorEntry(timestamp);
        if (entry == null) {
            return "";
        }
        return entry.getValue();
    }

}
