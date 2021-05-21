package blogcrud.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import blogcrud.blog.BlogRepository;
//import blogcrud.blog.CommentRepository;
import blogcrud.blog.model.Blog;
import blogcrud.blog.model.Comment;

@Controller
public class BlogController {
	
	@Autowired
	BlogRepository blogRepository;
//	@Autowired
//	CommentRepository commentRepository;
	
	@GetMapping("/")
	public String index() {
	    return "index";
	}
	
	@GetMapping("/addblog")
	public String displayAddBlogForm(Blog blog) {
	    return "add-blog";
	}
	
	@PostMapping("/addblog")
	public String addBlog(Blog blog, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-blog";
		}
		blogRepository.save(blog);
		model.addAttribute("message", "You added a blog");
		return "index";
	}
	
	@GetMapping("/getallblogs")
	public String displayAllBlogs(Model model) {
		model.addAttribute("blogs", blogRepository.findAll());
		return "display-all-blogs";
	}
	
	@GetMapping("/blog_id/{id}")
    public String displayBlog(@PathVariable("id") long id, Model model) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Blog Id:" + id));
        model.addAttribute("blog", blog);
        return "display-blog";
    }
	
//	@DeleteMapping("/delete/{id}")
	@GetMapping("/delete/{id}")
	public String deleteBlog(@PathVariable("id") long id, Model model) {
	    Blog blog = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid blog Id:" + id));
	    blogRepository.delete(blog);
	    model.addAttribute("message", "You deleted a blog");
		return "index";
	}
	
	@GetMapping("/update/{id}")
	public String displayUpdateBlogForm(@PathVariable("id") long id, Model model) {
	    Blog blog = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid blog Id:" + id));
	    model.addAttribute("blog", blog);
	    return "update-blog";
	}
//	@PutMapping("/update/{id}")
	@PostMapping("/update/{id}")
	public String updateBlog(@PathVariable("id") long id, Blog blog, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	model.addAttribute("message", "An error occured");
			return "index";
	    }
	    blogRepository.save(blog);
	    model.addAttribute("message", "You updated a blog");
		return "index";
	}
	
//	@PostMapping("/comment/{id}")
//	public String commentOnBlog(@PathVariable("id") long id, Comment comment, BindingResult result, Model model) {
//	    if (result.hasErrors()) {
//	    	model.addAttribute("message", "An error occured");
//			return "index";
//	    }
//	    Blog blog = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid blog Id:" + id));
//	    comment.setBlog(blog);
//	    commentRepository.save(comment);
//	    model.addAttribute("message", "You commented on a blog");
//		return "index";
//	}
}
