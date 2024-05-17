package vn.webapp.backend.auction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.webapp.backend.auction.enums.AuctionState;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(50)")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "nvarchar(200)")
    private String description;

    @Column(name = "first_price", nullable = false)
    private double firstPrice;

    @Column(name = "last_price", nullable = false)
    private double lastPrice;

    @Column(name = "participation_fee", nullable = false)
    private double participationFee;

    @Column(name = "deposit", nullable = false)
    private double deposit;

    @Column(name = "priceStep", nullable = false)
    private double priceStep;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "countdown_time", nullable = false)
    private Timestamp  countdownTime;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinColumn(name = "staff_id")
    private User user;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinColumn(name = "jewelry_id")
    private Jewelry jewelry;

    @Enumerated(EnumType.STRING)
    private AuctionState state;
}