# MyBlog

## Description
CRUD Blog application in SpringBoot

## Functionalities
 - Add a new blog
  - The user can click on "Add a Blog" button on landing page and then create a new blog.
  ```
  $ curl localhost:8080/addblog
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
  $ curl localhost:8080/delete/{id}
  ```
 - Update a blog
  - On /getallblogs, the user can click on "Edit" to edit content of blog
  ```
  $ curl localhost:8080/update/{id}
  ```
