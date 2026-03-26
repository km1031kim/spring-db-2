package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * 마이바티스 매핑 XML을 호출해주는 매퍼 인터페이스
 * @Mapper 애노테이션을 붙여야 마이바티스에서 인식
 * 이 인터페이스의 메서드를 호출하면 xml의 해당 sql을 실행
 */
@Mapper
public interface ItemMapper {
    void save(Item item);

    // 파라미터가 두개가 넘어가는 경우 @Param 사용
    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);

    // Optional 지원
    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearch);
}
