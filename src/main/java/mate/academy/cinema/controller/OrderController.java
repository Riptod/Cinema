package mate.academy.cinema.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import mate.academy.cinema.dto.OrderRequestDto;
import mate.academy.cinema.dto.OrderResponseDto;
import mate.academy.cinema.dto.TicketDto;
import mate.academy.cinema.model.Order;
import mate.academy.cinema.model.Ticket;
import mate.academy.cinema.service.OrderService;
import mate.academy.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/complete")
    public String completeOrder(@RequestBody @Valid OrderRequestDto requestDto) {
        orderService.completeOrder(userService.get(requestDto.getUserId()));
        return "Order completed successfully";
    }

    @GetMapping("/getOrder")
    public List<OrderResponseDto> getOrderHistory(@RequestParam Long userId) {
        return orderService.getOrderHistory(userService.get(userId)).stream()
                .map(this::ticketDtoFromOrder).collect(Collectors.toList());
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
