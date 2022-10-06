package lord.of.zangester.blogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Timestamp createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Post(String title, String content, Timestamp createdAt, User user) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }
}
