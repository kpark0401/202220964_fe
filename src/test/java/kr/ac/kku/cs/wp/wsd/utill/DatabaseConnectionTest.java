package kr.ac.kku.cs.wp.wsd.utill;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTest {

    private static final String URL = "jdbc:mysql://localhost:3306/cswp_202220964";
    private static final String USERNAME = "kpark0401";
    private static final String PASSWORD = "202220964";

    @Test
    public void testDatabaseConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            assertNotNull(connection);
            assertTrue(connection.isValid(1));
            System.out.println("데이터베이스 연결 성공!");

            // 사용자 이름 가져오기 테스트
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT username FROM users LIMIT 1")) {
                if (rs.next()) {
                    String username = rs.getString("username");
                    System.out.println("가져온 사용자 이름: " + username);
                    assertNotNull(username);
                } else {
                    System.out.println("사용자 정보가 없습니다.");
                }
            }
        } catch (SQLException e) {
            fail("데이터베이스 연결 실패: " + e.getMessage());
        }
    }
}
