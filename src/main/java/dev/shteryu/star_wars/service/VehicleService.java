package dev.shteryu.star_wars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.shteryu.star_wars.errors.NotFoundObjectException;
import dev.shteryu.star_wars.models.Vehicles;
import dev.shteryu.star_wars.repository.VehiclePagingRepository;
import dev.shteryu.star_wars.repository.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepo;

    @Autowired
    private VehiclePagingRepository pagingRepo;

    public Vehicles save(Vehicles vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public Page<Vehicles> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Vehicles findById(String vehicleId) {
        return vehicleRepo.findById(Integer.parseInt(vehicleId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Vehicle Not Found", Vehicles.class.getName(), vehicleId);
        });
    }

    public void deleteById(String vehicleId) {
        vehicleRepo.deleteById(Integer.parseInt(vehicleId));
    }
}
