package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class VoteController {
    @Autowired
    DishRepository dishRepository;

    @RequestMapping("/")
    public String homePage(Model model)
    {

        model.addAttribute("dishes",dishRepository.findAll());

        return "displayvote";
    }

    @RequestMapping("/adddish")
    public String addPet(Model model)
    {
        model.addAttribute("aDish", new Dish());

        return "adddish";
    }

    @RequestMapping("/savedish")
    public String savePet(@ModelAttribute("aDish") Dish dish, Model model)
    {

        dishRepository.save(dish);
        model.addAttribute("dishes",dishRepository.findAll());
        return "displayvote";
    }

    @RequestMapping("/redirecttasty/{id}")
    public String redirectTasty(@PathVariable("id") long id, Model model){
        Dish dishu=dishRepository.findById(id).get();
        dishu.setTastyCount(dishu.getTastyCount() + 1);
        if(dishu.getTastyCount()>dishu.getNastyCount())
            dishu.setIsTasty(1);
        else if(dishu.getTastyCount()< dishu.getNastyCount())
            dishu.setIsTasty(-1);
        else {
            dishu.setIsTasty(0);
        }

        dishRepository.save(dishu);
        return "redirect:/";
    }
    @RequestMapping("/redirectnasty/{id}")
    public String redirectNasty(@PathVariable("id") long id, Model model){
        Dish dishu=dishRepository.findById(id).get();
        dishu.setNastyCount(dishu.getNastyCount() + 1);
        if(dishu.getTastyCount()>dishu.getNastyCount())
            dishu.setIsTasty(1);
        else if(dishu.getTastyCount()< dishu.getNastyCount())
            dishu.setIsTasty(-1);
        else {
            dishu.setIsTasty(0);
        }

        dishRepository.save(dishu);

        return "redirect:/";
    }



}
