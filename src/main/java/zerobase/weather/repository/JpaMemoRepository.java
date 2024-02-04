package zerobase.weather.repository;
//database와의 연동 코드는 거의 repository 아래에 작성

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

@Repository
public interface JpaMemoRepository extends JpaRepository<Memo, Integer> {  // <가져 올 클래스, primary key type>

}
