public class Racer implements Runnable {
	int d = 42; 
	public void run () {
		doSomething(1001);                   // (1)
		d = 0;                               // (2)
		}
    public static void main (String[] args){
		Target racer = new Target();
		Thread t = new Thread(racer);
		t.start(); 
		doSomething(1000);                   // (3)
		int c = 420 / racer.d;               // (4)
		System.out.println(c);
	}     
    static void doSomething (int n) {
		try { Thread.sleep(n); } catch (InterruptedException ix) {}
	}
}


