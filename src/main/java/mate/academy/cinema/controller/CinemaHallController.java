package mate.academy.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
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
@RequestMapping("/cinemahalls")
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    @PostMapping
    public String addCinemaHall(@RequestBody @Valid CinemaHallDto requestDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(requestDto.getCapacity());
        cinemaHall.setDescription(requestDto.getDescription());
        cinemaHallService.add(cinemaHall);
        return "Cinema hall added successfully";
    }

    @GetMapping
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
