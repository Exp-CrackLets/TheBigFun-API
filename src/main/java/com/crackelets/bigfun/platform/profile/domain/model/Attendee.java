package com.crackelets.bigfun.platform.profile.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import lombok.*;
import java.util.HashSet;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendees")
public class Attendee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //Autogenerate value
  private Long id;

  @NotNull
  @NotBlank
  @Size(max = 50)
  @Column(unique = true)
  private String userName;

  @NotNull
  @NotBlank
  @Size(max = 255)
  private String name;

  @NotNull
  @NotBlank
  @Size(max = 255)
  private String email;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "attendee")
  private Set<AttendeeEvent> eventsListByAttendee;

  //Class add event
  public void addEvent(Attendee attendee, Long eventId) {
    if (eventsListByAttendee == null) {
      eventsListByAttendee = new HashSet<>();
    }
    ;
    this.eventsListByAttendee.add(new AttendeeEvent(this, eventId));
  }


}
