package com.example.Repository;

import com.example.Entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

     List<Event> findByEventcity(String eventcity);
     List<Event> findByEventdate (LocalDate eventdate);
     List<Event> findByEventcityAndEventdate (String eventcity , LocalDate eventdate);

}

