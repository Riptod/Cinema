package mate.academy.cinema.service.impl;

import java.util.List;

import mate.academy.cinema.dao.CinemaHallDao;
import mate.academy.cinema.model.CinemaHall;
import mate.academy.cinema.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Autowired
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id);
    }
}
