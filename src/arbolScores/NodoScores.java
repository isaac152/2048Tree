package arbolScores;


public class NodoScores {
	/*username, mov1,mov2,hiscore,sumamax*/
	private String username;
	private String mov1;
	private String mov2;
	private int hiscore;
	private int sumamax;
	private NodoScores left;
	private NodoScores right;
	 
	public NodoScores(String user,String m1,String m2,int hs,int max) {
		this.username=user;
		this.mov1=m1;
		this.mov2=m2;
		this.hiscore=hs;
		this.sumamax=max;
		this.left=null;
		this.right=null;
	}
	public NodoScores() {
		
	}
	  
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMov1() {
		return mov1;
	}
	public void setMov1(String mov1) {
		this.mov1 = mov1;
	}
	public String getMov2() {
		return mov2;
	}
	public void setMov2(String mov2) {
		this.mov2 = mov2;
	}
	public int getHiscore() {
		return hiscore;
	}
	public void setHiscore(int hiscore) {
		this.hiscore = hiscore;
	}
	public int getSumamax() {
		return sumamax;
	}
	public void setSumamax(int sumamax) {
		this.sumamax = sumamax;
	}
	public NodoScores getLeft() {
		return left;
	}
	public void setLeft(NodoScores left) {
		this.left = left;
	}
	public NodoScores getRight() {
		return right;
	}
	public void setRight(NodoScores right) {
		this.right = right;
	}
	public String toString(){
		return("Node [USER = "+ username + "----   MOV1 = "+ mov1+ "----   MOV2 = "+ mov2+ "----   HISCORE = "+ hiscore+ "----   SUMAMAX = "+ sumamax+  "]");
	} 
    
}