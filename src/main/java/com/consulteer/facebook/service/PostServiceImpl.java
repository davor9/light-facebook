package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.BasicUserDto;
import com.consulteer.facebook.dto.PostDto;
import com.consulteer.facebook.dto.UserDto;

import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.repository.PostRepository;
import com.consulteer.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public int likePost(PostDto post) {
        int count = post.getCount();
        count++;
        post.setCount(count);
        PostDto.convertToDtoPost(postRepository.save(PostDto.convertToEntityPost(post)));
        return count;
    }

    @Override
    public int likePost(long postId, long userId) {

        PostDto post = PostDto.convertToDtoPost(postRepository.getOne(postId));
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            if (post != null) {
                return likePost(post);
            }
        }
        return 0;
    }

    @Override
    public PostDto create(Long userId, PostDto postDto) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            UserDto user = UserDto.convertToUserDto(optionalUser.get());
            postDto.setUsers(BasicUserDto.convertToBasicDtoUser(UserDto.convertToEntity(user)));
            postDto.setTime(LocalDateTime.now());
            return PostDto.convertToDtoPost(postRepository.save(PostDto.convertToEntityPost(postDto)));
        }
        return null;
    }


    @Override
    public Page<Post> findAllPageable(Long userId, int page, int size, boolean sort) {
        Optional<User> optionalUser = userRepository.findById(userId);

        UserDto userDto= UserDto.convertToUserDto(optionalUser.get());
        if (optionalUser.isPresent()) {
            if (sort) {
                return (postRepository.findAllByUserSorted(optionalUser.get(), PageRequest.of(page, size)));
            }

            return postRepository.findAllByUser(optionalUser.get(), PageRequest.of(page, size));
        }
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public PostDto updatePost(long postId, PostDto post) {
        PostDto found = PostDto.convertToDtoPost(postRepository.getOne(postId));
        if (found != null) {
            found.setText(post.getText());
            found.setTitle(post.getTitle());

            return PostDto.convertToDtoPost(postRepository.save(PostDto.convertToEntityPost(found)));

        }
        return null;

    }

    @Override
    public void deletePost(long postId) {
        PostDto found = PostDto.convertToDtoPost(postRepository.getOne(postId));
        postRepository.delete(PostDto.convertToEntityPost(found));

    }

//    @Override
//    public List<PostDto> findAllByUser(Long userId) {
//        User user = userRepository.getOne(userId);
//        UserDto dtoUser = UserDto.convertToUserDto(user);
//        if(dtoUser != null) {
//            return postRepository.findAllByUser(user);
//        }
//
//        return null;
//    }

}
