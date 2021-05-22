# MyBlog

## Description
CRUD Blog application in SpringBoot

## Functionalities
 - Home page
  ```
  curl localhost:8080/
  ```
 - Add a new blog
   - The user can click on "Add a Blog" button on landing page and then create a new blog.
  ```
  $ curl localhost:8080/addblog
  ```
  ```
  $ curl -d "title=BLOG_TITLE&content=BLOG_CONTENT" localhost:8080/addblog/
  ```
 - Get the list of all the blogs
   - The user can click on "Get all the blogs" button on landing page and then can view all the blogs.
  ```
  $ curl localhost:8080/getallblogs
  ```
 - View a particular blog (by Id)
   - On /getallblogs, the user can click on "View" to view content of blog
  ```
  $ curl localhost:8080/blog_id/{id}
  ```
 - Delete a blog
   - On /getallblogs, the user can click on "Delete" to delete that blog
  ```
  $ curl -X DELETE localhost:8080/delete/{id}
  ```
 - Update a blog
   - On /getallblogs, the user can click on "Edit" to edit content of blog
  ```
  $ curl localhost:8080/update/{id}
  ```
  ```
  $ curl -X PUT -d 'title=UPDATED_TITLE&content=UPDATED_BLOG' http://localhost:8080/update/{id}
  ```

### Note: The @DeleteMapping and @PutMapping need to be uncommented in order to run Postman or Curl DELETE or PUT requests. By default, they use @PostMapping. Since, I did not have any prior experience of working with SpringBoot, I learnt it from scratch and implemented it in the application as precisely as I can. I got stuck on the level 2 and could not debug it before the deadline. However, I learnt a lot along the way!
