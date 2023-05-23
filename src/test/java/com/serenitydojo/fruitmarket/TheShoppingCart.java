package com.serenitydojo.fruitmarket;

import com.serenitydojo.Catalog;
import com.serenitydojo.Fruit;
import com.serenitydojo.ShoppingCart;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TheShoppingCart {
    Catalog catalog = new Catalog();
    @Before
    public void setUpCatalog() {

        catalog.setPriceOf(Fruit.Apple, 4.00);
        catalog.setPriceOf(Fruit.Orange, 5.50);
        catalog.setPriceOf(Fruit.Banana, 6.00);
        catalog.setPriceOf(Fruit.Pear, 4.50);
    }
    //A shopping cart should initially be empty.
    @Test
    public void shoppingCartShouldBeEmpty() {
        ShoppingCart shoppingCart = new ShoppingCart(new Catalog());
        int numberOfItems = shoppingCart.getNumberOfItems();
        assertThat(numberOfItems).isEqualTo(0);
    }
    //You can add a single item to your shopping cart.
    @Test
    public void shoppingCartShouldBeAbleToAddSingleItem() {

        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        shoppingCart.addToCart(Fruit.Apple,2.0);
        int numberOfItems = shoppingCart.getNumberOfItems();
        assertThat(numberOfItems).isEqualTo(1);
        System.out.println("The number of items in the cart is " + numberOfItems);
    }
   //shopping cart should keep a running total of the items in your cart.
    @Test
    public void shoppingCartShouldKeepRunningTotal() {
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        shoppingCart.addToCart(Fruit.Apple,2.0);
        shoppingCart.addToCart(Fruit.Orange,3.0);
        shoppingCart.addToCart(Fruit.Banana,4.0);
        shoppingCart.addToCart(Fruit.Pear,5.0);
        double runningTotal = shoppingCart.getRunningTotal();
        assertThat(runningTotal).isEqualTo(68.75);
        System.out.println("The running total is " + runningTotal);
    }
    //You can remove items from your shopping cart
    @Test
    public void shoppingCartShouldBeAbleToRemoveItems() {
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        shoppingCart.addToCart(Fruit.Apple,2.0);
        shoppingCart.addToCart(Fruit.Orange,3.0);
        shoppingCart.addToCart(Fruit.Banana,4.0);
        shoppingCart.addToCart(Fruit.Pear,5.0);
        System.out.println("The number of items in the cart is " + shoppingCart.getNumberOfItems());
        shoppingCart.removeFromCart(Fruit.Apple,2.0);
        int numberOfItems = shoppingCart.getNumberOfItems();
        assertThat(numberOfItems).isEqualTo(3);
        System.out.println("The number of items in the cart is " + numberOfItems);
    }
    //You can remove all items of a particular type from your shopping cart.
    @Test
    public void shoppingCartShouldBeAbleToRemoveAllItemsOfAParticularType() {
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        shoppingCart.addToCart(Fruit.Apple,2.0);
        shoppingCart.addToCart(Fruit.Orange,3.0);
        shoppingCart.addToCart(Fruit.Banana,4.0);
        shoppingCart.addToCart(Fruit.Pear,5.0);
        System.out.println("The number of items in the cart is " + shoppingCart.getNumberOfItems());
        shoppingCart.removeAllFromCart(Fruit.Apple);
        int numberOfItems = shoppingCart.getNumberOfItems();
        assertThat(numberOfItems).isEqualTo(3);
        System.out.println("The number of items in the cart is " + numberOfItems);
    }
    //You can see the types of items in your shopping cart.
    @Test
    public void shoppingCartShouldBeAbleToSeeTypesOfItems() {
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        shoppingCart.addToCart(Fruit.Apple,2.0);
        shoppingCart.addToCart(Fruit.Orange,3.0);
        shoppingCart.addToCart(Fruit.Banana,4.0);
        shoppingCart.addToCart(Fruit.Pear,5.0);
     // print out types of items in cart
        System.out.println("The types of items in the cart are " + shoppingCart.getTypesOfItems());
    }
    //When you buy 5 kilos or more of any fruit, you get a 10% discount
    @Test
    public void shouldApplyDiscountWhenBuying5KilosOrMore() {
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        shoppingCart.addToCart(Fruit.Apple,5.0);
        double runningTotal = shoppingCart.getRunningTotal();
        assertThat(runningTotal).isEqualTo(18.0);
        System.out.println("The running total is " + runningTotal);
    }

    @Test
    public void shouldApplyDiscountWhenBuying5KilosOrMoreOfDifferentType() {
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        shoppingCart.addToCart(Fruit.Apple,5.0);
        shoppingCart.addToCart(Fruit.Orange,15.0);
        shoppingCart.addToCart(Fruit.Banana,5.0);
        shoppingCart.addToCart(Fruit.Pear,5.0);
        double runningTotal = shoppingCart.getRunningTotal();
        assertThat(runningTotal).isEqualTo(139.5);
        System.out.println("The running total is " + runningTotal);
    }


}
