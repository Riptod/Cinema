package mate.academy.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.cinema.dto.OrderResponseDto;
import mate.academy.cinema.dto.TicketDto;
import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.Ticket;
import mate.academy.cinema.service.OrderService;
import mate.academy.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/complete")
    public String completeOrder(Authentication authentication) {
        orderService.completeOrder(userService.findByEmail(authentication.getName()));
        return "Order completed successfully";
    }

    @GetMapping("/getOrder")
    public List<OrderResponseDto> getOrderHistory(Authentication authentication) {
        return orderService.getOrderHistory(userService.findByEmail(authentication.getName()))
                .stream().map(this::ticketDtoFromOrder).collect(Collectors.toList());
    }

    private TicketDto ticketToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicketId(ticket.getId());
        ticketDto.setMovieTitle(ticket.getMovieSession().getMovie().getTitle());
        ticketDto.setCinemaHallId(ticket.getMovieSession().getCinemaHall().getId());
        ticketDto.setShowTime(ticket.getMovieSession().getShowTime().toString());
        return ticketDto;
    }

    private OrderResponseDto ticketDtoFromOrder(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setOrderDate(order.getOrderTime().toString());
        responseDto.setUserEmail(order.getUser().getEmail());
        responseDto.setTickets(order.getTickets().stream()
                .map(this::ticketToDto).collect(Collectors.toList()));
        return responseDto;
    }
}
