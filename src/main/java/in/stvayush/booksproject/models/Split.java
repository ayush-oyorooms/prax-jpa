package in.stvayush.booksproject.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "split")
@Getter
@Setter
public class Split {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "member_id_paid_by")
    private Member paidBy;

    @ManyToOne
    @JoinColumn(name = "member_id_owed_by")
    private Member owedBy;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "expense_id")
    private Expense expense;
}
