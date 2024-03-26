package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.entity.TacoOrder;

public interface TacoOrderRepository extends CrudRepository<TacoOrder, Long> {

//    TacoOrder save(TacoOrder tacoOrder);
}
