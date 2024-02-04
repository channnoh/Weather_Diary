package zerobase.weather.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {
    //jdbc -> mysql 연동
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemoRepository(DataSource dataSource){ // application.properties에 적어준 data 정보를 불러와서 JdbcTemplate에 넣어줌
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //jdbc 사용하여 memo data객체에 저장(jdbc는 sql mapper -> 직접 sql문 작성해야함)
    public Memo save(Memo memo){
        String sql = "insert into memo values(?,?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    public List<Memo> findAll(){
        String sql = "select * from memo";
        return jdbcTemplate.query(sql, memoRowMapper()); // 조회할 떄는 jdbcTemplate.query
    }

    //Optional -> 혹시 모르는 null 값을 처리하기 쉽게 해주는 java 함수
    public Optional<Memo> findById(int id){
        String sql = "select * from memo where id = ?";
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
    }

    private RowMapper<Memo> memoRowMapper(){
        // jdbc를 통해 database에서 data를 가져오면 가져온 데이터형식 -> ResultSet 형태으로 가져옴( {id = 1, text = "test"} )
        // RowMapper: 가져온 ResultSet 형태를 Memo라는 형식으로 mapping 해줌

        return (rs, rowNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );

    }

}
