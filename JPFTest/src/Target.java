 public class Target {
static class Fork {}
static class Philosopher extends Thread {
Fork left, right;
public Philosopher(Fork left, Fork right) {
this.left = left;
this.right = right;}
public void run() {
synchronized (left) {
synchronized (right) {}}}}
static int nPhilosophers = 6;
public static void main(String[] args) {
if (args.length > 0){
nPhilosophers = Integer.parseInt(args[0]);}
Fork[] forks = new Fork[nPhilosophers];
for (int i = 0; i < nPhilosophers; i++) {
forks[i] = new Fork();}
for (int i = 0; i < nPhilosophers; i++) {
Philosopher p = new Philosopher(forks[i], forks[(i + 1) % nPhilosophers]);
p.start();}}}

