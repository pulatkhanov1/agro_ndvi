package megafon.intern.second.task.controller;

import megafon.intern.second.task.model.Farmers;
import megafon.intern.second.task.service.FarmerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class FarmerController {
    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping("/farmersList")
    public String getAllEmployee(Model model) {
        List<Farmers> farmers = farmerService.findAllFarmers();
        model.addAttribute("farmers", farmers);
        return "farmerList";
    }

    @GetMapping("/createFarmer")
    public String createFarmerForm(Farmers farmers) {
        return "createFarmer";
    }

    @PostMapping("createFarmer")
    public String createFarmer(Farmers farmer) {
        farmerService.saveFarmer(farmer);
        return "redirect:/farmersList";
    }
    @GetMapping("deleteFarmer/{id}")
    public String deleteFarmer(@PathVariable("id") Long id){
    farmerService.deleteFarmer(id);
    return "redirect:/farmersList";
    }
    @GetMapping("/editFarmer/{id}")
    public String updateFarmerForm(@PathVariable("id") Long id, Model model) {
        Farmers farmer = farmerService.findfarmerById(id);
        model.addAttribute("farmer", farmer);
        return "updateFarmer";
    }
    @PostMapping("editFarmer")
    public String updateFarmer(Farmers farmer){
    farmerService.saveFarmer(farmer);
    return "redirect:/farmersList";}
}
