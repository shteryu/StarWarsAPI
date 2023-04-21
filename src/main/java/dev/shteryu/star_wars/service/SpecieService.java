package dev.shteryu.star_wars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.shteryu.star_wars.errors.NotFoundObjectException;
import dev.shteryu.star_wars.models.Species;
import dev.shteryu.star_wars.repository.SpeciePagingRepository;
import dev.shteryu.star_wars.repository.SpecieRepository;

@Service
public class SpecieService {

    @Autowired
    private SpecieRepository specieRepo;

    @Autowired
    private SpeciePagingRepository pagingRepo;

    public Species save(Species specie) {
        return specieRepo.save(specie);
    }

    public Page<Species> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Species findById(String specieId) {
        return specieRepo.findById(Long.parseLong(specieId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Specie Not Found", Species.class.getName(), specieId);
        });
    }

    public void deleteById(String specieId) {
        specieRepo.deleteById(Long.parseLong(specieId));
    }
}
