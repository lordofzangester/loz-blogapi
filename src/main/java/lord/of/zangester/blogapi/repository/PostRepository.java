package lord.of.zangester.blogapi.repository;

import lord.of.zangester.blogapi.entity.Post;
import lord.of.zangester.blogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByTitle(String title);
    Optional<List<Post>> findByUser(User user);
}
