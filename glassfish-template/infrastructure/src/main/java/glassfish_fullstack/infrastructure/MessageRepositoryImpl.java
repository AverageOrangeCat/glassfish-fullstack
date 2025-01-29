package glassfish_fullstack.infrastructure;

import glassfish_fullstack.domain.MessageBo;
import glassfish_fullstack.domain.MessageDto;
import glassfish_fullstack.domain.MessageRepository;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MessageRepositoryImpl implements MessageRepository {

    @Resource(lookup = "java:app/glassfish-database")
    DataSource dataSource;

    @Override
    public List<MessageBo> getMessages() {
        Connection connection = null;

        Statement statement = null;

        ResultSet resultSet = null;

        List<MessageBo> messageBoList = new ArrayList<>();

        try {
            connection = dataSource.getConnection();

            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM \"messages\"");

            while (resultSet.next()) {
                MessageBo messageBo = new MessageBo();

                messageBo.setId(resultSet.getLong("id"));

                messageBo.setUsername(resultSet.getString("username"));

                messageBo.setContext(resultSet.getString("context"));

                messageBoList.add(messageBo);
            }

        } catch (SQLException exception) {
            // TODO
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException exception) {
                // TODO
            }
        }

        return messageBoList;
    }

    @Override
    public void createMessage(MessageDto messageDto) {
        Connection connection = null;

        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("""
                INSERT INTO "messages" ("username", "context")
                VALUES (?, ?)
            """);

            statement.setString(1, messageDto.getUsername());

            statement.setString(2, messageDto.getContext());

            statement.executeQuery();

        } catch (SQLException exception) {
            // TODO
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException exception) {
                // TODO
            }
        }
    }

    @Override
    public void updateMessage(Long id, MessageDto messageDto) {
        Connection connection = null;

        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("""
                UPDATE "messages"
                SET "username" = ?, "context" = ?
                WHERE "id" = ?;
            """);

            statement.setString(1, messageDto.getUsername());

            statement.setString(2, messageDto.getContext());

            statement.setLong(3, id);

            statement.executeQuery();

        } catch (SQLException exception) {
            // TODO
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException exception) {
                // TODO
            }
        }
    }

    @Override
    public void deleteMessage(Long id) {
        Connection connection = null;

        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("""
                DELETE FROM "messages"
                WHERE "id" = ?
            """);

            statement.setLong(1, id);

            statement.executeQuery();

        } catch (SQLException exception) {
            // TODO
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException exception) {
                // TODO
            }
        }
    }

}
