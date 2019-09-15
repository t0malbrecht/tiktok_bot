package tiktok;

public abstract class config{
	public static String username = "xxxx";
	public static String password = "xxxx";
	
	public static int[][] columnOfHashtagVideo = {{24,174}, {177,327}, {330,480}, {483,633}, {636,786}, {789,900}};
	public static int[][] rowOfHashtagVideo = {{653,853},{985,1185},{1317,1517}};
	public static int[][] columnOfProfileVideo = {{0,298},{300,599},{601,900}};
	public static int[][] rowOfProfileVideo = {{677,1074},{1078,1475},{1479,1600}};
	
	public static double max_ratio = 2.5;
	public static double min_ratio = 0;
	
	public static int max_follower = 1000;
	public static int min_follower = 1;
	public static int max_following = 3000;
	public static int min_following = 30;
	
	public static void setSessionParameter(double min_ratio, double max_ratio, int min_follower, int max_follower, int min_following, int max_following) {
		config.min_ratio = min_ratio;
		config.max_ratio = max_ratio;
		config.min_follower = min_follower;
		config.max_follower = max_follower;
		config.min_following = min_following;
		config.max_following = max_following;
	}
	
	public static int like_counter = 0;
	public static int following_counter = 0;
	
	public static int interaction_per_session = 400;
	public static int interaction_per_user = 10;
	
	public static void setInteractionPerUser(int amountOfUsers) {
		config.interaction_per_user = config.interaction_per_session/amountOfUsers;
	}
	
}