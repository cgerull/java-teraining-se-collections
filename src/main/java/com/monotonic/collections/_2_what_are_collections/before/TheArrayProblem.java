package com.monotonic.collections._2_what_are_collections.before;

import com.monotonic.collections.common.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class TheArrayProblem
{
    public static void main(String[] args)
    {
        var door = new Product("Wooden Door", 35);
        var floorPanel = new Product("Floor Panel", 25);
        var window = new Product("Glass Window", 10);

        // Create
        Product[] products = { door, floorPanel };

        // Print
        System.out.println(Arrays.toString(products));

        // Add
        products = add(window, products);
        System.out.println(Arrays.toString(products));

        // Duplicate
        products = add(window, products);
        System.out.println(Arrays.toString(products));

        System.out.println("******* And now with Collections ********");
        // var products = new ArrayList<Product>();
        // or
        Collection<Product> productCollection = new ArrayList<>();

        productCollection.add(door);
        productCollection.add(floorPanel);
        productCollection.add(window);

        System.out.println(productCollection);

        for (var product : productCollection) {
            System.out.println(product);
        }

        System.out.println("******* And now a while loop ********");
        Iterator<Product> it = productCollection.iterator();
        while (it.hasNext()) {
            var product = it.next();
            System.out.println(product);

            if (product.weight() > 20) {
                it.remove();
            }
        }

        System.out.println("******* After remove products heavier > 20 ********");
        System.out.println(productCollection);
        // Add products back
        productCollection.add(door);
        productCollection.add(floorPanel);

        var toRemove = new ArrayList<Product>();
        toRemove.add(door);
        toRemove.add(window);

        productCollection.removeAll(toRemove);System.out.println("******* removeAll [door, window] ********");
        System.out.println(productCollection);

    }

    private static Product[] add(Product product, Product[] array)
    {
        int length = array.length;
        var newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = product;
        return newArray;
    }
}
