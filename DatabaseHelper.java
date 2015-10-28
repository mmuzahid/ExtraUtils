/**
 * @author MD. MUZAHIDUL ISLAM 
 * 
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DatabaseHelper {
	Connection conn;
	PreparedStatement prepStmt;
	ResultSet rs;

	public DatabaseHelper(Connection conn, PreparedStatement prepStmt,
			ResultSet rs) {
		this.conn = conn;
		this.prepStmt = prepStmt;
		this.rs = rs;
	}

	/** return prepared statement for SQL */
	private PreparedStatement getPreparedStatement(String sql)
			throws SQLException {
		return conn.prepareStatement(sql);
	}

	/** set bind parameters of prepared statement */
	private void setBindParams(PreparedStatement pstmt,
			Map<Integer, String> bindParams) throws SQLException {
		for (Entry<Integer, String> entry : bindParams.entrySet()) {
			pstmt.setString(entry.getKey(), entry.getValue());
		}
	}

	/** execute prepared statement and returns the ResultSet */
	private ResultSet executeToGetResultSet(PreparedStatement ps,
			Map<Integer, String> bindParams) {
		ResultSet rs = null;
		try {
			setBindParams(ps, bindParams);
			rs = ps.executeQuery();
		} catch (SQLException sqlExcep) {
			System.out.println(sqlExcep);
		}
		return rs;
	}

	/**
	 * execute prepared statement and returns the ResultSet
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings("unused")
	private ResultSet executeToGetResultSet(String queryType)
			throws SQLException {
		String sql = getReportQuery(queryType);
		prepStmt = getPreparedStatement(sql);
		Map<Integer, String> bindParams = getBindParams(queryType);
		rs = executeToGetResultSet(prepStmt, bindParams);
		return rs;
	}

	/** fetch value for a column name from a ResultSet */
	@SuppressWarnings("unused")
	private String getColumnValue(ResultSet rs, String colName)
			throws SQLException {
		return getColumnValue(rs, new String[] { colName })[0];
	}

	/**
	 * fetch column values from given ResultSet and column names
	 */
	private String[] getColumnValue(ResultSet rs, String[] colNames)
			throws SQLException {
		String[] values = new String[colNames.length];
		while (rs.next()) {
			for (int i = 0; i < colNames.length; i++) {
				String colVal = rs.getString(colNames[i]);
				values[i] = colVal != null ? colVal : "";
			}
			break;
		}
		return values;
	}

	/** return query as string for the given type */
	public abstract String getReportQuery(String queryType);

	/** returns bind parameter map for <code>queryType</code>*/
	public abstract Map<Integer, String> getBindParams(String queryType);
}
