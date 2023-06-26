package com.exemple.cardapio.food;

//serve para dados estaticos
public record FoodRepositoryDTO(Long id, String title, String image, Integer price) {

    public FoodRepositoryDTO(Food food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
