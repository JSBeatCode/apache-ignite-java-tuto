package test;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

public class IgniteExample {

    public static void main(String[] args) {
        // Start Ignite node
        try (Ignite ignite = Ignition.start()) {
            System.out.println("Apache Ignite is up and running!");

            // Create cache
            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("exampleCache");

            // Create
            cache.put(1, "Hello, Ignite!");

            // Read
            String value = cache.get(1);
            System.out.println("Retrieved from cache: " + value);

            // Update
            cache.put(1, "Updated value");

            // Read updated value
            value = cache.get(1);
            System.out.println("Updated value: " + value);

            // Delete
            cache.remove(1);

            // Read after deletion (should be null)
            value = cache.get(1);
            System.out.println("Value after deletion: " + value);
        }
    }
}
