package tw.idv.ixercise.event.ropository;

import org.springframework.data.jpa.repository.*;
import tw.idv.ixercise.event.entity.*;

public interface EventRepository extends JpaRepository<Event, Integer> {

    // 使用自動化命名規則進行條件搜尋
    Event findByEventName(String eventName);
                //eventName 對應到 Event 的 eventName 屬性
}
