class Main {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        System.out.println("get Value " + lru.get(1));
        lru.put(2, 10);
        lru.put(1, 5);
        lru.put(3, 15);
        System.out.println("Map size " + lru.map.size());
        System.out.println("get Value " + lru.get(2));
        lru.put(4, 20);
        System.out.println("Map size " + lru.map.size());
        System.out.println("get Value " + lru.get(1));

    }
}
