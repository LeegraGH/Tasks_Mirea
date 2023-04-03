import java.util.*;
import java.util.concurrent.Semaphore;

public class SemMap<K, V> implements Map<K, V> {

    private Map<K, V> map = new HashMap<>();
    private Semaphore sem = new Semaphore(1, true);

    public SemMap(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public int size() {
        int size = 0;
        try {
            sem.acquire();
            size = map.size();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        try {
            sem.acquire();
            empty = map.isEmpty();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        return empty;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean isKey = false;
        try {
            sem.acquire();
            isKey = map.containsKey(key);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        return isKey;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean isValue = false;
        try {
            sem.acquire();
            isValue = map.containsValue(value);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        return isValue;
    }

    @Override
    public V get(Object key) {
        V getKey = null;
        try {
            sem.acquire();
            getKey = map.get(key);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        return getKey;
    }

    @Override
    public V put(K key, V value) {
        V putKeyValue = null;
        try {
            sem.acquire();
            putKeyValue = map.put(key, value);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        return putKeyValue;
    }

    @Override
    public V remove(Object key) {
        V removeKey = null;
        try {
            sem.acquire();
            removeKey = map.remove(key);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        return removeKey;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            sem.acquire();
            map.putAll(m);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
    }

    @Override
    public void clear() {
        try {
            sem.acquire();
            map.clear();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
    }

    @Override
    public Set<K> keySet() {
        Set<K> setOfKeys = null;
        try {
            sem.acquire();
            setOfKeys = map.keySet();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        assert setOfKeys != null;
        return setOfKeys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> allValues = null;
        try {
            sem.acquire();
            allValues = map.values();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        assert allValues != null;
        return allValues;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entry = null;
        try {
            sem.acquire();
            entry = map.entrySet();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        assert entry != null;
        return entry;
    }
}
