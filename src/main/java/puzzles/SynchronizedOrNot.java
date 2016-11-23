package puzzles;

import java.util.*;

    public class SynchronizedOrNot {
        private Set<String> cache =  new HashSet<>();

        public synchronized void add(String value) {
            cache.add(value);
        }

        public boolean contains(String value) {
            return cache.contains(value);
        }
    }
