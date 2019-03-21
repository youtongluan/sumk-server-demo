package org.test.listener;

import java.util.List;
import java.util.Map;

import org.yx.annotation.Bean;
import org.yx.db.event.InsertEvent;
import org.yx.db.listener.DBListener;
import org.yx.db.sql.PojoMeta;
import org.yx.db.sql.PojoMetaHolder;
import org.yx.listener.SumkEvent;
import org.yx.log.Log;

//监听数据表的变更
@Bean
public class TableListener implements DBListener<InsertEvent> {

	@Override
	public boolean accept(SumkEvent event) {
		return InsertEvent.class.isInstance(event);
	}

	@Override
	public void listen(InsertEvent event) {
		try {
			PojoMeta pm = PojoMetaHolder.getTableMeta(event.getTable());
			List<Map<String, Object>> list = event.getPojos();
			if (pm == null || list == null) {
				return;
			}
			for (Map<String, Object> map : list) {
				Log.get(this.getClass()).error("{}表插入了一条数据：{}",event.getTable(),map);
			}
		} catch (Exception e) {
			Log.get(this.getClass()).error(e.toString(),e);
		}
	}

}
