package org.example.repo;

import org.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends ElasticsearchRepository<Book, String> {
    @Query("""
            {
                "query_string": {
                  "query": "?0",
                  "default_field": "*"
                }
            }
            """)
    Page<Book> findByText(String text, Pageable pageable);
}
