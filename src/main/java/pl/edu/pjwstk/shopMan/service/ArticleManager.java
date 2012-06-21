package pl.edu.pjwstk.shopMan.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.edu.pjwstk.shopMan.domain.Article;


@Stateless
public class ArticleManager {

	@PersistenceContext
	EntityManager em;
	
	public void addArticle(Article article){
		
		article.setId(null);
		em.persist(article);
	}
	
	public void deleteArticle(Article article){
		article = em.find(Article.class, article.getId());
		em.remove(article);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> getArticleList(){
		return em.createNamedQuery("article.all").getResultList();	
	}
	
}
