package org.springframework.data.jdbc.query;

import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import com.mysema.query.sql.RelationalPath;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.types.Expression;

public interface QueryDslJdbcOperations {

	/**
	 * Expose the classic Spring JdbcTemplate to allow invocation of
	 * classic JDBC operations.
	 */
	JdbcOperations getJdbcOperations();

	SQLQuery newSqlQuery();

	<T> T queryForObject(final SQLQuery sqlQuery, final RowMapper<T> rowMapper,
			final Expression<?>... cols);

	<T> List<T> query(final SQLQuery sqlQuery, final RowMapper<T> rowMapper,
			final Expression<?>... projection);

	long insert(final RelationalPath<?> entity, final SqlInsertCallback callBack);

	long update(final RelationalPath<?> entity, final SqlUpdateCallback callBack);

	long delete(final RelationalPath<?> entity, final SqlDeleteCallback callBack);

}