package com.therealdanvega.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.Post;
import com.therealdanvega.repository.AuthorRepository;
import com.therealdanvega.repository.PostRepository;

@Service
public class DataLoader {

	private PostRepository postRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public DataLoader(PostRepository postRepository,AuthorRepository authorRepository){
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}
	
	
	//allows us to call this method loadData() after everything has been setUp for our application
	//it could have seen for h2.sqlbut we have renamed it so allows us to load the data from here
	@PostConstruct
	private void loadData(){
		// create an author
		Author dv = new Author("Dan","Vega");
		authorRepository.save(dv);
		 
		// create a post
		Post post = new Post("Spring Data Rocks!");
		post.setBody("Post Body here...");
		post.setAuthor(dv);
		postRepository.save(post);
	}
	
}
