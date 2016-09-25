package uni.contactfour.dao;

import java.util.ArrayList;

import uni.contactfour.business.PlayerMatchedColumn;

public interface SaveDao {
	public void save(ArrayList<PlayerMatchedColumn> board);
	public ArrayList<PlayerMatchedColumn> load();
}
