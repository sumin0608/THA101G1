package tw.idv.ixercise.report.Core;

import java.util.List;

public interface CoreDao <P, I> {
	List<P> selectAll();
}
