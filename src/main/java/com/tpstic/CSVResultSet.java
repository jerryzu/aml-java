package com.tpstic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;

import org.apache.commons.dbutils.ProxyFactory;
import org.apache.poi.hssf.record.PageBreakRecord.Break;

/**
 * Wraps a <code>ResultSet</code> to trim strings returned by the
 * <code>getString()</code> and <code>getObject()</code> methods.
 *
 * <p>
 * Usage Example: This example shows how to decorate ResultSets so processing
 * continues as normal but all Strings are trimmed before being returned from
 * the <code>ResultSet</code>.
 * </p>
 *
 * <pre>
 * ResultSet rs = // somehow get a ResultSet;
 *
 * 		// Substitute wrapped ResultSet with additional behavior for real ResultSet
 * 		rs = CSVResultSet.wrap(rs);
 *
 * // Pass wrapped ResultSet to processor
 * List list = new BasicRowProcessor().toBeanList(rs);
 * </pre>
 */
public class CSVResultSet implements InvocationHandler {
	private static final ProxyFactory factory = ProxyFactory.instance();

	public static ResultSet wrap(ResultSet rs) {
		return factory.createResultSet(new CSVResultSet(rs));
	}

	private final ResultSet rs;

	public CSVResultSet(ResultSet rs) {
		super();
		this.rs = rs;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(this.rs, args);
		if ((method.getName().equals("getObject") && result instanceof String)) {
			result = "\"" + ((String) result).trim() + "\"";
		} else if ((method.getName().equals("getObject") && result instanceof Integer)) {
			result = "\"" + String.valueOf((Integer) result) + "\"";
		} else if ((method.getName().equals("getObject") && result instanceof BigDecimal)) {
			result = "\"" + String.valueOf((BigDecimal) result) + "\"";
		} else if ((method.getName().equals("getObject") && result instanceof Date)) {
			result = "\"" + String.valueOf((Date) result) + "\"";
		} else if ((method.getName().equals("getObject"))) {
			if (result == null) {
				result = "\"null\"";
			} else {
				System.out.println(result.getClass());
			}
		}
		return result;
	}
}