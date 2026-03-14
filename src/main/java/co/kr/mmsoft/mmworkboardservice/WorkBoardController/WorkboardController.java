package co.kr.mmsoft.mmworkboardservice.WorkBoardController;

import co.kr.mmsoft.mmworkboardservice.dto.ProjectPost;
import co.kr.mmsoft.mmworkboardservice.mapper.WorkboardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/workboard")
@RequiredArgsConstructor
public class WorkboardController {

    private final WorkboardMapper workboardMapper;

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectPost>> getProjects() {
        List<ProjectPost> list = workboardMapper.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody ProjectPost post) {
        int result = workboardMapper.insert(post);
        return result > 0 ? ResponseEntity.ok("등록되었습니다.") : ResponseEntity.internalServerError().body("등록 실패");
    }

    @PutMapping("/update/{workboardId}")
    public ResponseEntity<String> update(@PathVariable Long workboardId, @RequestBody ProjectPost post) {
        post.setWorkboardId(workboardId);
        int result = workboardMapper.update(post);
        return result > 0 ? ResponseEntity.ok("수정되었습니다.") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{workboardId}")
    public ResponseEntity<String> delete(@PathVariable Long workboardId) {
        int result = workboardMapper.delete(workboardId);
        return result > 0 ? ResponseEntity.ok("삭제되었습니다.") : ResponseEntity.notFound().build();
    }

    @PostMapping("/checkpw")
    public ResponseEntity<String> checkPw(@RequestBody ProjectPost post) {
        int count = workboardMapper.checkPasswd(post);
        return count > 0 ? ResponseEntity.ok("ok") : ResponseEntity.status(401).body("비밀번호 불일치");
    }
}
