package br.net.ti2.newsinlevelcontrolapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.ti2.newsinlevelcontrolapi.dto.ArticleSimpleDto;
import br.net.ti2.newsinlevelcontrolapi.models.Article;
import br.net.ti2.newsinlevelcontrolapi.repositories.ArticleRepository;

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticleController {
	@Autowired
	ArticleRepository articleRepository;
	@GetMapping
	public ResponseEntity<List<ArticleSimpleDto>> getAllArticles(){
		
		List<ArticleSimpleDto> dtoList = articleRepository.findArticleByDoneLessThanAndDoneGreaterThanOrderByUpdatedAt(5L,0L).stream().map(ArticleSimpleDto::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtoList);
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<ArticleSimpleDto> makeDone(@PathVariable Long id){
		Article article = articleRepository.getOne(id);
		article.setDone(article.getDone()+1);

		return ResponseEntity.ok().body(new ArticleSimpleDto(article));
	}
}
