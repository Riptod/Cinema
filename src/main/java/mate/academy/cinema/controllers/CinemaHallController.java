package mate.academy.cinema.controllers;

import java.util.List;
import java.util.stream.Collectors;

import mate.academy.cinema.dto.CinemaHallDto;
import mate.academy.cinema.model.CinemaHall;
import mate.academy.cinema.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemahall")
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    @PostMapping(value = "/")
    public void addMovie(@RequestBody CinemaHallDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.getCapacity());
        cinemaHall.setDescription(requestDto.getDescription());
        cinemaHallService.add(cinemaHall);
    }

    @GetMapping(value = "/getAll")
    public List<CinemaHallDto> getAll() {
        return cinemaHallService.getAll().stream().map(this::cinemaHallToDto)
                .collect(Collectors.toList());
    }

    private CinemaHallDto cinemaHallToDto(CinemaHall cinemaHall) {
        CinemaHallDto cinemaHallDto = new CinemaHallDto();
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallDto.setDescription(cinemaHallDto.getDescription());
        return cinemaHallDto;
    }
}
