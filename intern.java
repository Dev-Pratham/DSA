public class intern {
    public static void main(String[] args) {
        String str1 = new String("hello");
         String str2 = "hello";

        // Before using intern()
        System.out.println(str1 == str2); // Output: false (different references)

        // Using intern()
        String str3 = str1.intern();

        // After using intern(), both str2 and str3 refer to the same string in the pool
        System.out.println(str2 == str3); // Output: true (same reference)
    }
}

/*
 * The intern() method in Java is a native method of the String class, which is used to ensure that all identical string literals share the same memory reference. It helps in saving memory by storing only one copy of each distinct string value in the string pool.

How the intern() method works:

When you call intern() on a String object, it checks whether the string already exists in the string pool.

If the string exists, it returns the reference to the pooled instance.

If the string does not exist in the pool, it adds the string to the pool and returns the reference to this new instance.

Explanation of the Example:
  str1 is created using new String(), which creates a new object in the heap memory (not in the string pool).
  str2 is a string literal and is stored in the string pool.
  When str1.intern() is called, the JVM checks if "hello" is already in the string pool (which it is because of str2), so it returns a reference to the pooled string.
  Now, str3 and str2 refer to the same object in the string pool.

Why Use intern()?

  Memory Efficiency: It helps in reducing memory usage by reusing instances of strings that have the same value.

  Performance: It can improve performance in applications where many string comparisons are made, as comparisons between string literals (which use the == operator) are faster when they refer to the same object.

Important Points:

Strings created with new String() are not automatically added to the string pool, but calling intern() can add them.

String literals are automatically interned by the JVM, so they are stored in the string pool by default.

Overusing intern() can lead to increased memory usage for the string pool, especially if many unique strings are being interned.

In summary, the intern() method ensures that strings with the same content share the same memory reference, which can be useful in optimizing memory usage and improving performance in some scenarios.
 */


 /*
  * 
  what if i remove the string2 now there is no string "hello" in string pool then will above code work?

Yes, the code will still work even if you remove String str2 = "hello";.

Here’s why:

Scenario Without str2:
If you remove the str2 declaration, there will initially be no literal "hello" in the string pool. However, when you call str1.intern(), the following happens:

The JVM checks whether the string "hello" is already in the string pool.
Since it's not there (because you removed str2), the JVM will add "hello" to the string pool and return the reference to the newly added string in the pool.
So, even without str2, the interned string will be placed in the pool when you call intern().

Updated Example Without str2:
java
Copy code
public class Main {
    public static void main(String[] args) {
        String str1 = new String("hello");  // Created in heap, not the string pool

        // Intern the string, this adds "hello" to the string pool if it's not already there
        String str3 = str1.intern();        

        // Check if "hello" is now in the pool and has the same reference
        System.out.println("hello" == str3); // Output: true
    }
}
Explanation:
When you call str1.intern(), the string "hello" is added to the pool if it is not already there.
The expression "hello" == str3 will now return true because "hello" (the string literal) and str3 (the interned string) both refer to the same object in the string pool.
Conclusion:
Even if there was no "hello" in the string pool initially, calling intern() ensures that the string "hello" is placed in the pool and returns the reference to it. Hence, the code will still work as expected.
  */
