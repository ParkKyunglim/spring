package com.sboard.service;

import com.sboard.dto.ArticleDTO;
import com.sboard.entity.Article;
import com.sboard.repository.ArticleRepository;
import com.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void registerArticle(ArticleDTO articleDTO) {
        Article article = articleDTO.toEntity();
        articleRepository.save(article);
    }

    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(Article::toDTO)
                .collect(Collectors.toList());
    }

    public ArticleDTO getArticle(int no) {
        Optional<Article> articleOpt = articleRepository.findById(no);
        return articleOpt.map(Article::toDTO).orElse(null);
    }

    public void deleteArticle(int no) {
        articleRepository.deleteById(no);
    }

    public void updateArticle(ArticleDTO articleDTO) {
        Article article = articleDTO.toEntity();
        articleRepository.save(article);
    }


}