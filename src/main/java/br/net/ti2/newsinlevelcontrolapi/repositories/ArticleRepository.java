package br.net.ti2.newsinlevelcontrolapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import br.net.ti2.newsinlevelcontrolapi.models.Article;;

public interface ArticleRepository extends JpaRepository<Article, Long>{}
