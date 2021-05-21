package blogcrud.blog;

import org.springframework.data.repository.CrudRepository;

import blogcrud.blog.model.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long>{
	
}
