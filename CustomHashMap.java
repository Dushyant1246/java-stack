import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] table;

    static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public CustomHashMap() {
        table = new LinkedList[SIZE];
    }

    // Method to Enter data
    public void put(K key, V value) {
        int index = key.hashCode() % SIZE;
        if (table[index] == null) table[index] = new LinkedList<>();
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }

    // Method to get data
    public V get(K key) {
        int index = key.hashCode() % SIZE;
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) return entry.value;
            }
        }
        return null;
    }

    // Method to remove data
    public void remove(K key) {
        int index = key.hashCode() % SIZE;
        if (table[index] != null) {
            table[index].removeIf(entry -> entry.key.equals(key));
        }
    }
}
/*
CustomHashMap<String, Integer> customMap = new CustomHashMap<>();
customMap.put("One", 1);
customMap.put("Two", 2);
System.out.println("Custom HashMap Get Two: " + customMap.get("Two"));

Custom HashMap Get Two: 2
 */