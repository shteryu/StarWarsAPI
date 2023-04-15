package dev.shteryu.star_wars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.shteryu.star_wars.errors.NotFoundObjectException;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.repository.PlanetPagingRepository;
import dev.shteryu.star_wars.repository.PlanetRepository;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepo;

    @Autowired
    private PlanetPagingRepository pagingRepo;

    public Planets save(Planets planets) {
        return planetRepo.save(planets);
    }

    public Page<Planets> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Planets findById(String planetId) {
        return planetRepo.findById(Integer.parseInt(planetId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Planet Not Found", Planets.class.getName(), planetId);
        });
    }

    public void deleteById(String planetId) {
        planetRepo.deleteById(Integer.parseInt(planetId));
    }
}
