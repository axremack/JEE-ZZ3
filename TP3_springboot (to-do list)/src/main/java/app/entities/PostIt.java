package app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="notes")
public class PostIt {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="note_id")
    private Long   id;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    private String content;
    @Column(name="creation_date")
    @CreationTimestamp
    private Date   creationDate;
    @Column(name="end_date")
    private Date   endDate;

    protected PostIt() {}

    public PostIt(Category category, String content ) {
        this.category = category;
        this.content  = content;
        //this.creationDate     = new Date();
    }

    @Override
    public String toString() {
        return String.format(
                "PostIt[id=%d, content='%s']", id, content);
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public String getContent() {
        return content;
    }
}
