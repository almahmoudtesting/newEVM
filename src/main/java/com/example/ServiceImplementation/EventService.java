package com.example.ServiceImplementation;
import com.example.DTOs.EventDTO;
import com.example.Entity.Event;
import com.example.Entity.Users;
import com.example.Repository.EventRepository;
import com.example.Repository.UserRepository;
import com.example.ServiceInterface.EventInterface;
import javassist.tools.web.BadHttpRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventInterface {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Event AddEvent(EventDTO eventDTO, Long id) {

        Event event = new Event();
        event= modelMapper.map(eventDTO,Event.class);

        LocalDate date = LocalDate.now().minusDays(1);
        if (date.isBefore(event.getEventdate())){

        event.setOrganizerid(userRepository.findById(id).get());
            return eventRepository.save(event);
       }
       return event;
    }

    public Iterable<Event> findAll() {
        return eventRepository.findAll(); }


        public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void DeleteEvent(Long id) {
        Event event = eventRepository.findById(id).get();
        event.setDeleted(true);
        eventRepository.save(event);
    }

    @Override
    public void UpdateEvent(EventDTO eventDTO, Long id) {

        Event event1= eventRepository.findById(id).get();
        Event event= modelMapper.map(eventDTO,Event.class);

        event.setEventid(id);
        event.setOrganizerid(event1.getOrganizerid());

        eventRepository.save(event);
    }

    @Override
    public List<Event> ViewApprovedEvents() {
        LocalDate d = LocalDate.now();
        List<Event> list =new ArrayList<>();
        list= (List<Event>) eventRepository.findAll();
        List<Event> list1=new ArrayList<>();
        for (Event vevent:list) {

            if (vevent.isApproved() && !vevent.isDeleted() && d.isBefore(vevent.getEventdate()))

                list1.add(vevent);
        }
        return list1;
    }

    @Override
    public void ApproveEvent(Long id) {
        Event aevent = eventRepository.findById(id).get();
        aevent.setApproved(true);
        eventRepository.save(aevent);
    }

    @Override
    public List<Event> findByEventcity(String eventcity) {

    return eventRepository.findByEventcity(eventcity);
}

    @Override
    public List<Event> findByEventdate(LocalDate eventdate) {
        return eventRepository.findByEventdate(eventdate);
    }

    @Override
    public List<Event> findByEventcityAndEventdate(String eventcity, LocalDate eventdate) {
        return eventRepository.findByEventcityAndEventdate(eventcity,eventdate);
    }

    @Override
    public List<Event> ViewDisapprovedEvents() {
        LocalDate dd = LocalDate.now();
        List<Event> list2 =new ArrayList<>();
        list2= (List<Event>) eventRepository.findAll();
        List<Event> list3=new ArrayList<>();
        for (Event vevent:list2) {

            if (!vevent.isApproved() && !vevent.isDeleted() && dd.isBefore(vevent.getEventdate()))

                list3.add(vevent);
        }
        return list3;
    }

}
