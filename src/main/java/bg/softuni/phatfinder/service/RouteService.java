package bg.softuni.phatfinder.service;

import bg.softuni.phatfinder.data.RouteRepository;
import bg.softuni.phatfinder.model.DTOs.RouteShortIfoDTO;
import bg.softuni.phatfinder.model.entities.Picture;
import bg.softuni.phatfinder.model.entities.Route;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private RouteRepository routeRepository;
    private Random random;
    private ModelMapper modelMapper;


    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper();
        this.random = new Random();

    }
    @Transactional
    public List<RouteShortIfoDTO> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(this::mapToShortIfo)
                .toList();
    }

    private RouteShortIfoDTO mapToShortIfo(Route route) {

        RouteShortIfoDTO dto = modelMapper.map(route, RouteShortIfoDTO.class);

        Optional<Picture> first = route.getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());

        return dto;
    }

    @Transactional
    public RouteShortIfoDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount);

        Optional<Route> route = routeRepository.findById(randomId + 1);


        return mapToShortIfo(route.get());
    }
}
