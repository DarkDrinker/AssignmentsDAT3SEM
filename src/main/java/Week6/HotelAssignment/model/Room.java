package Week6.HotelAssignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer hotelId;
    private int number;
    private int price;

    public Room(Integer hotelId, int number, int price) {
        this.hotelId = hotelId;
        this.number = number;
        this.price = price;
    }
    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.DETACH})
    @JsonIgnore
    private Hotel hotel;

    @PrePersist
    public void prePersist(){
        if(this.hotelId == null) {
            this.hotelId = hotel.getId();
        }
    }
}