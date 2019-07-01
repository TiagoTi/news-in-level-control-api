package br.net.ti2.newsinlevelcontrolapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ArticleCreateDto {

	@NotNull @Min(value = 2)
	private Long orderNumber;
	
	@NotNull @NotEmpty @Length(max = 250, min = 5)
	private String title;
	
	private Long done = 0L;
	
	private boolean active = false;

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getDone() {
		return done;
	}

	public void setDone(Long done) {
		this.done = done;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
