package br.net.ti2.newsinlevelcontrolapi.dto;

import br.net.ti2.newsinlevelcontrolapi.models.Article;

public class ArticleSimpleDto {

	private Long id;
	private Long orderNumber;
	private Long done;
	private String title;
	
	public ArticleSimpleDto(Article article) {
		this.id = article.getId();
		this.orderNumber = article.getOrderNumber();
		this.done = article.getDone();
		this.title = article.getTitle();
	}
	
	

	public ArticleSimpleDto() {
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getOrderNumber() {
		return orderNumber;
	}



	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}



	public Long getDone() {
		return done;
	}



	public void setDone(Long done) {
		this.done = done;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "ArticleSimpleDto [id=" + id + ", orderNumber=" + orderNumber + ", done=" + done + ", title=" + title
				+ "]";
	}
	
	
}
