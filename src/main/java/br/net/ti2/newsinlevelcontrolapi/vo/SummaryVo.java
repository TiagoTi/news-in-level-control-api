package br.net.ti2.newsinlevelcontrolapi.vo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.net.ti2.newsinlevelcontrolapi.models.Article;
import br.net.ti2.newsinlevelcontrolapi.repositories.ArticleRepository;


public class SummaryVo {

	private Long done;
	private Long toDo;
	private Long doing;
	
	public SummaryVo(ArticleRepository articles) {
		List<Article> allArticles = articles.findAll();
		this.done  = (long) allArticles.stream().filter(a -> a.getDone() > 4).collect(Collectors.toList()).size();
		this.doing  = (long) allArticles.stream().filter(a -> a.getDone() <5 && a.getDone()>0).collect(Collectors.toList()).size();
		this.toDo  = (long) allArticles.stream().filter(a -> a.getDone() < 1).collect(Collectors.toList()).size();
	}

	public Long getDone() {
		return done;
	}

	public Long getToDo() {
		return toDo;
	}

	public Long getDoing() {
		return doing;
	}
	
}
