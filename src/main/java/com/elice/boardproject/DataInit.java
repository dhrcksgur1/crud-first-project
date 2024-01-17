package com.elice.boardproject;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.board.repository.BoardRepository;
import com.elice.boardproject.comment.entity.Comment;
import com.elice.boardproject.comment.repository.CommentRepository;
import com.elice.boardproject.post.entity.Post;
import com.elice.boardproject.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class DataInit {

    private final BoardRepository boardRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        log.info("init stub data");
        boardRepository.create(new Board("중고거래 게시판", "사용자들이 중고 물품을 사고팔 수 있는 게시판입니다."));
        boardRepository.create(new Board("취미 게시판", "특정 취미나 관심사에 대해 이야기하고 정보를 공유하는 게시판입니다."));
        boardRepository.create(new Board("지역 커뮤니티 게시판", "특정 지역의 주민들이 모여 지역 소식, 이벤트, 문제 등을 논의하는 게시판입니다."));
        boardRepository.create(new Board("여행 게시판", "여행 팁, 경험담, 추천 장소 등 여행과 관련된 정보를 공유하는 게시판입니다."));
        boardRepository.create(new Board("부동산 게시판", "부동산 매매, 임대, 투자 정보를 공유하는 게시판입니다."));
        boardRepository.create(new Board("요리 게시판", "요리 레시피, 식당 추천, 음식 관련 토론을 하는 게시판입니다."));
        Board board = boardRepository.findById(1L).orElseThrow(() -> new RuntimeException());
        Board board2 = boardRepository.findById(2L).orElseThrow(() -> new RuntimeException());
        
        postRepository.save(new Post(board,"모니터 팝니다", "24인치 IPS 모니터, 상태 양호, 1년 사용. HDMI 케이블 포함, 가격 50,000원, 직거래만 가능."));
        postRepository.save(new Post(board, "가전제품 삽니다", "소형 냉장고와 전자레인지 구매 희망. 사용기간 2년 이내, 깨끗하고 작동 잘 되는 제품 원함."));
        postRepository.save(new Post(board, "옷걸이 나눔합니다", "플라스틱 옷걸이 30개 무료 나눔. 사용감 있으나 상태 양호, 픽업만 가능."));
        postRepository.save(new Post(board, "맥북 팝니다", "2019년형 맥북 프로, 256GB SSD, 배터리 상태 좋음. 가격 800,000원, 상자 및 충전기 포함."));
        postRepository.save(new Post(board, "헤드폰 팝니다", "2019년형 맥북 프로, 256GB SSD, 배터리 상태 좋음. 가격 800,000원, 상자 및 충전기 포함."));
        postRepository.save(new Post(board, "책상 나눔합니다", "나무 책상, 넓은 수납공간, 상태 좋음. 크기: 120cm x 60cm. 무료로 드립니다, 자가 수령 필요."));
        postRepository.save(new Post(board, "카메라 팝니다", "캐논 DSLR 카메라, 18-55mm 렌즈 포함, 사용감 있으나 상태 양호. 메모리 카드 및 가방 포함. 가격 300,000원."));
        postRepository.save(new Post(board, "어린이 자전거 팝니다", "16인치 어린이용 자전거, 파란색, 좋은 상태, 사용기간 1년. 가격 70,000원, 안전장비 무료 포함."));
        postRepository.save(new Post(board, "커피 머신 팝니다", "네스프레소 커피 머신, 상태 매우 좋음, 캡슐 몇 개 포함. 가격 100,000원, 직거래 선호."));
        postRepository.save(new Post(board, "게임 콘솔 팝니다", "닌텐도 스위치, 완벽한 상태, Zelda 게임 카트리지 포함. 사용기간 6개월. 가격 250,000원, 직거래 선호합니다."));
        postRepository.save(new Post(board, "아기 카시트 나눔합니다", "Britax 아기 카시트, 상태 양호. 아이가 크게 자라 더 이상 사용하지 않습니다. 무료로 드립니다. 픽업 원합니다."));
        postRepository.save(new Post(board2, "가드닝 팁 공유", "내 작은 정원에서 키운 토마토! 토마토 재배에 관한 내 팁과 비법을 공유하고 싶어요. 초보 가드너들의 질문도 환영합니다."));
        postRepository.save(new Post(board2, "책 추천 및 토론", "이번 달에 읽은 가장 인상 깊었던 책 3권을 추천합니다. 이 책들에 대한 여러분의 생각은 어떤가요? 토론하고 싶어요!"));
        Post post = postRepository.findById(1L).orElseThrow(() -> new RuntimeException());
        Post post2 = postRepository.findById(12L).orElseThrow(() -> new RuntimeException());

//        commentRepository.save(new Comment(post, "안녕하세요. 모니터 팔렸나요?"));
//        commentRepository.save(new Comment(post, "모니터 제가 사고 싶어요."));
//        commentRepository.save(new Comment(post2, "스테비아 토마토 심는 방법을 알려주세요!"));
//        commentRepository.save(new Comment(post2, "자바의 정석 추천합니다."));
    }
}
