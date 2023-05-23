package com.serenitydojo;

import java.util.*;
import java.util.stream.Collectors;

public class Catalog {
    private Map<Fruit, Double> fruitToPrice = new HashMap<>();

    public void setPriceOf(Fruit fruit, double price) {
        fruitToPrice.put(fruit, price);
    }
    public double getPriceOf(Fruit fruit) {
        if (!fruitToPrice.containsKey(fruit)) {
            throw new FruitUnavailableException("Fruit not found", null);
        }
        return fruitToPrice.get(fruit);
    }

    public List<Fruit> sortFruitsAlphabetically() {
        List<Fruit> sortedFruits = new ArrayList<>(fruitToPrice.keySet());
        Collections.sort(sortedFruits, Comparator.comparing(Fruit::name));
        return sortedFruits;
    }


//    public static Catalog withItems(CatalogItem catalogItem, CatalogItem catalogItem1, CatalogItem catalogItem2, CatalogItem catalogItem3) {
//        Catalog catalog = new Catalog();
//        catalog.fruitToPrice.put(catalogItem.getFruit().name(), catalogItem.getPrice());
//        catalog.fruitToPrice.put(catalogItem1.getFruit().name(), catalogItem1.getPrice());
//        catalog.fruitToPrice.put(catalogItem2.getFruit().name(), catalogItem2.getPrice());
//        catalog.fruitToPrice.put(catalogItem3.getFruit().name(), catalogItem3.getPrice());
//        return catalog;
//    }


    }






