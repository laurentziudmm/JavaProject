package em;

import org.junit.Test;
import reflectionTwo.api.annotation.Column;
import reflectionTwo.api.em.ColumnInfo;
import reflectionTwo.api.em.EntityUtils;
import reflectionTwo.appl.domain.Department;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumnsMethod() {
        List<ColumnInfo> columns = EntityUtils.getColumns(Department.class);
        assertEquals(3, columns.size());
    }

    @Test
    public void testGetFieldsByAnnotations() throws NoSuchFieldException {
        assertEquals(3, EntityUtils.getFieldsByAnnotation(Department.class, Column.class).size());
    }
}
