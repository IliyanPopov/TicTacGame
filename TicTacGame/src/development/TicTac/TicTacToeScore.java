package development.TicTac;

public class TicTacToeScore {
	
	public TicTacToeScore(){}
	
	public TicTacToeScore(int id, String score,long time) {
		this.id = id;
		this.score = score;
		this.time=time;
		
	}	public TicTacToeScore( String score,long time) {

		this.score = score;
		this.time=time;
		
	}
	private int id;
	private String score;
	private long time;
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

}
