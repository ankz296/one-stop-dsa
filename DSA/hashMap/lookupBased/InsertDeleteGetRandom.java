package DSA.hashMap.lookupBased;

import java.util.*;

public class InsertDeleteGetRandom {


    /**
     * https://leetcode.com/problems/insert-delete-getrandom-o1
     * https://www.youtube.com/watch?v=69_s7mh8NYo
     * https://github.com/developer-docs/Leetcode-Solutions/blob/main/380.%20Insert%20Delete%20GetRandom%20O(1)
     */
    static class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;

            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!list.contains(val)) return false;

            int index = map.get(val);
            int lastValue = list.get(list.size() - 1);

            list.set(index, lastValue);
            map.put(lastValue, index);
            return true;

        }

        public int getRandom() {
            int randomInt = random.nextInt(list.size());
            return list.get(randomInt);
        }

        public void display() {
            System.out.println("Current Set: " + list);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RandomizedSet rs = new RandomizedSet();

        System.out.println("==============================");
        System.out.println("  RandomizedSet — O(1) Demo  ");
        System.out.println("==============================");
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. GetRandom");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: // INSERT
                    System.out.print("Enter value to insert: ");
                    int insertVal = sc.nextInt();
                    boolean inserted = rs.insert(insertVal);
                    if (inserted) {
                        System.out.println("✅ " + insertVal + " inserted!");
                    } else {
                        System.out.println("❌ " + insertVal + " already exists!");
                    }
                    rs.display();
                    break;

                case 2: // REMOVE
                    System.out.print("Enter value to remove: ");
                    int removeVal = sc.nextInt();
                    boolean removed = rs.remove(removeVal);
                    if (removed) {
                        System.out.println("✅ " + removeVal + " removed!");
                    } else {
                        System.out.println("❌ " + removeVal + " not found!");
                    }
                    rs.display();
                    break;

                case 3: // GETRANDOM
                    int randVal = rs.getRandom();
                    if (randVal == -1) {
                        System.out.println("❌ Set is empty!");
                    } else {
                        System.out.println("🎲 Random element: " + randVal);
                    }
                    break;

                case 4: // DISPLAY
                    rs.display();
                    break;

                case 5: // EXIT
                    System.out.println("Bye Ankit! 👋");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
