package com.linctronix.event;

import com.linctronix.event.Condition;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ConditionRepository extends Repository<Condition, Long> {

	@Query("select c.tree_id, c.id, c.init, c.\"type\", c.arity, wd.\"offset\", wd.duration, w.term, t.exp_value, w.acc_type, b.\"attribute\" enent_attr, b.\"action\" bind_action, b.\"name\" bind_name from \"condition\" c left join term t on c.id = t.cond_id left join wording w on t.word_id = w.id left join binding b on c.id = b.cond_id left join \"window\" wd on c.wind_id = wd.id where tree_id = 1 order by c.id")
	public Condition getCondition(Long id);
}
