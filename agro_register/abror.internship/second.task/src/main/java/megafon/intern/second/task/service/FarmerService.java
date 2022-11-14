package megafon.intern.second.task.service;

import megafon.intern.second.task.model.Farmers;
import megafon.intern.second.task.repository.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {
    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public Farmers findfarmerById(Long id) {
        return farmerRepository.getOne(id);
    }

    public List<Farmers> findAllFarmers() {
        return farmerRepository.findAll();
    }

    public void deleteFarmer(Long id) {
        farmerRepository.deleteById(id);
    }

    public Farmers saveFarmer(Farmers farmer) {
        return farmerRepository.save(farmer);
    }
}
