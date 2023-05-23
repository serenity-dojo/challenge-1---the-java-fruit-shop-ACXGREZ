package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.Fruit;
import com.serenitydojo.FruitUnavailableException;
import org.junit.Test;

import java.util.List;

import static com.serenitydojo.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest {

    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
// TODO: Uncomment this code and make it work
        Catalog catalog = new Catalog();

         catalog.setPriceOf(Apple, 4.00);
         assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
         catalog.setPriceOf(Orange,5.50);
         assertThat(catalog.getPriceOf(Orange)).isEqualTo(5.50);
         catalog.setPriceOf(Banana,6.00);
         assertThat(catalog.getPriceOf(Banana)).isEqualTo(6.00);
         catalog.setPriceOf(Pear,4.50);
         assertThat(catalog.getPriceOf(Pear)).isEqualTo(4.50);
         System.out.println("Price of Apple is " + catalog.getPriceOf(Apple));
         System.out.println("Price of Orange is " + catalog.getPriceOf(Orange));
         System.out.println("Price of Banana is " + catalog.getPriceOf(Banana));
         System.out.println("Price of Pear is " + catalog.getPriceOf(Pear));

    }

    @Test
    public void shouldListAvailableFruitsAlphabetically() {
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Pear, 4.50);
        catalog.setPriceOf(Apple, 4.00);
        catalog.setPriceOf(Banana, 6.00);
        catalog.setPriceOf(Orange, 5.50);
    //sort the list of fruits alphabetically
        List<Fruit> sortedFruits = catalog.sortFruitsAlphabetically();
    //assert that the fruit are listed alphabetically
        assertThat(sortedFruits.get(0)).isEqualTo(Apple);
        assertThat(sortedFruits.get(1)).isEqualTo(Banana);
        assertThat(sortedFruits.get(2)).isEqualTo(Orange);
        assertThat(sortedFruits.get(3)).isEqualTo(Pear);
    //print the list of fruits
        System.out.println("The list of fruits are " + sortedFruits);
    }

    @Test
    public void shouldReportThePriceOfAGivenFruit() {
        // catalog should report the price of a given fruit
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Pear, 4.50);
        catalog.setPriceOf(Apple, 4.00);
        catalog.setPriceOf(Banana, 6.00);
        catalog.setPriceOf(Orange, 5.50);
        //assert that the price of a given fruit is correct
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
        assertThat(catalog.getPriceOf(Banana)).isEqualTo(6.00);
        assertThat(catalog.getPriceOf(Orange)).isEqualTo(5.50);
        assertThat(catalog.getPriceOf(Pear)).isEqualTo(4.50);
        //print the price of a given fruit
        System.out.println("The price of Apple is " + catalog.getPriceOf(Apple));
        System.out.println("The price of Banana is " + catalog.getPriceOf(Banana));
        System.out.println("The price of Orange is " + catalog.getPriceOf(Orange));
        System.out.println("The price of Pear is " + catalog.getPriceOf(Pear));

    }

    @Test(expected = FruitUnavailableException.class)
    public void shouldThrowAFruitUnavailableExceptionIfTheFruitIsNotCurrentlyAvailable() {
        // catalog should throw a FruitUnavailableException if the fruit is not currently available
        Catalog catalog = new Catalog();
        catalog.setPriceOf(Pear, 4.50);
        catalog.setPriceOf(Apple, 4.00);
        catalog.setPriceOf(Banana, 6.00);
        catalog.setPriceOf(Orange, 5.50);
        catalog.getPriceOf(Pineapple);
        };



//    @Test
//    public void shouldListAvailableFruitsAlphabetically() {
//// TODO: Uncomment this code and make it work
//         Catalog catalog = Catalog.withItems(
//                 new CatalogItem(Pear, 1),
//                 new CatalogItem(Apple, 1),
//                 new CatalogItem(Banana, 1),
//                 new CatalogItem(Orange, 1)
//         );
//         List<CatalogItem> availableFruits = catalog.getAvailableFruits();
//         assertThat(availableFruits.get(0).getFruit()).isEqualTo(Apple);
//         assertThat(availableFruits.get(1).getFruit()).isEqualTo(Banana);
//         assertThat(availableFruits.get(2).getFruit()).isEqualTo(Pear);
//    }
}