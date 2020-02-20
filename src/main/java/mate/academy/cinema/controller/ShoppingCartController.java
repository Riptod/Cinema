package mate.academy.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import mate.academy.cinema.dto.ShoppingCartRequestDto;
import mate.academy.cinema.dto.TicketDto;
import mate.academy.cinema.model.ShoppingCart;
import mate.academy.cinema.model.Ticket;
import mate.academy.cinema.service.MovieSessionServise;
import mate.academy.cinema.service.ShoppingCartService;
import mate.academy.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {

    @Autowired
    private MovieSessionServise movieSessionServise;
    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping(value = "/addmoviesession")
    public void addMovieSessionToSC(@RequestParam Long userId,
                                    @RequestBody ShoppingCartRequestDto requestDto) {
        shoppingCartService.addSession(movieSessionServise.get(requestDto.getMovieSessionId()),
                userService.get(userId));
    }

    @GetMapping(value = "/byuser")
    public List<TicketDto> getByuser(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return shoppingCart.getTickets()
                .stream().map(this::ticketToDto).collect(Collectors.toList());
    }

    private TicketDto ticketToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicketId(ticket.getId());
        ticketDto.setMovieTitle(ticket.getMovieSession().getMovie().getTitle());
        ticketDto.setCinemaHallId(ticket.getMovieSession().getCinemaHall().getId());
        ticketDto.setShowTime(ticket.getMovieSession().getShowTime().toString());
        return ticketDto;
    }
}
