package netdb.courses.softwarestudio.lab.rpg.player;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class PlayerMgr {
	// TODO: declare a proper field to store the data of users
	private List<Player> playerList;
	
	public PlayerMgr(String data) {
		// TODO: parse data and generate list of players
		this.playerList = JSON.parseArray(data, Player.class);
	}

	public Player getPlayer(String login) {
		// TODO: get player with the login (you should use this method to get your own character)
		for(Player i : playerList)
			if( i.getLogin().equals(login) )
				return i;
		return null;
	}
		
	public Player findTeammate(Player player) {
		// TODO: find the best team-mate for `player`
				
		//find the closest level
		int IntervalOfClosestLevel = 2147483647;
		for(Player i : playerList)
			if( ( Math.abs(i.getLevel() - player.getLevel()) < IntervalOfClosestLevel ) 
					&& i !=  player )
				IntervalOfClosestLevel = Math.abs(i.getLevel() - player.getLevel());
		
		//find the players with the closest level
		List<Player> playersOfClosestLevel = new ArrayList<Player>();
		for(Player i : playerList)
			if( ( Math.abs(i.getLevel() - player.getLevel()) == IntervalOfClosestLevel )
					&& i !=  player )
				playersOfClosestLevel.add(i);
		
		if(playersOfClosestLevel.size() == 1)
			return playersOfClosestLevel.get(0);
		
		//find the one that has the complementary profession
		List<Player> playersWithComplementaryProfession = new ArrayList<Player>();
		for(Player i : playersOfClosestLevel)
			if( i.getProfession().equals(player.getComplementaryProfession()) )
				playersWithComplementaryProfession.add(i);
		
		if(playersWithComplementaryProfession.size() == 1)
			return playersWithComplementaryProfession.get(0);
		
		//return the one with smallest ID on the list
		Player PlayerWithSmallestId;
		if(playersWithComplementaryProfession.size() != 0){
			PlayerWithSmallestId = playersWithComplementaryProfession.get(0);
			for(Player i : playersWithComplementaryProfession)
				if( i.getId() < PlayerWithSmallestId.getId() )
					PlayerWithSmallestId = i;
		}else{
			PlayerWithSmallestId = playersOfClosestLevel.get(0);
			for(Player i : playersOfClosestLevel)
				if( i.getId() < PlayerWithSmallestId.getId() )
					PlayerWithSmallestId = i;			
		}
		
		return PlayerWithSmallestId;
	}
	
}
