package in.stvayush.booksproject.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int totalAmountToPay;

    @OneToMany(mappedBy = "godPayer")
    private List<Expense> godlyPaidExpenses = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Expense> expenses = new ArrayList<>();

    @ManyToMany
    private List<Group> groups = new ArrayList<>();

    @OneToMany(mappedBy = "paidBy", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Split> paidSplits = new ArrayList<>();

    @OneToMany(mappedBy = "owedBy", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Split> owedSplits = new ArrayList<>();
}
