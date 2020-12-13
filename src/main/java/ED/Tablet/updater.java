package ED.Tablet;

import javafx.concurrent.Task;

/*


INSERT INTO medication VALUES ("0906634738", "2021-01-22 11:37:22", "Test", "1mg", "Test")

*/

public class updater extends Task<Void> {

    private int timeout = 5000;
    private updateble updateble = null;

    public updater(updateble updateble) {
        // Inform world that a updatable was created
        System.out.println("Created updatable: " + updateble.hashCode());
        // Store the updatable
        this.updateble = updateble;
        // Create the task as a thread
        Thread th = new Thread(this);
        // Set as daemon, will close on app close
        th.setDaemon(true);
        // Start the thread
        th.start();
    }

    @Override
    protected Void call() throws Exception {
        while(!isCancelled()) {
            System.out.println("Updating updateble: " + updateble.hashCode());
            // Update the updatable
            updateble.update();
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException interrupted) {
                if (isCancelled()) {
                    System.out.println("Cancelled updateble: " + updateble.hashCode());
                    break;
                }
            }
        }
        return null;
    }

    protected void setTimeout(int timeout) {
        this.timeout = timeout;
    }

}
