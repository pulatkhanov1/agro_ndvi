package megafon.intern.second.task.repository;

import megafon.intern.second.task.model.Farmers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmers, Long> {
}
