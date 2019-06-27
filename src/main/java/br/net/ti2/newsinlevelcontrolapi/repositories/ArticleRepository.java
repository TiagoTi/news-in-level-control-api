package br.net.ti2.newsinlevelcontrolapi.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.net.ti2.newsinlevelcontrolapi.models.Article;;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	//select order_number, title, done, id from articles where done < 5 and done > 0 order by updated_at ;
	List<Article> findArticleByDoneLessThanAndDoneGreaterThanOrderByUpdatedAt(Long max,Long min);
}
