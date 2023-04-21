package dev.shteryu.star_wars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.shteryu.star_wars.errors.NotFoundObjectException;
import dev.shteryu.star_wars.models.Starships;
import dev.shteryu.star_wars.repository.StarshipPagingRepository;
import dev.shteryu.star_wars.repository.StarshipRepository;

@Service
public class StarshipService {

    @Autowired
    private StarshipRepository starshipRepo;

    @Autowired
    private StarshipPagingRepository pagingRepo;

    public Starships save(Starships starship) {
        return starshipRepo.save(starship);
    }

    public Page<Starships> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Starships findById(String starshipId) {
        return starshipRepo.findById(Long.parseLong(starshipId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Starship Not Found", Starships.class.getName(), starshipId);
        });
    }

    public void deleteById(String starshipId) {
        starshipRepo.deleteById(Long.parseLong(starshipId));
    }
}
