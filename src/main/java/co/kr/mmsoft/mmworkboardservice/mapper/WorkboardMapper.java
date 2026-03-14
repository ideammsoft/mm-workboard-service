package co.kr.mmsoft.mmworkboardservice.mapper;

import co.kr.mmsoft.mmworkboardservice.dto.ProjectPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkboardMapper {
    List<ProjectPost> findAll();
    int insert(ProjectPost post);
    int update(ProjectPost post);
    int delete(Long workboardId);
    int checkPasswd(ProjectPost post);
}
