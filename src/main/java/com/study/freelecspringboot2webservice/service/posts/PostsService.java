package com.study.freelecspringboot2webservice.service.posts;

import com.study.freelecspringboot2webservice.web.domain.posts.Posts;
import com.study.freelecspringboot2webservice.web.domain.posts.PostsRepository;
import com.study.freelecspringboot2webservice.web.dto.PostsListResponseDto;
import com.study.freelecspringboot2webservice.web.dto.PostsResponseDto;
import com.study.freelecspringboot2webservice.web.dto.PostsSaveRequestDto;
import com.study.freelecspringboot2webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("�ش� �Խñ��� �����ϴ�. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("�ش� �Խñ��� �����ϴ�. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
