package diana.springframework.msscbeerservice.repositories;

import diana.springframework.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

// automatically seen as repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
