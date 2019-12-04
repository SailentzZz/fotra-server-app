package com.fotra.database.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fotra.database.entities.PostFrame;


@Repository
public interface PostForumRepository extends CrudRepository<PostFrame, Integer>{

	@Query(value = "SELECT id_post, name, head, body, date, likes, comments, open_close, topic_var FROM public.\"PostFrame\" JOIN public.\"UserForum\" ON public.\"PostFrame\".autor = public.\"UserForum\".id_user;", nativeQuery = true)
	Iterable<PostFrameReqDtoRepo> findAllPostsWithUser();
	
	@Query(value = "SELECT id_post, name, head, body, date, likes, comments, open_close, topic_var FROM public.\"PostFrame\" JOIN public.\"UserForum\" ON public.\"PostFrame\".autor = public.\"UserForum\".id_user WHERE topic_var = :lang", nativeQuery = true)
	Iterable<PostFrameReqDtoRepo> findAllPostsWithTopic(@Param("lang") String lang);
	
	@Query(value = "SELECT id_post, name, head, body, date, likes, comments, open_close, topic_var FROM public.\"PostFrame\" JOIN public.\"UserForum\" ON public.\"PostFrame\".autor = public.\"UserForum\".id_user WHERE autor = :id", nativeQuery = true)
	Iterable<PostFrameReqDtoRepo> findAllPostsWithUser(@Param("id") Integer id);
	
	public static interface PostFrameReqDtoRepo {

		public String getId_post();
		
		public String getName();

		public String getHead();

		public String getBody();

		public Date getDate();

		public Integer getLikes();

		public Integer getComments();

		public Boolean getOpen_close();

		public String getTopic_var();
	  }
}
