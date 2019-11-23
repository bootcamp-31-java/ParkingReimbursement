/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.services;

import bootcamp.SpringSecurity.repositories.TicketRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lee Tae Yong
 */
@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

//    public Iterable<Tikcet> getAll() {
//        return ticketRepository.findAll();
//    }
//
//    public Optional<Tikcet> getById(Integer id) {
//        return ticketRepository.findById(id);
//    }
//
//    public void delete(Tikcet ticket) {
//        ticketRepository.delete(ticket);
//    }
//
//    public Tikcet save(Tikcet ticket) {
//        return ticketRepository.save(ticket);
//    }

}
