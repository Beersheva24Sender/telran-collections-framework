package telran.util;

@SuppressWarnings("unchecked")
public abstract class AbstractMap<K, V> implements Map<K, V> {
    protected Set<Entry<K, V>> set;

    protected abstract Set<K> getEmptyKeySet();

    @Override
    public V get(Object key) {

        Entry<K, V> pattern = new Entry<>((K) key, null);
        Entry<K, V> entry = set.get(pattern);
        V res = null;
        if (entry != null) {
            res = entry.getValue();
        }
        return res;
    }

    @Override
    public V put(K key, V value) {

        Entry<K, V> pattern = new Entry<>((K) key, null);

        Entry<K, V> existingEntry = set.get(pattern);
        if (existingEntry != null) {
            V oldValue = existingEntry.getValue();
            existingEntry.setValue(value);
            return oldValue;
        }

        set.add(new Entry<>(key, value));
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        Entry<K, V> pattern = new Entry<>((K) key, null);

        Entry<K, V> existingEntry = set.get(pattern);
        boolean res = existingEntry != null ? true : false;
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> entry : set) {
            if (entry.getValue() == null && value == null) {
                return true;
            }
            if (entry.getValue() != null && entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = getEmptyKeySet();
        // TODO
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return set;
    }

    @Override
    public Collection<V> values() {
        List<V> valuesList = new ArrayList<>();
        for (Entry<K, V> entry : set) {
            valuesList.add(entry.getValue());
        }
        return valuesList;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

}
