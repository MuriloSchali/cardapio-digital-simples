package com.exemple.cardapio.controller;

import com.exemple.cardapio.food.Food;
import com.exemple.cardapio.food.FoodRepository;
import com.exemple.cardapio.food.FoodRepositoryDTO;
import com.exemple.cardapio.food.FoodRequestDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//essa classe é a controler da nossa aplicação
@RestController
// requisicao - vai rodar o getAll
@RequestMapping("food")
public class FoodController {

    // istancia da classe repositry
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodRepositoryDTO> getAll() {
        // vai pégar todos os dados da tabela usando o repository
        List<FoodRepositoryDTO> foodList = repository.findAll().stream().map(FoodRepositoryDTO::new).toList();
        return foodList;
    }

}
