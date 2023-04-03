public class Developer {
    public void doJobInTime(BugTracker bugTracker){
        if (bugTracker.isActiveSprint()){
            System.out.println("Developer is solving problems");
        } else {
            System.out.println("Developer is having a rest");
        }
    }
}
