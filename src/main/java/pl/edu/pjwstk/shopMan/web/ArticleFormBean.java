package pl.edu.pjwstk.shopMan.web;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.shopMan.domain.Article;
import pl.edu.pjwstk.shopMan.service.ArticleManager;

@SessionScoped
@Named("articleBean")
public class ArticleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Article article = new Article();
	private ListDataModel<Article> articles = new ListDataModel<Article>();

	@Inject
	private ArticleManager am;

	public Article getArticle() {
		return article;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}

	public ListDataModel<Article> getArticles() {
		articles.setWrappedData(am.getArticleList());
		return articles;
	}

	public String deleteArticle() {
		Article artToDel = articles.getRowData();
		am.deleteArticle(artToDel);
		return null;
	}

	@SuppressWarnings("deprecation")
	public String addArticle() {
		if (article.getDataWaznosci() == null) {
			Date newDate = new Date();
			newDate.setDate(newDate.getDate() +14); // Default valid to date :D
			article.setDataWaznosci(newDate);
		}
		am.addArticle(article);
		article = new Article();
		return "articleManager";
	}


}
